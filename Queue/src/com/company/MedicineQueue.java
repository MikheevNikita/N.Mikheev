package com.company;

public class MedicineQueue<Student> {

    private Queue<Student> queue = new Queue<Student>();

    public void setQueue(int size) {
        queue.init(size);
    }

    public void setQueue(Student[] students) {
        queue.init(students);
    }

    public void add(Student student) throws QueueOverloadException{
        try{
            queue.poll(student);
        }catch (QueueOverloadException e){
            e.message();
        }
    }
}
