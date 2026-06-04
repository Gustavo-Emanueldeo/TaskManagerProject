/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package taskmanagerproject;

import java.io.IOException;
import javafx.application.Application;
import javafx.stage.Stage;
import java.sql.Connection;

/**
 *
 * @author Gustavo E
 */


public class TaskManagerProject extends Application {

    @Override
    public void start(Stage stage) throws IOException {

        SceneManager.setStage(stage);

        
        SceneManager.changeScene("Login.fxml");

        stage.setTitle("Task Manager");
        stage.show();
    }

    public static void main(String[] args) {

        try {
            Connection connection = DatabaseConnection.getConnection();
            System.out.println("Conectado com sucesso");
        } catch (Exception e) {
            System.out.println("Não foi possível conectar-se");
            e.printStackTrace();
        }

        launch(args);
    }
}
