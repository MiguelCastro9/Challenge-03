package com.api.service;

import com.api.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Miguel Castro
 */
@Service
public class EnderecoService {

    @Autowired
    EnderecoRepository enderecoRepository;

    public Integer totalPacientePorEstado(String estado) {

        return enderecoRepository.countPacienteByEstado(estado);
    }
}
