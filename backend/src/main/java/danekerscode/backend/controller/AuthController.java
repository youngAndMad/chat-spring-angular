package danekerscode.backend.controller;

import danekerscode.backend.dto.AuthRequest;
import danekerscode.backend.dto.UserDTO;
import danekerscode.backend.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("refresh-token")
    ResponseEntity<?> refresh(
            @RequestHeader("refresh_token") String refreshToken
    ) {
        return
                ResponseEntity
                        .ok(userService.refresh(refreshToken));
    }

    @PostMapping
    ResponseEntity<?> auth(
            @RequestBody AuthRequest authRequest
    ) {
        return ResponseEntity
                        .ok(userService.auth(authRequest));
    }

}
