package danekerscode.backend.mapper;

import danekerscode.backend.dto.UserDTO;
import danekerscode.backend.enums.Role;
import danekerscode.backend.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(imports = Role.class)
public interface UserMapper {

    @Mapping(target = "id" , ignore = true)
    @Mapping(target = "role" , expression = "java(Role.USER)")
    User toModel(UserDTO dto);

}
