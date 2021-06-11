package com.bridgelabz;

public interface INode<T> {
    void setData(T data);

    T getData();

    void setNext(INode<T> next);

    INode<T> getNext();

}
