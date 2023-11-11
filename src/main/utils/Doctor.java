package main.utils;

class Doctor implements Runnable {

    Queue[] queues;
    int id;

    public Doctor(int id, Queue[] queue) {
        this.queues = queue;
        this.id = id;
    }

    public void run() {
        outer: while (true) {
            for (Queue q : this.queues) {
                Patient p = q.process();
                if (p == null) {
                    break outer;
                }
                long startTime = System.nanoTime();
                try {
                    Thread.sleep(p.getDuration());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                long stopTime = System.nanoTime();
                long duration = (stopTime - startTime) / (long) 1e+9;
                System.out
                        .println("TimeElapsed in the processing of patient by Doctor with id " + this.id + " : "
                                + duration + " seconds");
            }
        }
    }

}