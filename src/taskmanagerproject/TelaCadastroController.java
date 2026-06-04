/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package taskmanagerproject;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 *
 * @author Gustavo E
 */
public class TelaCadastroController {

    @FXML
    private TextField campoTitulo;

    @FXML
    private TextArea campoDescricao;

    @FXML
    private void salvarTask() throws IOException {

        String titulo = campoTitulo.getText().trim();
        String descricao = campoDescricao.getText();

        if (titulo.isEmpty()) {
            campoTitulo.setStyle("-fx-border-color: red; -fx-border-width: 2;");
            animarErro(campoTitulo);
            return;
        }

        if (TaskRepository.taskEmEdicao == null) {

            Task novaTask = new Task();
            novaTask.setTitle(titulo);
            novaTask.setDescription(descricao);

            novaTask.setUserId(Session.usuarioLogado.getId());

            TaskDAO.salvar(novaTask);

        } else {

            Task task = TaskRepository.taskEmEdicao;

            task.setTitle(titulo);
            task.setDescription(descricao);

            TaskDAO.atualizarTask(
                task.getId(),
                titulo,
                descricao
            );

            TaskRepository.taskEmEdicao = null;
        }

        SceneManager.changeScene("TelaListagem.fxml");
    }

    private void animarErro(javafx.scene.Node node) {

        javafx.animation.TranslateTransition shake =
                new javafx.animation.TranslateTransition(
                        javafx.util.Duration.millis(50), node);

        shake.setFromX(0);
        shake.setByX(10);
        shake.setCycleCount(6);
        shake.setAutoReverse(true);

        shake.play();
    }

    @FXML
    private void cancelar() throws IOException {
        TaskRepository.taskEmEdicao = null;
        SceneManager.changeScene("TelaListagem.fxml");
    }

    @FXML
    private void sair() throws IOException {

        Session.usuarioLogado = null;
        TaskRepository.taskEmEdicao = null;

        SceneManager.changeScene("Login.fxml");
    }
}