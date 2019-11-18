package View;

import Model.Client;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * The type Search results list.
 */
public class SearchResultsList extends JPanel {
    private JList clientList;
    private JLabel searchResultsLabel;
    private JScrollPane scrollPane;
    private DefaultListModel listModel;

    /**
     * Instantiates a new Search results list.
     */
    public SearchResultsList(){
        //createSearchResultList();
        setLayout(new BorderLayout());
        clientList = new JList();
        //clientList.setPreferredSize(new Dimension(300,300));
        scrollPane = new JScrollPane(clientList);
        scrollPane.setPreferredSize(new Dimension(250,300));
        searchResultsLabel = new JLabel("Search Results");
        setBorder(BorderFactory.createLineBorder(Color.BLACK));
        setPreferredSize(new Dimension(400,400));
        add(searchResultsLabel,BorderLayout.NORTH);
        add(scrollPane,BorderLayout.CENTER);
        setVisible(true);
    }

    /**
     * Gets client list.
     *
     * @return the client list
     */
    public JList getClientList() {
        return clientList;
    }

    /**
     * Gets list model.
     *
     * @return the list model
     */
    public DefaultListModel getListModel() {
        return listModel;
    }

    /**
     * Clear search result.
     */
    public void clearSearchResult(){
        clientList.setListData(new ArrayList<Client>().toArray());
    }


    /**
     * Populate list.
     *
     * @param myClientList the my client list
     */
    public void populateList(Object[] myClientList){
        clientList.setListData(myClientList);
    }


}
