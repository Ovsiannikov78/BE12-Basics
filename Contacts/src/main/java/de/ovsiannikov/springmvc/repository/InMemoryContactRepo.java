package de.ovsiannikov.springmvc.repository;

import de.ovsiannikov.springmvc.exceptions.NotFoundException;
import de.ovsiannikov.springmvc.model.Contact;
import org.springframework.stereotype.Repository;
import java.util.*;

// AND TESTS!!!
@Repository
public class InMemoryContactRepo implements IContactRepo {
    private int idCounter;

    List<Contact> source = new ArrayList<>();

    public InMemoryContactRepo(NotFoundException notFoundException) {
    }


    @Override
    public void save(Contact contact) {
        if (!source.contains(contact) && contact.getId() == 0) {
            contact.setId(++idCounter);
            source.add(contact);
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

    private void updateContact(Contact contact) {
        for (Contact theContact : source) {
            if (theContact.getId() == contact.getId()) {
                source.set(source.indexOf(theContact), contact);
            }
        }
    }
}
