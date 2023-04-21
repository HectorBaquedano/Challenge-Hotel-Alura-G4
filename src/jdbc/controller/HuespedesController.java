package jdbc.controller;

import java.time.LocalDate;
import java.util.List;

import jdbc.dao.HuespedesDAO;
import jdbc.factory.ConnectionFactory;
import jdbc.modelo.Huespedes;

public class HuespedesController {

    private HuespedesDAO huespedesDao;
    
    public HuespedesController() {
        var factory = new ConnectionFactory();
        this.huespedesDao = new HuespedesDAO(factory.recuperaConexion());
    }

    public void guardar(Huespedes huespedes) {
        this.huespedesDao.guardar(huespedes);
    }

    public List<Huespedes> listar() {
        return this.huespedesDao.listar();
    }

    public List<Huespedes> buscarId(String id) {
        return this.huespedesDao.buscarId(id);
    }
    
    public void modificar(String nombre, String apellido, LocalDate fechaNacimiento, String nacionalidad, String telefono, Integer idReserva, Integer id) {
        this.huespedesDao.modificar(nombre, apellido, fechaNacimiento, nacionalidad, telefono, idReserva, id);
    }

    public void eliminar(Integer idReserva) {
        this.huespedesDao.eliminar(idReserva);
    }

    

}
