package hearthealth;

import hearthealth.model.CTTest;
import hearthealth.model.User;
import hearthealth.util.FileManager;

public class CTScanTechnician extends User {

    public CTScanTechnician() {
        super("", "", "CTScanTechnician");
    }

    public void recordCACScore(CTTest ctTest) {
        FileManager.saveCTTest(ctTest);
    }

    public void saveCTScanResults(CTTest ctTest) {
        FileManager.saveCTTest(ctTest);
    }
}