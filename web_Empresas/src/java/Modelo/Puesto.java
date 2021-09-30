/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

/**
 *
 * @author Kevin Matinez
 */
public class Puesto {
    
    private int id_puesto;
    private String puesto;
    private Conexion cn;
    
    public int getId_puesto() {
        return id_puesto;
    }

    public void setId_puesto(int id_puesto) {
        this.id_puesto = id_puesto;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }
    public Puesto(){}
    public Puesto(int id_puesto, String puesto) {
        this.id_puesto = id_puesto;
        this.puesto = puesto;
    }
    
    public HashMap drop_Sangre(){
            HashMap<String,String> drop = new HashMap();
            try{
                cn = new Conexion();
                String query = "SELECT id_puestos as id,puesto FROM puestos;";
                cn.abrir_connexion();
                ResultSet consulta = cn.conexionBD.createStatement().executeQuery(query);
                while (consulta.next()){
                    drop.put(consulta.getString("id"), consulta.getString("puesto"));
                }
                
                cn.cerrar_connexion();
                
            }catch(SQLException ex){
                System.out.println(ex.getMessage());
            }
        return drop;
    }
    
}
