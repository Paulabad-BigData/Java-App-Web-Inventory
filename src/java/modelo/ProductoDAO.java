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
public class ProductoDAO {

    ConexionBD con = new ConexionBD();
    Connection cnx;
    PreparedStatement ps;
    ResultSet rs;

    public ProductoM buscar(String serial)
    {
        ProductoM pro = new ProductoM();
        String sql = "select * from producto where serial ="+serial;
        
         List<ProductoM> lista = new ArrayList<>();

        try {
            cnx = con.ConexionBD();
            //prepara la sentencia sql
            ps = cnx.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
               
                pro.setId(rs.getInt(1));
                pro.setSerial(rs.getString(2));
                pro.setDescrip(rs.getString(3));
                pro.setPrecio(rs.getDouble(4));
                pro.setStock(rs.getInt(5));
                pro.setEstado(rs.getString(6));

                
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return pro;
    
    }
    
    
    int resultado;

    public List mostrar() {
        String sql = "select * from producto";

        List<ProductoM> lista = new ArrayList<>();

        try {
            cnx = con.ConexionBD();
            //prepara la sentencia sql
            ps = cnx.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                ProductoM pro = new ProductoM();
                pro.setId(rs.getInt(1));
                pro.setSerial(rs.getString(2));
                pro.setDescrip(rs.getString(3));
                pro.setPrecio(rs.getDouble(4));
                pro.setStock(rs.getInt(5));
                pro.setEstado(rs.getString(6));

                lista.add(pro);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }

    public int insertar(ProductoM pro) {

        try {
            String sql = "insert into producto(serial,descripcion,precio,stock,estado) values(?,?,?,?,?)";

            cnx = con.ConexionBD();
            //prepara la sentencia sql
            ps = cnx.prepareStatement(sql);
            ps.setString(1, pro.getSerial());
            ps.setString(2, pro.getDescrip());
            ps.setDouble(3, pro.getPrecio());
            ps.setInt(4, pro.getStock());
            ps.setString(5, pro.getEstado());

            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ProductoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultado;
    }

    public ProductoM cargar(int id) {
        ProductoM pro = new ProductoM();
        String sql = "select * from producto where idProducto=" + id;
        try {

            cnx = con.ConexionBD();
            //prepara la sentencia sql
            ps = cnx.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                pro.setSerial(rs.getString(2));
                pro.setDescrip(rs.getString(3));
                pro.setPrecio(rs.getDouble(4));
                pro.setStock(rs.getInt(5));
                pro.setEstado(rs.getString(6));

            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return pro;

    }
    
     public int modificar(ProductoM pro) {
        String sql = "update producto set Serial=?, Descripcion=?, Precio=?, Stock=?, Estado=? where idProducto=?";

        try {

             cnx = con.ConexionBD();
            //prepara la sentencia sql
            ps = cnx.prepareStatement(sql);
            ps.setString(1, pro.getSerial());
            ps.setString(2, pro.getDescrip());
            ps.setDouble(3, pro.getPrecio());
            ps.setInt(4, pro.getStock());
            ps.setString(5, pro.getEstado());
            ps.setInt(6,pro.getId());

            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ProductoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultado;

    }
     public void eliminar(int id) {
        String sql = "delete from producto where idProducto=" + id;
        try {

            cnx = con.ConexionBD();
            //prepara la sentencia sql
            ps = cnx.prepareStatement(sql);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ProductoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
