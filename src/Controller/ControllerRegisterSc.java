package Controller;

import ConnectionDatabase.ConnectionFactory;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ControllerRegisterSc {

    public void clickbacktologin() {
        Main.changeScreen("login");
    }

    @FXML
    private TextField tfuserregister;

    @FXML
    private TextField tfemailregister;

    @FXML
    private PasswordField tfpassregister;

    @FXML
    private Button buttonregister2;

    @FXML
    void actbuttonregister2(ActionEvent actionEvent) throws SQLException {

        String nulo = "";
        String name = tfuserregister.getText();
        String password = tfpassregister.getText();
        String email = tfemailregister.getText();

        tfuserregister.setText("");
        tfpassregister.setText("");
        tfemailregister.setText("");
        //Verifica se os campos nao foram preenchidos.
        if (((name.equals(nulo)) || (password.equals(nulo))) || (email.equals(nulo))) {
            JOptionPane.showMessageDialog(null, "Por favor, e necessario preencher todos os campos.");
        }
        else{
            //Insere os dados no banco de dados.
            Connection conn = ConnectionFactory.getConnection();

            PreparedStatement stmt = conn.prepareStatement("INSERT INTO usuarios(nomeUsuario,senhaUsuario,emailUsuario) VALUES(\'" + name + "\', \'" + password + "\', \'" + email + "\')");
            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Cadastro foi efetuado com sucesso, voce sera redirecionado para a tela de login.");
            conn.close();
            Main.changeScreen("login");
        }
    }
}
