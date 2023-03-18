package com.api.repository;

import com.api.model.PacienteModel;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Miguel Castro
 */
@Repository
public interface PacienteRepository extends JpaRepository<PacienteModel, Long> {

    public PacienteModel findByCpf(String cpf);
    
    public PacienteModel findByContatoEmail(String email);
    
    public PacienteModel findByContatoNumero(String numero);
    
    @Query(value = "SELECT p.fisico_id, f.id, YEAR(CURRENT_DATE()) - YEAR(data_nascimento) AS idade, f.altura, f.peso FROM paciente p "
            + "INNER JOIN fisico f ON p.fisico_id = f.id", nativeQuery = true)
    public List<Object> getIdadePesoAltura();
}
