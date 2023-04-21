package jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import jdbc.modelo.Huespedes;

public class HuespedesDAO {

    private Connection con;

    public HuespedesDAO(Connection con) {
        this.con = con;
    }
    
    public void guardar(Huespedes huespedes) {
        try {
            PreparedStatement statement;
                statement = con.prepareStatement(
                        "INSERT INTO HUESPEDES "
                        + "(nombre, apellido, fecha_nacimiento, nacionalidad, telefono, id_reserva)"
                        + " VALUES (?, ?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
    
            try (statement) {
                statement.setString(1, huespedes.getNombre());
                statement.setString(2, huespedes.getApellido());
                statement.setObject(3, huespedes.getFechaNacimiento());
                statement.setString(4, huespedes.getNacionalidad());
                statement.setString(5, huespedes.getTelefono());
                statement.setInt(6, huespedes.getIdReserva());
    
                statement.execute();
    
                final ResultSet resultSet = statement.getGeneratedKeys();
    
                try (resultSet) {
                    while (resultSet.next()) {
                        huespedes.setId(resultSet.getInt(1));                                                
                    }
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Huespedes> listar() {
        List<Huespedes> resultado = new ArrayList<Huespedes>();

        try {
            final PreparedStatement statement = con
                    .prepareStatement("SELECT id, nombre, apellido, fecha_nacimiento, nacionalidad, telefono, id_reserva FROM HUESPEDES");
    
            try (statement) {
                statement.execute();
    
                final ResultSet resultSet = statement.getResultSet();
    
                try (resultSet) {
                    while (resultSet.next()) {
                        resultado.add(new Huespedes(
                        		resultSet.getInt("id"),
                                resultSet.getString("nombre"),
                                resultSet.getString("apellido"),
                                resultSet.getDate("fecha_nacimiento").toLocalDate(),
                                resultSet.getString("nacionalidad"),
                                resultSet.getString("telefono"),
                                resultSet.getInt("id_reserva")
                                ));
                    }
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return resultado;
    }

    
    public List<Huespedes> buscarId(String id) {
        List<Huespedes> resultado = new ArrayList<Huespedes>();

        try {
            final PreparedStatement statement = con
                    .prepareStatement("SELECT id, nombre, apellido, fecha_nacimiento, nacionalidad, telefono, id_reserva FROM huespedes WHERE id =?");
    
            try (statement) {
            	statement.setString(1, id);
                statement.execute();
    
                final ResultSet resultSet = statement.getResultSet();
    
                try (resultSet) {
                    while (resultSet.next()) {
                        resultado.add(new Huespedes(
                        		resultSet.getInt("id"),
                                resultSet.getString("nombre"),
                                resultSet.getString("apellido"),
                                resultSet.getDate("fecha_nacimiento").toLocalDate(),
                                resultSet.getString("nacionalidad"),
                                resultSet.getString("telefono"),
                                resultSet.getInt("id_reserva")
                                ));
                    }
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return resultado;
    }
    
    public void modificar(String nombre, String apellido, LocalDate fechaNacimiento, String nacionalidad, String telefono, Integer idReserva, Integer id) {
        try (
             PreparedStatement statement = con.prepareStatement(
            		"UPDATE huespedes SET "
            		+ "nombre = ?, "
            		+ "apellido = ?, "
            		+ "fecha_nacimiento = ?, "
            		+ "nacionalidad = ?, "
            		+ "telefono = ?, "
            		+ "id_reserva = ? "
            		+ "WHERE id = ?")){           
            	
                statement.setString(1, nombre);
                statement.setString(2, apellido);
                statement.setObject(3, fechaNacimiento);
                statement.setString(4, nacionalidad);
                statement.setString(5, telefono);
                statement.setInt(6, idReserva);
                statement.setInt(7, id);
                statement.execute();

            }catch (SQLException e) {
                throw new RuntimeException(e);
        } 
   }

    
    public void eliminar(Integer id) {
        try {
        	
            final PreparedStatement statement = con.prepareStatement("DELETE FROM huespedes WHERE id = ?");

            try (statement) {
                statement.setInt(1, id);
                statement.execute();              

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
   
}
