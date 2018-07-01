package com.ddemyanov.javase10.t02.db;

import lombok.SneakyThrows;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.concurrent.BlockingQueue;
import java.util.function.Supplier;

public class ConnectionPool {

//    final BlockingQueue<PooledConnection> freeConnections;
    volatile boolean isOpened = true;

    @SneakyThrows
    public static Connection get() {
        return DriverManager.getConnection("jdbc:h2:mem:test;DB_CLOSE_DELAY=-1");
    }
}
