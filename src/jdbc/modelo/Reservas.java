package jdbc.modelo;

import java.time.LocalDate;

public class Reservas {
	
	private Integer id;
	private LocalDate fechaE;
	private LocalDate fechaS;
	private String valor;
	private String formaDePago;
	
	public Reservas(LocalDate fechaE, LocalDate fechaS, String valor, String formaDePago) {
		this.fechaE = fechaE;
		this.fechaS = fechaS;
		this.valor = valor;
		this.formaDePago = formaDePago;
	}
	
	public Reservas(Integer id, LocalDate fechaE, LocalDate fechaS, String valor, String formaDePago) {
		super();
		this.id = id;
		this.fechaE = fechaE;
		this.fechaS = fechaS;
		this.valor = valor;
		this.formaDePago = formaDePago;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public LocalDate getFechaE() {
		return fechaE;
	}
	public void setFechaE(LocalDate fechaE) {
		this.fechaE = fechaE;
	}
	public LocalDate getFechaS() {
		return fechaS;
	}
	public void setFechaS(LocalDate fechaS) {
		this.fechaS = fechaS;
	}
	public String getValor() {
		return valor;
	}
	public void setValor(String valor) {
		this.valor = valor;
	}
	public String getFormaDePago() {
		return formaDePago;
	}
	public void setFormaDePago(String formaDePago) {
		this.formaDePago = formaDePago;
	}	

}
