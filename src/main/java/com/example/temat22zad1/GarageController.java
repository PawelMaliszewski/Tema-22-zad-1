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
    String home(Model model) {
        model.addAttribute("location", "index");
        return "index";
    }

    @GetMapping("/service")
    String service(Model model) {
        model.addAttribute("location", "service");
        return "index";
    }

    @GetMapping("/opening-hours")
    String openingHours(Model model) {
        model.addAttribute("location", "opening-hours");
        return "index";
    }

    @GetMapping("/contact")
    String contact(Model model) {
        Email email = new Email();
        model.addAttribute("email", email);
        model.addAttribute("location", "contact");
        return "index";
    }

    @PostMapping("/send-email")
    public String sendEmail(@ModelAttribute Email email, Model model) throws MessagingException {
        mailService.sendEmail(email.getSenderEmail(), email.getSubject(), email.getMassage());
        model.addAttribute("location", "massage-sent");
        return "index";
    }
}
