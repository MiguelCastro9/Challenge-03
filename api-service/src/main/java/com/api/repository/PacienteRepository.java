package com.api.repository;

import com.api.model.PacienteModel;
import org.springframework.data.jpa.repository.JpaRepository;
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
}
