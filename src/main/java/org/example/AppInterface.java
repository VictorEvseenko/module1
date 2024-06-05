package org.example;

import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class AppInterface {
    private ContactsBook contactsBook = new ContactsBook();
    private final Scanner scanner = new Scanner(System.in);
    private final Writer writer = new Writer();

    public AppInterface(ContactsBook contactsBook) {
        this.contactsBook = contactsBook;
    }

    public void start() {
        while (true) {
            System.out.println("Выберите действие:");
            System.out.println("1.Показать все контакты");
            System.out.println("2.Добавить контакт");
            System.out.println("3.Удалить контакт");
            System.out.println("4.Загрузить контакты в файл");

            String input = scanner.nextLine();

            switch (input) {
                case "1":
                    getAllContacts();
                    break;
                case "2":
                    addContact();
                    break;
                case "3":
                    deleteContact();
                    break;
                case "4":
                    writeToFile();
                    break;
                default:
                    System.out.println("Некорректный ввод!");
            }
        }
    }

    private void getAllContacts() {
        if (contactsBook.getAllContacts().isEmpty()) {
            System.out.println("Список пуст!");
        } else {
            System.out.println("Список контактов:");
            for (Contact contact : contactsBook.getAllContacts()) {
                System.out.println(contact.getFullName() + " | " + contact.getPhoneNumber() + " | " + contact.getEmail());
            }
        }
    }

    private void addContact() {
        System.out.println("Введите данные контакта в формате: ФИО;телефон;email");
        String inputContact = scanner.nextLine();
        try {
            contactsBook.addContact(Contact.parseAddedContact(inputContact));
            System.out.println("Контакт успешно добавлен!");
        } catch (RuntimeException ex) {
            System.out.println("Некорректно введены данные!");
        }
    }

    private void deleteContact() {
        if (contactsBook.getAllContacts().isEmpty()) {
            System.out.println("Список контактов пуст!");
        } else {
            System.out.println("Введите email контакта:");
            String inputEmail = scanner.nextLine();
            try {
                contactsBook.deleteContact(inputEmail);
            } catch (RuntimeException ex) {
                System.out.println("Список контактов пуст! Добавьте новый контакт!");
            }
        }
    }

    private void writeToFile() {
        if (contactsBook.getAllContacts().isEmpty()) {
            System.out.println("Список контактов пуст!");
        } else {
            writer.writeToFile(contactsBook.getAllContacts());
            System.out.println("Контакты успешно сохранены!");
        }
    }

}

