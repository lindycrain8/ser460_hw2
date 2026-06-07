package hearthealth.model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CTTest {
    private String patientID;
    private int totalCACScore;
    private int LMScore;
    private int LADScore;
    private int LCXScore;
    private int RCAScore;
    private int PDAScore;

    public CTTest(String patientID, int totalCACScore, int LMScore, int LADScore,
                  int LCXScore, int RCAScore, int PDAScore) {
        this.patientID = patientID;
        this.totalCACScore = totalCACScore;
        this.LMScore = LMScore;
        this.LADScore = LADScore;
        this.LCXScore = LCXScore;
        this.RCAScore = RCAScore;
        this.PDAScore = PDAScore;
    }

    public String getPatientID() {
        return patientID;
    }

    public int getTotalCACScore() {
        return totalCACScore;
    }

    public int getLMScore() {
        return LMScore;
    }

    public int getLADScore() {
        return LADScore;
    }

    public int getLCXScore() {
        return LCXScore;
    }

    public int getRCAScore() {
        return RCAScore;
    }

    public int getPDAScore() {
        return PDAScore;
    }

    public void setPatientID(String patientID) {
        this.patientID = patientID;
    }

    public void setTotalCACScore(int totalCACScore) {
        this.totalCACScore = totalCACScore;
    }

    public void setLMScore(int LMScore) {
        this.LMScore = LMScore;
    }

    public void setLADScore(int LADScore) {
        this.LADScore = LADScore;
    }

    public void setLCXScore(int LCXScore) {
        this.LCXScore = LCXScore;
    }

    public void setRCAScore(int RCAScore) {
        this.RCAScore = RCAScore;
    }

    public void setPDAScore(int PDAScore) {
        this.PDAScore = PDAScore;
    }

    public void storeCTScanData() {
        new File("records").mkdirs();
        String filename = "records/" + patientID + "_CTResults.txt";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            writer.write("PatientID: " + patientID);
            writer.newLine();
            writer.write("TotalCACScore: " + totalCACScore);
            writer.newLine();
            writer.write("LMScore: " + LMScore);
            writer.newLine();
            writer.write("LADScore: " + LADScore);
            writer.newLine();
            writer.write("LCXScore: " + LCXScore);
            writer.newLine();
            writer.write("RCAScore: " + RCAScore);
            writer.newLine();
            writer.write("PDAScore: " + PDAScore);
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static CTTest getCACScores(String patientID) {
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
}