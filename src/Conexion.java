import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conexion {
    String bd = "campus";
    String url = "jdbc:mysql://localhost:3306/";
    String user;
    String password;
    String driver = "com.mysql.cj.jdbc.Driver";
    Connection cx;

    public Conexion(String bd, String user, String password) {
        this.bd = bd;
        this.user = user;
        this.password = password;
    }

    public Connection conectar() {
        try {
            Class.forName(driver);
            cx = DriverManager.getConnection(url + bd, user, password);
            if (cx != null) {
                System.out.println("@@@@ CONECTADO A LA BASE DE DATOS @@@@ " + bd);
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("@@@ NO se conecto a " + bd + " " + ex.getMessage());
        }
        return cx;
    }

    public void desconectar() {
        try {
            if (cx != null && !cx.isClosed()) {
                cx.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void insertData(String tableName, String column1, String column2, String value1, String value2) {
        try {
            String query = "INSERT INTO " + tableName + " (" + column1 + ", " + column2 + ") VALUES (?, ?)";
            
            try (PreparedStatement statement = cx.prepareStatement(query)) {
                statement.setString(1, value1);
                statement.setString(2, value2);
                int rowsAffected = statement.executeUpdate();
                
                if (rowsAffected > 0) {
                    System.out.println("Data inserted successfully!");
                } else {
                    System.out.println("Failed to insert data.");
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void createTable(String tableName, String column1, String column2) {
        try {
            String query = "CREATE TABLE IF NOT EXISTS " + tableName + " (" + column1 + " VARCHAR(255), " + column2 + " VARCHAR(255))";
            
            try (Statement statement = cx.createStatement()) {
                statement.executeUpdate(query);
                System.out.println("Table created or already exists!");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void executeQuery(String query) {
        try {
            try (Statement statement = cx.createStatement(); ResultSet resultSet = statement.executeQuery(query)) {
                while (resultSet.next()) {
                    String column1Value = resultSet.getString("column1");
                    String column2Value = resultSet.getString("column2");
                    
                    System.out.println("Column1: " + column1Value + ", Column2: " + column2Value);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}