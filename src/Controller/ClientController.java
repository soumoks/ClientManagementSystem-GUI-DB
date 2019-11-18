package Controller;
import Model.Client;
import Model.ClientManager;
import View.CMSView;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.*;
import java.util.ArrayList;


/**
 * The type Client controller.
 */
public class ClientController {
    private CMSView theView;
    private ClientManager theManager;
    private Client selectedClient;

    /**
     * Instantiates a new Client controller.
     *
     * @param theView    the the view
     * @param theManager the the manager
     */
    public ClientController(CMSView theView, ClientManager theManager) {
        this.theView = theView;
        this.theManager = theManager;
        theView.getTheSearchPanel().getSearchButton().addActionListener(new SearchButtonListener());
        theView.getTheSearchResultsList().getClientList().addListSelectionListener(new SearchResultsListenener());
        theView.getTheClientInformationPanel().getSave().addActionListener(new SaveButtonListener());
        theView.getTheClientInformationPanel().getDelete().addActionListener(new DeleteButtonListener());
        theView.getTheClientInformationPanel().getClear().addActionListener(new ClearButtonListener());
        theView.getTheSearchPanel().getClearSearchButton().addActionListener(new ClearSearchListener());

        //Anonymous listeners for the text field which controls the number of characters that can be typed into the field
        theView.getTheClientInformationPanel().getFirstNameField().addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (theView.getTheClientInformationPanel().getFirstNameField().getText().length() >= 20 ){
                    e.consume();
                }
                //super.keyTyped(e);
            }
        });
        theView.getTheClientInformationPanel().getLastNameField().addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (theView.getTheClientInformationPanel().getLastNameField().getText().length() >= 20 ){
                    e.consume();
                }
                //super.keyTyped(e);
            }
        });
        theView.getTheClientInformationPanel().getAddressField().addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (theView.getTheClientInformationPanel().getAddressField().getText().length() >= 50 ){
                    e.consume();
                }
                //super.keyTyped(e);
            }
        });
    }

    /**
     * The type Search button listener.
     */
    class SearchButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String searchParameter = theView.getTheSearchPanel().getSearchParameterField().getText();
            if (theView.getTheSearchPanel().getClientIdButton().isSelected()) {
                System.out.println("Client ID button is selected");
                System.out.println(searchParameter);
                ArrayList<Client> result = theManager.searchClient(Integer.parseInt(searchParameter));
                theView.populateSearchResultsList(result.toArray());
            }
            else if (theView.getTheSearchPanel().getClientTypeButton().isSelected()) {
                System.out.println("Client Type button is selected");
                System.out.println(searchParameter);
                ArrayList<Client> result = theManager.searchClientType(searchParameter);
                theView.populateSearchResultsList(result.toArray());
            }
            else if (theView.getTheSearchPanel().getLastNameButton().isSelected()) {
                System.out.println("Last Name button is selected");
                System.out.println(searchParameter);
                ArrayList<Client> result = theManager.searchClient(searchParameter);
                theView.populateSearchResultsList(result.toArray());
            }
        }
    }


    /**
     * Clear search Button Listenener
     */
    class ClearSearchListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            theView.getTheSearchResultsList().clearSearchResult();
            theView.getTheSearchPanel().getSearchParameterField().setText("");
            theView.getTheSearchPanel().getButtonGroup().clearSelection();
        }
    }


    /**
     * The type Search results listenener.
     */
    class SearchResultsListenener implements ListSelectionListener {

        @Override
        public void valueChanged(ListSelectionEvent e) {
            if (theView.getTheSearchResultsList().getClientList().getSelectedIndex() >= 0 && !e.getValueIsAdjusting()) {
                selectedClient = (Client) theView.getTheSearchResultsList().getClientList().getModel().getElementAt(theView.getTheSearchResultsList().getClientList().getSelectedIndex());
                System.out.println(selectedClient.getLastName());
                theView.setClientInformation(selectedClient);
            }
        }
    }


    /**
     * The type Save button listener.
     */
    class SaveButtonListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            //If Client ID is present on the GUI, that means the client is already in the Table. Fire an update Query
            if(!theView.getTheClientInformationPanel().getClientIdField().getText().equals("")){
                if(theManager.checkPhoneNumber(theView.getTheClientInformationPanel().getPhoneNumberField().getText())){
                    theManager.updateItem(theView.getTheClientInformationPanel().getFirstNameField().getText(), theView.getTheClientInformationPanel().getLastNameField().getText(), theView.getTheClientInformationPanel().getAddressField().getText(), theView.getTheClientInformationPanel().getPostalCodeField().getText(), theView.getTheClientInformationPanel().getPhoneNumberField().getText(), theView.getTheClientInformationPanel().getClientTypeComboBox().getSelectedItem().toString(),Integer.parseInt(theView.getTheClientInformationPanel().getClientIdField().getText()));
                    JOptionPane.showMessageDialog(null, "Client Details updated", "Message",JOptionPane.PLAIN_MESSAGE);
                }
                else{
                    JOptionPane.showMessageDialog(null, "Phone Number does not match the format 111-111-1111", "Message",JOptionPane.PLAIN_MESSAGE);
                }
            }

            //If not Fire an Insert query
            else if(!theView.getTheClientInformationPanel().getFirstNameField().getText().equals("") && !theView.getTheClientInformationPanel().getLastNameField().getText().equals("") && !theView.getTheClientInformationPanel().getAddressField().getText().equals("") && !theView.getTheClientInformationPanel().getPostalCodeField().getText().equals("") && !theView.getTheClientInformationPanel().getPhoneNumberField().getText().equals("")){
                if(theManager.checkPhoneNumber(theView.getTheClientInformationPanel().getPhoneNumberField().getText())){
                    theManager.addItem(theView.getTheClientInformationPanel().getFirstNameField().getText(), theView.getTheClientInformationPanel().getLastNameField().getText(), theView.getTheClientInformationPanel().getAddressField().getText(), theView.getTheClientInformationPanel().getPostalCodeField().getText(), theView.getTheClientInformationPanel().getPhoneNumberField().getText(), theView.getTheClientInformationPanel().getClientTypeComboBox().getSelectedItem().toString());
                    JOptionPane.showMessageDialog(null, "Client Details added", "Message",JOptionPane.PLAIN_MESSAGE);
                }
                else{
                    JOptionPane.showMessageDialog(null, "Phone Number does not match the format 111-111-1111", "Message",JOptionPane.PLAIN_MESSAGE);
                }
            }
            else{
                JOptionPane.showMessageDialog(null, "Please correct your inputs and try again!", " Warning",JOptionPane.PLAIN_MESSAGE);
            }
        }
    }

    /**
     * The type Delete button listener.
     */
    class DeleteButtonListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            theManager.deleteClient(Integer.parseInt(theView.getTheClientInformationPanel().getClientIdField().getText()));
            JOptionPane.showMessageDialog(null, "Client removed", "Message",JOptionPane.PLAIN_MESSAGE);
        }
    }

    /**
     * The type Clear button listener.
     */
    class ClearButtonListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            theView.clearInformationPanel();
        }
    }
}

