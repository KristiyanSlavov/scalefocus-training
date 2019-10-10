package com.scalefocus.training.collection.common;

public interface MyList extends MyCollection {

    void insertAtStart(Object data);

    void insertAt(int index, Object data);
}
