package com.api.repository;

import com.api.model.DataModel;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Miguel Castro
 */
@Repository
public interface DataRepository extends JpaRepository<DataModel, Long> {

    @Query(value = "SELECT p.id, YEAR(CURRENT_DATE()) - YEAR(p.data_nascimento) AS idade, p.genero, f.altura, f.peso, f.tipo_sanguineo "
            + "FROM Paciente p "
            + "INNER JOIN Fisico f "
            + "ON "
            + "p.fisico_id = f.id", nativeQuery = true)
    public List<DataModel> getData();
}
