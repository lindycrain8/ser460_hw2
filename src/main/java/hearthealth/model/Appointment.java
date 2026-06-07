package hearthealth.model;

import java.util.Date;

public class Appointment {
    private String appointmentID;
    private String patientID;
    private Date appointmentDate;

    public Appointment(String appointmentID, String patientID, Date appointmentDate) {
        this.appointmentID = appointmentID;
        this.patientID = patientID;
        this.appointmentDate = appointmentDate;
    }

    public String getAppointmentID() {
        return appointmentID;
    }

    public String getPatientID() {
        return patientID;
    }

    public Date getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentID(String appointmentID) {
        this.appointmentID = appointmentID;
    }

    public void setPatientID(String patientID) {
        this.patientID = patientID;
    }

    public void setAppointmentDate(Date appointmentDate) {
        this.appointmentDate = appointmentDate;
    }
}