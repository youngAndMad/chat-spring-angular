package danekerscode.backend.service.redis;

import danekerscode.backend.model.Message;

import java.util.List;

public interface MessageRedisService {
    void save(Message message);

    void delete(Long id);

    List<Message> messages(Long chatId);
    List<Message> messages();

}
