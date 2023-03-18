package com.api.service;

import com.api.exception.ValorExistenteException;
import com.api.model.PacienteModel;
import com.api.repository.PacienteRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Miguel Castro
 */
@Service
public class PacienteService {

    @Autowired
    PacienteRepository pacienteRepository;

    public List<PacienteModel> listar() {

        return pacienteRepository.findAll();
    }

    public PacienteModel salvar(PacienteModel pacienteModel) {

        verificaValorExistente(pacienteModel);
        return pacienteRepository.save(pacienteModel);
    }

    //CRIAR UM OJECTO DE FATO PARA REPRESENTAR ESSA QUERY
    public List<Object> calculoIMC() {

//        Integer total = pacienteRepository.getPesoEAltura().size();
        //List<Integer> idades = pacienteRepository.getPesoEAltura();
//        List<Double> calculosIMC;
//        List<Integer> listaTotalPacientePorFaixaEtaria = null;
//        Integer totalPacientePorFaixaEtaria;

//        for (int i = 0; i < 100; i++) {
//            if (idades.get(i) > 0 && idades.get(i) <= 10) {
//                listaTotalPacientePorFaixaEtaria.add(idades.get(i));
//            }
//            for (int j = 0; j < listaTotalPacientePorFaixaEtaria.size(); j++) {
//                
//            }
//        }
    return pacienteRepository.getIdadePesoAltura();
    }

    private void verificaValorExistente(PacienteModel pacienteModel) {

        PacienteModel pacienteCpf = pacienteRepository.findByCpf(pacienteModel.getCpf());
        PacienteModel pacienteContatoEmail = pacienteRepository.findByContatoEmail(pacienteModel.getContato().get(0).getEmail());
        PacienteModel pacienteContatoNumero = pacienteRepository.findByContatoNumero(pacienteModel.getContato().get(0).getNumero());

        if (pacienteCpf != null) {
            throw new ValorExistenteException(String.format("O CPF [%s] já existe.", pacienteModel.getCpf()));
        }

        if (pacienteContatoEmail != null) {
            throw new ValorExistenteException(String.format("O e-mail de contato [%s] já existe.", pacienteModel.getContato().get(0).getEmail()));
        }

        if (pacienteContatoNumero != null) {
            throw new ValorExistenteException(String.format("O número de contato [%s] já existe.", pacienteModel.getContato().get(0).getNumero()));
        }
    }
}
