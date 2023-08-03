package danekerscode.backend.enums;

import io.jsonwebtoken.SignatureAlgorithm;
import lombok.AllArgsConstructor;
import lombok.Getter;

import static io.jsonwebtoken.SignatureAlgorithm.*;

@Getter
@AllArgsConstructor
public enum TokenType {
    ACCESS(15, HS384),
    REFRESH(60, HS512);

    private final Integer expirationMinute;
    private final SignatureAlgorithm algorithm;
}
