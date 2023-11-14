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

    public long processPatients() {
        int idx = 0;
        for (Doctor d : this.doctors) {
            Thread thread = new Thread(d);
            this.threads[idx] = thread;
            thread.start();
        }
        try {
            long start_time = System.nanoTime();

            for (Thread t : this.threads) {
                if (t != null) {
                    t.join();

                }
            }

            long end_time = System.nanoTime();

            long elapsed_time = (end_time - start_time) / (long) 1e+9;

            System.out.printf("Total elapsed time is %d\n", elapsed_time);

            return elapsed_time;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
