/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package taskmanagerproject;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 *
 * @author Gustavo E
 */
public class TaskCardController {
    @FXML
    private Label tituloLabel;
    
    @FXML
    private Label descricaoLabel;
    
    @FXML
    private HBox taskCard;
    
    @FXML
    private CheckBox checkBoxTask;
    
    private Task task;
    
    public void setTask(Task task) {
        this.task = task;
        
        tituloLabel.setText(task.getTitle());
        descricaoLabel.setText(task.getDescription());
        checkBoxTask.setSelected(task.isConcluded());
        
    }
    
    @FXML
    private void excluirTask() {
        TaskDAO.excluir(task.getId());
        
        VBox containerTasks = (VBox) taskCard.getParent();
        containerTasks.getChildren().remove(taskCard);
    }
    
    @FXML
    private void alterarStatusTask() {
        boolean novoStatus = checkBoxTask.isSelected();
        
        task.setConcluded(novoStatus);
        TaskDAO.atualizarStatus(task.getId(),novoStatus);
    }
    
    @FXML
    private void editarTask() throws IOException {
        TaskRepository.taskEmEdicao = task;
        SceneManager.changeScene("TelaCadastro.fxml");
    }
}
