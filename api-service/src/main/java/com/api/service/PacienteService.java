package com.api.service;

import com.api.exception.ValorExistenteException;
import com.api.model.FaixaEtariaIMCModel;
import com.api.model.IMCModel;
import com.api.model.PacienteModel;
import com.api.repository.IMCRepository;
import com.api.repository.PacienteRepository;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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

    @Autowired
    IMCRepository imcRepository;

    public List<PacienteModel> listar() {

        return pacienteRepository.findAll();
    }

    public PacienteModel salvar(PacienteModel pacienteModel) {

        verificaValorExistente(pacienteModel);
        return pacienteRepository.save(pacienteModel);
    }

    public List<FaixaEtariaIMCModel> calculoIMC() {

        List<IMCModel> imcs = new ArrayList<>();
        imcs = imcRepository.getIdadePesoAltura();
        HashMap<String, Double> imcsMedio = new HashMap<>();

        for (int i = 0; i < imcs.size(); i++) {

            Integer idade = imcs.get(i).getIdade();
            Double peso = imcs.get(i).getPeso();
            Double altura = imcs.get(i).getAltura();
            Double imc = peso / (altura * altura);

            if (idade >= 0 && idade <= 10) {
                if (imcsMedio.containsKey("Faixa etária [0 - 10]")) {
                    imcsMedio.put("Faixa etária [0 - 10]", imcsMedio.get("Faixa etária [0 - 10]") + imc);
                } else {
                    imcsMedio.put("Faixa etária [0 - 10]", imc);
                }
            }
            if (idade >= 11 && idade <= 20) {
                if (imcsMedio.containsKey("Faixa etária [11 - 20]")) {
                    imcsMedio.put("Faixa etária [11 - 20]", imcsMedio.get("Faixa etária [11 - 20]") + imc);
                } else {
                    imcsMedio.put("Faixa etária [11 - 20]", imc);
                }
            }
            if (idade >= 21 && idade <= 30) {
                if (imcsMedio.containsKey("Faixa etária [21 - 30]")) {
                    imcsMedio.put("Faixa etária [21 - 30]", imcsMedio.get("Faixa etária [21 - 30]") + imc);
                } else {
                    imcsMedio.put("Faixa etária [21 - 30]", imc);
                }
            }
            if (idade >= 31 && idade <= 40) {
                if (imcsMedio.containsKey("Faixa etária [31 - 40]")) {
                    imcsMedio.put("Faixa etária [31 - 40]", imcsMedio.get("Faixa etária [31 - 40]") + imc);
                } else {
                    imcsMedio.put("Faixa etária [31 - 40]", imc);
                }
            }
            if (idade >= 41 && idade <= 50) {
                if (imcsMedio.containsKey("Faixa etária [41 - 50]")) {
                    imcsMedio.put("Faixa etária [41 - 50]", imcsMedio.get("Faixa etária [41 - 50]") + imc);
                } else {
                    imcsMedio.put("Faixa etária [41 - 50]", imc);
                }
            }
            if (idade >= 51 && idade <= 60) {
                if (imcsMedio.containsKey("Faixa etária [51 - 60]")) {
                    imcsMedio.put("Faixa etária [51 - 60]", imcsMedio.get("Faixa etária [51 - 60]") + imc);
                } else {
                    imcsMedio.put("Faixa etária [51 - 60]", imc);
                }
            }
            if (idade >= 61 && idade <= 70) {
                if (imcsMedio.containsKey("Faixa etária [61 - 70]")) {
                    imcsMedio.put("Faixa etária [61 - 70]", imcsMedio.get("Faixa etária [61 - 70]") + imc);
                } else {
                    imcsMedio.put("Faixa etária [61 - 70]", imc);
                }
            }
            if (idade >= 71 && idade <= 80) {
                if (imcsMedio.containsKey("Faixa etária [71 - 80]")) {
                    imcsMedio.put("Faixa etária [71 - 80]", imcsMedio.get("Faixa etária [71 - 80]") + imc);
                } else {
                    imcsMedio.put("Faixa etária [71 - 80]", imc);
                }
            }
            if (idade >= 81 && idade <= 90) {
                if (imcsMedio.containsKey("Faixa etária [81 - 90]")) {
                    imcsMedio.put("Faixa etária [81 - 90]", imcsMedio.get("Faixa etária [81 - 90]") + imc);
                } else {
                    imcsMedio.put("Faixa etária [81 - 90]", imc);
                }
            }
            if (idade >= 91 && idade <= 100) {
                if (imcsMedio.containsKey("Faixa etária [91 - 100]")) {
                    imcsMedio.put("Faixa etária [91 - 100]", imcsMedio.get("Faixa etária [91 - 100]") + imc);
                } else {
                    imcsMedio.put("Faixa etária [91 - 100]", imc);
                }
            }
        }
        List<FaixaEtariaIMCModel> faixasEtarias = new ArrayList<>();

        for (Map.Entry<String, Double> entry : imcsMedio.entrySet()) {
            FaixaEtariaIMCModel faixaEtariaIMC = new FaixaEtariaIMCModel(entry.getKey(), entry.getValue());
            faixasEtarias.add(faixaEtariaIMC);
        }

        return faixasEtarias;
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
