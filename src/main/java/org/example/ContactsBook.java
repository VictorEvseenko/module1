package org.example;

import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class ContactsBook
{
    private final List<Contact> contactsList = new ArrayList<>();

    public List<Contact> getAllContacts() {
        return contactsList;
    }

    public void addContact(Contact contact) {
        contactsList.add(contact);
    }

    public void deleteContact(String email) {
        boolean isFounded = false;
        for (Contact contact : contactsList) {
            if (contact.getEmail().equals(email)) {
                isFounded = true;
                contactsList.remove(contact);
            }
        }
        if(!isFounded) {
            System.out.println("Контакт с таким email не найден!");
        }
        else {
            System.out.println("Контакт успешно удален!");
        }
    }

}
