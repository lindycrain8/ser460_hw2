package hearthealth;

import hearthealth.model.CTTest;
import hearthealth.model.PatientRecord;
import hearthealth.model.User;
import hearthealth.util.FileManager;

public class Patient extends User {

    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String healthHistory;
    private String insuranceID;
    private PatientRecord patientRecord;

    public Patient() {
        super("", "", "Patient");
    }
    
    public void setPatientRecord(PatientRecord patientRecord) {
        this.patientRecord = patientRecord;
    }
    
    public PatientRecord getPatientRecord() {
        return this.patientRecord;
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

    public void viewCTScanResults(String patientID) {
        CTTest ctTest = FileManager.loadCTTest(patientID);
        if (ctTest != null) {
            ctTest.getCACScores();
        }
    }

    public void login() {
        //to do
    }
}