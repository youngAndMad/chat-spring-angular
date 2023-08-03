package danekerscode.backend.service;

import danekerscode.backend.dto.MessageDTO;
import danekerscode.backend.model.Message;

public interface MessageService {
    Message save(MessageDTO dto);

    void deleteById(Long id);

    Message findById(Long id);
}
