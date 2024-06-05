package org.example;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Contact
{
    String fullName;
    String phoneNumber;
    String email;

    public static Contact parseAddedContact(String contact) {
        String[] info = contact.split(";");
            return new Contact(info[0], info[1], info[2]);
    }

    @Override
    public String toString() {
        return fullName + ";" + phoneNumber + ";" + email + System.lineSeparator();
    }

}
