/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.proyecto.modelo;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author toshiba
 */
public class Producto {
    private String idProducto;
    private String codProducto;
    private String nombre;
    private double precioCompra;
    private double precioVenta;
    private int cantidad;
    private int idCategoria;
    private String estado;

    public Producto() {
    }

    public Producto(String idProducto, String codProducto, String nombre, double precioCompra, double precioVenta, int cantidad, int idCategoria, String estado) {
        this.idProducto = idProducto;
        this.codProducto = codProducto;
        this.nombre = nombre;
        this.precioCompra = precioCompra;
        this.precioVenta = precioVenta;
        this.cantidad = cantidad;
        this.idCategoria = idCategoria;
        this.estado = estado;
    }
    
    public static Producto load(ResultSet rs)throws SQLException{
        Producto objProducto = new Producto();
        objProducto.setIdProducto(rs.getString(1));
        objProducto.setCodProducto(rs.getString(2));
        objProducto.setNombre(rs.getString(3));
        objProducto.setPrecioCompra(rs.getDouble(4));
        objProducto.setPrecioVenta(rs.getDouble(5));
        objProducto.setCantidad(rs.getInt(6));
        objProducto.setIdCategoria(rs.getInt(7));
        objProducto.setEstado(rs.getString(8));
        
        return objProducto;
    }

    public String getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(String idProducto) {
        this.idProducto = idProducto;
    }

    public String getCodProducto() {
        return codProducto;
    }

    public void setCodProducto(String codProducto) {
        this.codProducto = codProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecioCompra() {
        return precioCompra;
    }

    public void setPrecioCompra(double precioCompra) {
        this.precioCompra = precioCompra;
    }

    public double getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(double precioVenta) {
        this.precioVenta = precioVenta;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Producto{" + "idProducto=" + idProducto + ", codProducto=" + codProducto + ", nombre=" + nombre + ", precioCompra=" + precioCompra + ", precioVenta=" + precioVenta + ", cantidad=" + cantidad + ", idCategoria=" + idCategoria + ", estado=" + estado + '}';
    }
    
    
}
