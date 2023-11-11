package main.utils;

public class Patient {
    int process_duration = 10;

    public Patient(int duration) {
        if (duration > 0) {
            this.process_duration = (duration * 1000);
        }
    }

    public int getDuration() {
        return this.process_duration;
    }

    @Override
    public String toString() {
        return "Patient {process_duration: " + (this.process_duration / 1000) + " seconds}";
    }

}
