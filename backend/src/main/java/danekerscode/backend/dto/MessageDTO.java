package danekerscode.backend.dto;

public record MessageDTO(
        String value,
        Long chatId,
        Long senderId
) {
}
