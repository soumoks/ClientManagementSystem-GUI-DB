package Model;

import javax.swing.*;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * The type Client manager.
 */
public class ClientManager {

    /**
     * The Jdbc connection.
     */
    public Connection jdbc_connection;
    /**
     * The P stat.
     */
    public PreparedStatement pStat;
    /**
     * The Database name.
     */
    public String databaseName = "ClientDB", /**
     * The Table name.
     */
    tableName = "ClientTable", /**
     * The Data file.
     */
    dataFile = "clients.txt";


    /**
     * The Connection info.
     */
    public String connectionInfo = "jdbc:mysql://javadb.ctyf6w6t7h5z.us-east-1.rds.amazonaws.com:3306/ClientDB?verifyServerCertificate=false&useSSL=true",
    /**
     * The Login.
     */
    login          = "admin",
    /**
     * The Password.
     */
    password       = "";

    /**
     * Instantiates a new Client manager.
     */
    public ClientManager(){
        try{
            // If this throws an error, make sure you have added the mySQL connector JAR to the project
            Class.forName("com.mysql.jdbc.Driver");

            // If this fails make sure your connectionInfo and login/password are correct
            jdbc_connection = DriverManager.getConnection(connectionInfo, login, password);
            System.out.println("Connected to: " + connectionInfo + "\n");
        }
        catch(SQLException e) { e.printStackTrace(); }
        catch(Exception e) { e.printStackTrace(); }
    }

    /**
     * Create db.
     */
    public void createDB(){
        String sql = "CREATE DATABASE" + databaseName;

        //**********
        //Add a check to see if the Database is already created
        try{
            PreparedStatement pStat = jdbc_connection.prepareStatement(sql);
            //pStat.setString(1,databaseName);
            pStat.executeUpdate();
        } catch (SQLException e) {
            System.out.println("DB already exists");
            //e.printStackTrace();
        }
    }

    /**
     * Create table.
     */
    public void createTable(){
        String sql = "CREATE TABLE " + tableName + "(" +
                "ID INT(4) NOT NULL, " +
                "TOOLNAME VARCHAR(20) NOT NULL, " +
                "QUANTITY INT(4) NOT NULL, " +
                "PRICE DOUBLE(5,2) NOT NULL, " +
                "SUPPLIERID INT(4) NOT NULL, " +
                "PRIMARY KEY ( id ))";
        String sql2 = "CREATE TABLE " + tableName + "(" + "Id INT(4) NOT NULL PRIMARY KEY AUTO_INCREMENT, " +
                "FirstName VARCHAR(20), " +
                "LastName VARCHAR(20), " +
                "Address VARCHAR(50), " +
                "PostalCode VARCHAR(7), " +
                "PhoneNumber VARCHAR(12), " +
                "Type CHAR(1))";
        try{
            PreparedStatement pStat = jdbc_connection.prepareStatement(sql2);
            //pStat.setString(1,tableName);
            pStat.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Table already exists");
            //e.printStackTrace();
        }
    }

    /**
     * Fill table.
     */
    public void fillTable()
    {
        try{
            Scanner sc = new Scanner(new FileReader(dataFile));
            while(sc.hasNext())
            {
                String clientInfo[] = sc.nextLine().split(";");
                addItem(clientInfo[0],clientInfo[1],
                        clientInfo[2],clientInfo[3],clientInfo[4],clientInfo[5]);
            }
            sc.close();
        }
        catch(FileNotFoundException e)
        {
            System.err.println("File " + dataFile + " Not Found!");
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    /**
     * Check phone number boolean.
     *
     * @param phoneNumber the phone number
     * @return the boolean
     */
    public boolean checkPhoneNumber(String phoneNumber){
        return phoneNumber.matches("\\d\\d\\d-\\d\\d\\d-\\d\\d\\d\\d");
    }

    /**
     * Add item.
     *
     * @param firstName   the first name
     * @param lastName    the last name
     * @param address     the address
     * @param postalCode  the postal code
     * @param phoneNumber the phone number
     * @param type        the type
     */
    public void addItem(String firstName, String lastName, String address, String postalCode, String phoneNumber, String type){
        String addClient = "INSERT INTO " + tableName + " (FirstName,LastName,Address,PostalCode,PhoneNumber,Type)" + " VALUES (?,?,?,?,?,?)";
        if(checkPhoneNumber(phoneNumber)){
            try{
                PreparedStatement pStat = jdbc_connection.prepareStatement(addClient);
                pStat.setString(1,firstName);
                pStat.setString(2,lastName);
                pStat.setString(3,address);
                pStat.setString(4,postalCode);
                pStat.setString(5,phoneNumber);
                pStat.setString(6,type);
                int rowCount = pStat.executeUpdate();
                System.out.println("row Count = " + rowCount);
            }
            catch (SQLException e) {
                e.printStackTrace();
            }
        }
        else{
            JOptionPane.showMessageDialog(null, "Phone Number does not match the format 111-111-1111", "Message",JOptionPane.PLAIN_MESSAGE);
        }

    }

    /**
     * Update item.
     *
     * @param firstName   the first name
     * @param lastName    the last name
     * @param address     the address
     * @param postalCode  the postal code
     * @param phoneNumber the phone number
     * @param type        the type
     * @param id          the id
     */
    public void updateItem(String firstName, String lastName, String address, String postalCode, String phoneNumber, String type, int id){
        String updateClient = "UPDATE " + tableName + " SET FirstName=?,LastName=?,Address=?,PostalCode=?,PhoneNumber=?,Type=?" + " WHERE Id=?";
        if(checkPhoneNumber(phoneNumber)){
            try{PreparedStatement pStat = jdbc_connection.prepareStatement(updateClient);
                pStat.setString(1,firstName);
                pStat.setString(2,lastName);
                pStat.setString(3,address);
                pStat.setString(4,postalCode);
                pStat.setString(5,phoneNumber);
                pStat.setString(6,type);
                pStat.setInt(7,id);;
                int rowCount = pStat.executeUpdate();
                System.out.println("row Count = " + rowCount);
            }
            catch (SQLException e) {
                e.printStackTrace();
            }
        }
        else{
            JOptionPane.showMessageDialog(null, "Phone Number does not match the format 111-111-1111", "Message",JOptionPane.PLAIN_MESSAGE);
        }
    }

    /**
     * Delete client.
     *
     * @param id the id
     */
    public void deleteClient(int id){
        String deleteClient = "DELETE FROM " + tableName + " WHERE Id=?";
        try{PreparedStatement pStat = jdbc_connection.prepareStatement(deleteClient);
            pStat.setInt(1,id);
            int rowCount = pStat.executeUpdate();
            System.out.println("row Count = " + rowCount);
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Searches a client based on Client ID
     *
     * @param clientID the client id
     * @return array list
     */
    public ArrayList<Client> searchClient(int clientID){
        String sql = "SELECT * FROM " + tableName + " WHERE ID=?";
        ResultSet client;
        try{
            PreparedStatement pStat = jdbc_connection.prepareStatement(sql);
            //pStat.setString(1,tableName);
            pStat.setInt(1,clientID);
            client = pStat.executeQuery();
            ArrayList<Client> clientArrayList = new ArrayList<>();
            if(client.next()){
                clientArrayList.add(new Client(client.getInt("Id"),client.getString("FirstName"),client.getString("LastName"),
                        client.getString("Address"),client.getString("PostalCode"),client.getString("PhoneNumber"),
                        client.getString("Type")));
//                return new Client(client.getInt("Id"),client.getString("FirstName"),client.getString("LastName"),
//                        client.getString("Address"),client.getString("PostalCode"),client.getString("PhoneNumber"),
//                        client.getString("Type"));
            }
            return clientArrayList;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Searches Client based on Last Name
     *
     * @param lastName the last name
     * @return array list
     */
    public ArrayList<Client> searchClient(String lastName){
        String sql = "SELECT * FROM " + tableName + " WHERE LastName=?";
        ResultSet client;
        try{
            PreparedStatement pStat = jdbc_connection.prepareStatement(sql);
            //pStat.setString(1,tableName);
            pStat.setString(1,lastName);
            client = pStat.executeQuery();
            ArrayList<Client> clientArrayList = new ArrayList<>();

            //TODO An Array list might not be required here. Check and modify if required
            while(client.next()){
                clientArrayList.add(new Client(client.getInt("Id"),client.getString("FirstName"),client.getString("LastName"),
                        client.getString("Address"),client.getString("PostalCode"),client.getString("PhoneNumber"),
                        client.getString("Type")));
            }
            return clientArrayList;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Search client type array list.
     *
     * @param clientType the client type
     * @return the array list
     */
//TODO Change the function parameter to accept a Char once changed in the client Class
    public ArrayList<Client> searchClientType(String clientType){
        String sql = "SELECT * FROM " + tableName + " WHERE Type=?";
        ResultSet client;
        try{
            PreparedStatement pStat = jdbc_connection.prepareStatement(sql);
            //pStat.setString(1,tableName);
            pStat.setString(1,clientType);
            client = pStat.executeQuery();
            ArrayList<Client> clientArrayList = new ArrayList<>();
            //TODO Change this to return the entire result set based on the results returned by the above Select query.
            while(client.next()){
                clientArrayList.add(new Client(client.getInt("Id"),client.getString("FirstName"),client.getString("LastName"),
                        client.getString("Address"),client.getString("PostalCode"),client.getString("PhoneNumber"),
                        client.getString("Type")));
            }
            return clientArrayList;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    //public Object[] searchClient()

    /**
     * Print table.
     */
    public void printTable(){
        try{
            String sql = "SELECT * FROM " + tableName;
            PreparedStatement pStat = jdbc_connection.prepareStatement(sql);
            //pStat.setString(1,tableName);
            ResultSet clients = pStat.executeQuery();
            System.out.println("Clients:");
            while(clients.next())
            {
                System.out.println(clients.getInt("ID") + " " +
                        clients.getString("FirstName") + " " +
                        clients.getString("LastName") + " " +
                        clients.getString("Address") + " " +
                        clients.getString("PostalCode") + " " +
                        clients.getString("PhoneNumber") + " " +
                        clients.getString("Type"));
            }
            clients.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
