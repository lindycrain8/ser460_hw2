package hearthealth;

import hearthealth.model.Appointment;
import hearthealth.model.PatientRecord;
import hearthealth.model.User;
import hearthealth.util.FileManager;

import java.io.File;

public class Receptionist extends User {

    public Receptionist() {
        super("", "", "Receptionist");
    }

    public String generatePatientID() {
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
        return String.valueOf(highestID + 1);
    }

    public void inputPatientInformation(PatientRecord record) {
        FileManager.savePatientRecord(record);
    }

    public void scheduleExam(Appointment appointment) {
        //to do
    }
}