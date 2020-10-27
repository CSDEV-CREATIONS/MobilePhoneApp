package dev.CSDEV_CREATIONS;

import java.util.ArrayList;


// Creation of MobilePhone Class
public class MobilePhone {

    private String myNumber;
    private ArrayList<Contacts> myContacts;

    // MobilePhone Constructor
    public MobilePhone(String myNumber) {
        this.myNumber = myNumber;
        this.myContacts = new ArrayList<Contacts>();
    }

    // Method checks to see if a contact is already on file, if not it adds a new contact
    public boolean addNewContacts(Contacts contact) {
        if(findContact(contact.getName()) >= 0) {
            System.out.println("Contact is already on file");
            return false;
        }

        myContacts.add(contact);
        return true;
    }

    // Method updates an existing contact
    public boolean updateContacts(Contacts oldContact, Contacts newContact) {
        int foundPosition = findContact(oldContact);
        if(foundPosition < 0) {
            System.out.println(oldContact.getName() + " was not found.");
            return false;
        }
        this.myContacts.set(foundPosition, newContact);
        System.out.println(oldContact.getName() + " was replaced with " + newContact.getName());
        return true;
    }

    // Method removes an existing contact
    public boolean removeContact(Contacts contact) {
        int foundPosition = findContact(contact);
        if(foundPosition < 0) {
            System.out.println(contact.getName() + " was not found.");
            return false;
        }
        this.myContacts.remove(foundPosition);
        System.out.println(contact.getName() + ", was deleted");
        return true;
    }

    // Method returns the indexOf a contact
    private int findContact(Contacts contact) {
        return this.myContacts.indexOf(contact);
    }

    // Overloaded from above method, difference is this one takes in a contactName parameter
    private int findContact(String contactName) {
        for(int i = 0; i<this.myContacts.size(); i++) {
            Contacts contact = this.myContacts.get(i);
            if(contact.getName().equals(contactName)) {
                return i;
            }
        }
        return -1;
    }
    
    // Method queries a contact and returns a contact name
    public String queryContact(Contacts contact) {
        if(findContact(contact) >= 0) {
            return contact.getName();
            
        }
        return null;
    }

    // This overloaded method from the above method takes in a name parameter and finds the position of the contact name in the contacts array
    public Contacts queryContact(String name) {
        int position = findContact(name);
        if(position >= 0) {
            return this.myContacts.get(position);
        }
        return null;
    }


    // Method outputs the contacts 
    public void printContacts() {
        for(int i = 0; i<this.myContacts.size(); i++) {
            System.out.println((i+1) + "." +
                        this.myContacts.get(i).getName() + " -> " +
                        this.myContacts.get(i).getPhoneNumber());
        }
    }
    
}
