/**
 * 
 */
package mx.itson.banco.persistencia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import mx.itson.banco.entidades.Cliente;
import mx.itson.banco.entidades.Credito;
import mx.itson.banco.entidades.Ejecutivo;

/**
 * @author LagunaJS
 *
 */
public class Consultar {

	public Cliente obtenerCliente(int id){
		Cliente e = new Cliente();
		try{
			String consulta = "SELECT * FROM cliente WHERE id = " +id;
			ResultSet rs = Conexion.ejecutarConsulta(consulta);
			if(rs.first()){
				e.setId(rs.getInt("id"));
				e.setNombre(rs.getString("nombre"));
			}
		}catch(Exception ex){
			System.out.println(ex);
		}
		return e;
	}
	
	public Ejecutivo obtenerEjecutivo(int id){
		Ejecutivo e = new Ejecutivo();
		try{
			String consulta = "SELECT * FROM ejecutivo WHERE id = " +id;
			ResultSet rs = Conexion.ejecutarConsulta(consulta);
			if(rs.first()){
				e.setId(rs.getInt("id"));
				e.setNombre(rs.getString("nombre"));
			}
		}catch(Exception ex){
			System.out.println(ex);
		}
		return e;
	}
	
	public List<Cliente> obtenerClientes(){
		List<Cliente> clientes = new ArrayList<Cliente>();	
		try{
			String consulta = "SELECT * FROM cliente";
			ResultSet rs =  Conexion.ejecutarConsulta(consulta);
			if(rs.first()){
				do{
					Cliente cliente =  new Cliente();
					cliente.setId(rs.getInt("id"));
					cliente.setNombre(rs.getString("nombre"));
					cliente.setCorreo(rs.getString("correo"));
					
					clientes.add(cliente);
				}while(rs.next());
			}
		}catch (Exception e){
			
		}
		return clientes;
	}
	
	public List<Ejecutivo> obtenerEjecutivos(){
		List<Ejecutivo> ejecutivos = new ArrayList<Ejecutivo>();
		try{
			String consulta = "SELECT * FROM ejecutivo";
			ResultSet rs =  Conexion.ejecutarConsulta(consulta);
			if(rs.first()){
				do{
					Ejecutivo ejecutivo =  new Ejecutivo();
					ejecutivo.setId(rs.getInt("id"));
					ejecutivo.setNombre(rs.getString("nombre"));
					ejecutivo.setPuesto(rs.getString("puesto"));
					
					ejecutivos.add(ejecutivo);
				}while(rs.next());
			}
		}catch (Exception e){
			
		}
		return ejecutivos;
	}
	
	public List<Credito> obetenerCreditos(int id){
		List<Credito> creditos = new ArrayList<Credito>();
		Credito credito = new Credito();
		try{
			String consulta = "SELECT * FROM credito WHERE idCliente =" +id;
			ResultSet rs = Conexion.ejecutarConsulta(consulta);
			if(rs.first()){
				while(rs.next()){
					credito.setId(rs.getInt("id"));
					credito.setCantidad(rs.getDouble("cantidad"));
					credito.setTasaDeInteres(rs.getDouble("tasaDeInteres"));
					credito.setCliente(obtenerCliente(rs.getInt("idCliente")));
					credito.setEjecutivo(obtenerEjecutivo(rs.getInt("idEjecutivo")));
					credito.setEstado(rs.getString("estado"));
					credito.setMotivo(rs.getString("motivo"));
					
					creditos.add(credito);
				}
			}
		}catch (Exception e){
			
		}
		return creditos;
	}
	
	public void GuardarCliente(Cliente c){
		try{
			String query = "INSERT INTO cliente (nombre,correo) VALUES( (?), (?) )";
			PreparedStatement st = Conexion.conectar().prepareStatement(query);
			st.setString(1, c.getNombre());
			st.setString(2, c.getCorreo());
			st.execute();
		}catch (Exception e){
			
		}
	}
	
	public void GuardarEjecutivo(Ejecutivo e){
		try{
			String query = "INSERT INTO ejecutivo (nombre,puesto) VALUES( (?), (?) )";
			PreparedStatement st = Conexion.conectar().prepareStatement(query);
			st.setString(1, e.getNombre());
			st.setString(2, e.getPuesto());
			st.execute();
		}catch (Exception ex){
			
		}
	}
	
	public void Endeudar(Double cantidad, Double tasaDeInteres, int idCliente, int idEjecutivo, String motivo ){
		try{
			String query = "INSERT INTO credito (cantidad, tasaDeInteres, idCliente, idEjecutivo, motivo) VALUES((?),(?),(?),(?),(?))";
			PreparedStatement st = Conexion.conectar().prepareStatement(query);
			st.setDouble(1, cantidad);
			st.setDouble(2, tasaDeInteres);
			st.setInt(3, idCliente);
			st.setInt(4, idEjecutivo);
			st.setString(5, motivo);
			st.execute();
		}catch (Exception e){
			System.out.println(e);
		}
	}
	
	
}
