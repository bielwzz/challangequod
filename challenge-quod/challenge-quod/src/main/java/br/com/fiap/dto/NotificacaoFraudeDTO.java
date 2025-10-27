package br.com.fiap.dto;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.Map;


public class NotificacaoFraudeDTO {

        private String transacaoId;
        private String tipoBiometria;
        private String tipoFraude;
        private ZonedDateTime dataCaptura;
        private DispositivoDTO dispositivo;
        private List<String> canalNotificacao;
        private String notificadoPor;
        private Map<String, Object> metadados;

    public String getTransacaoId() {
        return transacaoId;
    }

    public void setTransacaoId(String transacaoId) {
        this.transacaoId = transacaoId;
    }

    public String getTipoBiometria() {
        return tipoBiometria;
    }

    public void setTipoBiometria(String tipoBiometria) {
        this.tipoBiometria = tipoBiometria;
    }

    public String getTipoFraude() {
        return tipoFraude;
    }

    public void setTipoFraude(String tipoFraude) {
        this.tipoFraude = tipoFraude;
    }

    public ZonedDateTime getDataCaptura() {
        return dataCaptura;
    }

    public void setDataCaptura(ZonedDateTime dataCaptura) {
        this.dataCaptura = dataCaptura;
    }

    public DispositivoDTO getDispositivo() {
        return dispositivo;
    }

    public void setDispositivo(DispositivoDTO dispositivo) {
        this.dispositivo = dispositivo;
    }

    public List<String> getCanalNotificacao() {
        return canalNotificacao;
    }

    public void setCanalNotificacao(List<String> canalNotificacao) {
        this.canalNotificacao = canalNotificacao;
    }

    public String getNotificadoPor() {
        return notificadoPor;
    }

    public void setNotificadoPor(String notificadoPor) {
        this.notificadoPor = notificadoPor;
    }

    public Map<String, Object> getMetadados() {
        return metadados;
    }

    public void setMetadados(Map<String, Object> metadados) {
        this.metadados = metadados;
    }
}
