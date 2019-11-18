package View;

import javax.swing.*;
import java.awt.*;

/**
 * The type Search panel.
 */
public class SearchPanel extends JPanel {
    private JRadioButton clientIdButton;
    private JRadioButton lastNameButton;
    private JRadioButton clientTypeButton;
    private JLabel searchLabel,searchParameterLabel,searchTypeLabel;
    private JTextField searchParameterField;
    private JButton searchButton,clearSearchButton;
    private ButtonGroup buttonGroup;
    //private JPanel searchPanel;


    /**
     * Gets client id button.
     *
     * @return the client id button
     */
    public JRadioButton getClientIdButton() {
        return clientIdButton;
    }

    /**
     * Gets last name button.
     *
     * @return the last name button
     */
    public JRadioButton getLastNameButton() {
        return lastNameButton;
    }

    /**
     * Gets client type button.
     *
     * @return the client type button
     */
    public JRadioButton getClientTypeButton() {
        return clientTypeButton;
    }


    /**
     * Gets search parameter field.
     *
     * @return the search parameter field
     */
    public JTextField getSearchParameterField() {
        return searchParameterField;
    }


    /**
     * Gets search button.
     *
     * @return the search button
     */
    public JButton getSearchButton() {
        return searchButton;
    }


    /**
     * Gets clear search button.
     *
     * @return the clear search button
     */
    public JButton getClearSearchButton() {
        return clearSearchButton;
    }


    /**
     * Gets button group.
     *
     * @return the button group
     */
    public ButtonGroup getButtonGroup() {
        return buttonGroup;
    }


    /**
     * Instantiates a new Search panel.
     */
    public SearchPanel(){
        createSearchPanel();
    }


    /**
     * Create search panel.
     */
    public void createSearchPanel(){
        //*******************************
        //Search Panel
        //searchPanel = new JPanel();
        setPreferredSize(new Dimension(500,200));
        setBorder(BorderFactory.createLineBorder(Color.BLACK));
        searchLabel = new JLabel("Search Clients");
        searchTypeLabel = new JLabel("Select type of search to be performed");
        searchParameterLabel = new JLabel("Enter the Search Parameter below");
        searchParameterField = new JTextField(10);
        searchButton = new JButton("Search");
        clearSearchButton = new JButton("Clear Search");
        clientIdButton = new JRadioButton("Client ID");
        lastNameButton = new JRadioButton("Last Name");
        clientTypeButton = new JRadioButton("Client Type");
        buttonGroup = new ButtonGroup();
        buttonGroup.add(clientIdButton);
        buttonGroup.add(lastNameButton);
        buttonGroup.add(clientTypeButton);
        setLayout(new GridBagLayout());
        GridBagConstraints constraintsSearchPanel = new GridBagConstraints();

        constraintsSearchPanel.gridx = 0;
        constraintsSearchPanel.gridy = 0;
        add(searchLabel,constraintsSearchPanel);

        constraintsSearchPanel.gridx = 0;
        constraintsSearchPanel.gridy = 1;
        add(searchTypeLabel,constraintsSearchPanel);

        constraintsSearchPanel.gridx = 0;
        constraintsSearchPanel.gridy = 2;
        add(clientIdButton,constraintsSearchPanel);

        constraintsSearchPanel.gridx = 0;
        constraintsSearchPanel.gridy = 3;
        add(lastNameButton,constraintsSearchPanel);


        constraintsSearchPanel.gridx = 0;
        constraintsSearchPanel.gridy = 4;
        add(clientTypeButton,constraintsSearchPanel);

        constraintsSearchPanel.gridx = 0;
        constraintsSearchPanel.gridy = 5;
        add(searchParameterLabel,constraintsSearchPanel);

        constraintsSearchPanel.gridx = 0;
        constraintsSearchPanel.gridy = 6;
        add(searchParameterField,constraintsSearchPanel);

        constraintsSearchPanel.gridx = 1;
        constraintsSearchPanel.gridy = 6;
        add(searchButton,constraintsSearchPanel);

        constraintsSearchPanel.gridx = 2;
        constraintsSearchPanel.gridy = 6;
        add(clearSearchButton,constraintsSearchPanel);
        setVisible(true);
    }
}
