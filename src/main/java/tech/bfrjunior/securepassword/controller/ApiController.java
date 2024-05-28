package tech.bfrjunior.securepassword.controller;

import org.springframework.web.bind.annotation.RestController;

import tech.bfrjunior.securepassword.service.PasswordService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class ApiController {

    private final PasswordService passwordService;

    public ApiController(PasswordService passwordService) {
        this.passwordService = passwordService;
    }

    @PostMapping(value = "/validate-password")
    public ResponseEntity<FailureResponse> validatePassword(@RequestBody BodyResquest request) {

        var failures = passwordService.validatePass(request.password());

        if (failures.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.badRequest().body(new FailureResponse(failures));
    }

}
