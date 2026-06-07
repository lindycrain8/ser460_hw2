package hearthealth.model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class PatientRecord {
    private String patientID;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String healthHistory;
    private String insuranceID;

    public PatientRecord(String patientID, String firstName, String lastName,
                         String email, String phoneNumber, String healthHistory,
                         String insuranceID) {
        this.patientID = patientID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.healthHistory = healthHistory;
        this.insuranceID = insuranceID;
    }

    public String getPatientID() {
        return patientID;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getHealthHistory() {
        return healthHistory;
    }

    public String getInsuranceID() {
        return insuranceID;
    }

    public void setPatientID(String patientID) {
        this.patientID = patientID;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setHealthHistory(String healthHistory) {
        this.healthHistory = healthHistory;
    }

    public void setInsuranceID(String insuranceID) {
        this.insuranceID = insuranceID;
    }

    public void storePatientInformation() {
        new File("patients").mkdirs();
        String filename = "patients/" + patientID + "_PatientInfo.txt";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            writer.write("PatientID: " + patientID);
            writer.newLine();
            writer.write("FirstName: " + firstName);
            writer.newLine();
            writer.write("LastName: " + lastName);
            writer.newLine();
            writer.write("Email: " + email);
            writer.newLine();
            writer.write("PhoneNumber: " + phoneNumber);
            writer.newLine();
            writer.write("HealthHistory: " + healthHistory);
            writer.newLine();
            writer.write("InsuranceID: " + insuranceID);
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static PatientRecord getPatientInformation(String patientID) {
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
}