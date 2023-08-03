package danekerscode.backend.mapper;

import danekerscode.backend.dto.MessageDTO;
import danekerscode.backend.model.Chat;
import danekerscode.backend.model.Message;
import danekerscode.backend.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface MessageMapper {

    @Mapping(target = "chat" , expression = "java(chat)")
    @Mapping(target = "sender" , expression = "java(user)")
    @Mapping(target = "id" , ignore = true)
    Message model(MessageDTO dto , Chat chat , User user);

}
