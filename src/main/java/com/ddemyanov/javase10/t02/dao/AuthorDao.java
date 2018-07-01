package com.ddemyanov.javase10.t02.dao;

import com.ddemyanov.javase10.t02.db.ConnectionPool;
import com.ddemyanov.javase10.t02.model.Author;
import lombok.Cleanup;
import lombok.SneakyThrows;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AuthorDao implements Dao <Author, Long>{

    private static final String COUNT_SQL = "SELECT count(id) FROM author";
    private static final String DELETE_SQL = "DELETE FROM author";
    private static final String DELETE_ID_SQL = "DELETE FROM  author WHERE id = ?";
    private static final String UPDATE_SQL = "UPDATE author SET name = ?, surname = ? " + "WHERE id = ?";
    private static final String SELECT_ALL_SQL = "SELECT * FROM author";
    private static final String GET_ONE_SQL = "SELECT * FROM author WHERE id = ?";
    private static final String CREATE_SQL = "INSERT INTO author (name, surname) VALUES (?, ?)";

    @SneakyThrows
    @Override
    public Author create(Author entity) {
        @Cleanup Connection connection = ConnectionPool.get();
        @Cleanup PreparedStatement prepStatement = connection.prepareStatement(CREATE_SQL,
                                                                               PreparedStatement.RETURN_GENERATED_KEYS);
        prepStatement.setString(1, entity.getName());
        prepStatement.setString(2, entity.getSurName());
        prepStatement.executeQuery();

        @Cleanup ResultSet resultSet = prepStatement.getGeneratedKeys();
        entity.setId(resultSet.getLong(1));

        prepStatement.close();
        return entity;
    }

    @SneakyThrows
    @Override
    public Optional <Author> getById(Long id) {
        @Cleanup Connection connection = ConnectionPool.get();
        @Cleanup PreparedStatement st = connection.prepareStatement(GET_ONE_SQL);
        st.setLong(1, id);
        @Cleanup ResultSet rs = st.executeQuery();

        return Optional.ofNullable(rs.next() ? Author.builder()
                                                     .id(rs.getLong("id"))
                                                     .name(rs.getString("name"))
                                                     .surName(rs.getString("surname"))
                                                     .build() : null);
    }

    @SneakyThrows
    @Override
    public List <Author> getAll() {

        List <Author> list = new ArrayList <>();
        @Cleanup Connection connection = ConnectionPool.get();
        @Cleanup Statement statement = connection.createStatement();
        @Cleanup ResultSet resultSet = statement.executeQuery(SELECT_ALL_SQL);

        while (resultSet.next()) {
            list.add(Author.builder()
                           .id(resultSet.getLong("id"))
                           .name(resultSet.getString("name"))
                           .surName(resultSet.getString("surname"))
                           .build());
        }

        return list;
    }

    @SneakyThrows
    @Override
    public Author update(Author entity) {
        @Cleanup Connection connection = ConnectionPool.get();
        @Cleanup PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_SQL);
        preparedStatement.setString(1, entity.getName());
        preparedStatement.setString(2, entity.getSurName());
        preparedStatement.setLong(3, entity.getId());
        preparedStatement.executeUpdate();

        return entity;
    }

    @SneakyThrows
    @Override
    public Dao <Author, Long> deleteById(Long id) {
        @Cleanup Connection connection = ConnectionPool.get();
        @Cleanup PreparedStatement preparedStatement = connection.prepareStatement(DELETE_ID_SQL);
        preparedStatement.setLong(1, id);
        preparedStatement.executeUpdate();
        return this;
    }

    @Override
    public Dao <Author, Long> delete(Author entity) {
        return deleteById(entity.getId());
    }

    @SneakyThrows
    @Override
    public Dao <Author, Long> clear() {
        @Cleanup Connection connection = ConnectionPool.get();
        @Cleanup Statement statement = connection.createStatement();
        statement.executeQuery(DELETE_SQL);
        return this;
    }

    @SneakyThrows
    @Override
    public Long count() {
        @Cleanup Connection connection = ConnectionPool.get();
        @Cleanup Statement statement = connection.createStatement();
        @Cleanup ResultSet resultSet = statement.executeQuery(COUNT_SQL);
        return resultSet.next() ? resultSet.getLong(1) : 0L;
    }
}
