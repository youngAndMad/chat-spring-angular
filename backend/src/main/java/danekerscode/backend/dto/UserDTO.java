package danekerscode.backend.dto;

public record UserDTO(
        String name,
        String surname,
        String email,
        String password,
        String gender
) {
}
