package com.matricula.core.interfaces;

import com.matricula.core.to.AlumnoTO;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author dev09
 */
public interface AlumnoDAOInterface extends Mantenible<AlumnoTO, Integer> {

    /**
     * Este metodo realiza una consulta general a la base de datos.
     *
     * @return retorna una lista con todos los registros de la base de datos.
     * @throws SQLException
     * @throws InstantiationException
     * @throws IllegalAccessException
     * @throws ClassNotFoundException
     */
    public List<AlumnoTO> listarTodos() throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException;

    /**
     * Este metodo realiza una consulta a la tabla Alumnos buscando por nombre.
     *
     * @param nombre es el nombre por el cual se va a realizar la consulta.
     * @return una lista con los valores coincidentes con el parametro.
     * @throws SQLException
     * @throws InstantiationException
     * @throws IllegalAccessException
     * @throws ClassNotFoundException
     */
    public List<AlumnoTO> listarPorNombre(String nombre) throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException;

    /**
     * Este metodo realiza una consulta a la tabla Alumnos buscando
     * coincidencias por numero de recibo, no tiene que estar completo el numero
     * del recibo.
     *
     * @param recibo numero de recibo que se quiere consultar.
     * @return lista de Alumnos que el mumero de recibo coinciden con el
     * parametro.
     * @throws SQLException
     * @throws InstantiationException
     * @throws IllegalAccessException
     * @throws ClassNotFoundException
     */
    public List<AlumnoTO> listarPorRecibo(String recibo) throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException;
}
