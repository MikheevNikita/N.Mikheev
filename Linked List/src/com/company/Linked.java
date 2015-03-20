package com.company;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class Linked<T> implements List<Item>{

    private Item[] linkedList;

    public Item[] getLinkedList(){
        return linkedList;
    }

    void linked(T[] items){
        linkedList = new Item[items.length + 1];
        linkedList[0].setNext(linkedList[1]);
        for (int index = 1; index <= items.length; index++){
            linkedList[index].setItem(items[index-1]);
            if(index <= items.length){
                linkedList[index].setNext(linkedList[index + 1]);
            }
        }
    }


    @Override
    public int size() {
        return linkedList.length;
    }

    @Override
    public boolean isEmpty() {
        if(size() == 0){
            return false;
        }else{
            return true;
        }
    }

    @Override
    public boolean contains(Object o) {
        for (int index = 0; index < size(); index++){
            if (linkedList[index] == o){
                return true;
            }else{
                continue;
            }
        }
        return false;
    }

    @Override
    public Iterator<Item> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        Object[] objected = new Object[size()-1];
        for (int index = 1; index < size()-1; index++){
            objected[index] = linkedList[index].getItem();
        }
        return objected;
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }


    @Override
    public boolean add(Item item) {
        if (item != null){
            Linked linked = new Linked();
            linked.linked(linkedList);
            this.linkedList = new Item[linked.size() + 1];
            for (int index = 0; index < linked.size(); index++){
                this.linkedList[index] = linked.linkedList[index];
            }
            linkedList[size() - 1] = item;
            linkedList[size() - 2].setNext(linkedList[size()-1]);
            return true;
        }
        return false;
    }

    @Override
    public boolean remove(Object o) {
        for (int index = 1; index < size(); index++){
            if(linkedList[index].getItem() == o){
                Linked linked = new Linked();
                linked.linked(linkedList);
                this.linkedList = new Item[linked.size() - 1];
                int counter = 0;
                for (int i = 0; i < size(); i++){
                    if (i != index){
                        linkedList[counter] = linked.linkedList[i];
                        counter++;
                        if (counter < size()){
                            linkedList[counter].setNext(linkedList[counter + 1]);
                        }
                    }
                }
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends Item> c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection<? extends Item> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {
        linkedList = new Item[11];
        linkedList[0] = new Item();
        linkedList[0].setNext(linkedList[1]);

    }

    @Override
    public Item get(int index) {
        return linkedList[index+1];
    }

    @Override
    public Item set(int index, Item element) {
        Item item = linkedList[index+1];
        linkedList[index+1] = element;
        element.setNext(linkedList[index + 2]);
        linkedList[index].setNext(linkedList[index + 1]);
        return item;
    }

    @Override
    public void add(int index, Item element) {

    }

    @Override
    public Item remove(int index) {
        return null;
    }

    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator<Item> listIterator() {
        return null;
    }

    @Override
    public ListIterator<Item> listIterator(int index) {
        return null;
    }

    @Override
    public List<Item> subList(int fromIndex, int toIndex) {
        return null;
    }
}
