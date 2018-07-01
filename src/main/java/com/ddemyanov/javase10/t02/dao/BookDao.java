package com.ddemyanov.javase10.t02.dao;

import com.ddemyanov.javase10.t02.db.ConnectionPool;
import com.ddemyanov.javase10.t02.model.Author;
import com.ddemyanov.javase10.t02.model.Book;
import lombok.Cleanup;
import lombok.SneakyThrows;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class BookDao implements Dao<Book, Long> {

    private static final String COUNT_SQL = "SELECT count(id) FROM book";
    private static final String DELETE_SQL = "DELETE FROM book";
    private static final String DELETE_ID_SQL = "DELETE FROM  book WHERE id = ?";
    private static final String UPDATE_SQL = "UPDATE book SET name = ?, surname = ? " + "WHERE id = ?";
    private static final String SELECT_ALL_SQL = "SELECT * FROM book";
    private static final String GET_ONE_SQL = "SELECT * FROM book WHERE id = ?";
    private static final String CREATE_SQL = "INSERT INTO author (name, surname) VALUES (?, ?)";

    @SneakyThrows
    @Override
    public Book create(Book entity) {
        @Cleanup Connection connection = ConnectionPool.get();
        @Cleanup PreparedStatement prepStatement = connection.prepareStatement(CREATE_SQL, Statement
                .RETURN_GENERATED_KEYS);

        prepStatement.executeQuery();

        @Cleanup ResultSet resultSet = prepStatement.getGeneratedKeys();
        entity.setId(resultSet.getLong(1));

        prepStatement.close();
        return entity;
    }

    @SneakyThrows
    @Override
    public Optional<Book> getById(Long id) {
        @Cleanup Connection connection = ConnectionPool.get();
        @Cleanup PreparedStatement st = connection.prepareStatement(GET_ONE_SQL);
        st.setLong(1, id);
        @Cleanup ResultSet rs = st.executeQuery();

        return Optional.ofNullable(rs.next() ? Book.builder()
                                                     .build() : null);
    }

    @SneakyThrows
    @Override
    public List<Book> getAll() {

        List <Book> list = new ArrayList<>();
        @Cleanup Connection connection = ConnectionPool.get();
        @Cleanup Statement statement = connection.createStatement();
        @Cleanup ResultSet resultSet = statement.executeQuery(SELECT_ALL_SQL);

        while (resultSet.next()) {
            list.add(Book.builder()
                           .build());
        }

        return list;
    }

    @SneakyThrows
    @Override
    public Book update(Book entity) {
        @Cleanup Connection connection = ConnectionPool.get();
        @Cleanup PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_SQL);

        preparedStatement.executeUpdate();
        return entity;
    }

    @SneakyThrows
    @Override
    public Dao <Book, Long> deleteById(Long id) {
        @Cleanup Connection connection = ConnectionPool.get();
        @Cleanup PreparedStatement preparedStatement = connection.prepareStatement(DELETE_ID_SQL);
        preparedStatement.setLong(1, id);
        preparedStatement.executeUpdate();
        return this;
    }

    @Override
    public Dao <Book, Long> delete(Book entity) {
        return deleteById(entity.getId());
    }

    @SneakyThrows
    @Override
    public Dao <Book, Long> clear() {
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
