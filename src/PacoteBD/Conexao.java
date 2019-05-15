package PacoteBD;

import java.sql.*;

public class Conexao {

    public static Connection abrirConexao() {
        Connection con = null;

        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();

            String url = "jdbc:mysql://127.0.0.1/estacionamento?"
                    + "user=root&password=";

            con = DriverManager.getConnection(url);

            System.out.println("Conexao Aberta!!");

        } catch (SQLException e) {
        } catch (ClassNotFoundException e) {
        } catch (Exception e) {
        }
        return con;
    }

    public void fecharConexao(Connection con) {
        try {
            con.close();
        } catch (SQLException e) {

        } catch (Exception e) {

        }
    }
}
