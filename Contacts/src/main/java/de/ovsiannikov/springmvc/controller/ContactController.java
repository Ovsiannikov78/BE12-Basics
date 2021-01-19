package de.ovsiannikov.springmvc.controller;

import de.ovsiannikov.springmvc.model.Contact;
import de.ovsiannikov.springmvc.service.ContactService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ContactController {

    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    private ContactService contactService;

    @GetMapping("/contacts")
    public String getAll(Model model) {

        List<Contact> contacts = contactService.getAll();

        model.addAttribute("contactList", contacts);
        return "contacts-form";
    }

    @GetMapping("/showAddingForm")
    public String showAddingForm(Model model) {
        Contact theContact = new Contact();

        model.addAttribute("contact", theContact);

        return "/adding-form";
    }

    @GetMapping("/updatingForm")
    public String updatingForm(@RequestParam("contactId") int id, Model model) throws ClassNotFoundException {

        Contact contact = contactService.get(id);

        model.addAttribute("contact", contact);

        return "/adding-form";
    }

    @PostMapping("/add")
    public String create(@ModelAttribute("contact") Contact contact) {

        contactService.create(contact);

        return "redirect:/contacts";
    }

    @GetMapping("/delete")
    public String remove(@RequestParam("contactId") int id) throws ClassNotFoundException {

        contactService.remove(id);

        return "redirect:/contacts";
    }
}
