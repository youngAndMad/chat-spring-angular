package danekerscode.backend.mapper;

import danekerscode.backend.dto.ChatDTO;
import danekerscode.backend.model.Chat;
import danekerscode.backend.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper
public interface ChatMapper {

    @Mapping(target = "members" ,source = "users")
    @Mapping(target = "messages" , ignore = true)
    @Mapping(target = "id" , ignore = true)
    Chat toModel(ChatDTO dto , List<User> users);
}
