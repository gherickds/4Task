package ConnectionDatabase;

import java.sql.Connection;

public class BaseDAO {

    /**
     * Classe base DAO para reduzir o acomplamento das classes DAO com a classe ConnectionFactory.java
     */
        Connection getConnection(){
            return ConnectionFactory.getConnection();
        }

    }
