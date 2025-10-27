package br.com.fiap.repository;


import br.com.fiap.model.NotificacaoFraude;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface NotificacaoFraudeRepository extends MongoRepository<NotificacaoFraude, String> {
}