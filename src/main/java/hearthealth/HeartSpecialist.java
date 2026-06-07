package hearthealth;

import hearthealth.model.CTTest;
import hearthealth.model.User;

public class HeartSpecialist extends User {

    public HeartSpecialist() {
        super("", "", "HeartSpecialist");
    }

    public void reviewCTScanResults(String patientID) {
        CTTest.getCACScores(patientID);
    }

    public String determineRisk(int totalCACScore) {
        if (totalCACScore == 0) {
            return "Zero: No plaque. Your risk of heart attack is low.";
        } else if (totalCACScore <= 10) {
            return "1-10: Small amount of plaque. You have less than a 10 percent chance of having heart disease, and your risk of heart attack is low.";
        } else if (totalCACScore <= 100) {
            return "11-100: Some plaque. You have mild heart disease and a moderate chance of heart attack. Your doctor may recommend other treatment in "
                    + "addition to lifestyle changes.";
        } else if (totalCACScore <= 400) {
            return "101-400: Moderate amount of plaque. You have mild heart disease and plaque may be blocking an artery. Your chance of having a heart attack "
                    + "is moderate to high. Your health professional may want more tests and may start treatment.";
        } else {
            return "Over 400: Large amount of plaque. You have more than a 90 percent chance that plaque is blocking one of your arteries. "
                    + "Your chance of heart attack is high. Your health professional will want more tests and will start treatment.";
        }
    }
}