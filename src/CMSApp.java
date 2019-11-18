import View.CMSView;
import Model.Client;
import Model.ClientManager;
import Controller.ClientController;

import java.text.ParseException;

/**
 * The type Cms app.
 */
public class CMSApp {
    /**
     * The entry point of application.
     *
     * @param args the input arguments
     * @throws ParseException the parse exception
     */
    public static void main(String [] args) throws ParseException {
        CMSView myView = new CMSView();
        myView.setVisible(true);
        myView.pack();
        ClientManager myManager = new ClientManager();
        ClientController theController = new ClientController(myView,myManager);
        //myManager.createDB();
        myManager.createTable();
        myManager.fillTable();
    }


}
