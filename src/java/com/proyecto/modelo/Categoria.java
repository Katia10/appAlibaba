
package com.proyecto.modelo;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Categoria {
    private String idCategoria;
    private String descripcion;
    private String estado;

    public Categoria(String idCategoria, String descripcion, String estado) {
        this.idCategoria = idCategoria;
        this.descripcion = descripcion;
        this.estado = estado;
    }

    public Categoria() {
    }
    
    public static Categoria load(ResultSet rs)throws SQLException{
        Categoria objCategoria = new Categoria();
        objCategoria.setIdCategoria(rs.getString(1));
        objCategoria.setDescripcion(rs.getString(2));
        objCategoria.setEstado(rs.getString(3));
        
        return objCategoria;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(String idCategoria) {
        this.idCategoria = idCategoria;
    }

    @Override
    public String toString() {
        return descripcion;
    }
    
    
    
}
