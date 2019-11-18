package Model;

/**
 * The type Client.
 */
public class Client {
    private int id;
    private String firstName;
    private String lastName;
    private String address;
    private String postalCode;
    private String phoneNumber;
    private String type;

    /**
     * Instantiates a new Client.
     *
     * @param id          the id
     * @param firstName   the first name
     * @param lastName    the last name
     * @param address     the address
     * @param postalCode  the postal code
     * @param phoneNumber the phone number
     * @param type        the type
     */
    public Client(int id,String firstName,String lastName,String address,String postalCode, String phoneNumber, String type){
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.postalCode = postalCode;
        this.phoneNumber = phoneNumber;
        this.type = type;
    }

    /**
     * Gets id.
     *
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * Gets first name.
     *
     * @return the first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Gets last name.
     *
     * @return the last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Gets address.
     *
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * Gets postal code.
     *
     * @return the postal code
     */
    public String getPostalCode() {
        return postalCode;
    }

    /**
     * Gets phone number.
     *
     * @return the phone number
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Gets type.
     *
     * @return the type
     */
    public String getType() {
        return type;
    }


    public String toString(){
        //String client = "ID: " + this.id + " " + "Name: " + this.firstName + " " + this.lastName + "\n" + "Address: " + this.address + "\n" + "PhoneNumber: " + this.phoneNumber + "\n" + "Client Type: " + this.type;
        String client = "ID: " + this.id + " " + "Name: " + this.firstName + " " + this.lastName + " " + this.type;
        return client;
    }
}
