package com.api.service;

import com.api.exception.ValorExistenteException;
import com.api.model.IMCModel;
import com.api.model.PacienteModel;
import com.api.repository.IMCRepository;
import com.api.repository.PacienteRepository;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
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

    public List<Double> calculoIMC() {

        List<IMCModel> imcs = new ArrayList<>();
        List<Double> imcsMedio = new ArrayList<>();
        imcs = imcRepository.getIdadePesoAltura();

        for (int i = 0; i < imcs.size(); i++) {

            Integer idade = imcs.get(i).getIdade();
            Double peso = imcs.get(i).getPeso();
            Double altura = imcs.get(i).getAltura();
            Double imc = peso / (altura * altura);
            DecimalFormat decimalFormat = new DecimalFormat("#,###.00");
            decimalFormat.setDecimalFormatSymbols(new DecimalFormatSymbols(Locale.US));
            decimalFormat.setRoundingMode(RoundingMode.DOWN);
            imc = Double.valueOf(decimalFormat.format(imc));

            if (idade >= 0 && idade <= 10) {
                imcsMedio.add(imc);
            }
            if (idade >= 11 && idade <= 20) {
                imcsMedio.add(imc);
            }
            if (idade >= 21 && idade <= 30) {
                imcsMedio.add(imc);
            }
            if (idade >= 31 && idade <= 40) {
                imcsMedio.add(imc);
            }
            if (idade >= 41 && idade <= 50) {
                imcsMedio.add(imc);
            }
            if (idade >= 51 && idade <= 60) {
                imcsMedio.add(imc);
            }
            if (idade >= 61 && idade <= 70) {
                imcsMedio.add(imc);
            }
            if (idade >= 71 && idade <= 80) {
                imcsMedio.add(imc);
            }
            if (idade >= 81 && idade <= 90) {
                imcsMedio.add(imc);
            }
            if (idade >= 91 && idade <= 100) {
                imcsMedio.add(imc);
            }
        }
        return imcsMedio;
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
