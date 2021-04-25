package com.jes.pharmacygraph.entities;

public class HashNode {

    private int key;
    private String contentName;
    private HashNode next;

    public HashNode(){

    }

    public HashNode(int key){
        this.key = key;
    }

    public HashNode(int key, String contentName){
        this.key = key;
        this.contentName = contentName;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public String getContentName() {
        return contentName;
    }

    public void setContentName(String contentName) {
        this.contentName = contentName;
    }

    public HashNode getNext() {
        return next;
    }

    public void setNext(HashNode next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "HashNode{" +
                "key=" + key +
                ", contentName='" + contentName + '\'' +
                '}';
    }
}
