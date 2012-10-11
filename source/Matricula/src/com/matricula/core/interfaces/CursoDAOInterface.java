package com.matricula.core.interfaces;

import com.matricula.core.to.CursoTO;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Gustavo Fernández
 * @see Maintanable
 * @see CursoTO
 */
public interface CursoDAOInterface extends Mantenible<CursoTO, Integer> {

    /**
     *
     * @return List de los registros de la tabla cursos de la base de datos.
     * @throws SQLException
     */
    List<CursoTO> findAll() throws SQLException;
}
