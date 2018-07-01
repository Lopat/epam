package com.ddemyanov.javase10.t02.db;

import lombok.experimental.Delegate;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.function.Consumer;

public class PooledConnection implements Connection {

    private Consumer<PooledConnection> closer;

    @Delegate(excludes = AutoCloseable.class)
    Connection connection;

    @Override
    public void close() {
        closer.accept(this);
    }

    public void reallyClose() throws SQLException {
        connection.close();
    }
}
