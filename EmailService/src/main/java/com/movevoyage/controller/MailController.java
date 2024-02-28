package com.movevoyage.controller;

import com.movevoyage.payload.StandardMessageResponse;
import com.movevoyage.service.MailService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/email")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class MailController {
    private final MailService mailService;
    @PostMapping("/send/welcome")
    public StandardMessageResponse send(@RequestHeader String mail) {
        mailService.welcome(mail, null);
        return new StandardMessageResponse("Email sent successfully", true);
    }
}