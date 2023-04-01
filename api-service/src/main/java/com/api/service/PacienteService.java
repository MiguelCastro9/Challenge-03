package com.api.service;

import com.api.dto.DoadoresTipoSanguineoResponseDto;
import com.api.dto.FaixaEtariaIMCResponseDto;
import com.api.dto.MediaTipoSanguineoResponseDto;
import com.api.dto.PercentualObesosResponseDto;
import com.api.enums.GeneroEnum;
import com.api.enums.TipoSanguineoEnum;
import com.api.exception.MensagemCustomException;
import com.api.model.CalculoModel;
import com.api.model.PacienteModel;
import com.api.repository.PacienteRepository;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.api.repository.CalculoRepository;

/**
 *
 * @author Miguel Castro
 */
@Service
public class PacienteService {

    @Autowired
    PacienteRepository pacienteRepository;

    @Autowired
    CalculoRepository imcRepository;

    public List<PacienteModel> listar() {

        return pacienteRepository.findAll();
    }

    public PacienteModel salvar(PacienteModel pacienteModel) {

        verificaValorExistente(pacienteModel);
        return pacienteRepository.save(pacienteModel);
    }

    public List<FaixaEtariaIMCResponseDto> calculoPorfaixaEtariaIMC() {

        List<CalculoModel> imcs = new ArrayList<>();
        imcs = imcRepository.getData();
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
        List<FaixaEtariaIMCResponseDto> faixasEtarias = imcsMedio.entrySet().stream()
                .map(entry -> new FaixaEtariaIMCResponseDto(entry.getKey(), entry.getValue()))
                .collect(Collectors.toList());

        return faixasEtarias;
    }

    public PercentualObesosResponseDto calculoPercentualObesos() {
        
        List<CalculoModel> imcs = imcRepository.getData();
        
        Long qtdMasculinos = imcs.stream().filter(imc -> imc.getGenero().equalsIgnoreCase(GeneroEnum.MASCULINO.name())).count();
        Long qtdFemininos = imcs.stream().filter(imc -> imc.getGenero().equalsIgnoreCase(GeneroEnum.FEMININO.name())).count();
        Long qtdObesosMasculinos = imcs.stream().filter(imc -> imc.getGenero().equalsIgnoreCase(GeneroEnum.MASCULINO.name()) && imc.getPeso() / (imc.getAltura() * imc.getAltura()) > 30).count();
        Long qtdObesosFemininos = imcs.stream().filter(imc -> imc.getGenero().equalsIgnoreCase(GeneroEnum.FEMININO.name()) && imc.getPeso() / (imc.getAltura() * imc.getAltura()) > 30).count();
        Double percentualObesosMasculinos = qtdMasculinos > 0 ? 100.0 * qtdObesosMasculinos / qtdMasculinos : 0;
        Double percentualObesosFemininos = qtdFemininos > 0 ? 100.0 * qtdObesosFemininos / qtdFemininos : 0;
        
        return new PercentualObesosResponseDto(percentualObesosMasculinos, percentualObesosFemininos);
    }

    public MediaTipoSanguineoResponseDto calculoMediaIdadePorTipoSanguineo() {

        List<CalculoModel> imcs = imcRepository.getData();

        Double mediaAPositivo = imcs.stream()
                .filter(imc -> imc.getTipo_sanguineo().equalsIgnoreCase(TipoSanguineoEnum.A_POSITIVO.name()))
                .mapToDouble(CalculoModel::getIdade)
                .average().orElse(0.0);

        Double mediaANegativo = imcs.stream()
                .filter(imc -> imc.getTipo_sanguineo().equalsIgnoreCase(TipoSanguineoEnum.A_NEGATIVO.name()))
                .mapToDouble(CalculoModel::getIdade)
                .average().orElse(0.0);

        Double mediaBPositivo = imcs.stream()
                .filter(imc -> imc.getTipo_sanguineo().equalsIgnoreCase(TipoSanguineoEnum.B_POSITIVO.name()))
                .mapToDouble(CalculoModel::getIdade)
                .average().orElse(0.0);

        Double mediaBNegativo = imcs.stream()
                .filter(imc -> imc.getTipo_sanguineo().equalsIgnoreCase(TipoSanguineoEnum.B_NEGATIVO.name()))
                .mapToDouble(CalculoModel::getIdade)
                .average().orElse(0.0);

        Double mediaOPositivo = imcs.stream()
                .filter(imc -> imc.getTipo_sanguineo().equalsIgnoreCase(TipoSanguineoEnum.O_POSITIVO.name()))
                .mapToDouble(CalculoModel::getIdade)
                .average().orElse(0.0);

        Double mediaONegativo = imcs.stream()
                .filter(imc -> imc.getTipo_sanguineo().equalsIgnoreCase(TipoSanguineoEnum.O_NEGATIVO.name()))
                .mapToDouble(CalculoModel::getIdade)
                .average().orElse(0.0);

        Double mediaABPositivo = imcs.stream()
                .filter(imc -> imc.getTipo_sanguineo().equalsIgnoreCase(TipoSanguineoEnum.A_B_POSITIVO.name()))
                .mapToDouble(CalculoModel::getIdade)
                .average().orElse(0.0);

        Double mediaABNegativo = imcs.stream()
                .filter(imc -> imc.getTipo_sanguineo().equalsIgnoreCase(TipoSanguineoEnum.A_B_NEGATIVO.name()))
                .mapToDouble(CalculoModel::getIdade)
                .average().orElse(0.0);

        return new MediaTipoSanguineoResponseDto(mediaAPositivo, mediaANegativo, mediaBPositivo,
                mediaBNegativo, mediaOPositivo, mediaONegativo, mediaABPositivo, mediaABNegativo);
    }

    public DoadoresTipoSanguineoResponseDto calculoDoadoresPorTipoSanguineo() {

        List<CalculoModel> imcs = imcRepository.getData();

        Integer totalDoadoresAPositivo = (int) imcs.stream()
                .filter(imc -> imc.getTipo_sanguineo().equalsIgnoreCase(TipoSanguineoEnum.A_POSITIVO.name()))
                .filter(imc -> imc.getIdade() >= 16 && imc.getIdade() <= 69 && imc.getPeso() >= 50)
                .count();

        Integer totalDoadoresANegativo = (int) imcs.stream()
                .filter(imc -> imc.getTipo_sanguineo().equalsIgnoreCase(TipoSanguineoEnum.A_NEGATIVO.name()))
                .filter(imc -> imc.getIdade() >= 16 && imc.getIdade() <= 69 && imc.getPeso() >= 50)
                .count();

        Integer totalDoadoresBPositivo = (int) imcs.stream()
                .filter(imc -> imc.getTipo_sanguineo().equalsIgnoreCase(TipoSanguineoEnum.B_POSITIVO.name()))
                .filter(imc -> imc.getIdade() >= 16 && imc.getIdade() <= 69 && imc.getPeso() >= 50)
                .count();

        Integer totalDoadoresBNegativo = (int) imcs.stream()
                .filter(imc -> imc.getTipo_sanguineo().equalsIgnoreCase(TipoSanguineoEnum.B_NEGATIVO.name()))
                .filter(imc -> imc.getIdade() >= 16 && imc.getIdade() <= 69 && imc.getPeso() >= 50)
                .count();

        Integer totalDoadoresOPositivo = (int) imcs.stream()
                .filter(imc -> imc.getTipo_sanguineo().equalsIgnoreCase(TipoSanguineoEnum.O_POSITIVO.name()))
                .filter(imc -> imc.getIdade() >= 16 && imc.getIdade() <= 69 && imc.getPeso() >= 50)
                .count();

        Integer totalDoadoresONegativo = (int) imcs.stream()
                .filter(imc -> imc.getTipo_sanguineo().equalsIgnoreCase(TipoSanguineoEnum.O_NEGATIVO.name()))
                .filter(imc -> imc.getIdade() >= 16 && imc.getIdade() <= 69 && imc.getPeso() >= 50)
                .count();

        Integer totalDoadoresABPositivo = (int) imcs.stream()
                .filter(imc -> imc.getTipo_sanguineo().equalsIgnoreCase(TipoSanguineoEnum.A_B_POSITIVO.name()))
                .filter(imc -> imc.getIdade() >= 16 && imc.getIdade() <= 69 && imc.getPeso() >= 50)
                .count();

        Integer totalDoadoresABNegativo = (int) imcs.stream()
                .filter(imc -> imc.getTipo_sanguineo().equalsIgnoreCase(TipoSanguineoEnum.A_B_NEGATIVO.name()))
                .filter(imc -> imc.getIdade() >= 16 && imc.getIdade() <= 69 && imc.getPeso() >= 50)
                .count();

        return new DoadoresTipoSanguineoResponseDto(totalDoadoresAPositivo, totalDoadoresANegativo,
                totalDoadoresBPositivo, totalDoadoresBNegativo, totalDoadoresOPositivo,
                totalDoadoresONegativo, totalDoadoresABPositivo, totalDoadoresABNegativo);
    }

    private void verificaValorExistente(PacienteModel pacienteModel) {

        PacienteModel pacienteCpf = pacienteRepository.findByCpf(pacienteModel.getCpf());
        PacienteModel pacienteContatoEmail = pacienteRepository.findByContatoEmail(pacienteModel.getContato().get(0).getEmail());
        PacienteModel pacienteContatoNumero = pacienteRepository.findByContatoNumero(pacienteModel.getContato().get(0).getNumero());

        if (pacienteCpf != null) {
            throw new MensagemCustomException(String.format("O CPF [%s] já existe.", pacienteModel.getCpf()));
        }

        if (pacienteContatoEmail != null) {
            throw new MensagemCustomException(String.format("O e-mail de contato [%s] já existe.", pacienteModel.getContato().get(0).getEmail()));
        }

        if (pacienteContatoNumero != null) {
            throw new MensagemCustomException(String.format("O número de contato [%s] já existe.", pacienteModel.getContato().get(0).getNumero()));
        }
    }
}
