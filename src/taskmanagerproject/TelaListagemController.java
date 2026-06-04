/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package taskmanagerproject;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 *
 * @author Gustavo E
 */
public class TelaListagemController {

    @FXML
    private VBox containerTasks;

    @FXML
    private void irParaCadastro() throws IOException {
        SceneManager.changeScene("TelaCadastro.fxml");
    }

    @FXML
    private void sair() throws IOException {

        Session.usuarioLogado = null;

        SceneManager.changeScene("Login.fxml");
    }

    @FXML
    private void initialize() {

        for (Task task : TaskDAO.listar()) {
            adicionarTask(task);
        }
    }

    public void adicionarTask(Task task) {

        try {

            FXMLLoader loader = new FXMLLoader(
                    getClass().getResource("TaskCard.fxml"));

            HBox card = loader.load();

            TaskCardController controller = loader.getController();
            controller.setTask(task);

            containerTasks.getChildren().add(card);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}