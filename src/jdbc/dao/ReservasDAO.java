package jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import jdbc.modelo.Reservas;

public class ReservasDAO {

    private Connection con;

    public ReservasDAO(Connection con) {
        this.con = con;
    }
    
    public void guardar(Reservas reserva) {
        try {
            PreparedStatement statement;
                statement = con.prepareStatement(
                        "INSERT INTO RESERVAS "
                        + "(fecha_entrada, fecha_salida, valor, forma_de_pago)"
                        + " VALUES (?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
    
            try (statement) {
            	
                statement.setObject(1, reserva.getFechaE());
                statement.setObject(2, reserva.getFechaS());
                statement.setString(3, reserva.getValor());
                statement.setString(4, reserva.getFormaDePago());
                    
                statement.execute();
    
                final ResultSet resultSet = statement.getGeneratedKeys();
    
                try (resultSet) {
                    while (resultSet.next()) {
                        reserva.setId(resultSet.getInt(1));
                       
                    }
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    
    public List<Reservas> listar() {
        List<Reservas> resultado = new ArrayList<Reservas>();

        try {
            final PreparedStatement statement = con
                    .prepareStatement("SELECT id, fecha_entrada, fecha_salida, valor, forma_de_pago FROM reservas");
    
            try (statement) {
                statement.execute();
    
                final ResultSet resultSet = statement.getResultSet();
    
                try (resultSet) {
                    while (resultSet.next()) {
                       
                    	resultado.add(new Reservas(
                        		resultSet.getInt("ID"),
                                resultSet.getDate("fecha_entrada").toLocalDate(),
                                resultSet.getDate("fecha_salida").toLocalDate(),
                                resultSet.getString("valor"),
                                resultSet.getString("forma_de_pago")));
                    }
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return resultado;
    }
    
    public List<Reservas> buscarId(String id) {
        List<Reservas> resultado = new ArrayList<Reservas>();

        try {
            final PreparedStatement statement = con
                    .prepareStatement("SELECT id, fecha_entrada, fecha_salida, valor, forma_de_pago FROM reservas WHERE id =?");
    
            try (statement) {
            	statement.setString(1, id);
                statement.execute();
    
                final ResultSet resultSet = statement.getResultSet();
    
                try (resultSet) {
                    while (resultSet.next()) {
                       
                    	resultado.add(new Reservas(
                        		resultSet.getInt("ID"),
                                resultSet.getDate("fecha_entrada").toLocalDate().plusDays(1),
                                resultSet.getDate("fecha_salida").toLocalDate().plusDays(1),
                                resultSet.getString("valor"),
                                resultSet.getString("forma_de_pago")));
                    }
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return resultado;
    }
    
    public void modificar(LocalDate fechaE, LocalDate fechaS, String valor, String formaDePago, Integer id) {
        try {
            final PreparedStatement statement = con.prepareStatement(
                    "UPDATE reservas SET "
                    + " fecha_entrada = ?, "
                    + " fecha_salida = ?,"
                    + " valor = ?,"
                    + "forma_de_pago = ?"
                    + " WHERE id = ?");

            try (statement) {
                statement.setObject(1, java.sql.Date.valueOf(fechaE));
                statement.setObject(2, java.sql.Date.valueOf(fechaS));
                statement.setString(3, valor);
                statement.setString(4, formaDePago);
                statement.setInt(5, id);
                statement.execute();

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
      }
    }

    public void eliminar(Integer id) {
        try {
        	Statement state = con.createStatement();
        	state.execute("SET FOREIGN_KEY_CHECKS=0");
            final PreparedStatement statement = con.prepareStatement("DELETE FROM reservas WHERE id = ?");

            try (statement) {
                statement.setInt(1, id);
                statement.execute();
                state.execute("SET FOREIGN_KEY_CHECKS=1");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
}
