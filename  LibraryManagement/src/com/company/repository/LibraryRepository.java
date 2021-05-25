package com.company.repository;

import com.company.Library;
import com.company.config.DatabaseConfiguration;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class LibraryRepository {
    public void createTable() {
        String createTableSql = "CREATE TABLE IF NOT EXISTS libraries" +
                "(id int PRIMARY KEY AUTO_INCREMENT, name varchar(30)," +
                "address varchar(30))";

        Connection connection = DatabaseConfiguration.getDatabaseConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(createTableSql);
            preparedStatement.execute(createTableSql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertLibrary(String name, String address) {
        String insertLibrarySql = "INSERT INTO libraries(name, address) VALUES(?, ?)";

        Connection connection = DatabaseConfiguration.getDatabaseConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(insertLibrarySql);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, address);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public Library getLibraryById(int id) {
        String selectSql = "SELECT * FROM libraries WHERE id=?";

        Connection connection = DatabaseConfiguration.getDatabaseConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(selectSql);
            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();
            return mapToLibrary(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void updateLibraryName(String name, int id) {
        String updateNameSql = "UPDATE libraries SET name=? WHERE id=?";

        Connection connection = DatabaseConfiguration.getDatabaseConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(updateNameSql);
            preparedStatement.setString(1, name);
            preparedStatement.setInt(2, id);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteLibrary(int id) {
        String deleteLibrary = "DELETE FROM libraries WHERE id=?";

        Connection connection = DatabaseConfiguration.getDatabaseConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(deleteLibrary);
            preparedStatement.setInt(1, id);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Library> getAll() {
        String selectSql = "SELECT * FROM libraries";

        Connection connection = DatabaseConfiguration.getDatabaseConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(selectSql);

            ResultSet resultSet = preparedStatement.executeQuery();
            ArrayList<Library> libraries = new ArrayList<>();
            while(resultSet.next()) {
                Library library = new Library(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3));
                libraries.add(library);
            }
            return libraries;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    private Library mapToLibrary(ResultSet resultSet) throws SQLException {
        if (resultSet.next()) {
            return new Library(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3));
        }
        return null;
    }
}
