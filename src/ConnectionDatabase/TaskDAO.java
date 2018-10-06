package ConnectionDatabase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import Controller.ControllerLoginSc;

public class TaskDAO {

	public void inserir(String Titulo, String tarefa) throws SQLException{

        try(Connection conn = ConnectionFactory.getConnection();
            PreparedStatement preparedStatement = conn.prepareStatement("INSERT INTO tarefas(idUsuario, nomeTarefa, descTarefa) values(?,?,?)")){

            int usuario = ControllerLoginSc.idSessionUser;
            preparedStatement.setInt(1,usuario);
            preparedStatement.setString(2,Titulo); //Titulo da tarefa (coluna nome)
            preparedStatement.setString(3,tarefa); //Corpo da tarefa (coluna tarefa)

            preparedStatement.execute();

        }catch (Exception e){
            throw new RuntimeException(e);
        }


    }

	
}
