package danekerscode.backend.dto;

public record AuthRequest(
        String email,
        String password
) {
}
