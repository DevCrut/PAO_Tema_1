package org.example.repos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.function.BiConsumer;

public sealed abstract class Observer permits SoftwareRepos {
    HashMap<int, BiConsumer<int, int>> observerAddList;
    int observerAddCount = 0;
    HashMap<int, BiConsumer<int, int>> observerRemoveList;
    int observerRemoveCount = 0;
    HashMap<int, BiConsumer<int, int>> observerModifyList;
    int observerModifyCount = 0;

    public void triggerAdd(int tableID, int itemID){
        for (HashMap.Entry<int, BiConsumer<int, int>> set : observerAddList.entrySet()) {
            set.getValue().accept(tableID, itemID);
        }
    }
    public void triggerRemove(int tableID, int itemID){
        for (HashMap.Entry<int, BiConsumer<int, int>> set : observerRemoveList.entrySet()) {
            set.getValue().accept(tableID, itemID);
        }
    }
    public void triggerModify(int tableID, int itemID){
        for (HashMap.Entry<int, BiConsumer<int, int>> set : observerModifyList.entrySet()) {
            set.getValue().accept(tableID, itemID);
        }
    }
    public int listenAdd(BiConsumer<int, int> lambda) {
        int newKey = this.observerAddCount;
        observerAddList.put(newKey, lambda);
        return newKey;
    }
    public int listenRemove(BiConsumer<int, int> lambda) {
        int newKey = this.observerRemoveCount;
        observerRemoveList.put(newKey, lambda);
        return newKey;
    }
    public int listenModify(BiConsumer<int, int> lambda) {
        int newKey = this.observerModifyCount;
        observerModifyList.put(newKey, lambda);
        return newKey;
    }

    public void disconnectAdd(int key){
        this.observerAddList.remove(key);
    }
    public void disconnectRemove(int key){
        this.observerRemoveList.remove(key);
    }
    public void disconnectModify(int key){
        this.observerModifyList.remove(key);
    }

}
