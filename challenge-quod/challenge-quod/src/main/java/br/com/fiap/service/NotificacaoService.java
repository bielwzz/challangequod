package br.com.fiap.service;

import br.com.fiap.dto.DispositivoDTO;
import br.com.fiap.dto.NotificacaoFraudeDTO;
import br.com.fiap.model.NotificacaoFraude;
import br.com.fiap.repository.NotificacaoFraudeRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class NotificacaoService {

    private final NotificacaoFraudeRepository repository;
    private final RestTemplate restTemplate;

    public NotificacaoService(NotificacaoFraudeRepository repository) {
        this.repository = repository;
        this.restTemplate = new RestTemplate();
    }

    public void processarNotificacao(NotificacaoFraudeDTO dto) {
        // Converter DTO para Entity
        NotificacaoFraude entidade = new NotificacaoFraude();
        entidade.setTransacaoId(dto.getTransacaoId());
        entidade.setTipoBiometria(dto.getTipoBiometria());
        entidade.setTipoFraude(dto.getTipoFraude());
        entidade.setDataCaptura(dto.getDataCaptura());
        entidade.setNotificadoPor(dto.getNotificadoPor());
        entidade.setCanalNotificacao(dto.getCanalNotificacao());
        entidade.setMetadados(dto.getMetadados());

        NotificacaoFraude.Dispositivo dispositivo = new NotificacaoFraude.Dispositivo();
        DispositivoDTO dispDTO = dto.getDispositivo();
        dispositivo.setFabricante(dispDTO.getFabricante());
        dispositivo.setModelo(dispDTO.getModelo());
        dispositivo.setSistemaOperacional(dispDTO.getSistemaOperacional());
        entidade.setDispositivo(dispositivo);

        // Persistir no MongoDB
        repository.save(entidade);

        // Simular notificação ao sistema QUOD
        String url = "http://sistema-quod.local/api/fraudes";
        try {
            restTemplate.postForEntity(url, dto, String.class);
        } catch (Exception e) {
            System.err.println("Erro ao notificar o sistema QUOD: " + e.getMessage());
        }
    }
}