package org.example;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@Profile("init")
public class ContactsProfile
{
    @Value("${app.default-contacts}")
    private String txtFile;

    private final ContactsBook contactsBook;
    private final Reader reader = new Reader();

    public ContactsProfile(ContactsBook contactsBook) {
        this.contactsBook = contactsBook;
    }

    @PostConstruct
    public void loadDefaultContacts() {
        contactsBook.getAllContacts().addAll(reader.readFromFile(txtFile));
    }

}
