package PacoteBD;

import java.util.*;
import java.sql.*;

public class CarroDAO {

    private Connection con = null;

    public CarroDAO(Connection con) {
        setCon(con);
    }

    public Connection getCon() {
        return con;
    }

    public void setCon(Connection con) {
        this.con = con;
    }

    public String inserir(CarroBean carro) {

        String sql = "insert into carro(placa,cor,descricao)values(?,?,?)";

        try {
            PreparedStatement ps = getCon().prepareStatement(sql);

            ps.setString(1, carro.getPlaca());
            ps.setString(2, carro.getCor());
            ps.setString(3, carro.getDescricao());

            ps.executeUpdate();

            if (ps.executeUpdate() > 0) {
                return "Inserido com Sucesso!!";
            } else {
                return "Erro ao inserir!!";
            }

        } catch (SQLException e) {
            return e.getMessage();
        }
    }

    public String alterar(CarroBean carro) {

        String sql = "update carro set cor=?,descricao=?, where placa=?";

        try {
            PreparedStatement ps = getCon().prepareStatement(sql);

            ps.setString(1, carro.getCor());
            ps.setString(2, carro.getDescricao());
            ps.setString(3, carro.getPlaca());

            ps.executeUpdate();

            if (ps.executeUpdate() > 0) {
                return "Alterado com Sucesso!!";
            } else {
                return "Erro ao alterado!!";
            }

        } catch (SQLException e) {
            return e.getMessage();
        }
    }

    public String excluir(CarroBean carro) {

        String sql = "delete from carro where placa=?";

        try {
            PreparedStatement ps = getCon().prepareStatement(sql);

            ps.setString(1, carro.getPlaca());

            ps.executeUpdate();

            if (ps.executeUpdate() > 0) {
                return "Apagado com Sucesso!!";
            } else {
                return "Erro ao Apagar!!";
            }

        } catch (SQLException e) {
            return e.getMessage();
        }
    }
    
    public List<CarroBean> listaCarros(){
        
        String sql = "select * from carro"; 
    }

}
