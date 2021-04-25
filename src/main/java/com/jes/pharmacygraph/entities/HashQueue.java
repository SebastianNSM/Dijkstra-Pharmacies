package com.jes.pharmacygraph.entities;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class HashQueue {
    private HashNode head;

    public HashQueue(){

    }

    public void add(HashNode entry){
        if(head == null){
            this.head = entry;
        }else{
            HashNode temp = head;
            while(temp.getNext() != null){
                temp = temp.getNext();
            }
            temp.setNext(entry);
        }
    }

    public HashNode find(String name){
        if(head == null){
            return null;
        }else{
            HashNode temp = head;
            while(temp != null){
                if(temp.getContentName().equals(name)){
                    return temp;
                }else{
                    temp = temp.getNext();
                }
            }
            return null;
        }
    }
}
