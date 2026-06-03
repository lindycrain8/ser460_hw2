package hearthealth;

import hearthealth.model.Appointment;
import hearthealth.model.PatientRecord;
import hearthealth.model.User;
import hearthealth.util.FileManager;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Receptionist extends User {

    private static final String ID_COUNTER_FILE = "patientIDCounter.txt";

    public Receptionist() {
        super("", "", "Receptionist");
    }

    public String generatePatientID() {
        File dataFolder = new File("data");
        if (!dataFolder.exists()) {
            dataFolder.mkdir();
        }
        int highestID = 9999;
        File[] files = dataFolder.listFiles();
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
        return String.valueOf(highestID + 1);
    }

    public void inputPatientInformation(PatientRecord record) {
        FileManager.savePatientRecord(record);
    }

    public void scheduleExam(Appointment appointment) {
        // stub - exam scheduling logic
    }
}