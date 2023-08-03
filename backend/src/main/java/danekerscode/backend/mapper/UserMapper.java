package danekerscode.backend.mapper;

import danekerscode.backend.dto.UserDTO;
import danekerscode.backend.enums.Gender;
import danekerscode.backend.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface UserMapper {

    @Mapping(target = "id" , ignore = true)
    User toModel(UserDTO dto);

}
