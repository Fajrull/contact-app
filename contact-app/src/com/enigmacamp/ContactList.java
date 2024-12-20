package com.enigmacamp;

import com.enigmacamp.exception.ContactNotFoundException;
import com.enigmacamp.exception.DuplicateContactException;

import java.util.ArrayList;
import java.util.List;

public class ContactList {
    private List<Contact> contacts = new ArrayList<>();

    public void addContact(Contact contact) {
        duplicateContact(contact.getName(),contact.getPhoneNumber(),contact.getEmail());
        contacts.add(contact);
    }

    public void deleteContact(String name){
        List<Contact> toRemove = new ArrayList<>();
        // Menambahkan kontak yang akan dihapus ke dalam koleksi sementara
        for (Contact contact : contacts) {
            if (contact.getName().equals(name)) {
                toRemove.add(contact);
            }
        }
        // Menghapus kontak yang ditemukan dari daftar utama
        contacts.removeAll(toRemove);
    }


    public List<Contact> searchContact(String name){
        List<Contact> result = new ArrayList<>();
            for (Contact contact : contacts){
                if(contact.getName().equals(name)){
                    result.add(contact);
                }
            }

            if (result.isEmpty()){
                throw new ContactNotFoundException("contact tidak ada");
            }
            return result ;
    }

    public void updateContact(String name,String phoneNumber,String email) {
        for (Contact contact : contacts) {
                if (contact.getName() == name) {
                    contact.setName(name);
                    contact.setPhoneNumber(phoneNumber);
                    contact.setEmail(email);
                }
            }
    }

    public List<Contact> getAllContacts(){
        return contacts;
    }

    public void duplicateContact(String name,String phoneNumber,String email) {
        for (Contact contact : contacts) {
            if (contact.getName().equals(name)) {
                throw new DuplicateContactException("Contact with name " + name + " already exists");
            }
            if (contact.getPhoneNumber().equals(phoneNumber)) {
                throw new DuplicateContactException("Contact with phone number " + phoneNumber + " already exists");
            }
            if (contact.getEmail().equals(email)) {
                throw new DuplicateContactException("Contact with email " + email + " already exists");
            }
        }
    }



}
