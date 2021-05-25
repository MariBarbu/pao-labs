package com.company.repository;

import com.company.Librarian;
import com.company.Section;
import com.company.config.DatabaseConfiguration;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class LibrarianRepository {
    public void createTable() {
        String createTableSql = "CREATE TABLE IF NOT EXISTS librarians" +
                "(id int PRIMARY KEY AUTO_INCREMENT, name varchar(30), hours int, birthDate varchar(30), " +
                 "library_id int,  FOREIGN KEY(library_id) REFERENCES libraries(id) ON DELETE CASCADE, " +
                "section_id int,  FOREIGN KEY(section_id) REFERENCES sections(id) ON DELETE CASCADE )";

        Connection connection = DatabaseConfiguration.getDatabaseConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(createTableSql);
            preparedStatement.execute(createTableSql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertLibrarian(String name, int hours, String birthDate, int library_id, int section_id) {
        String insertLibrarianSql = "INSERT INTO librarians(name, hours, birthDate, library_id, section_id) VALUES(?, ?, ?, ?, ?)";

        Connection connection = DatabaseConfiguration.getDatabaseConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(insertLibrarianSql);
            preparedStatement.setString(1, name);
            preparedStatement.setInt(2, hours);
            preparedStatement.setString(3, birthDate);
            preparedStatement.setInt(4, library_id);
            preparedStatement.setInt(5, section_id);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public Librarian getLibrarianById(int id) {
        String selectSql = "SELECT * FROM librarians WHERE id=?";

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

    public void updateLibrarianName(String name, int id) {
        String updateNameSql = "UPDATE librarians SET name=? WHERE id=?";

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

    public void deleteLibrarian(int id) {
        String deleteLibrarian = "DELETE FROM librarians WHERE id=?";

        Connection connection = DatabaseConfiguration.getDatabaseConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(deleteLibrarian);
            preparedStatement.setInt(1, id);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Librarian> getAll() {
        String selectSql = "SELECT * FROM librarians";

        Connection connection = DatabaseConfiguration.getDatabaseConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(selectSql);
            ResultSet resultSet = preparedStatement.executeQuery();
            ArrayList<Librarian> librarians = new ArrayList<>();
            while(resultSet.next()) {
                Librarian librarian = new Librarian(resultSet.getInt(1), resultSet.getString(2),
                        resultSet.getInt(3), resultSet.getString(4), resultSet.getInt(5),
                        resultSet.getInt(6));
                librarians.add(librarian);
            }
            return librarians;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    private Librarian mapToLibrary(ResultSet resultSet) throws SQLException {
        if (resultSet.next()) {
            return new Librarian(resultSet.getInt(1), resultSet.getString(2),
                    resultSet.getInt(3), resultSet.getString(4), resultSet.getInt(5),
                    resultSet.getInt(6));
        }
        return null;
    }
}
