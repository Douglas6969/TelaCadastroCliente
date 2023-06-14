package unipar.exemplo.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionGeneric {

    public Connection conn;
    public Statement statement;

    private final String URL = "jdbc:postgresql://localhost:5432/";
    private final String USERNAME = "postgres";
    private final String PASSWORD = "adm123";
    private final String DBNAME = "Unipar";

    private String urlConnection = "";

    public ConnectionGeneric(){
        this.urlConnection = URL + DBNAME;
    }

    public void getConnection() throws SQLException {
        Connection conn = DriverManager.getConnection(this.urlConnection,USERNAME,PASSWORD);
        this.statement = conn.createStatement();
        this.conn = conn;

    }

    public void closeConnection() throws SQLException {
        this.conn.close();
    }

}
