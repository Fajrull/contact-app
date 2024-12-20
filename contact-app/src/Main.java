import com.enigmacamp.Contact;
import com.enigmacamp.ContactList;

public class Main {
    public static void main(String[] args) {
        ContactList contactList = new ContactList();
        try {
            contactList.addContact(new Contact("fajrul", "12122222222", "cascsac@gmail.com"));
            contactList.addContact(new Contact("fajruadl", "12222222232", "casac@gmail.com"));
            contactList.addContact(new Contact("khaq", "1212312001223", "csac@gmail.com"));


        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Menambahkan kontak baru");
        System.out.println(contactList.getAllContacts());
        System.out.println("=".repeat(30));

        System.out.println("Menghapus kontak");
        contactList.deleteContact("fajruadl");
        System.out.println(contactList.getAllContacts());
        System.out.println("=".repeat(30));

        System.out.println("Mencari kontak dengan nama");
        System.out.println(contactList.searchContact("khaq"));
        System.out.println("=".repeat(30));

        System.out.println("Mengupdate kontak");
        contactList.updateContact("khaq", "0874647462722", "yori@gmail.com");
        System.out.println(contactList.searchContact("khaq"));

    }
}
