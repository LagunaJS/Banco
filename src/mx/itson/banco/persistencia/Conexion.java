/**
 * 
 */
package mx.itson.banco.persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * @author LagunaJS
 *
 */
public class Conexion {

	public static Connection conectar(){
		Connection conexion = null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			conexion = DriverManager.getConnection("jdbc:mysql://localhost:8889/banco_beta", "root", "root");
		}catch (Exception e){
			System.out.println(e);
		}
		return conexion;
	}
	
	public static ResultSet ejecutarConsulta(String consulta) throws Exception{
		Statement statement = conectar().createStatement();
		ResultSet rs = statement.executeQuery(consulta);
		return rs;
	}
}
