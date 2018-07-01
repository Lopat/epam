package com.ddemyanov.javase10.t01;

import java.sql.*;

public class JDBC {

    private static final String URL = "jdbc:h2:mem:test;DB_CLOSE_DELAY=-1";
    private static final String CREATE_SQL = "CREATE TABLE students (id IDENTITY, name varchar, surname varchar, age int)";
    private static final String INSERT_SQL = "INSERT INTO students (name, surname, age) VALUES ('Vasya', 'Pupkin', 28)";
    private static final String INSERT2_SQL = "INSERT INTO students (name, surname, age) VALUES ('Olga', 'Nikolaeva', 29)";
    private static final String PREP_INSERT_SQL = "INSERT INTO students (name, surname, age) VALUES (?, ?, ?)";
    private static final String PREP_GET_SQL = "SELECT name FROM students where age BETWEEN ? and ?";

    public static void main(String[] args) throws SQLException {

        Connection connection = DriverManager.getConnection(URL);
        Statement st = connection.createStatement();

        st.executeUpdate(CREATE_SQL);
        st.executeUpdate(INSERT_SQL);
        st.executeUpdate(INSERT2_SQL);

        PreparedStatement ps = connection.prepareStatement(PREP_INSERT_SQL);
        ps.setString(1, "Vitaly");
        ps.setString(2, "Sergeev");
        ps.setInt(3, 22);

        PreparedStatement ps2 = connection.prepareStatement(PREP_GET_SQL);
        ps2.setInt(1, 28);
        ps2.setInt(2, 30);
        ResultSet result = ps2.executeQuery();
        System.out.println("Get names of students aged between 28 and 30");
        while (result.next()){
            System.out.println(result.getString(1));
        }


        ps.executeUpdate();

        ResultSet rs = st.executeQuery("SELECT id, name, surname, groupnum FROM students");
        System.out.println("Everything from students");
        while(rs.next()){
            System.out.println(String.format("%d : %s : %s : %d", rs.getInt(1), rs.getString(2),
                    rs.getString(3), rs.getInt(4)));
        }

        st.execute("DELETE FROM students");
        st.close();
        ps.close();
        ps2.close();
        connection.close();
    }
}
