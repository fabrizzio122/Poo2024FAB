package pe.edu.upeu.syscenterlife.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import pe.edu.upeu.syscenterlife.connx.ConnS;
import pe.edu.upeu.syscenterlife.modelo.Cliente;

public class ClienteDao {

    ConnS instance = ConnS.getInstance();
    Connection connection = instance.getConnection();
    PreparedStatement ps;
    ResultSet rs = null;

    public List<Cliente> listarCliente() {
        List<Cliente> lista = new ArrayList<>();
        try {
            ps = connection.prepareStatement("SELECT * from cliente");
            rs = ps.executeQuery();
            while (rs.next()) {
                lista.add(Cliente.builder()
                        .dniruc(rs.getString("dniruc"))
                        .nombres(rs.getString("nombres"))
                        .documento(rs.getString("documento"))
                        .build());
            }
        } catch (Exception e) {
        }
        return lista;
    }
    public int guardarCliente(Cliente c){
        int result=0;
        try {
            ps=connection.prepareStatement("INSERT INTO cliente(dniruc, nombres, documento)"
                    +" VALUES('"+c.getDniruc()+"', '"+c.getNombres()+"', '"+c.getDocumento()+"')");
                    result= ps.executeUpdate();
        ps.executeUpdate();
            
        } catch (Exception e) {
            System.err.println("Error: "+e.getMessage());
        }
        return result;
    }

}
