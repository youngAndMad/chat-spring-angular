package danekerscode.backend.dto;

import danekerscode.backend.enums.Gender;

public record UserDTO(
        String name,
        String surname,
        String email,
        String password,
        Gender gender
) {
}
