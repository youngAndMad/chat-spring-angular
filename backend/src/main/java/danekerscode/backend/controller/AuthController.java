package danekerscode.backend.controller;

import danekerscode.backend.dto.UserDTO;
import danekerscode.backend.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("auth")
@RequiredArgsConstructor
public class AuthController {

    private final UserService userService;


    @PostMapping("register")
    ResponseEntity<?> register(
            @RequestBody UserDTO userDTO
    ) {
        return ResponseEntity
                .status(201)
                .body(userService.save(userDTO));
    }
}
