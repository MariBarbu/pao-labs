package com.company.repository;

import com.company.Book;
import com.company.Section;
import com.company.config.DatabaseConfiguration;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BookRepository {
    public void createTable() {
        String createTableSql = "CREATE TABLE IF NOT EXISTS books" +
                "(id int PRIMARY KEY AUTO_INCREMENT, title varchar(30), " + "author varchar(30), " +
                "description varchar(1000), year int, section_id int, FOREIGN KEY(section_id) REFERENCES sections(id) ON DELETE CASCADE)";

        Connection connection = DatabaseConfiguration.getDatabaseConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(createTableSql);
            preparedStatement.execute(createTableSql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertBook(String title, String author, String description, int year, int section_id) {
        String insertBookSql = "INSERT INTO books(title, author, description, year, section_id) VALUES(?, ?, ?, ?, ?)";

        Connection connection = DatabaseConfiguration.getDatabaseConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(insertBookSql);
            preparedStatement.setString(1, title);
            preparedStatement.setString(2, author);
            preparedStatement.setString(3, description);
            preparedStatement.setInt(4, year);
            preparedStatement.setInt(5, section_id);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public Book getBookById(int id) {
        String selectSql = "SELECT * FROM books WHERE id=?";

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

    public void updateBookTitle(String title, int id) {
        String updateTitleSql = "UPDATE books SET title=? WHERE id=?";

        Connection connection = DatabaseConfiguration.getDatabaseConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(updateTitleSql);
            preparedStatement.setString(1, title);
            preparedStatement.setInt(2, id);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteBook(int id) {
        String deleteBook = "DELETE FROM books WHERE id=?";

        Connection connection = DatabaseConfiguration.getDatabaseConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(deleteBook);
            preparedStatement.setInt(1, id);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Book> getAll(int section_id) {
        String selectSql = "SELECT * FROM books WHERE section_id=?";

        Connection connection = DatabaseConfiguration.getDatabaseConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(selectSql);
            preparedStatement.setInt(1, section_id);
            ResultSet resultSet = preparedStatement.executeQuery();
            ArrayList<Book> sections = new ArrayList<>();
            while(resultSet.next()) {
                Book book = new Book(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3),  resultSet.getString(4), resultSet.getInt(5), resultSet.getInt(6));
                sections.add(book);
            }
            return sections;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    private Book mapToLibrary(ResultSet resultSet) throws SQLException {
        if (resultSet.next()) {
            return new Book(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4), resultSet.getInt(5), resultSet.getInt(6));
        }
        return null;
    }


}
