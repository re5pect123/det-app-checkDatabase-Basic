package detel_app_engine;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class StartApp {

    public static void main(String[] args) {

        //add number for delete
      //  String numberForDelete = "38119427736";
        String numberForCheck = "381114300066";

        //Start
        try {
           DetelApp.NumberForCheck(numberForCheck);
        //        DetelApp.NumberForDelete(numberForDelete);
        } catch (SQLException ex) {
            Logger.getLogger(StartApp.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
