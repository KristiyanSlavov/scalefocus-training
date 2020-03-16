package com.scalefocus.training.collection.common;

public interface MyList<T> extends MyCollection<T> {

    void insertAtStart(T data);

    void insertAt(int index, T data);
}
