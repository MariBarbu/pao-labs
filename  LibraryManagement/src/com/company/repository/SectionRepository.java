package com.company.repository;

import com.company.Library;
import com.company.Section;
import com.company.config.DatabaseConfiguration;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SectionRepository {
    public void createTable() {
        String createTableSql = "CREATE TABLE IF NOT EXISTS sections" +
                "(id int PRIMARY KEY AUTO_INCREMENT, name varchar(30)," +
                "floor int, library_id int, FOREIGN KEY (library_id) REFERENCES libraries(id) ON DELETE CASCADE)";

        Connection connection = DatabaseConfiguration.getDatabaseConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(createTableSql);
            preparedStatement.execute(createTableSql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertSection(String name, int floor, int library_id) {
        String insertSectionSql = "INSERT INTO sections(name, floor, library_id) VALUES(?, ?, ?)";

        Connection connection = DatabaseConfiguration.getDatabaseConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(insertSectionSql);
            preparedStatement.setString(1, name);
            preparedStatement.setInt(2, floor);
            preparedStatement.setInt(3, library_id);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public Section getSectionById(int id) {
        String selectSql = "SELECT * FROM sections WHERE id=?";

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

    public void updateSectionName(String name, int id) {
        String updateNameSql = "UPDATE sections SET name=? WHERE id=?";

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

    public void deleteSection(int id) {
        String deleteSection = "DELETE FROM sections WHERE id=?";

        Connection connection = DatabaseConfiguration.getDatabaseConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(deleteSection);
            preparedStatement.setInt(1, id);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Section> getAll(int library_id) {
        String selectSql = "SELECT * FROM sections WHERE library_id=?";

        Connection connection = DatabaseConfiguration.getDatabaseConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(selectSql);
            preparedStatement.setInt(1, library_id);
            ResultSet resultSet = preparedStatement.executeQuery();
            ArrayList<Section> sections = new ArrayList<>();
            while(resultSet.next()) {
                Section section = new Section(resultSet.getInt(1), resultSet.getString(2), resultSet.getInt(3), resultSet.getInt(4));
                sections.add(section);
            }
            return sections;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    private Section mapToLibrary(ResultSet resultSet) throws SQLException {
        if (resultSet.next()) {
            return new Section(resultSet.getInt(1), resultSet.getString(2), resultSet.getInt(3), resultSet.getInt(4));
        }
        return null;
    }
}
