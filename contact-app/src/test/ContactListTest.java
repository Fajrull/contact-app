package test;

import com.enigmacamp.Contact;
import com.enigmacamp.ContactList;
import com.enigmacamp.exception.ContactNotFoundException;
import com.enigmacamp.exception.DuplicateContactException;
import org.junit.Test;
import static org.junit.Assert.*;

public class ContactListTest {
    ContactList contactList = new ContactList();
    @Test
    public void shouldAddContact(){
        contactList.addContact(new Contact("John Doe", "08123456789", "john@email.com"));
    }

    @Test
    public void shouldNotAddDuplicateContact(){
        contactList.addContact(new Contact("John Doe", "08123456789", "john@email.com"));
        assertThrows(DuplicateContactException.class, () -> {
            contactList.addContact(new Contact("John Doe", "08123456789", "john@email.com"));
        });
    }

    @Test
    public void shouldFindContactByName(){
        contactList.addContact(new Contact("John Doe", "08123456789", "john@email.com"));
        contactList.addContact(new Contact("John Boe", "12345678812", "boe@email.com"));
        contactList.searchContact("John Doe");
    }

    @Test
    public void shouldUpdateExistingContact(){
        contactList.addContact(new Contact("John Doe", "08123456789", "john@email.com"));
        contactList.updateContact("John Doe", "0987272832", "tesupdate@email.com");
    }

    @Test
    public void shouldDeleteContact(){
        contactList.addContact(new Contact("John Doe", "08123456789", "john@email.com"));
        contactList.addContact(new Contact("John Boe", "12345678812", "boe@email.com"));
        contactList.deleteContact("John Doe");
    }

    @Test
    public void shouldThrowExceptionWhenContactNotFound(){
        contactList.addContact(new Contact("John Boe", "12345678812", "boe@email.com"));
        contactList.addContact(new Contact("John Doe", "08123456789", "john@email.com"));

        assertThrows(ContactNotFoundException.class, () -> {
            contactList.searchContact("Joon");
        });
    }
}

