package danekerscode.backend.service;

import danekerscode.backend.dto.UserDTO;
import danekerscode.backend.model.User;

import java.util.Map;

public interface UserService {
    Map<String,Object> save(UserDTO dto);
}
