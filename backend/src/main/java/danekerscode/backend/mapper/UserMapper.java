package danekerscode.backend.mapper;

import danekerscode.backend.dto.UserDTO;
import danekerscode.backend.enums.Gender;
import danekerscode.backend.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface UserMapper {

    @Mapping(target = "id" , ignore = true)
    @Mapping(target = "gender" , expression = "java(mapGender(dto.gender()))")
    User toModel(UserDTO dto);

    default Gender mapGender(String gender){
        return Gender.valueOf(gender.toUpperCase());
    }

}
