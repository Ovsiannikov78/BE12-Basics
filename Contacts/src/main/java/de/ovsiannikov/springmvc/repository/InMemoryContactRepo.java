package de.ovsiannikov.springmvc.repository;

import de.ovsiannikov.springmvc.exceptions.NotFoundException;
import de.ovsiannikov.springmvc.model.Contact;
import org.springframework.stereotype.Repository;

import java.util.*;

// AND TESTS!!!
@Repository
public class InMemoryContactRepo implements IContactRepo {
    private int idCounter = 1;

    List<Contact> source = new ArrayList<>();

    public InMemoryContactRepo(NotFoundException notFoundException) {
    }


    @Override
    public void save(Contact contact) {
        if (source.isEmpty() || !source.contains(contact)) {
            contact.setId(idCounter);
            source.add(contact);
            idCounter++;
        } else {
            updateContact(contact);
        }
    }

    @Override
    public Contact find(int id) throws ClassNotFoundException {
        return source.stream()
                .filter(contact -> contact.getId() == id)
                .findFirst()
                .orElseThrow(ClassNotFoundException::new);
    }

    @Override
    public void remove(int id) throws ClassNotFoundException {
        if (find(id).getId() == id) {
            source.remove(find(id));
        }
    }

    @Override
    public List<Contact> findAll() {
        return new ArrayList<>(source);
    }

    public void updateContact(Contact contact) {
        for (Contact theContact : source) {
            if (theContact.getId() == contact.getId()) {
                source.set(source.indexOf(theContact), contact);
            }
        }
    }
}
