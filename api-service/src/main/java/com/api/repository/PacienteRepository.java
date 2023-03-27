package com.api.repository;

import com.api.model.IMCModel;
import com.api.model.PacienteModel;
import java.util.List;
import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.SqlResultSetMapping;
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
    
    
    @Query(value = "SELECT com.api.model.PacienteModel(p.id, YEAR(CURRENT_DATE()) - YEAR(p.data_nascimento), f.altura, f.peso) FROM paciente p "
            + "INNER JOIN fisico f ON p.fisico_id = f.id")
    public List<IMCModel> getIdadePesoAltura();
}
