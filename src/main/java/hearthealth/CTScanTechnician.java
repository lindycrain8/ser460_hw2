package hearthealth;

import hearthealth.model.CTTest;
import hearthealth.model.User;

public class CTScanTechnician extends User {

    public CTScanTechnician() {
        super("", "", "CTScanTechnician");
    }

    public void recordCACScore(CTTest ctTest) {
        ctTest.storeCTScanData();
    }

    public void saveCTScanResults(CTTest ctTest) {
        ctTest.storeCTScanData();
    }
}