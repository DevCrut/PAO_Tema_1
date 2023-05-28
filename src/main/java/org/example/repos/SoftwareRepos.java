package org.example.repos;

import org.example.classes.Software;
import org.example.database.DatabaseConnection;
import org.example.database.DatabaseManager;
import org.example.services.Repos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public final class SoftwareRepos extends Observer<Software> implements Repos<Software> {

    private static DatabaseConnection database = DatabaseManager.getInstance();
    @Override
    public void add(Software x) {
        try {
            Statement stmt = database.getConnection().createStatement();
            String sqlCommand = "insert into plt_software values(" +
                    x.getSoftware_id() + ", " +
                    x.getAccount_id() + ", " +
                    x.getSoftware_type_id() + ", '" +
                    x.getSoftware_name() + "', to_date('" +
                    x.getTime_owned() + "'))";
            System.out.println(sqlCommand);
            int res = stmt.executeUpdate(sqlCommand);
            if (res > 0)
                System.out.println("Successfully Inserted");
            else
                System.out.println("Insert Failed");

            triggerAdd(x);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void remove(Software x) {
        try {
            Statement stmt = database.getConnection().createStatement();
            String sqlCommand = "delete from plt_software where software_id = " + x.getSoftware_id();
            int res = stmt.executeUpdate(sqlCommand);
            if (res > 0)
                System.out.println("Successfully Removed");
            else
                System.out.println("Remove Failed");

            triggerRemove(x);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void modify(Software x) {
        try {
            Statement stmt = database.getConnection().createStatement();
            String sqlCommand = "update plt_software set " +
                    "account_id=" + x.getAccount_id() + ", " +
                    "software_type=" + x.getSoftware_type_id() + ", " +
                    "software_name='" + x.getSoftware_name() + "', " +
                    "time_owned=to_date('" + x.getTime_owned() + "') where software_id=" + x.getSoftware_id();
            System.out.println(sqlCommand);
            int res = stmt.executeUpdate(sqlCommand);
            if (res > 0)
                System.out.println("Successfully Updated");
            else
                System.out.println("Update Failed");

            triggerModify(x);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public ResultSet getQuery(String query) {
        try{
            Statement statement = database.getConnection().createStatement();
            return statement.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
