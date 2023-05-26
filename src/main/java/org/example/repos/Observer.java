package org.example.repos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.function.Consumer;

public sealed abstract class Observer<T> permits SoftwareRepos, UserRepos {
    HashMap<int, Consumer<T>> observerAddList;
    int observerAddCount = 0;
    HashMap<int, Consumer<T>> observerRemoveList;
    int observerRemoveCount = 0;
    HashMap<int, Consumer<T>> observerModifyList;
    int observerModifyCount = 0;

    public void triggerAdd(T x){
        for (HashMap.Entry<int, Consumer<T>> set : observerAddList.entrySet()) {
            set.getValue().accept(x);
        }
    }
    public void triggerRemove(T x){
        for (HashMap.Entry<int, Consumer<T>> set : observerRemoveList.entrySet()) {
            set.getValue().accept(x);
        }
    }
    public void triggerModify(T x){
        for (HashMap.Entry<int, Consumer<T>> set : observerModifyList.entrySet()) {
            set.getValue().accept(x);
        }
    }
    public int listenAdd(Consumer<T> lambda) {
        int newKey = this.observerAddCount;
        observerAddList.put(newKey, lambda);
        return newKey;
    }
    public int listenRemove(Consumer<T> lambda) {
        int newKey = this.observerRemoveCount;
        observerRemoveList.put(newKey, lambda);
        return newKey;
    }
    public int listenModify(Consumer<T> lambda) {
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
