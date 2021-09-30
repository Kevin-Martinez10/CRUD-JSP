package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



/**
 *
 * @author Kevin Matinez
 */
public class Conexion {
    //jdbc:mysql://localhost:%s/%s?serverTimezone=UTC
    //jdbc:mysql://localhost:3306/%s
    public Connection conexionBD;
    private final String puerto= "3306";
    public final String db = "de_empresa";
    public final String urlConnexion = String.format("jdbc:mysql://localhost:%s/%s?serverTimezone=UTC",puerto, db );
    public final String usuario = "usr_empresa";
    public final String contraseña = "Empres@123";
    public final String jdbc = "com.mysql.cj.jdbc.Driver";
    
    
    public void abrir_connexion(){
    try{
        
        Class.forName(jdbc);
        conexionBD = DriverManager.getConnection(urlConnexion,usuario,contraseña);
       
        }catch(Exception ex){
    
        System.out.println("Error........." + ex.getMessage() );
        }
    
    }
    
    public void cerrar_connexion (){
        
        try{
            conexionBD.close();
            
        }catch(SQLException ex){
            
            System.out.println("Error........." + ex.getMessage() );
        
        }
    
    }
    
}
