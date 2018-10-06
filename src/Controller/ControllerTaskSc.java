package Controller;

import ConnectionDatabase.ConnectionFactory;
import ConnectionDatabase.TaskDAO;
import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ControllerTaskSc {

    @FXML
    private TableView<?> listtask;

    @FXML
    private Button buttonlogout;

    @FXML
    private Button buttoncreatetask;

    @FXML
    private TextField tftask;

    @FXML
    private DatePicker pickdate;

    @FXML
    private TextArea tfdescription;

    @FXML
    private Button buttonedittask;

    @FXML
    private Button buttondeletetask;

    @FXML
    void actbuttoncreatetask(ActionEvent event) throws SQLException {
    	
    	String Titulo = tftask.getText();
        String Area   = tfdescription.getText();

        TaskDAO dao = new TaskDAO();
        dao.inserir(Titulo, Area);
        JOptionPane.showMessageDialog(null, "Tarefa foi criada com sucesso");
    }
        /*String nulo = "";
        String taskname = tftask.getText();
        String taskdesc = tfdescription.getText();
        //String date = pickdate.get();

        tftask.setText("");
        tfdescription.setText("");
        //tfemailregister.setText("");
        //Verifica se os campos não foram preenchidos.
        if (taskname.equals(nulo)) {
            JOptionPane.showMessageDialog(null, "Por favor, é necessário informar um nome para sua tarefa.");
        } else {
            //Insere os dados no banco de dados.
            Connection conn = ConnectionFactory.getConnection();

            PreparedStatement stmt = conn.prepareStatement("INSERT INTO tarefas(nomeTarefa,descTarefa) VALUES(\'" + taskname + "\', \'" + taskdesc + "\', \'");
            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Cadastro foi efetuado com sucesso, você será redirecionado para a tela de login.");
            conn.close();
        }

        }*/
    @FXML
    void actbuttonlogout (ActionEvent event){
        Main.changeScreen("login");
}
}
