package danekerscode.backend.dto;

import danekerscode.backend.enums.ChatType;

import java.util.List;

public record ChatDTO(
        ChatType type,
        String name,
        List<Long> users
) {
}
