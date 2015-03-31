package com.company;

import java.util.*;

public class Dictionary<K, V> implements Map <K, V>{

    LinkedList<Element>[] dictionary;
    int size;

    public Dictionary(int size){
        dictionary = new LinkedList[size];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean containsKey(Object key) {
        for (Element e :dictionary[getIndex(key)]){
            if (e.getKey() == key){
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean containsValue(Object value) {
        for (LinkedList<Element> list : dictionary){
            for (Element el: list){
                if (el.getValue() == value){
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public V get(Object key) {
        return null;
    }

    @Override
    public V put(K key, V value) {
        dictionary[getIndex(key)].add(new Element(key, value));
        return value;
    }

    @Override
    public V remove(Object key) {
        for (Element e :dictionary[getIndex(key)]){
            if (e.getKey() == key){
                V value = (V) e.getValue();
                dictionary[getIndex(key)].remove(e);
                return value;
            }
        }
        return null;
    }

    @Override
    public void putAll(Map<? extends K, ? extends V> m) {

    }

    @Override
    public void clear() {
        size = dictionary.length;
        dictionary = new LinkedList[size];
    }

    @Override
    public Set<K> keySet() {
        Set<K> set = new Set<K>(){

        };
    }

    @Override
    public Collection<V> values() {
        return null;
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        return null;
    }

    private int getIndex(Object o){
        return o.hashCode()%dictionary.length;
    }

    private class Element<K, V> implements Entry <K, V> {
        private K key;
        private V value;

        public Element(K key, V value){
            this.key = key;
            this.value = value;
        }

        @Override
        public K getKey() {
            return key;
        }

        @Override
        public V getValue() {
            return value;
        }

        @Override
        public V setValue(V value) {
            this.value = value;
            return this.value;
        }

        public void setKey(K key){
            this.key = key;
        }

    }
}

