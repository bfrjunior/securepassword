package tech.bfrjunior.securepassword.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class ApiController {

    @PostMapping(name = "/validate-password")
    public ResponseEntity<?> validatePassword() {

        return ResponseEntity.noContent().build();
    }

}
