package dev.CSDEV_CREATIONS;

// Creation of the contacts class
public class Contacts {

    private String name;
    private String phoneNumber;

    // Contacts Constructor
    public Contacts(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber= phoneNumber;
    }
    
    // Getter for the getName
    /**
     * @return the name
     */
    public String getName() {
        return name;
    }
    
    // Getter for the getPhoneNumber
    /**
     * @return the phoneNumber
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    // Method creates a contact
    public static Contacts createContact(String name, String phoneNumber) {
        return new Contacts(name, phoneNumber);
    }
    
}
