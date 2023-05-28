package org.example.repos;

import org.example.classes.*;
import org.example.database.DatabaseConnection;
import org.example.database.DatabaseManager;
import org.example.services.Repos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public final class WalletRepos extends Observer<Wallet> implements Repos<Wallet> {

    private static DatabaseConnection database = DatabaseManager.getInstance();
    @Override
    public void add(Wallet x) {
        try {
            Statement stmt = database.getConnection().createStatement();
            String sqlCommand = "insert into plt_wallet values(" +
                    x.getWallet_id() + ", " +
                    x.getBonus_points() + ", '" +
                    x.getDollars() + ")";
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
    public void remove(Wallet x) {
        try {
            Statement stmt = database.getConnection().createStatement();
            String sqlCommand = "delete from plt_wallet where wallet_id = " + x.getWallet_id();
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
    public void modify(Wallet x) {
        try {
            Statement stmt = database.getConnection().createStatement();
            String sqlCommand = "update plt_wallet set bonus_points="+x.getBonus_points()+" "+
                    ", dollars="+x.getDollars()+" "+
                    " where wallet_id = " + x.getWallet_id();
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
