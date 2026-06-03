package hearthealth.model;

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
        //to do
    }

    public void getCACScores() {
        //to do
    }
}