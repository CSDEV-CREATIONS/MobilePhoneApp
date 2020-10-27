package dev.CSDEV_CREATIONS;

import java.util.Scanner;

public class Main {

    private static Scanner s = new Scanner(System.in);
    private static MobilePhone mobilePhone = new MobilePhone("417 453 8760");

    // Main method with all the functionallity of the application
    public static void main(String[] args) {

        boolean quit = false;
        startPhone();
        printActions();
        while(!quit) {
            System.out.println("\nEnter action: (6 to show available actions)");
            int action = s.nextInt();
            s.nextLine();

            switch(action) {
                case 0:
                    System.out.println("\nShutting down....");
                    quit = true;
                    break;
                case 1:
                    mobilePhone.printContacts();
                    break;
                case 2:
                    addNewContact();
                    break;
                case 3:
                    updateContact();
                    break;
                case 4:
                    removeContact();
                    break;
                case 5:
                    queryContact();
                    break;
                case 6:
                    printActions();
                    break;
            }

        }

    }

    // Gets called when a new contact is added
    private static void addNewContact() {
        System.out.println("Enter new contact name: ");
        String name = s.nextLine();
        System.out.println("Enter phone number: ");
        String phone = s.nextLine();
        Contacts newContact = Contacts.createContact(name, phone);
        if(mobilePhone.addNewContacts(newContact)) {
            System.out.println("New contact added: name = " + name + ", phone = "+ phone);
        } else {
            System.out.println("Cannot add, " + name + " already on file");
        }
    }

    // Gets called when a contact is updated
    private static void updateContact() {
        System.out.println("Enter existing contact name: ");
        String name = s.nextLine();
        Contacts existingContactRecord = mobilePhone.queryContact(name);
        if(existingContactRecord == null) {
            System.out.println("Contact not found.");
            return;
        }

        System.out.println("Enter new contact name: ");
        String newName = s.nextLine();
        System.out.println("Enter new contact phone number: ");
        String newNumber = s.nextLine();
        Contacts newContact = Contacts.createContact(newName, newNumber);
        if(mobilePhone.updateContacts(existingContactRecord, newContact)) {
            System.out.println("Sucessfully updated record");
        } else {
            System.out.println("Error updating record");
        }

    }

    // Gets called when a contact is removed
    private static void removeContact() {
        System.out.println("Enter existing contact name: ");
        String name = s.nextLine();
        Contacts existingContactRecord = mobilePhone.queryContact(name);
        if(existingContactRecord == null) {
            System.out.println("Contact not found.");
            return;
        }

        if(mobilePhone.removeContact(existingContactRecord)) {
            System.out.println("Sucessfully deleted");
        } else {
            System.out.println("Error deleting contact");
        }
    }

    // Gets called when a contact is queried
    private static void queryContact() {
        System.out.println("Enter existing contact name: ");
        String name = s.nextLine();
        Contacts existingContactRecord = mobilePhone.queryContact(name);
        if(existingContactRecord == null) {
            System.out.println("Contact not found.");
            return;
        }
        System.out.println("Name: " + existingContactRecord.getName() + " phone number is " + existingContactRecord.getPhoneNumber());
        
    }

    

    // Gets called at the start of the app to start the phone
    private static void startPhone() {
        System.out.println("Starting phone....");
    }

    // Gets called at the start of the app to print all the different functions
    private static void printActions() {
        System.out.println("\nAvailable Actions:\npress");
        System.out.println("0 - to shut down\n" + 
                           "1 - to print contacts\n" +
                           "2 - to add a new contact\n" +
                           "3 - to update an existing contact\n" +
                           "4 - to remove an existing contact\n" +
                           "5 - query if an existing contact exists\n" +
                           "6 - to pirnt a list of available actions.");
        System.out.println("Choose your action: ");
    }
    
}
