package main.utils;

public class Doctors {
    Doctor[] doctors;
    Thread[] threads;

    public Doctors(int numbers, Queue[] queues) {
        this.doctors = new Doctor[numbers];
        this.threads = new Thread[numbers];

        for (int i = 0; i < numbers; i++) {
            this.doctors[i] = new Doctor(i, queues);
        }

    }

    public void processPatients() {
        for (Doctor d : this.doctors) {
            Thread thread = new Thread(d);
            thread.start();
        }
        try {
            for (Thread t : this.threads) {
                if (t != null) {
                    t.join();

                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
