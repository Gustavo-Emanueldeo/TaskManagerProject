/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package taskmanagerproject;

import java.sql.*;
/**
 *
 * @author Gustavo E
 */
public class UserDAO {

    public static User loginOuCriar(String username) {

        try (Connection conn = DatabaseConnection.getConnection()) {


            String sql = "SELECT * FROM users WHERE username = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, username);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setUsername(rs.getString("username"));
                return user;
            }

            String insert = "INSERT INTO users (username) VALUES (?)";
            PreparedStatement stmt2 = conn.prepareStatement(insert, Statement.RETURN_GENERATED_KEYS);
            stmt2.setString(1, username);
            stmt2.executeUpdate();

            ResultSet keys = stmt2.getGeneratedKeys();

            if (keys.next()) {
                User user = new User();
                user.setId(keys.getInt(1));
                user.setUsername(username);
                return user;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
}