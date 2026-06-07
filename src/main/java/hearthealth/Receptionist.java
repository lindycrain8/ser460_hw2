package hearthealth;

import hearthealth.model.Appointment;
import hearthealth.model.PatientRecord;
import hearthealth.model.User;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Receptionist extends User {

    public Receptionist() {
        super("", "", "Receptionist");
    }

    public void generatePatientID(PatientRecord record) {
        int highestID = 9999;
        File[] files = new File("patients").listFiles();
        if (files != null) {
            for (File file : files) {
                String name = file.getName();
                if (name.endsWith("_PatientInfo.txt")) {
                    try {
                        int id = Integer.parseInt(name.replace("_PatientInfo.txt", ""));
                        if (id > highestID) {
                            highestID = id;
                        }
                    } catch (NumberFormatException e) {
                    }
                }
            }
        }
        String newID = String.valueOf(highestID + 1);
        record.setPatientID(newID);
    }

    public void inputPatientInformation(PatientRecord record) {
        generatePatientID(record);
        record.storePatientInformation();
    }

    public void scheduleExam(Appointment appointment) {
        new File("appointments").mkdirs();
        String filename = "appointments/" + appointment.getPatientID() + "_Appointment.txt";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            writer.write("AppointmentID: " + appointment.getAppointmentID());
            writer.newLine();
            writer.write("PatientID: " + appointment.getPatientID());
            writer.newLine();
            writer.write("AppointmentDate: " + appointment.getAppointmentDate());
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}