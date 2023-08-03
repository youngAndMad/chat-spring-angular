package danekerscode.backend.service.impl;

import danekerscode.backend.dto.ChatDTO;
import danekerscode.backend.exception.EntityNotFoundException;
import danekerscode.backend.mapper.ChatMapper;
import danekerscode.backend.model.Chat;
import danekerscode.backend.repository.ChatRepository;
import danekerscode.backend.service.ChatService;
import danekerscode.backend.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ChatServiceImpl implements ChatService {

    private final ChatMapper chatMapper;
    private final ChatRepository chatRepository;
    private final UserService userService;

    @Override
    public Chat save(ChatDTO dto) {
        var users = dto.users().stream()
                .map(userService::findById)
                .toList();

        return chatRepository.save(chatMapper.toModel(dto , users));
    }

    @Override
    public void deleteById(Long id) {
        chatRepository.delete(this.findById(id));
    }

    @Override
    public Chat findById(Long id) {
        return chatRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(Chat.class , id));
    }


}
