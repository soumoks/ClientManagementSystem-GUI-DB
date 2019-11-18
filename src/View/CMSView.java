package View;

import Model.Client;

import javax.swing.*;
import java.awt.*;
import java.text.ParseException;
import java.util.ArrayList;

/**
 * The type Cms view.
 */
public class CMSView extends JFrame {
    //***************************
    //Panels for the window
    private JFrame mainPanel;
    private JLabel mainLabel;
    private SearchPanel theSearchPanel;
    private SearchResultsPanel theSearchResultsPanel;
    private ClientInformationPanel theClientInformationPanel;
    private SearchResultsList theSearchResultsList;


    /**
     * Constructor. Creates the Window
     *
     * @throws ParseException the parse exception
     */
    public CMSView() throws ParseException {
        theSearchPanel = new SearchPanel();
        theSearchResultsPanel = new SearchResultsPanel();
        theClientInformationPanel = new ClientInformationPanel();
        theSearchResultsList = new SearchResultsList();
        setPreferredSize(new Dimension(1000,600));
        createWindow(theSearchPanel,theSearchResultsList,theClientInformationPanel);
    }

    /**
     * Gets the search results list.
     *
     * @return the the search results list
     */
    public SearchResultsList getTheSearchResultsList() {
        return theSearchResultsList;
    }


    /**
     * Gets the search panel.
     *
     * @return the the search panel
     */
    public SearchPanel getTheSearchPanel() {
        return theSearchPanel;
    }


    /**
     * Gets the client information panel.
     *
     * @return the the client information panel
     */
    public ClientInformationPanel getTheClientInformationPanel() {
        return theClientInformationPanel;
    }


    /**
     * Populate search results list.
     *
     * @param myClientList the my client list
     */
    public void populateSearchResultsList(Object [] myClientList){
        getTheSearchResultsList().populateList(myClientList);
    }


    /**
     * Set client information.
     *
     * @param myClient the my client
     */
    public void setClientInformation(Client myClient){
        getTheClientInformationPanel().getClientIdField().setText(Integer.toString(myClient.getId()));
        getTheClientInformationPanel().getFirstNameField().setText(myClient.getFirstName());
        getTheClientInformationPanel().getLastNameField().setText(myClient.getLastName());
        getTheClientInformationPanel().getAddressField().setText(myClient.getAddress());
        getTheClientInformationPanel().getPostalCodeField().setText(myClient.getPostalCode());
        getTheClientInformationPanel().getPhoneNumberField().setText(myClient.getPhoneNumber());
        getTheClientInformationPanel().getClientTypeComboBox().setSelectedItem(myClient.getType());
    }

    /**
     * Clears the fields present in the Information panel
     */
    public void clearInformationPanel(){
        getTheClientInformationPanel().clearInformationPanel();
    }

    /**
     * Function that creates the Window
     *
     * @param mySearchpanel       the my searchpanel
     * @param mySearchResultsList the my search results list
     * @param myInformationPanel  the my information panel
     */
    public void createWindow(SearchPanel mySearchpanel, SearchResultsList mySearchResultsList, ClientInformationPanel myInformationPanel){
        //mainPanel = new JFrame();
        mainLabel = new JLabel("Client Management Screen");
        setLayout(new GridBagLayout());
        GridBagConstraints constraintsMainPanel = new GridBagConstraints();


        constraintsMainPanel.gridx = 0;
        constraintsMainPanel.gridy = 0;
        add(mySearchpanel,constraintsMainPanel);

        constraintsMainPanel.gridx = 0;
        constraintsMainPanel.gridy = 1;
        add(mySearchResultsList,constraintsMainPanel);

        constraintsMainPanel.gridx = 1;
        constraintsMainPanel.gridy = 0;
        //constraintsMainPanel.weightx = 0.01;
        add(myInformationPanel,constraintsMainPanel);
        validate();
        setPreferredSize(new Dimension(1300,800));
        //getContentPane().add(mainPanel);
    }
}
