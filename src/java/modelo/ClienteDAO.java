/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import conexionBD.ConexionBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author PERSONAL
 */
public class ClienteDAO {

    ConexionBD con = new ConexionBD();
    Connection cnx;
    PreparedStatement ps;
    ResultSet rs;
    
    public ClienteM buscar(String dni)
    {
        ClienteM cli = new ClienteM();
        String sql = "select * from cliente where dni ="+dni;
        try {
            cnx = con.ConexionBD();
            //prepara la sentencia sql
            ps = cnx.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
   
                cli.setId(rs.getInt(1));
                cli.setDni(rs.getString(2));
                cli.setNombres(rs.getString(3));
                cli.setDirec(rs.getString(4));
                cli.setTel(rs.getString(5));
                cli.setEstado(rs.getString(6));

               
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cli;
    
    }
    
    int resultado;
    
    public List mostrar() {
        String sql = "select * from cliente";

        List<ClienteM> lista = new ArrayList<>();

        try {
            cnx = con.ConexionBD();
            //prepara la sentencia sql
            ps = cnx.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                ClienteM cli = new ClienteM();
                cli.setId(rs.getInt(1));
                cli.setDni(rs.getString(2));
                cli.setNombres(rs.getString(3));
                cli.setDirec(rs.getString(4));
                cli.setTel(rs.getString(5));
                cli.setEstado(rs.getString(6));

                lista.add(cli);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }
    
    public int insertar(ClienteM cli){
        
        try {
            String sql = "insert into cliente(dni,nombres,direccion,telefono,estado) values(?,?,?,?,?)";

            cnx = con.ConexionBD();
            //prepara la sentencia sql
            ps = cnx.prepareStatement(sql);
            ps.setString(1, cli.getDni());
            ps.setString(2, cli.getNombres());
            ps.setString(3, cli.getDirec());
            ps.setString(4, cli.getTel());
            ps.setString(5, cli.getEstado());

            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultado;
    }
    
    public ClienteM cargar(int id) {
        ClienteM cli = new ClienteM();
        String sql = "select * from cliente where idCliente=" + id;
        try {

            cnx = con.ConexionBD();
            //prepara la sentencia sql
            ps = cnx.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                cli.setDni(rs.getString(2));
                cli.setNombres(rs.getString(3));
                cli.setDirec(rs.getString(4));
                cli.setTel(rs.getString(5));
                cli.setEstado(rs.getString(6));

            }
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cli;

    }
    
    public int modificar(ClienteM cli) {
        String sql = "update cliente set Dni=?, Nombres=?, Direccion=?, Telefono=?, Estado=? where idCliente=?";

        try {

            cnx = con.ConexionBD();
            //prepara la sentencia sql
            ps = cnx.prepareStatement(sql); 
            ps.setString(1, cli.getDni());
            ps.setString(2, cli.getNombres());
            ps.setString(3, cli.getDirec());
            ps.setString(4, cli.getTel());
            ps.setString(5, cli.getEstado());
            ps.setInt(6,cli.getId());

            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultado;

    }
    
    public void eliminar(int id) {
        String sql = "delete from cliente where idCliente=" + id;
        try {

            cnx = con.ConexionBD();
            //prepara la sentencia sql
            ps = cnx.prepareStatement(sql);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
          

