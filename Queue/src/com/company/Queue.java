package com.company;

public class Queue<T> implements Queable<T>{

    private Object[] queue;
    private int coursor = 0;
    private int end = 0;

    public void init(T[] rawQueue){
        queue = new Object[rawQueue.length];
        for (int index = 0; index < size(); index++){
            queue[index] = rawQueue[index];
        }
    }

    public void init(int desiredSize){
        queue = new Object[desiredSize];
    }

    @Override
    public T offer() {
        T result = (T) queue[coursor];
        offered();
        return result;
    }

    @Override
    public T peek() {
        return (T) queue[coursor];
    }

    @Override
    public void poll(T element) throws QueueOverloadException{
        try{
            setEnd();
            queue[end] = element;
        }catch (QueueOverloadException e){
            e.message();
        }
    }

    @Override
    public boolean isEmpty() {
        return coursor == end;
    }

    @Override
    public int size() {
        return queue.length;
    }

    private void offered(){
        if (coursor < size() - 1){
            coursor++;
        }else{
            coursor = 0;
        }
    }

    private void setEnd() throws QueueOverloadException{
        if (end < size() - 1 && --coursor != end){
            end++;
        }else if(end == size() -1 && coursor != 0){
            end = 0;
        }else{
            throw new QueueOverloadException();
        }
    }
}
