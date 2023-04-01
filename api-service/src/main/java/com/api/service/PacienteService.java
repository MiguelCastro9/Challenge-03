package com.api.service;

import com.api.dto.DoadoresTipoSanguineoResponseDto;
import com.api.dto.FaixaEtariaIMCResponseDto;
import com.api.dto.MediaTipoSanguineoResponseDto;
import com.api.dto.PercentualObesosResponseDto;
import com.api.enums.GeneroEnum;
import com.api.enums.TipoSanguineoEnum;
import com.api.exception.MensagemCustomException;
import com.api.model.DataModel;
import com.api.model.PacienteModel;
import com.api.repository.PacienteRepository;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.api.repository.DataRepository;

/**
 *
 * @author Miguel Castro
 */
@Service
public class PacienteService {

    @Autowired
    PacienteRepository pacienteRepository;

    @Autowired
    DataRepository imcRepository;

    public List<PacienteModel> listar() {

        return pacienteRepository.findAll();
    }

    public PacienteModel salvar(PacienteModel pacienteModel) {

        verificaValorExistente(pacienteModel);
        return pacienteRepository.save(pacienteModel);
    }

    public List<FaixaEtariaIMCResponseDto> calculoIMCPorfaixaEtaria() {

        List<DataModel> data = new ArrayList<>();
        data = imcRepository.getData();
        HashMap<String, Double> imcs = new HashMap<>();

        for (int i = 0; i < data.size(); i++) {

            Integer idade = data.get(i).getIdade();
            Double peso = data.get(i).getPeso();
            Double altura = data.get(i).getAltura();
            Double imc = peso / (altura * altura);

            if (idade >= 0 && idade <= 10) {
                if (imcs.containsKey("Faixa etária [0 - 10]")) {
                    imcs.put("Faixa etária [0 - 10]", imcs.get("Faixa etária [0 - 10]") + imc);
                } else {
                    imcs.put("Faixa etária [0 - 10]", imc);
                }
            }
            if (idade >= 11 && idade <= 20) {
                if (imcs.containsKey("Faixa etária [11 - 20]")) {
                    imcs.put("Faixa etária [11 - 20]", imcs.get("Faixa etária [11 - 20]") + imc);
                } else {
                    imcs.put("Faixa etária [11 - 20]", imc);
                }
            }
            if (idade >= 21 && idade <= 30) {
                if (imcs.containsKey("Faixa etária [21 - 30]")) {
                    imcs.put("Faixa etária [21 - 30]", imcs.get("Faixa etária [21 - 30]") + imc);
                } else {
                    imcs.put("Faixa etária [21 - 30]", imc);
                }
            }
            if (idade >= 31 && idade <= 40) {
                if (imcs.containsKey("Faixa etária [31 - 40]")) {
                    imcs.put("Faixa etária [31 - 40]", imcs.get("Faixa etária [31 - 40]") + imc);
                } else {
                    imcs.put("Faixa etária [31 - 40]", imc);
                }
            }
            if (idade >= 41 && idade <= 50) {
                if (imcs.containsKey("Faixa etária [41 - 50]")) {
                    imcs.put("Faixa etária [41 - 50]", imcs.get("Faixa etária [41 - 50]") + imc);
                } else {
                    imcs.put("Faixa etária [41 - 50]", imc);
                }
            }
            if (idade >= 51 && idade <= 60) {
                if (imcs.containsKey("Faixa etária [51 - 60]")) {
                    imcs.put("Faixa etária [51 - 60]", imcs.get("Faixa etária [51 - 60]") + imc);
                } else {
                    imcs.put("Faixa etária [51 - 60]", imc);
                }
            }
            if (idade >= 61 && idade <= 70) {
                if (imcs.containsKey("Faixa etária [61 - 70]")) {
                    imcs.put("Faixa etária [61 - 70]", imcs.get("Faixa etária [61 - 70]") + imc);
                } else {
                    imcs.put("Faixa etária [61 - 70]", imc);
                }
            }
            if (idade >= 71 && idade <= 80) {
                if (imcs.containsKey("Faixa etária [71 - 80]")) {
                    imcs.put("Faixa etária [71 - 80]", imcs.get("Faixa etária [71 - 80]") + imc);
                } else {
                    imcs.put("Faixa etária [71 - 80]", imc);
                }
            }
            if (idade >= 81 && idade <= 90) {
                if (imcs.containsKey("Faixa etária [81 - 90]")) {
                    imcs.put("Faixa etária [81 - 90]", imcs.get("Faixa etária [81 - 90]") + imc);
                } else {
                    imcs.put("Faixa etária [81 - 90]", imc);
                }
            }
            if (idade >= 91 && idade <= 100) {
                if (imcs.containsKey("Faixa etária [91 - 100]")) {
                    imcs.put("Faixa etária [91 - 100]", imcs.get("Faixa etária [91 - 100]") + imc);
                } else {
                    imcs.put("Faixa etária [91 - 100]", imc);
                }
            }
        }
        List<FaixaEtariaIMCResponseDto> faixasEtarias = imcs.entrySet().stream()
                .map(entry -> new FaixaEtariaIMCResponseDto(entry.getKey(), entry.getValue()))
                .collect(Collectors.toList());

        return faixasEtarias;
    }

    public PercentualObesosResponseDto calculoPercentualObesos() {

        List<DataModel> data = imcRepository.getData();

        Long qtdMasculinos = data.stream().filter(dt -> dt.getGenero().equalsIgnoreCase(GeneroEnum.MASCULINO.name())).count();
        Long qtdFemininos = data.stream().filter(dt -> dt.getGenero().equalsIgnoreCase(GeneroEnum.FEMININO.name())).count();
        Long qtdObesosMasculinos = data.stream().filter(dt -> dt.getGenero().equalsIgnoreCase(GeneroEnum.MASCULINO.name()) && dt.getPeso() / (dt.getAltura() * dt.getAltura()) > 30).count();
        Long qtdObesosFemininos = data.stream().filter(dt -> dt.getGenero().equalsIgnoreCase(GeneroEnum.FEMININO.name()) && dt.getPeso() / (dt.getAltura() * dt.getAltura()) > 30).count();
        Double percentualObesosMasculinos = qtdMasculinos > 0 ? 100.0 * qtdObesosMasculinos / qtdMasculinos : 0;
        Double percentualObesosFemininos = qtdFemininos > 0 ? 100.0 * qtdObesosFemininos / qtdFemininos : 0;

        return new PercentualObesosResponseDto(percentualObesosMasculinos, percentualObesosFemininos);
    }

    public MediaTipoSanguineoResponseDto calculoMediaIdadePorTipoSanguineo() {

        List<DataModel> data = imcRepository.getData();

        Double mediaAPositivo = data.stream()
                .filter(dt -> dt.getTipo_sanguineo().equalsIgnoreCase(TipoSanguineoEnum.A_POSITIVO.name()))
                .mapToDouble(DataModel::getIdade)
                .average().orElse(0.0);

        Double mediaANegativo = data.stream()
                .filter(dt -> dt.getTipo_sanguineo().equalsIgnoreCase(TipoSanguineoEnum.A_NEGATIVO.name()))
                .mapToDouble(DataModel::getIdade)
                .average().orElse(0.0);

        Double mediaBPositivo = data.stream()
                .filter(dt -> dt.getTipo_sanguineo().equalsIgnoreCase(TipoSanguineoEnum.B_POSITIVO.name()))
                .mapToDouble(DataModel::getIdade)
                .average().orElse(0.0);

        Double mediaBNegativo = data.stream()
                .filter(dt -> dt.getTipo_sanguineo().equalsIgnoreCase(TipoSanguineoEnum.B_NEGATIVO.name()))
                .mapToDouble(DataModel::getIdade)
                .average().orElse(0.0);

        Double mediaOPositivo = data.stream()
                .filter(dt -> dt.getTipo_sanguineo().equalsIgnoreCase(TipoSanguineoEnum.O_POSITIVO.name()))
                .mapToDouble(DataModel::getIdade)
                .average().orElse(0.0);

        Double mediaONegativo = data.stream()
                .filter(dt -> dt.getTipo_sanguineo().equalsIgnoreCase(TipoSanguineoEnum.O_NEGATIVO.name()))
                .mapToDouble(DataModel::getIdade)
                .average().orElse(0.0);

        Double mediaABPositivo = data.stream()
                .filter(dt -> dt.getTipo_sanguineo().equalsIgnoreCase(TipoSanguineoEnum.A_B_POSITIVO.name()))
                .mapToDouble(DataModel::getIdade)
                .average().orElse(0.0);

        Double mediaABNegativo = data.stream()
                .filter(dt -> dt.getTipo_sanguineo().equalsIgnoreCase(TipoSanguineoEnum.A_B_NEGATIVO.name()))
                .mapToDouble(DataModel::getIdade)
                .average().orElse(0.0);

        return new MediaTipoSanguineoResponseDto(mediaAPositivo, mediaANegativo, mediaBPositivo,
                mediaBNegativo, mediaOPositivo, mediaONegativo, mediaABPositivo, mediaABNegativo);
    }

    public DoadoresTipoSanguineoResponseDto calculoDoadoresPorTipoSanguineo() {

        List<DataModel> data = imcRepository.getData();

        Integer totalDoadoresAPositivo = (int) data.stream()
                .filter(dt -> dt.getTipo_sanguineo().equalsIgnoreCase(TipoSanguineoEnum.A_POSITIVO.name()))
                .filter(dt -> dt.getIdade() >= 16 && dt.getIdade() <= 69 && dt.getPeso() >= 50)
                .count();

        Integer totalDoadoresANegativo = (int) data.stream()
                .filter(dt -> dt.getTipo_sanguineo().equalsIgnoreCase(TipoSanguineoEnum.A_NEGATIVO.name()))
                .filter(dt -> dt.getIdade() >= 16 && dt.getIdade() <= 69 && dt.getPeso() >= 50)
                .count();

        Integer totalDoadoresBPositivo = (int) data.stream()
                .filter(dt -> dt.getTipo_sanguineo().equalsIgnoreCase(TipoSanguineoEnum.B_POSITIVO.name()))
                .filter(dt -> dt.getIdade() >= 16 && dt.getIdade() <= 69 && dt.getPeso() >= 50)
                .count();

        Integer totalDoadoresBNegativo = (int) data.stream()
                .filter(dt -> dt.getTipo_sanguineo().equalsIgnoreCase(TipoSanguineoEnum.B_NEGATIVO.name()))
                .filter(dt -> dt.getIdade() >= 16 && dt.getIdade() <= 69 && dt.getPeso() >= 50)
                .count();

        Integer totalDoadoresOPositivo = (int) data.stream()
                .filter(dt -> dt.getTipo_sanguineo().equalsIgnoreCase(TipoSanguineoEnum.O_POSITIVO.name()))
                .filter(dt -> dt.getIdade() >= 16 && dt.getIdade() <= 69 && dt.getPeso() >= 50)
                .count();

        Integer totalDoadoresONegativo = (int) data.stream()
                .filter(dt -> dt.getTipo_sanguineo().equalsIgnoreCase(TipoSanguineoEnum.O_NEGATIVO.name()))
                .filter(dt -> dt.getIdade() >= 16 && dt.getIdade() <= 69 && dt.getPeso() >= 50)
                .count();

        Integer totalDoadoresABPositivo = (int) data.stream()
                .filter(imc -> imc.getTipo_sanguineo().equalsIgnoreCase(TipoSanguineoEnum.A_B_POSITIVO.name()))
                .filter(imc -> imc.getIdade() >= 16 && imc.getIdade() <= 69 && imc.getPeso() >= 50)
                .count();

        Integer totalDoadoresABNegativo = (int) data.stream()
                .filter(imc -> imc.getTipo_sanguineo().equalsIgnoreCase(TipoSanguineoEnum.A_B_NEGATIVO.name()))
                .filter(imc -> imc.getIdade() >= 16 && imc.getIdade() <= 69 && imc.getPeso() >= 50)
                .count();

        return new DoadoresTipoSanguineoResponseDto(
                "[A+] pode doar para [AB+ e A+] e pode receber de [A+, A-, O+ e O-]", totalDoadoresAPositivo,
                "[A-] pode doar para [A+, A-, AB+ e AB-] e pode receber de [A- e O-]", totalDoadoresANegativo,
                "[B+] pode doar para [B+ e AB+] e pode receber de [B+, B-, O+ e O-]", totalDoadoresBPositivo,
                "[B-] pode doar para [B+, B-, AB+ e AB-] e pode receber de [B- e O-]", totalDoadoresBNegativo,
                "[O+] pode doar para [A+, B+, O+ e AB+] e pode receber de [O+ e O-]", totalDoadoresOPositivo,
                "[O-] pode doar para [A+, B+, O+, AB+, A-, B-, O- e AB-] e pode receber de [O-]", totalDoadoresONegativo,
                "[AB+] pode doar para [AB+] e pode receber de [A+, B+, O+, AB+, A-, B-, O- e AB-]", totalDoadoresABPositivo,
                "[AB-] pode doar para [AB+ e AB-] e pode receber de [A-, B-, O- e AB-]", totalDoadoresABNegativo);
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
