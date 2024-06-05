package org.example;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class Writer
{
    public void writeToFile(List<Contact> contacts)
    {
        StringBuilder str = new StringBuilder();
        for (Contact contact : contacts) {
            str.append(contact.toString());
        }

        try {
            FileWriter writer = new FileWriter("contacts.txt");
            writer.write(str.toString());
            writer.flush();
        } catch(IOException ex) {
            ex.printStackTrace();
        }
    }

}
