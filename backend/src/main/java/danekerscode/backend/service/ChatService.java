package danekerscode.backend.service;

import danekerscode.backend.dto.ChatDTO;
import danekerscode.backend.model.Chat;
import danekerscode.backend.repository.ChatRepository;

public interface ChatService {
    Chat save(ChatDTO dto);

    void deleteById(Long id);

    Chat findById(Long id);
}
