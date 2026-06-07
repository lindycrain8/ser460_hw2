package hearthealth.util;

import hearthealth.model.CTTest;
import hearthealth.model.PatientRecord;
import hearthealth.model.Appointment;
import java.util.Date;

import java.io.*;

public class FileManager {

    public static void savePatientRecord(PatientRecord record) {
        String filename = "patients/" + record.getPatientID() + "_PatientInfo.txt";
        new File("patients").mkdirs();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            writer.write("PatientID: " + record.getPatientID());
            writer.newLine();
            writer.write("FirstName: " + record.getFirstName());
            writer.newLine();
            writer.write("LastName: " + record.getLastName());
            writer.newLine();
            writer.write("Email: " + record.getEmail());
            writer.newLine();
            writer.write("PhoneNumber: " + record.getPhoneNumber());
            writer.newLine();
            writer.write("HealthHistory: " + record.getHealthHistory());
            writer.newLine();
            writer.write("InsuranceID: " + record.getInsuranceID());
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static PatientRecord loadPatientRecord(String patientID) {
        String filename = "patients/" + patientID + "_PatientInfo.txt";
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String pid = reader.readLine().split(": ")[1];
            String firstName = reader.readLine().split(": ")[1];
            String lastName = reader.readLine().split(": ")[1];
            String email = reader.readLine().split(": ")[1];
            String phoneNumber = reader.readLine().split(": ")[1];
            String healthHistory = reader.readLine().split(": ")[1];
            String insuranceID = reader.readLine().split(": ")[1];
            return new PatientRecord(pid, firstName, lastName, email,
                                     phoneNumber, healthHistory, insuranceID);
        } catch (FileNotFoundException e) {
            return null;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void saveCTTest(CTTest ctTest) {
        String filename = "records/" + ctTest.getPatientID() + "_CTResults.txt";
        new File("records").mkdirs();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            writer.write("PatientID: " + ctTest.getPatientID());
            writer.newLine();
            writer.write("TotalCACScore: " + ctTest.getTotalCACScore());
            writer.newLine();
            writer.write("LMScore: " + ctTest.getLMScore());
            writer.newLine();
            writer.write("LADScore: " + ctTest.getLADScore());
            writer.newLine();
            writer.write("LCXScore: " + ctTest.getLCXScore());
            writer.newLine();
            writer.write("RCAScore: " + ctTest.getRCAScore());
            writer.newLine();
            writer.write("PDAScore: " + ctTest.getPDAScore());
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static CTTest loadCTTest(String patientID) {
        String filename = "records/" + patientID + "_CTResults.txt";
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String pid = reader.readLine().split(": ")[1];
            int totalCACScore = Integer.parseInt(reader.readLine().split(": ")[1]);
            int LMScore = Integer.parseInt(reader.readLine().split(": ")[1]);
            int LADScore = Integer.parseInt(reader.readLine().split(": ")[1]);
            int LCXScore = Integer.parseInt(reader.readLine().split(": ")[1]);
            int RCAScore = Integer.parseInt(reader.readLine().split(": ")[1]);
            int PDAScore = Integer.parseInt(reader.readLine().split(": ")[1]);
            return new CTTest(pid, totalCACScore, LMScore, LADScore,
                              LCXScore, RCAScore, PDAScore);
        } catch (FileNotFoundException e) {
            return null;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public static Appointment loadAppointment(String patientID) {
        String filename = "appointments/" + patientID + "_Appointment.txt";
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String appointmentID = reader.readLine().split(": ")[1];
            String pid = reader.readLine().split(": ")[1];
            String dateStr = reader.readLine().split(": ")[1];
            java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd");
            Date appointmentDate = sdf.parse(dateStr);
            return new Appointment(appointmentID, pid, appointmentDate);
        } catch (FileNotFoundException e) {
            return null;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        } catch (java.text.ParseException e) {
            e.printStackTrace();
            return null;
        }
    }
}