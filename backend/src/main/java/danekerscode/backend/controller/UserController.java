package danekerscode.backend.controller;

import danekerscode.backend.dto.UserDTO;
import danekerscode.backend.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/user")
public class UserController {

    private final UserService userService;

    @GetMapping("{id}")
    ResponseEntity<?> find(
            @PathVariable Long id
    ){
        return ResponseEntity.
                ok(userService.findById(id));
    }




}

