package taskmanagerproject;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
/**
 *
 * @author Gustavo E
 */
public class LoginController {

    @FXML
    private TextField campoUsuario;

    @FXML
    private void entrar() throws IOException {

        String username = campoUsuario.getText().trim();

        if (username.isEmpty()) {
            campoUsuario.setStyle(
                "-fx-border-color:red; -fx-border-width:2;"
            );
            return;
        }

        User user = UserDAO.loginOuCriar(username);


        if (user == null) {
            System.out.println("");
            return;
        }

        Session.usuarioLogado = user;

        System.out.println("Usuário logado: "
                + Session.usuarioLogado.getUsername()
                + " (ID: "
                + Session.usuarioLogado.getId()
                + ")");

        SceneManager.changeScene("TelaListagem.fxml");
    }
    
     @FXML
    private void fecharAplicacao() {
        javafx.application.Platform.exit();
        
    }
}