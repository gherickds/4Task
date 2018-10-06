package Controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


import ConnectionDatabase.ConnectionFactory;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import javax.swing.JOptionPane;

public class ControllerLoginSc {

        @FXML
        private Button buttonlogin;

        @FXML
        private CheckBox boxremember;

        @FXML
        private PasswordField tfpass;

        @FXML
        private TextField tfuser;

        @FXML
        private Button buttonregister;

        public static int idSessionUser;

        @FXML
        void actbuttonlogin(ActionEvent event) throws SQLException {
        	
            Connection conn = ConnectionFactory.getConnection();
            Statement stat = conn.createStatement();
            ResultSet result = stat.executeQuery("SELECT idUsuario,nomeUsuario,senhaUsuario,emailUsuario FROM usuarios");

            //Login
            while (result.next()){
            	int    userID = result.getInt("idUsuario");
                String email = result.getString("emailUsuario");
                String senha = result.getString("senhaUsuario");
                
                if ((email.equals(tfuser.getText())) && (senha.equals(tfpass.getText()))){
                System.out.println("foi");
                idSessionUser = userID; //Pega o id do usuario para uma variavel global.
                JOptionPane.showMessageDialog(null, "Login efetuado com sucesso");
            	Main.changeScreen("task");
                }
            	
                else{
                
                }
            }
            //int idUsuarioSessao = Integer.parseInt(result.getString("idUsuario"));
            //System.out.println(idUsuarioSessao);
            conn.close();
        }

        @FXML
        void actbuttonregister(ActionEvent event) {
            Main.changeScreen("register");
        }

        @FXML
        void initialize() {
            assert buttonlogin != null : "fx:id=\"buttonlogin\" was not injected: check your FXML file 'loginscreen.fxml'.";
            assert boxremember != null : "fx:id=\"boxremember\" was not injected: check your FXML file 'loginscreen.fxml'.";
            assert tfpass != null : "fx:id=\"tfpass\" was not injected: check your FXML file 'loginscreen.fxml'.";
            assert tfuser != null : "fx:id=\"tfuser\" was not injected: check your FXML file 'loginscreen.fxml'.";
            assert buttonregister != null : "fx:id=\"buttonregister\" was not injected: check your FXML file 'loginscreen.fxml'.";

        }
    }
