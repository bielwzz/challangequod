package br.com.fiap.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.UUID;

public class SimulacaoCapturaController {

    @PostMapping("/biometria/facial")
    public ResponseEntity<String> simularCapturaFacial() {
        return ResponseEntity.ok("Captura facial simulada com sucesso: transacaoId=" + UUID.randomUUID());
    }

    @PostMapping("/biometria/digital")
    public ResponseEntity<String> simularCapturaDigital() {
        return ResponseEntity.ok("Captura de impressão digital simulada com sucesso: transacaoId=" + UUID.randomUUID());
    }

    @PostMapping("/documento")
    public ResponseEntity<String> simularCapturaDocumento() {
        return ResponseEntity.ok("Captura de documento simulada com sucesso: transacaoId=" + UUID.randomUUID());
    }
}
