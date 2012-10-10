package com.matricula.core.interfaces;

import com.matricula.core.to.ProfesorTO;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Gustavo Fernández
 * @see Maintanable
 */
public interface ProfesorDAOInterface extends Maintanable<ProfesorTO, Integer> {

    /**
     *
     * @return List de los registros de la tabla profesores de la base de datos.
     * @throws SQLException
     */
    List<ProfesorTO> findAll() throws SQLException;
}