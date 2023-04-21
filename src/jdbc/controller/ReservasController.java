package jdbc.controller;

import java.time.LocalDate;
import java.util.List;

import jdbc.dao.ReservasDAO;
import jdbc.factory.ConnectionFactory;
import jdbc.modelo.Reservas;

public class ReservasController {

    private ReservasDAO reservasDao;

    public ReservasController() {
        var factory = new ConnectionFactory();
    	this.reservasDao = new ReservasDAO(factory.recuperaConexion());
    	
    }
 
	public void guardar(Reservas reserva) {
		this.reservasDao.guardar(reserva);
		
	}

    public List<Reservas> listar() {
        return this.reservasDao.listar();
    } 
    
    public List<Reservas> buscar(String id) {
        return this.reservasDao.buscarId(id);
    } 
    
    public void modificar(LocalDate fechaE, LocalDate fechaS, String valor, String formaDePago, Integer id) {
    	this.reservasDao.modificar(fechaE, fechaS, valor, formaDePago, id);
    }
    
    public void eliminar(Integer id) {
    	this.reservasDao.eliminar(id);
    }
}
