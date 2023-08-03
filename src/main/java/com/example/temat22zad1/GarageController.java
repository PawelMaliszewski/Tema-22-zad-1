package com.example.temat22zad1;

import jakarta.mail.MessagingException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class GarageController {

    private final MailService mailService;

    public GarageController(MailService mailService) {
        this.mailService = mailService;
    }

    @GetMapping("/")
    String home() {
        return "index";
    }

    @GetMapping("/service")
    String service() {
        return "service";
    }

    @GetMapping("/opening-hours")
    String openingHours() {
        return "opening-hours";
    }

    @GetMapping("/contact")
    String contact(Model model) {
        Email email = new Email();
        model.addAttribute("email", email);
        return "contact";
    }

    @GetMapping("/email-confirmation")
    public String emailConfirmation() {
        return "/email-confirmation";
    }

    @PostMapping("/send-email")
    public String sendEmail(@ModelAttribute Email email) {
        mailService.sendEmail(email.getSenderEmail(), email.getSubject(), email.getMassage());
        return "redirect:/email-confirmation";
    }
}
