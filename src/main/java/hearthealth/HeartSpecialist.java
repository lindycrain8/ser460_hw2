package hearthealth;

import hearthealth.model.CTTest;
import hearthealth.model.User;
import hearthealth.util.FileManager;

public class HeartSpecialist extends User {

    public HeartSpecialist() {
        super("", "", "HeartSpecialist");
    }

    public void reviewCTScanResults(String patientID) {
        CTTest ctTest = FileManager.loadCTTest(patientID);
        if (ctTest != null) {
            ctTest.getCACScores();
        }
    }

    public String determineRisk(int totalCACScore) {
        if (totalCACScore == 0) {
            return "Zero: No plaque. Your risk of heart attack is low.";
        } else if (totalCACScore <= 10) {
            return "1-10: Small amount of plaque. You have less than a 10 percent chance of having heart disease, and your risk of heart attack is low.";
        } else if (totalCACScore <= 100) {
            return "11-100: Some plaque. You have mild heart disease and a moderate chance of heart attack.";
        } else if (totalCACScore <= 400) {
            return "101-400: Moderate amount of plaque. You have heart disease and plaque may be blocking an artery.";
        } else {
            return "Over 400: Large amount of plaque. You have more than a 90 percent chance that plaque is blocking one of your arteries.";
        }
    }

    public void communicateResultsToPatient(String email, String risk) {
        //to do
        System.out.println("Emailing " + email + " with risk: " + risk);
    }
}