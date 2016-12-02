/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package administradorbd;


import javax.swing.JOptionPane;
import java.sql.*;

/**
 *
 * @author edito
 */
public class Administradorbd {
    Connection conexion = null;
    Statement sentencia = null;
   
    public void crearClientes() throws SQLException
    {
        
        try
        {
            Class.forName("org.sqlite.JDBC");
            conexion = DriverManager.getConnection("jdbc:sqlite:empresa.sqlite");
            sentencia =conexion.createStatement();
            
            String SQL = "CREATE TABLE CLIENTES" + 
                    "(ID       INT     PRIMARY KEY NOT NULL,"+ 
                    " NOMBRE   TEXT    NOT NULL," +
                    " APELLIDO   TEXT    NOT NULL," +
                    " EMAIL    TEXT)";
            
            sentencia.executeUpdate(SQL);
            sentencia.close();
            conexion.close();
            
        }
        catch(ClassNotFoundException | SQLException e)
        {
            System.err.println("Error: " + e.getMessage());
            System.exit(0);
               
        }
        
        System.out.println("Tabla Clientes creada!");
        
    }
     public void insertarCliente(String[] datos) 
    {
        
        try
        {
            Class.forName("org.sqlite.JDBC");
            conexion = DriverManager.getConnection("jdbc:sqlite:empresa.sqlite");
            conexion.setAutoCommit(false);
            
            sentencia = conexion.createStatement();
            
            String SQL = "INSERT INTO CLIENTES (ID, NOMBRE, APELLIDO, EMAIL) " +
                    "VALUES ('"+datos[0]+"','"+datos[1]+"','"+datos[2]+"','"+datos[3]+"')";
                    
            
            sentencia.executeUpdate(SQL);
            sentencia.close();
            conexion.commit();
            conexion.close();
            
        }
        catch(ClassNotFoundException | SQLException e)
        {
            System.err.println("Error : " + e.getMessage());
            System.exit(0);
        }
        JOptionPane.showMessageDialog(null, "Datos ingresados de forma correcta en la tabla Clientes!");
        
    }
    public void actualizarCliente(String[] datos) 
    {
        try
        {
            Class.forName("org.sqlite.JDBC");
            conexion = DriverManager.getConnection("jdbc:sqlite:empresa.sqlite");
            conexion.setAutoCommit(false);
            
            sentencia = conexion.createStatement();
            
            String SQL = "UPDATE CLIENTES SET NOMBRE='"+datos[1]+"', APELLIDO='"+datos[2]+"', EMAIL='"+datos[3]+"' WHERE ID= '"+datos[0]+"' ; "; 
                
            sentencia.executeUpdate(SQL);
            sentencia.close();
            conexion.commit();
            conexion.close();
            
        }
        catch(ClassNotFoundException | SQLException e)
        {
            System.err.println("Error : " + e.getMessage());
            System.exit(0);
        }
        JOptionPane.showMessageDialog(null, "Datos actualizados de forma correcta en la tabla Clientes!");
       
    }
    public ResultSet mostrar() throws ClassNotFoundException
    {
        ResultSet rs=null;
        try {
            Class.forName("org.sqlite.JDBC");
            
            conexion = DriverManager.getConnection("jdbc:sqlite:empresa.sqlite");
            conexion.setAutoCommit(false);
            
            
            sentencia = conexion.createStatement();
            rs= sentencia.executeQuery("SELECT * FROM CLIENTES");
                     
            
        } catch (SQLException ex) {
            System.err.println(ex);
        }
        return rs;
        
    } 
     public void eliminarCliente(String[] datos) 
    {
         
        try
        {
            Class.forName("org.sqlite.JDBC");
            conexion = DriverManager.getConnection("jdbc:sqlite:empresa.sqlite");
            conexion.setAutoCommit(false);
            
            sentencia = conexion.createStatement();
            
            String SQL = "DELETE FROM CLIENTES WHERE ID= '"+datos[0]+"' ; "; 
                 
            
            sentencia.executeUpdate(SQL);
            sentencia.close();
            conexion.commit();
            conexion.close();
            
        }
        catch(ClassNotFoundException | SQLException e)
        {
            System.err.println("Error : " + e.getMessage());
            System.exit(0);
        }
        JOptionPane.showMessageDialog(null, "Datos eliminados de forma correcta en la tabla Clientes!");
        
      
    }
     

}
