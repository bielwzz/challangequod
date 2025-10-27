package br.com.fiap.controller;

import br.com.fiap.dto.NotificacaoFraudeDTO;
import br.com.fiap.service.NotificacaoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/notificacoes")
public class NotificacaoController {

    private final NotificacaoService notificacaoService;

    public NotificacaoController(NotificacaoService notificacaoService) {
        this.notificacaoService = notificacaoService;
    }

    @PostMapping("/fraude")
    public ResponseEntity<String> notificarFraude(@RequestBody NotificacaoFraudeDTO dto) {
        notificacaoService.processarNotificacao(dto);
        return ResponseEntity.ok("Notificação registrada com sucesso.");
    }
}