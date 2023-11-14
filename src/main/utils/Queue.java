package main.utils;

import java.util.Vector;

public class Queue {
    Vector<Patient> patients;
    int size = 1;
    int priority = 0;

    public Queue(int size, int priority) {
        this.size = size;
        this.patients = new Vector<Patient>();
        this.priority = priority;
    }

    /**
     * push - Adds patients to queue**
     * 
     * @param patient
     * @return false if the queue is full | true when patients is added successfully
     */
    public boolean push(Patient patient) {
        if (this.size == this.patients.size()) {
            System.out.println("the queue is full");
            return false;
        } else if (this.patients.contains(patient)) {
            System.out.println("Patient is already in queue");
            return false;
        }

        this.patients.add(patient);
        System.out.println("patient added queue with priority " + this.priority);
        System.out.print("Patient data: ");
        System.out.println(patient);
        return true;
    }

    synchronized public Patient process() {
        if (this.patients.size() <= 0) {
            System.out.println("The queue is empty");
            return null;
        }
        return this.patients.remove(0);
    }

    public int size() {
        return this.size;
    }

    public String toString() {
        return "Queue of priority " + this.priority + " with size of " + this.size;
    }
}
