package test;

import com.enigmacamp.Contact;
import com.enigmacamp.exception.InvalidEmailException;
import com.enigmacamp.exception.InvalidPhoneNumberException;
import org.junit.Test;
import static org.junit.Assert.*;

public class ContactTest {
    @Test
    public void shouldCreateValidContact() {
        Contact contact = new Contact("John Doe", "08123456789", "john@email.com");
        assertEquals("John Doe", contact.getName());
        assertEquals("08123456789", contact.getPhoneNumber());
        assertEquals("john@email.com", contact.getEmail());
    }

    @Test
    public void shouldThrowExceptionForEmptyName() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("", "123123121233", "john@email.com");
        });
    }

    @Test
    public void shouldThrowExceptionForInvalidPhone() {
        assertThrows(InvalidPhoneNumberException.class, () -> {
            new Contact("John Doe", "123", "john@email.com");
        });
    }

    @Test
    public void shouldThrowExceptionForInvalidEmail() {
        assertThrows(InvalidEmailException.class, () -> {
            new Contact("John Doe", "12391284981924", "johnemail.com");
        });
    }
}
