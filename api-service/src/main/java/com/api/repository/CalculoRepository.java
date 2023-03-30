package com.api.repository;

import com.api.model.CalculoModel;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Miguel Castro
 */
@Repository
public interface CalculoRepository extends JpaRepository<CalculoModel, Long> {

    @Query(value = "SELECT p.id, YEAR(CURRENT_DATE()) - YEAR(p.data_nascimento) AS idade, p.genero, f.altura, f.peso "
            + "FROM Paciente p "
            + "INNER JOIN Fisico f "
            + "ON "
            + "p.fisico_id = f.id", nativeQuery = true)
    public List<CalculoModel> getData();
}
