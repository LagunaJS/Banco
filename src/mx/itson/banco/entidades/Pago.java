/**
 * 
 */
package mx.itson.banco.entidades;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author LagunaJS
 *
 */
@Entity
public class Pago {
	private int id;
	private Double monto;
	private Date fechaAcordada;
	private Date fechaPago;
	private int idCredito;
	private boolean atraso;
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
	 * @return the monto
	 */
	@Basic
	public Double getMonto() {
		return monto;
	}
	/**
	 * @param monto the monto to set
	 */
	public void setMonto(Double monto) {
		this.monto = monto;
	}
	/**
	 * @return the fechaAcordada
	 */
	@Basic
	public Date getFechaAcordada() {
		return fechaAcordada;
	}
	/**
	 * @param fechaAcordada the fechaAcordada to set
	 */
	public void setFechaAcordada(Date fechaAcordada) {
		this.fechaAcordada = fechaAcordada;
	}
	/**
	 * @return the fechaPago
	 */
	@Basic
	public Date getFechaPago() {
		return fechaPago;
	}
	/**
	 * @param fechaPago the fechaPago to set
	 */
	public void setFechaPago(Date fechaPago) {
		this.fechaPago = fechaPago;
	}
	/**
	 * @return the idCredito
	 */
	@Basic
	public int getIdCredito() {
		return idCredito;
	}
	/**
	 * @param idCredito the idCredito to set
	 */
	public void setIdCredito(int idCredito) {
		this.idCredito = idCredito;
	}
	/**
	 * @return the atraso
	 */
	@Basic
	public boolean isAtraso() {
		return atraso;
	}
	/**
	 * @param atraso the atraso to set
	 */
	public void setAtraso(boolean atraso) {
		this.atraso = atraso;
	}

}
