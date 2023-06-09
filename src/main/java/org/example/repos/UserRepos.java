package org.example.repos;

import org.example.classes.*;
import org.example.database.DatabaseConnection;
import org.example.database.DatabaseManager;
import org.example.services.Repos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public final class UserRepos extends Observer<Account> implements Repos<Account> {

    private static DatabaseConnection database = DatabaseManager.getInstance();
    @Override
    public void add(Account x) {
        try {
            Statement stmt = database.getConnection().createStatement();
            String sqlCommand = "insert into plt_account values(" +
                    x.getAccount_id() + ", " +
                    x.getAccount_type() + ", '" +
                    x.getAccount_name() + "', to_date('" +
                    x.getTime_created() + "'), " +
                    x.getWallet() + ")";
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
    public void remove(Account x) {
        try {
            Statement stmt = database.getConnection().createStatement();
            String sqlCommand = "delete from plt_account where account_id = " + x.getAccount_id();
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
    public void modify(Account x) {
        try {
            Statement stmt = database.getConnection().createStatement();
            String sqlCommand = "update plt_account set account_type="+x.getAccount_type()+" "+
                                ", account_name='"+x.getAccount_name()+"' "+
                                ", account_time_created=to_date('"+x.getTime_created()+"') "+
                                ", wallet_id="+x.getWallet()+" where account_id = " + x.getAccount_id();
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
