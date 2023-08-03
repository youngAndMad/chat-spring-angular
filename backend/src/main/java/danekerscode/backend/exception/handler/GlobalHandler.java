package danekerscode.backend.exception.handler;

import danekerscode.backend.exception.InvalidCredentialsException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.function.BiFunction;

import static org.springframework.http.HttpStatus.*;

@ControllerAdvice
public class GlobalHandler {

    @ExceptionHandler(InvalidCredentialsException.class)
    ProblemDetail handler(InvalidCredentialsException e){
        return withDetails.apply(e , UNAUTHORIZED);
    }

    private final BiFunction<RuntimeException, HttpStatus, ProblemDetail> withDetails =
            (e, status) ->
                    ProblemDetail.forStatusAndDetail(status, e.getMessage());
}
