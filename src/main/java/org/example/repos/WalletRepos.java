package org.example.repos;

import org.example.classes.Wallet;
import org.example.classes.Wallet;

import java.util.ArrayList;

public class WalletRepos {
    ArrayList<Wallet> wallets;

    public void WalletRepos(){
        this.wallets = new ArrayList<>();
    }
    public void WalletRepos(ArrayList<Wallet> wallets){
        this.wallets = new ArrayList<>(wallets);
    }

    public void addWallet(Wallet x){
        this.wallets.add(x);
    }

    public void removeWallet(Wallet x){
        this.wallets.remove(x);
    }

    public boolean removeWallet(int wallet_id){
        for(Wallet c : this.wallets)
            if (wallet_id == c.getWallet_id()) {
                this.removeWallet(c);
                return true;
            }
        return false;
    }

    public ArrayList<Wallet> getWallets() {
        return wallets;
    }
}
