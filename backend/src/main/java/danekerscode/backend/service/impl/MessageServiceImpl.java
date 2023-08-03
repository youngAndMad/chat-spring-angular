package danekerscode.backend.service.impl;

import danekerscode.backend.dto.MessageDTO;
import danekerscode.backend.exception.EntityNotFoundException;
import danekerscode.backend.mapper.MessageMapper;
import danekerscode.backend.model.Message;
import danekerscode.backend.repository.MessageRepository;
import danekerscode.backend.service.ChatService;
import danekerscode.backend.service.MessageService;
import danekerscode.backend.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class MessageServiceImpl implements MessageService {

    private final MessageRepository messageRepository;
    private final ChatService chatService;
    private final MessageMapper mapper;
    private final UserService userService;

    @Override
    public Message save(MessageDTO dto) {
        return null;
    }

    @Override
    public void deleteById(Long id) {
        messageRepository.delete(this.findById(id));
    }

    @Override
    public Message findById(Long id) {
       return messageRepository
               .findById(id)
               .orElseThrow(() -> new EntityNotFoundException(Message.class , id));
    }
}
