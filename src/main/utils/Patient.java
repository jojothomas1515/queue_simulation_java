package main.utils;

public class Patient {
    long id;
    int process_duration = 10 * 1000;

    public Patient(int duration) {
        if (duration > 0) {
            this.process_duration = (duration * 1000);
        }

        this.id = (long) (Math.random() * 1e+9);
    }

    public int getDuration() {
        return this.process_duration;
    }

    @Override
    public String toString() {
        return "Patient { id: " + this.id + " duration: " + (this.process_duration / 1000) + " secs }";
    }

}
