package View;

import javax.swing.*;
import java.awt.*;


//TODO - Replace JtextArea with JList.
//https://docs.oracle.com/javase/tutorial/uiswing/components/list.html


public class SearchResultsPanel extends JPanel {
    private JTextArea searchResultArea;
    private JScrollPane scrollPane;
    private JLabel searchResultsLabel;

    public SearchResultsPanel(){
        createSearchResultsPanel();
    }

    public JTextArea getSearchResultArea() {
        return searchResultArea;
    }

    public void setSearchResultArea(JTextArea searchResultArea) {
        this.searchResultArea = searchResultArea;
    }

    public JScrollPane getScrollPane() {
        return scrollPane;
    }

    public void setScrollPane(JScrollPane scrollPane) {
        this.scrollPane = scrollPane;
    }

    public JLabel getSearchResultsLabel() {
        return searchResultsLabel;
    }

    public void setSearchResultsLabel(JLabel searchResultsLabel) {
        this.searchResultsLabel = searchResultsLabel;
    }

    public void createSearchResultsPanel(){
        setBorder(BorderFactory.createLineBorder(Color.BLACK));
        setPreferredSize(new Dimension(300,100));
        searchResultArea = new JTextArea(30,30);
        searchResultArea.setLineWrap(true);
        //searchResultArea.setWrapStyleWord(true);
        searchResultArea.setEditable(true);
        scrollPane = new JScrollPane(searchResultArea);
        searchResultsLabel = new JLabel("Search Results: ");
        add(searchResultsLabel);
        add(scrollPane);
        setVisible(true);
    }
}
