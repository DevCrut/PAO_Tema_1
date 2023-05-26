package org.example.repos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.function.Consumer;

public sealed abstract class Observer<T> permits SoftwareRepos, UserRepos {
    HashMap<Integer, Consumer<T>> observerAddList = new HashMap<>();
    int observerAddCount = 0;
    HashMap<Integer, Consumer<T>> observerRemoveList = new HashMap<>();
    int observerRemoveCount = 0;
    HashMap<Integer, Consumer<T>> observerModifyList = new HashMap<>();
    int observerModifyCount = 0;

    public void triggerAdd(T x){
        for (HashMap.Entry<Integer, Consumer<T>> set : observerAddList.entrySet()) {
            set.getValue().accept(x);
        }
    }
    public void triggerRemove(T x){
        for (HashMap.Entry<Integer, Consumer<T>> set : observerRemoveList.entrySet()) {
            set.getValue().accept(x);
        }
    }
    public void triggerModify(T x){
        for (HashMap.Entry<Integer, Consumer<T>> set : observerModifyList.entrySet()) {
            set.getValue().accept(x);
        }
    }
    public int listenAdd(Consumer<T> lambda) {
        int newKey = this.observerAddCount;
        this.observerAddCount += 1;
        observerAddList.put(newKey, lambda);
        return newKey;
    }
    public int listenRemove(Consumer<T> lambda) {
        int newKey = this.observerRemoveCount;
        this.observerRemoveCount += 1;
        observerRemoveList.put(newKey, lambda);
        return newKey;
    }
    public int listenModify(Consumer<T> lambda) {
        int newKey = this.observerModifyCount;
        this.observerModifyCount += 1;
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
