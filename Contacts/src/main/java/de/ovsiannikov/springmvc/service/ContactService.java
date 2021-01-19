package de.ovsiannikov.springmvc.service;

import de.ovsiannikov.springmvc.model.Contact;
import de.ovsiannikov.springmvc.repository.IContactRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactService {

    IContactRepo contactRepo;

    public ContactService(IContactRepo contactRepo) {
        this.contactRepo = contactRepo;
    }

    public void create(Contact contact) {
        contactRepo.save(contact);
    }

    public void edit(Contact contact) {
        contactRepo.save(contact);
    }

    public void remove(int id) throws ClassNotFoundException {
        contactRepo.remove(id);
    }

    public Contact get(int id) throws ClassNotFoundException {
        return contactRepo.find(id);
    }

    public List<Contact> getAll() {
        return contactRepo.findAll();
    }
}
