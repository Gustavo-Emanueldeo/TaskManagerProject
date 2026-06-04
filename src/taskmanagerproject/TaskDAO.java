/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package taskmanagerproject;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Gustavo E
 */

public class TaskDAO {

    public static void salvar(Task task) {

        String sql = "INSERT INTO tasks (title, description, user_id) VALUES (?, ?, ?)";

        try {
            Connection conn = DatabaseConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setString(1, task.getTitle());
            stmt.setString(2, task.getDescription());
            stmt.setInt(3, task.getUserId());

            stmt.executeUpdate();

            stmt.close();
            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static List<Task> listar() {

        List<Task> tasks = new ArrayList<>();

        String sql = "SELECT * FROM tasks WHERE user_id = ?";

        try {

            Connection conn = DatabaseConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setInt(1, Session.usuarioLogado.getId());

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {

                Task task = new Task();

                task.setId(rs.getInt("id"));
                task.setTitle(rs.getString("title"));
                task.setDescription(rs.getString("description"));
                task.setConcluded(rs.getBoolean("isChecked"));
                task.setUserId(rs.getInt("user_id"));

                tasks.add(task);
            }

            rs.close();
            stmt.close();
            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return tasks;
    }

    public static void atualizarStatus(int id, boolean isConcluded) {

        String sql = "UPDATE tasks SET isChecked = ? WHERE id = ?";

        try {

            Connection conn = DatabaseConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setBoolean(1, isConcluded);
            stmt.setInt(2, id);

            stmt.executeUpdate();

            stmt.close();
            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void atualizarTask(int id, String novoTitulo, String novaDescricao) {

        String sql = "UPDATE tasks SET title = ?, description = ? WHERE id = ?";

        try {

            Connection conn = DatabaseConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setString(1, novoTitulo);
            stmt.setString(2, novaDescricao);
            stmt.setInt(3, id);

            stmt.executeUpdate();

            stmt.close();
            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void excluir(int id) {

        String sql = "DELETE FROM tasks WHERE id = ?";

        try {

            Connection conn = DatabaseConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setInt(1, id);

            stmt.executeUpdate();

            stmt.close();
            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}