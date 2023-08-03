package danekerscode.backend.mapper;

import danekerscode.backend.dto.UserDTO;
import danekerscode.backend.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface UserMapper {

    @Mapping(target = "messages" , ignore = true)
    @Mapping(target = "id" , ignore = true)
    @Mapping(target ="chats" , ignore = true)
    User toModel(UserDTO dto);

}
