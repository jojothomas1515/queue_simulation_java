package main;

import main.utils.Doctors;
import main.utils.Patient;
import main.utils.Queue;
import java.io.FileWriter;
import java.io.IOException;

class Main {

    public static void main(String[] args) {

        if (args.length < 4) {
            System.out.println("Usage: <number of queues> <size of queue> <number of doctors> <number of iterations>");
            return;
        }
        try {
            FileWriter fw = new FileWriter("./data1.csv");
            fw.write("elapsed_time,");

            for (int it = 0; it < Integer.parseInt(args[3]); it++) {
                int number_of_queues = 0;
                int queue_size = 0;
                int doctors_on_duty = 0;

                try {
                    number_of_queues = Integer.parseInt(args[0]);
                    queue_size = Integer.parseInt(args[1]);
                    doctors_on_duty = Integer.parseInt(args[2]);
                } catch (NumberFormatException e) {
                    System.err.println("Invalid arguments: values must be a number");
                }

                Queue[] queues = new Queue[number_of_queues];

                for (int i = 0; i < number_of_queues; i++) {
                    Queue queue = new Queue(queue_size, i);
                    for (int j = 0; j < queue.size(); j++) {
                        int process_duration = (int) Math.floor(Math.random() * 20);
                        Patient p = new Patient(process_duration);
                        System.out.println(queue.size());
                        queue.push(p);

                    }

                    queues[i] = queue;
                }

                Doctors doctors = new Doctors(doctors_on_duty, queues);

                long elapsed = doctors.processPatients();
                System.out.println(elapsed);

                fw.append(String.format("\n%d", elapsed));

            }
            fw.close();

        } catch (IOException e) {
            System.out.println(e);
        }

    }

}