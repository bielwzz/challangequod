package br.com.fiap.controller;


import br.com.fiap.service.NotificacaoService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.Map;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;

@WebMvcTest(NotificacaoController.class)
public class NotificacaoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private NotificacaoService notificacaoService;

    @Test
    public void testNotificarFraude() throws Exception {
        String json = """
            {
              \"transacaoId\": \"123e4567-e89b-12d3-a456-426614174000\",
              \"tipoBiometria\": \"facial\",
              \"tipoFraude\": \"deepfake\",
              \"dataCaptura\": \"2025-02-13T14:30:00Z\",
              \"dispositivo\": {
                \"fabricante\": \"Samsung\",
                \"modelo\": \"Galaxy S22\",
                \"sistemaOperacional\": \"Android 13\"
              },
              \"canalNotificacao\": [\"sms\", \"email\"],
              \"notificadoPor\": \"sistema-de-monitoramento\",
              \"metadados\": {
                \"latitude\": -23.55052,
                \"longitude\": -46.633308,
                \"ipOrigem\": \"192.168.1.10\"
              }
            }
        """;

        mockMvc.perform(post("/api/notificacoes/fraude")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(status().isOk());

        verify(notificacaoService).processarNotificacao(org.mockito.ArgumentMatchers.any());
    }
}