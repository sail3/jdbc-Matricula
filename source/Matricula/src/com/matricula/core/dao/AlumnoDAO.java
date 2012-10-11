package com.matricula.core.dao;

import com.matricula.core.db.AccesoDB;
import com.matricula.core.interfaces.AlumnoDAOInterface;
import com.matricula.core.to.AlumnoTO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author dev09
 */
public class AlumnoDAO implements AlumnoDAOInterface {

    @Override
    public List<AlumnoTO> listarTodos() throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException {
        String sql = "SELECT * FROM Alumnos";
        PreparedStatement ps = AccesoDB.getConection().prepareStatement(sql);
        ResultSet cdr = ps.executeQuery();
        ArrayList<AlumnoTO> lista = new ArrayList<AlumnoTO>();
        while (cdr.next()) {
            AlumnoTO alumno = null;
            alumno.setCodigo(cdr.getInt(1));
            alumno.setNombre(cdr.getString(2));
            alumno.setRecibo(cdr.getString(3));
            lista.add(alumno);
        }
        return lista;
    }

    @Override
    public List<AlumnoTO> listarPorNombre(String nombre) throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException {
        String sql = "SELECT * FROM Alumno WHERE vch_alumnombre LIKE '%?%'";
        PreparedStatement ps = AccesoDB.getConection().prepareStatement(sql);
        ps.setString(1, nombre);
        ResultSet cdr = ps.executeQuery();
        ArrayList<AlumnoTO> lista = new ArrayList<AlumnoTO>();
        while (cdr.next()) {
            AlumnoTO alumno = null;
            alumno.setCodigo(cdr.getInt(1));
            alumno.setNombre(cdr.getString(2));
            alumno.setRecibo(cdr.getString(3));
            lista.add(alumno);
        }
        return lista;
    }

    @Override
    public List<AlumnoTO> listarPorRecibo(String recibo) throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException {
        String sql = "SELECT * FROM Alumno WHERE chr_alumrecibo LIKE '%?%'";
        PreparedStatement ps = AccesoDB.getConection().prepareStatement(sql);
        ps.setString(1, recibo);
        ResultSet cdr = ps.executeQuery();
        ArrayList<AlumnoTO> lista = new ArrayList<AlumnoTO>();
        while (cdr.next()) {
            AlumnoTO alumno = null;
            alumno.setCodigo(cdr.getInt(1));
            alumno.setNombre(cdr.getString(2));
            alumno.setRecibo(cdr.getString(3));
            lista.add(alumno);
        }
        return lista;
    }

    @Override
    public int crear(AlumnoTO obj) throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException {
        int codigo = 0;
        String sql = "INSERT INTO Alumno VALUES (null, ?, ?)";
        ResultSet cdr = null;
        PreparedStatement ps = AccesoDB.getConection().prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
        ps.setString(1, obj.getNombre());
        ps.setString(2, obj.getRecibo());
        ps.executeUpdate();
        cdr = ps.getGeneratedKeys();
        while (cdr.next()) {
            codigo = cdr.getInt(1);
        }
        return codigo;
    }

    @Override
    public AlumnoTO recuperar(Integer key) throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException {
        String sql = "SELECT * FROM Alumno WHERE int_alumid = ?";
        PreparedStatement pst = AccesoDB.getConection().prepareStatement(sql);
        ResultSet cdr = null;
        pst.setInt(1, key);
        cdr = pst.executeQuery();
        AlumnoTO alumno = null;
        while (cdr.next()) {
            alumno = new AlumnoTO();
            alumno.setCodigo(cdr.getInt(1));
            alumno.setNombre(cdr.getString(2));
            alumno.setRecibo(cdr.getString(3));
        }
        return alumno;
    }

    @Override
    public int actualizar(AlumnoTO obj) throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException {
        String sql = "UPDATE Alumno SET vch_alumnombre=?, chr_alumrecibo=? WHERE int_alumid=?";
        PreparedStatement pst = AccesoDB.getConection().prepareStatement(sql);
        pst.setString(1, obj.getNombre());
        pst.setString(2, obj.getRecibo());
        pst.setInt(3, obj.getCodigo());
        return pst.executeUpdate();
    }

    @Override
    public int eliminar(Integer key) throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException {
        String sql = "DELETE FROM Alumno WHERE int_alumid = ?";
        ResultSet cdr = null;
        PreparedStatement ps = AccesoDB.getConection().prepareStatement(sql);
        ps.setInt(1, key);
        return ps.executeUpdate();
    }
}
