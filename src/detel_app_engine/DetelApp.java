package detel_app_engine;

import check_number.SelectFromDatabase;
import delete_number.DeleteFromDatabase;
import java.sql.SQLException;

public class DetelApp {

    public static void NumberForDelete(String numberForDelete) throws SQLException {
        DeleteFromDatabase.zeusBulkCreateUser(numberForDelete);
        DeleteFromDatabase.dev(numberForDelete);
        DeleteFromDatabase.detelip(numberForDelete);
        DeleteFromDatabase.numbers(numberForDelete);
        DeleteFromDatabase.registracije(numberForDelete);
    }

    public static void NumberForCheck(String numberForCheck) throws SQLException {
        SelectFromDatabase.selectFromBulkCreateUser_SviKreirani(numberForCheck);
        SelectFromDatabase.selectFromDev(numberForCheck);
        SelectFromDatabase.selectFromDetelip(numberForCheck);
        SelectFromDatabase.selectFromNumbers(numberForCheck);
        SelectFromDatabase.selectFromRegistracije(numberForCheck);
    }

}
