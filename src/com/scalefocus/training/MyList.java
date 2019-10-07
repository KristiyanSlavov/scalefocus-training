package com.scalefocus.training;

public interface MyList extends MyCollection {

    void insertAtStart(Object data);

    void insertAt(int index, Object data);
}
