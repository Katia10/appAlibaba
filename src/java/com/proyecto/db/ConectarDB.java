package com.proyecto.db;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConectarDB {
    private String driver = "";
    private String url = "";
    private String usuario = "";
    private String password = "";
    
    Connection conex = null;
    
   public ConectarDB(){
       
   }
   
   public Connection conectar() throws SQLException{
        try {
            Class.forName(driver);
            conex =  DriverManager.getConnection(url, usuario, password);
       
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ConectarDB.class.getName()).log(Level.SEVERE, null, ex);
           
        }
       return conex;
   }
   
   public void desconectar()throws SQLException{
       if(conex!=null){
           if(conex.isClosed()){
                conex.close();
           }
       }
      
   }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public Connection getConex() {
        return conex;
    }

    public void setConex(Connection conex) {
        this.conex = conex;
    }
   
   
}
