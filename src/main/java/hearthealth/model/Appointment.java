package hearthealth.model;

import java.util.Date;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

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
    
    public static Appointment provideAppointmentInfo(String patientID) {
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