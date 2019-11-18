package View;

import javax.swing.*;
import javax.swing.text.MaskFormatter;
import java.awt.*;
import java.text.ParseException;

/**
 * The type Client information panel.
 */
public class ClientInformationPanel extends JPanel {
    private JLabel clientInformationLabel;
    private JLabel clientIdLabel,firstNameLabel,lastNameLabel,addressLabel,clientTypeLabel,postalCodeLabel,phoneNumberLabel;
    private JFormattedTextField postalCodeField,phoneNumberField;
    private JTextField clientIdField,firstNameField,lastNameField,addressField;
    private JComboBox clientTypeComboBox;
    private JButton save, delete, clear, newButton;
    private JPanel northPanel,centerPanel,southPanel;

    /**
     * Instantiates a new Client information panel.
     *
     * @throws ParseException the parse exception
     */
    public ClientInformationPanel() throws ParseException {
        createInformationPanel();
    }


    /**
     * Gets client id field.
     *
     * @return the client id field
     */
    public JTextField getClientIdField() {
        return clientIdField;
    }

    /**
     * Gets first name field.
     *
     * @return the first name field
     */
    public JTextField getFirstNameField() {
        return firstNameField;
    }


    /**
     * Gets last name field.
     *
     * @return the last name field
     */
    public JTextField getLastNameField() {
        return lastNameField;
    }


    /**
     * Gets address field.
     *
     * @return the address field
     */
    public JTextField getAddressField() {
        return addressField;
    }


    /**
     * Gets postal code field.
     *
     * @return the postal code field
     */
    public JTextField getPostalCodeField() {
        return postalCodeField;
    }


    /**
     * Gets phone number field.
     *
     * @return the phone number field
     */
    public JTextField getPhoneNumberField() {
        return phoneNumberField;
    }


    /**
     * Gets client type combo box.
     *
     * @return the client type combo box
     */
    public JComboBox getClientTypeComboBox() {
        return clientTypeComboBox;
    }


    /**
     * Gets save.
     *
     * @return the save
     */
    public JButton getSave() {
        return save;
    }


    /**
     * Gets delete.
     *
     * @return the delete
     */
    public JButton getDelete() {
        return delete;
    }


    /**
     * Gets clear.
     *
     * @return the clear
     */
    public JButton getClear() {
        return clear;
    }


    /**
     * Create information panel.
     *
     * @throws ParseException the parse exception
     */
    public void createInformationPanel() throws ParseException {

        //*******************************
        //Client Information Panel
        //clientInformationPanel = new JPanel();
        setBorder(BorderFactory.createLineBorder(Color.BLACK));
        //setPreferredSize(new Dimension(450,300));

        //TODO Create a Border layout instead GridBag Layout
        setLayout(new GridBagLayout());;
        northPanel = new JPanel();
        centerPanel = new JPanel();
        southPanel = new JPanel();
        GridBagConstraints constraintsClientInformation = new GridBagConstraints();

        clientInformationLabel = new JLabel("Client Information");
        constraintsClientInformation.gridx = 0;
        constraintsClientInformation.gridy = 0;

        northPanel.add(clientInformationLabel);
//        add(northPanel,BorderLayout.NORTH);
        add(clientInformationLabel,constraintsClientInformation);

        clientIdLabel = new JLabel("Client ID: ");
        constraintsClientInformation.gridx = 0;
        constraintsClientInformation.gridy = 1;
        centerPanel.add(clientIdLabel);
        add(clientIdLabel,constraintsClientInformation);


        clientIdField = new JTextField(5);
        clientIdField.setEditable(false);
//        clientIdField.setPreferredSize(new Dimension(50,20));
        constraintsClientInformation.gridx = 1;
        constraintsClientInformation.gridy = 1;
        centerPanel.add(clientIdField);
        add(clientIdField,constraintsClientInformation);

        firstNameLabel = new JLabel("First Name: ");
        constraintsClientInformation.gridx = 1;
        constraintsClientInformation.gridy = 2;
        centerPanel.add(firstNameLabel);
        add(firstNameLabel,constraintsClientInformation);

        firstNameField = new JTextField(20);
//        firstNameField.setPreferredSize(new Dimension(50,20));
        constraintsClientInformation.gridx = 2;
        constraintsClientInformation.gridy = 2;
        centerPanel.add(firstNameField);
        add(firstNameField,constraintsClientInformation);

        lastNameLabel = new JLabel("Last Name");
        constraintsClientInformation.gridx = 1;
        constraintsClientInformation.gridy = 3;
        centerPanel.add(lastNameLabel);
        add(lastNameLabel,constraintsClientInformation);

        lastNameField  = new JTextField(20);
//        lastNameField.setPreferredSize(new Dimension(50,20));
        constraintsClientInformation.gridx = 2;
        constraintsClientInformation.gridy = 3;
        centerPanel.add(lastNameField);
        add(lastNameField,constraintsClientInformation);

        addressLabel = new JLabel("Address: ");
        constraintsClientInformation.gridx = 1;
        constraintsClientInformation.gridy = 4;
        centerPanel.add(addressLabel);
        add(addressLabel,constraintsClientInformation);

        addressField = new JTextField(50);
//        addressField.setPreferredSize(new Dimension(50,20));
        constraintsClientInformation.gridx = 2;
        constraintsClientInformation.gridy = 4;
        centerPanel.add(addressField);
        add(addressField,constraintsClientInformation);

        postalCodeLabel = new JLabel("Postal Code: ");
        constraintsClientInformation.gridx = 1;
        constraintsClientInformation.gridy = 5;
        centerPanel.add(postalCodeLabel);
        add(postalCodeLabel,constraintsClientInformation);

        postalCodeField = new JFormattedTextField(new MaskFormatter("?#? #?#"));
        postalCodeField.setColumns(7);
//        postalCodeField.setPreferredSize(new Dimension(50,20));
        constraintsClientInformation.gridx = 2;
        constraintsClientInformation.gridy = 5;
        centerPanel.add(postalCodeField);
        add(postalCodeField,constraintsClientInformation);

        phoneNumberLabel = new JLabel("Phone Number: ");
        constraintsClientInformation.gridx = 1;
        constraintsClientInformation.gridy = 6;
        centerPanel.add(phoneNumberLabel);
        add(phoneNumberLabel,constraintsClientInformation);

        phoneNumberField = new JFormattedTextField(new MaskFormatter("###-###-####"));
        phoneNumberField.setColumns(12);
        //        phoneNumberField.setPreferredSize(new Dimension(50,20));
        constraintsClientInformation.gridx = 2;
        constraintsClientInformation.gridy = 6;
        centerPanel.add(phoneNumberField);
        add(phoneNumberField,constraintsClientInformation);

        clientTypeLabel = new JLabel("Client Type: ");
        constraintsClientInformation.gridx = 1;
        constraintsClientInformation.gridy = 7;
        centerPanel.add(clientTypeLabel);
        add(clientTypeLabel,constraintsClientInformation);

        String [] clientTypes = {"C","R"};
        clientTypeComboBox = new JComboBox(clientTypes);
        constraintsClientInformation.gridx = 2;
        constraintsClientInformation.gridy = 7;
        centerPanel.add(clientTypeComboBox);
        //add(centerPanel,BorderLayout.CENTER);
        add(clientTypeComboBox,constraintsClientInformation);

        //newButton = new JButton("New");
        //southPanel.add(newButton);

        save = new JButton("Save");
        constraintsClientInformation.gridx = 1;
        constraintsClientInformation.gridy = 8;
        southPanel.add(save);
        add(save,constraintsClientInformation);

        delete = new JButton("Delete");
        constraintsClientInformation.gridx = 2;
        constraintsClientInformation.gridy = 8;
        southPanel.add(delete);
        add(delete,constraintsClientInformation);

        clear = new JButton("Clear");
        constraintsClientInformation.gridx = 3;
        constraintsClientInformation.gridy = 8;
        southPanel.add(clear);
        add(clear,constraintsClientInformation);


        setVisible(true);




    }

    /**
     * Clear information panel.
     */
    public void clearInformationPanel(){
        clientIdField.setText("");
        firstNameField.setText("");
        lastNameField.setText("");
        addressField.setText("");
        postalCodeField.setText("");
        phoneNumberField.setText("");
    }
}
