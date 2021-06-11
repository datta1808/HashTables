package com.bridgelabz;

import java.util.ArrayList;

class MyLinkedHashMap<T, V> {
    private final int numBuckets;
    ArrayList<MyLinkedList> myBucketArray;

    // Constructor
    public MyLinkedHashMap() {
        numBuckets = 10;
        myBucketArray = new ArrayList<>(numBuckets);
        for (int i = 0; i < numBuckets; i++)
            this.myBucketArray.add(null);
    }

    // Get bucket index for given key
    private int getBucketIndex(T key) {
        int hashCode = Math.abs(key.hashCode());
        int index = hashCode % numBuckets;
        return index;
    }

    // Get value given Key
    public V get(T key) {
        int index = this.getBucketIndex(key);
        MyLinkedList myLinkedList = myBucketArray.get(index);
        if (myLinkedList == null)
            return null;
        MyMapNode<T, V> myMapNode = (MyMapNode<T, V>) myLinkedList.searchNode((Comparable) key);
        return (myMapNode == null) ? null : myMapNode.getValue();
    }

    // Add to linked hash map
    public void add(T key, V value) {
        int index = getBucketIndex(key);
        MyLinkedList myLinkedList = myBucketArray.get(index);
        if (myLinkedList == null) {
            myLinkedList = new MyLinkedList();
            myBucketArray.set(index, myLinkedList);
        }
        MyMapNode<T, V> myMapNode = (MyMapNode<T, V>) myLinkedList.searchNode((Comparable) key);
        if (myMapNode == null) {
            myMapNode = new MyMapNode<T, V>(key, value);
            myLinkedList.addLast(myMapNode);
        } else {
            myMapNode.setValue(value);
        }
    }
}
