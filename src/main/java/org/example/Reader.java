package org.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Reader
{
    public List<Contact> readFromFile(String txtFile)
    {
        List<Contact> defaultContacts = new ArrayList<>();
        List<String> lines = new ArrayList<>();
        try {
            lines = Files.readAllLines(Paths.get(txtFile));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        for (String line : lines) {
            defaultContacts.add(Contact.parseAddedContact(line));
        }
        return defaultContacts;
    }

}
