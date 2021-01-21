package de.ovsiannikov.springmvc.repository;

import de.ovsiannikov.springmvc.model.Contact;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;

class InMemoryContactRepoTest {

    InMemoryContactRepo inMemoryContactRepo;
    List<Contact> contacts = Arrays.asList(new Contact(1, "John", "Johnson", 25),
            new Contact(2, "Alex", "Gastro", 34),
            new Contact(3, "Inga", "Gaus", 18));

    @Test
    void save() {
        InMemoryContactRepo myList = mock(InMemoryContactRepo.class);
        doCallRealMethod().when(myList).save(anyObject());
        myList.save(new Contact(1, "John", "Johnson", 25));

        verify(myList, times(1)).save(new Contact(1, "John", "Johnson", 25));

    }

    /*@Test
    void remove() throws ClassNotFoundException {
        List<Contact> exp = Arrays.asList(new Contact(1, "John", "Johnson", 25),
                                          new Contact(3, "Inga", "Gaus", 18 ));


        Contact akt = inMemoryContactRepo.remove(2);

        assertEquals(exp,akt);
    }

@Test
    void find_2() throws ClassNotFoundException {
        int id = 1;
        Contact exp = contacts.stream()
                .filter(contact -> contacts.get(1).getId() == id)
                .findFirst().orElseThrow(ClassNotFoundException::new);
    }
    @Test
    void remove_1() {

        List exp = Arrays.asList(new Contact(1, "John", "Johnson", 25),
                                 new Contact(3, "Inga", "Gaus", 18 ));

        List akt = inMemoryContactRepo.remove(2);


    }

    @Test
    void findAll() {
    }*/
}
