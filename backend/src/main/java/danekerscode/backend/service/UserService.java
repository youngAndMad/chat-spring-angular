package danekerscode.backend.service;

import danekerscode.backend.dto.AuthRequest;
import danekerscode.backend.dto.UserDTO;
import danekerscode.backend.model.User;
import org.springframework.http.ResponseEntity;

import java.util.Map;

public interface UserService {
    Map<String,Object> save(UserDTO dto);

    Map<String,Object> refresh(String refreshToken);

    Map<String,Object> auth(AuthRequest authRequest);
}
