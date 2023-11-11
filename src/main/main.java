package main;

import main.utils.Doctors;
import main.utils.Patient;
import main.utils.Queue;

class Main {

    public static void main(String[] args) {
        System.out.println("hello jojo");

        Queue q1 = new Queue(5);
        Queue[] queues = { q1 };

        for (int i = 0; i < q1.size(); i++) {
            int process_duration = (int) Math.floor(Math.random() * 100);
            Patient p = new Patient(process_duration);
            System.out.println(q1.size());
            q1.push(p);

        }

        Doctors doctors = new Doctors(3, queues);

        doctors.processPatients();

    }

}