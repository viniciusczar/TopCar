import java.sql.*;

public class FabricaDeConexoes {
	
    public Connection solicitaConexao(String host, String banco, String usuario, String senha) {
        try {
            return DriverManager.getConnection("jdbc:mysql://" + "127.0.0.1" + "/" + "Concessionaria", "root", "");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
