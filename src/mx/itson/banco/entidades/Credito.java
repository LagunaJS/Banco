/**
 * 
 */
package mx.itson.banco.entidades;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 * @author LagunaJS
 *
 */
@Entity
public class Credito {
	private int id;
	private Double cantidad;
	private Double tasaDeInteres;
	private Cliente Cliente;
	private Ejecutivo Ejecutivo;
	private Date fechaInicio;
	private Date fechaFinal;
	private String estado;
	private String motivo;
	/**
	 * @return the id
	 */
	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the cantidad
	 */
	@Basic
	public Double getCantidad() {
		return cantidad;
	}
	/**
	 * @param cantidad the cantidad to set
	 */
	public void setCantidad(Double cantidad) {
		this.cantidad = cantidad;
	}
	/**
	 * @return the tasaDeInteres
	 */
	@Basic
	public Double getTasaDeInteres() {
		return tasaDeInteres;
	}
	/**
	 * @param tasaDeInteres the tasaDeInteres to set
	 */
	public void setTasaDeInteres(Double tasaDeInteres) {
		this.tasaDeInteres = tasaDeInteres;
	}

	/**
	 * @return the cliente
	 */
	@OneToOne
	public Cliente getCliente() {
		return Cliente;
	}
	/**
	 * @param cliente the cliente to set
	 */
	public void setCliente(Cliente cliente) {
		Cliente = cliente;
	}
	/**
	 * @return the ejecutivo
	 */
	@OneToOne
	public Ejecutivo getEjecutivo() {
		return Ejecutivo;
	}
	/**
	 * @param ejecutivo the ejecutivo to set
	 */
	public void setEjecutivo(Ejecutivo ejecutivo) {
		Ejecutivo = ejecutivo;
	}
	/**
	 * @return the fechaInicio
	 */
	@Basic
	public Date getFechaInicio() {
		return fechaInicio;
	}
	/**
	 * @param fechaInicio the fechaInicio to set
	 */
	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	/**
	 * @return the fechaFinal
	 */
	@Basic
	public Date getFechaFinal() {
		return fechaFinal;
	}
	/**
	 * @param fechaFinal the fechaFinal to set
	 */
	public void setFechaFinal(Date fechaFinal) {
		this.fechaFinal = fechaFinal;
	}
	/**
	 * @return the estado
	 */
	@Basic
	public String getEstado() {
		return estado;
	}
	/**
	 * @param estado the estado to set
	 */
	public void setEstado(String estado) {
		this.estado = estado;
	}
	/**
	 * @return the motivo
	 */
	@Basic
	public String getMotivo() {
		return motivo;
	}
	/**
	 * @param motivo the motivo to set
	 */
	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}

}
