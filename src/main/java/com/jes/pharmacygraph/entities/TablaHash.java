package com.jes.pharmacygraph.entities;

import java.util.stream.IntStream;

public class TablaHash {
    private int keyCount;
    private HashQueue[] items;

    public TablaHash(){

    }

    public TablaHash(int keyCount){
        this.keyCount = keyCount;
        this.items = new HashQueue[keyCount];
    }

    public void add(String name){
        int key = hash(name);
        if(items[key] == null){
            items[key] = new HashQueue();
        }
        items[key].add(new HashNode(key, name));
    }

    public HashNode find(String name){
        int key = hash(name);
        if(items[key].find(name) != null){
            return items[key].find(name);
        }else{
            return null;
        }
    }

    public int hash(String name){
        int asciiName = 0;
        for(int i=0;i<name.length();i++){
            int asciiChar = (int) name.charAt(i);
            asciiName+=asciiChar;
        }
        int key = (asciiName%closestPrime(keyCount)+1);
        return key;
    }

    public int closestPrime(int limit){
        for(int num = limit; num>2; num--){
            boolean foundPrime = false;
            for(int divider = 2; divider<num; divider++){
                if(num%divider == 0){
                    foundPrime = false;
                    break;
                }else{
                    foundPrime = true;
                }
            }
            if(foundPrime){
                return num;
            }
        }
        return 0;
    }
}
