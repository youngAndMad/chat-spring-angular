package danekerscode.backend.controller;

import danekerscode.backend.exception.InvalidCredentialsException;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ProblemDetail;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RequestMapping("api/v1/demo")
@RestController
public class DemoController {

    @GetMapping("admin")
    @PreAuthorize("hasRole('ADMIN')")
    String adminDemo(){
        return "secured endpoint for admins";
    }

    @GetMapping("admin-and-user")
    @PreAuthorize("hasAnyRole('USER' , 'ADMIN')")
    String adminUserDemo(){
        return "secured endpoint for admins and user";
    }

    @GetMapping("user")
    @PreAuthorize("hasRole('USER')")
    String userDemo(){
        return "secured endpoint for users";
    }



}
