import java.util.ArrayList;
import java.util.Scanner;

class Appointment {
    String doctorName;
    String patientName;
    String appointmentTime;

    public Appointment(String doctorName, String patientName, String appointmentTime) {
        this.doctorName = doctorName;
        this.patientName = patientName;
        this.appointmentTime = appointmentTime;
    }

    public String toString() {
        return "Doctor: " + doctorName + ", Patient: " + patientName + ", Time: " + appointmentTime;
    }
}

public class DoctorAppointmentSystem {
    static ArrayList<Appointment> appointments = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n==== Online Doctor Appointment System ====");
            System.out.println("1. Book an Appointment");
            System.out.println("2. View All Appointments");
            System.out.println("3. Check Doctor Availability");
            System.out.println("4. Exit");
            System.out.print("Select an option (1-4): ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    bookAppointment();
                    break;
                case 2:
                    viewAppointments();
                    break;
                case 3:
                    checkDoctorAvailability();
                    break;
                case 4:
                    System.out.println("Exiting the system...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice, please try again.");
            }
        }
    }

    public static void bookAppointment() {
        System.out.print("Enter Doctor's Name: ");
        String doctorName = scanner.nextLine();
        System.out.print("Enter Patient's Name: ");
        String patientName = scanner.nextLine();
        System.out.print("Enter Appointment Time (e.g., 10:00 AM): ");
        String appointmentTime = scanner.nextLine();

        appointments.add(new Appointment(doctorName, patientName, appointmentTime));
        System.out.println("Appointment successfully booked!");
    }

    public static void viewAppointments() {
        if (appointments.isEmpty()) {
            System.out.println("No appointments booked yet.");
        } else {
            System.out.println("\n=== Booked Appointments ===");
            for (Appointment appointment : appointments) {
                System.out.println(appointment);
            }
        }
    }

    public static void checkDoctorAvailability() {
        System.out.print("Enter Doctor's Name to check availability: ");
        String doctorName = scanner.nextLine();

        boolean isAvailable = true;
        for (Appointment appointment : appointments) {
            if (appointment.doctorName.equalsIgnoreCase(doctorName)) {
                System.out.println("Doctor " + doctorName + " is booked for " + appointment.appointmentTime);
                isAvailable = false;
            }
        }

        if (isAvailable) {
            System.out.println("Doctor " + doctorName + " is available.");
        }
    }
}
