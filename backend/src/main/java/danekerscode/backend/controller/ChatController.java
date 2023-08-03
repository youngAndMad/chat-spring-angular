package danekerscode.backend.controller;

import danekerscode.backend.dto.ChatDTO;
import danekerscode.backend.dto.MessageDTO;
import danekerscode.backend.service.ChatService;
import danekerscode.backend.service.MessageService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("chat")
public class ChatController {


    private final ChatService chatService;

    @PostMapping
    ResponseEntity<?> save(
            @RequestBody ChatDTO dto
    ){
        return ResponseEntity
                .status(201)
                .body(chatService.save(dto));
    }

    @GetMapping("{id}")
    ResponseEntity<?> find(
            @PathVariable Long id
    ){
        return ResponseEntity
                .ok(chatService.findById(id));
    }

}
