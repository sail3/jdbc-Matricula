package com.matricula.core.dao;

import com.matricula.core.db.AccesoDB;
import com.matricula.core.interfaces.ProfesorDAOInterface;
import com.matricula.core.to.ProfesorTO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Gustavo Fernández
 * @see Maintanable
 * @see ProfesorDAOInterface
 * @see ProfesorTO
 */
public class ProfesorDAO implements ProfesorDAOInterface {

    /**
     *
     * @param obj el objeto Profesor que se va a insertar.
     * @return un int que representa el número de filas afectadas, devuelve 1 si
     * la inserción fue exitosa, en caso contrario devuelve 0.
     * @throws SQLException
     */
    @Override
    public int crear(ProfesorTO obj) throws SQLException {
        String sqlinsercion = "INSERT INTO Profesor(vch_profnombre, vch_proftitulo) VALUES(?, ?)";
        PreparedStatement pst;
        try {
            pst = AccesoDB.getConection().prepareStatement(sqlinsercion);
        } catch (Exception e) {
            System.err.println("Exception: " + e.getMessage());
            return 0;
        }
        pst.setString(1, obj.getNombre());
        pst.setString(2, obj.getTitulo());
        int rowsAffected = pst.executeUpdate();
        return rowsAffected;
    }

    /**
     *
     * @param codigo el codigo identificador del registro en la base de datos.
     * @return un objeto Profesor.
     * @throws SQLException
     */
    @Override
    public ProfesorTO recuperar(Integer codigo) throws SQLException {
        String sql = "SELECT * FROM Profesor WHERE int_alumid = ?";
        PreparedStatement pst;
        try {
            pst = AccesoDB.getConection().prepareStatement(sql);
        } catch (Exception e) {
            System.err.println("Exception: " + e.getMessage());
            return null;
        }
        pst.setInt(1, codigo);
        ResultSet rs = pst.executeQuery();
        ProfesorTO obj = null;
        while (rs.next()) {
            obj = new ProfesorTO();
            obj.setCodigo(rs.getInt(1));
            obj.setNombre(rs.getString(2));
            obj.setTitulo(rs.getString(3));
        }
        return obj;
    }

    /**
     *
     * @param obj el objeto profesor con los datos que se desean actualizar.
     * @return un int que representa el número de filas afectadas. Devuelve 0 si
     * no se encontro el registro a actualizar.
     * @throws SQLException
     */
    @Override
    public int actualizar(ProfesorTO obj) throws SQLException {
        String sqlActualizacion = "UPDATE Profesor SET vch_profnombre=?, "
                + "vch_proftitulo=? WHERE int_profid=?";
        PreparedStatement pst;
        try {
            pst = AccesoDB.getConection().prepareStatement(sqlActualizacion);
        } catch (Exception e) {
            System.err.println("Exception: " + e.getMessage());
            return 0;
        }
        pst.setInt(3, obj.getCodigo());
        pst.setString(1, obj.getNombre());
        pst.setString(2, obj.getTitulo());
        int rowsAffected = pst.executeUpdate();
        return rowsAffected;
    }

    /**
     *
     * @param codigo el codigo identificador del registro Profesor en la base de
     * datos.
     * @return un int que representa el número de filas afectadas. Devuelve 0 si
     * no se encontro el registro a eliminar.
     * @throws SQLException
     */
    @Override
    public int eliminar(Integer codigo) throws SQLException {
        String sqlEliminacion = "DELETE FROM Profesor WHERE int_profid=?";
        PreparedStatement pst;
        try {
            pst = AccesoDB.getConection().prepareStatement(sqlEliminacion);
        } catch (Exception e) {
            System.err.println("Exception: " + e.getMessage());
            return 0;
        }
        pst.setInt(1, codigo);
        int rowsAffected = pst.executeUpdate();
        return rowsAffected;
    }

    /**
     *
     * @return List de los registros de la tabla profesores de la base de datos.
     * @throws SQLException
     */
    @Override
    public List<ProfesorTO> listarTodos() throws SQLException {
        List lista = new ArrayList();
        String sqlConsulta = "SELECT int_profid, vch_profnombre, vch_proftitulo "
                + "FROM Profesor ORDER BY 1";
        PreparedStatement pst;
        try {
            pst = AccesoDB.getConection().prepareStatement(sqlConsulta);
        } catch (Exception e) {
            System.err.println("Exception: " + e.getMessage());
            return null;
        }
        ResultSet rs = pst.executeQuery();
        while (rs.next()) {
            ProfesorTO obj = new ProfesorTO();
            obj.setCodigo(rs.getInt("int_profid"));
            obj.setNombre(rs.getString("vch_profnombre"));
            obj.setTitulo(rs.getString("vch_proftitulo"));
            lista.add(obj);
        }
        return lista;
    }
}