package danekerscode.backend.service.redis.impl;

import danekerscode.backend.model.Message;
import danekerscode.backend.service.redis.MessageRedisService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository

public class RedisMessageServiceImpl implements MessageRedisService {

    @Value("${spring.data.redis.prefix.message}")
    private String MESSAGE_PREFIX;

    private final HashOperations<String,Long,Message> hash;

    public RedisMessageServiceImpl(RedisTemplate<String, Message> redisTemplate) {
        this.hash = redisTemplate.opsForHash();
    }

    @Override
    public void save(Message message) {
        hash.put(MESSAGE_PREFIX , 1L , message);
    }

    @Override
    public void delete(Long id) {
        hash.delete(MESSAGE_PREFIX , id);
    }

    @Override
    public List<Message> messages(Long chatId) {
        return null;
    }

    @Override
    public List<Message> messages() {
       return hash.entries(MESSAGE_PREFIX)
               .values().stream()
               .toList();
    }
}
