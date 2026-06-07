package hearthealth.model;

import hearthealth.util.FileManager;

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
        FileManager.savePatientRecord(this);
    }

    public void getPatientInformation() {
        FileManager.loadPatientRecord(this.patientID);
    }
}