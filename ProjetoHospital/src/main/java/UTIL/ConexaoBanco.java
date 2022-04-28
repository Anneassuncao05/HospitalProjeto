package UTIL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

 public class ConexaoBanco {
        public static Connection getConnection() {
            String usuario = "root";
            String senha = "BD@Anne123";
            String url = "jdbc:mysql://localhost:3306/projetohospital";
            String driver = "com.mysql.cj.jdbc.Driver";
            try {
                Class.forName(driver);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ConexaoBanco.class.getName()).log(Level.SEVERE, null, ex);
            }
            Connection connection = null;
            try {
                connection = DriverManager.getConnection(url, usuario, senha);
            } catch (SQLException ex) {
                Logger.getLogger(ConexaoBanco.class.getName()).log(Level.SEVERE, null, ex);
            }
            return connection;
    }  

}