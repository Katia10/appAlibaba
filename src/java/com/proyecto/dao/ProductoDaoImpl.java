
package com.proyecto.dao;

import java.util.List;
import com.proyecto.modelo.Producto;
import com.proyecto.db.ConectarDB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProductoDaoImpl implements IDAO{
    ConectarDB con;
    PreparedStatement psmt = null;
    ResultSet rs = null;
    String respuesta = null;
    Producto prod;

    public ProductoDaoImpl() {
        con = new ConectarDB();
        con.setDriver("com.mysql.jdbc.Driver");
        con.setUrl("jdbc:mysql://localhost:3306/ventas");
        con.setUsuario("root");
        
        con.setPassword("");
    }
        
    @Override
    public String insertar(Object obj) throws SQLException{
        Producto objProd =  (Producto) obj;
        try {
            psmt = con.conectar().prepareStatement("INSERT INTO productos VALUES (null,?,?,?,?,?,?,?)");
            psmt.setString(1, objProd.getCodProducto());
            psmt.setString(2, objProd.getNombre());
            psmt.setDouble(3, objProd.getPrecioCompra());
            psmt.setDouble(4, objProd.getPrecioVenta());
            psmt.setInt(5, objProd.getCantidad());
            psmt.setInt(6, objProd.getIdCategoria());
            psmt.setString(7, objProd.getEstado());
            psmt.executeUpdate();
            respuesta = "El registro se realizo con exito";
            
        } catch (Exception e) {
            throw new SQLException("Error al registrar: " + e.toString());
        }finally{
            if(psmt!=null){
                psmt.close();
            }
            
            con.desconectar();
            
        }
        return respuesta;
    }

    @Override
    public String eliminar(Object obj) throws SQLException{
        Producto objProd = (Producto) obj;
        try {
            psmt = con.conectar().prepareStatement("UPDATE productos SET estado=? WHERE idProducto=?");
            psmt.setString(1, "Inactivo");
            psmt.setInt(2, Integer.parseInt(objProd.getIdProducto()));
            psmt.executeUpdate();
            respuesta = "El registro se realizo con exito";
        } catch (SQLException e) {
            throw new SQLException("Error al registrar: " + e.toString()); 
        }finally{
            if(psmt!=null){
                psmt.close();
            }
            
            con.desconectar();
            
        }
        return respuesta;
    }

    @Override
    public String modificar(Object obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Producto> listar() throws SQLException{
       List<Producto> listaProd = new ArrayList<>();
        try {
            psmt = con.conectar().prepareStatement("SELECT * FROM productos");
            rs = psmt.executeQuery();
            while (rs.next()) {                
                listaProd.add(Producto.load(rs));
            }
        } catch (Exception e) {
            System.out.println("Error en la consulta: " + e);
        }finally{
            if(psmt!=null){
                psmt.close();
            }
            if(rs!=null){
                rs.close();
            }
            
            con.desconectar();
        }
       return listaProd;
    }

    @Override
    public Object buscarPorID(String id) throws SQLException {
        
        try {
            psmt = con.conectar().prepareStatement("SELECT * FROM productos WHERE idProducto=?");
            psmt.setString(1,id);
            rs = psmt.executeQuery();
            while (rs.next()) {                
                
                prod =  Producto.load(rs);
            }
        } catch (SQLException e) {
            System.out.println("Error en la consulta: " + e);
        }finally{
            if(psmt!=null){
                psmt.close();
            }
            if(rs!=null){
                rs.close();
            }
            
            con.desconectar();
        }
        
       return prod;
    }

    @Override
    public int contar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean existe(Object id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<?> busquedaPorParametro(String field, Object param) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<?> existeUsuario(String usuario, String clave) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   @Override
   public String generarCodigo()throws SQLException{
               String codigo = null;
        try {
            psmt=con.conectar().prepareStatement("SELECT COUNT(idProducto) FROM productos");
            rs=psmt.executeQuery();
            while(rs.next()){
                //codigo = "P000" + rs.getString(1).length();
//                codigo = "P000" + rs.getString(1);
                switch(rs.getString(1).length()){
                    case 1:
                        codigo = "P000" + rs.getString(1);
                        break;
                    case 2:
                        codigo = "P00" + rs.getString(1);
                        break;
                    case 3:
                        codigo = "P0" + rs.getString(1);
                        break;
                    case 4:
                        codigo = "P" + rs.getString(1);
                        break;
                   default: break;
                     
                    
                }
         }
            
            
        } catch (Exception e) {
            throw new SQLException("Erro al generar código: "+e.toString());

        }
         return codigo;
   }
    
    
    
}
