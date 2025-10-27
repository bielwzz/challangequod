package br.com.fiap.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.Map;

@Document(collection = "notificacoes_fraude")
public class NotificacaoFraude {
    @Id
    private String id;
    private String transacaoId;
    private String tipoBiometria;
    private String tipoFraude;
    private ZonedDateTime dataCaptura;
    private Dispositivo dispositivo;
    private List<String> canalNotificacao;
    private String notificadoPor;
    private Map<String, Object> metadados;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

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

    public Dispositivo getDispositivo() {
        return dispositivo;
    }

    public void setDispositivo(Dispositivo dispositivo) {
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

    public static class Dispositivo {
        private String fabricante;
        private String modelo;
        private String sistemaOperacional;

        public String getFabricante() {
            return fabricante;
        }

        public void setFabricante(String fabricante) {
            this.fabricante = fabricante;
        }

        public String getModelo() {
            return modelo;
        }

        public void setModelo(String modelo) {
            this.modelo = modelo;
        }

        public String getSistemaOperacional() {
            return sistemaOperacional;
        }

        public void setSistemaOperacional(String sistemaOperacional) {
            this.sistemaOperacional = sistemaOperacional;
        }
    }
}
