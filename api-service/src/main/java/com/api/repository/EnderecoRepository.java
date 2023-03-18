package com.api.repository;

import com.api.model.EnderecoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Miguel Castro
 */
@Repository
public interface EnderecoRepository extends JpaRepository<EnderecoModel, Long> {

    @Query(value = "SELECT COUNT(*) FROM endereco WHERE estado = :estado", nativeQuery = true)
    public Integer countPacienteByEstado(String estado);
}
