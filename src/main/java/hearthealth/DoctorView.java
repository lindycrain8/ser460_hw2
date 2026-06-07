package hearthealth;

import hearthealth.model.CTTest;
import hearthealth.model.PatientRecord;
import hearthealth.util.FileManager;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class DoctorView {

    private Stage stage;

    public DoctorView(Stage stage) {
        this.stage = stage;
    }

    public void show() {
        TextField patientIDField = new TextField();
        Button viewResultsBtn = new Button("View Results");
        Label messageLabel = new Label("");

        GridPane idForm = new GridPane();
        idForm.setHgap(10);
        idForm.setVgap(10);
        idForm.setAlignment(Pos.CENTER);
        idForm.add(new Label("Patient ID:"), 0, 0);
        idForm.add(patientIDField, 1, 0);

        viewResultsBtn.setOnAction(e -> {
            String patientID = patientIDField.getText();
            PatientRecord record = FileManager.loadPatientRecord(patientID);
            if (record == null) {
                messageLabel.setText("Error: Wrong patient ID.");
                return;
            }
            CTTest ctTest = FileManager.loadCTTest(patientID);
            if (ctTest == null) {
                messageLabel.setText("No CT scan data available yet.");
                return;
            }
            showResults(record, ctTest);
        });

        VBox layout = new VBox(15);
        layout.setAlignment(Pos.CENTER);
        layout.setPadding(new Insets(20));
        layout.getChildren().addAll(idForm, viewResultsBtn, messageLabel);

        Scene scene = new Scene(layout, 500, 200);
        stage.setScene(scene);
    }

    private void showResults(PatientRecord record, CTTest ctTest) {
        HeartSpecialist specialist = new HeartSpecialist();

        TextField totalCACField = new TextField(String.valueOf(ctTest.getTotalCACScore()));
        totalCACField.setEditable(false);

        GridPane topPane = new GridPane();
        topPane.setHgap(10);
        topPane.setVgap(10);
        topPane.add(new Label("Total Agatston CAC score:"), 0, 0);
        topPane.add(totalCACField, 1, 0);

        TextField lmField = new TextField(String.valueOf(ctTest.getLMScore()));
        TextField ladField = new TextField(String.valueOf(ctTest.getLADScore()));
        TextField lcxField = new TextField(String.valueOf(ctTest.getLCXScore()));
        TextField rcaField = new TextField(String.valueOf(ctTest.getRCAScore()));
        TextField pdaField = new TextField(String.valueOf(ctTest.getPDAScore()));

        lmField.setEditable(false);
        ladField.setEditable(false);
        lcxField.setEditable(false);
        rcaField.setEditable(false);
        pdaField.setEditable(false);

        GridPane leftPane = new GridPane();
        leftPane.setHgap(10);
        leftPane.setVgap(10);
        leftPane.add(new Label("LM:"), 0, 0);
        leftPane.add(lmField, 1, 0);
        leftPane.add(new Label("LAD:"), 0, 1);
        leftPane.add(ladField, 1, 1);
        leftPane.add(new Label("LCX:"), 0, 2);
        leftPane.add(lcxField, 1, 2);
        leftPane.add(new Label("RAC:"), 0, 3);
        leftPane.add(rcaField, 1, 3);
        leftPane.add(new Label("PDA:"), 0, 4);
        leftPane.add(pdaField, 1, 4);

        TextArea riskArea = new TextArea();
        riskArea.setEditable(false);
        riskArea.setPrefWidth(200);
        riskArea.setPrefRowCount(8);
        riskArea.setWrapText(true);

        HBox middlePane = new HBox(20);
        middlePane.setAlignment(Pos.CENTER);
        middlePane.getChildren().addAll(leftPane, riskArea);

        Button determineRiskBtn = new Button("Determine Risk");
        determineRiskBtn.setOnAction(e -> {
            String risk = specialist.determineRisk(ctTest.getTotalCACScore());
            riskArea.setText(risk);
        });

        Button backBtn = new Button("Back to Main Menu");
        backBtn.setOnAction(e -> new MainMenuView(stage).show());

        VBox layout = new VBox(15);
        layout.setAlignment(Pos.CENTER);
        layout.setPadding(new Insets(20));
        layout.getChildren().addAll(topPane, middlePane, determineRiskBtn, backBtn);

        Scene scene = new Scene(layout, 600, 500);
        stage.setScene(scene);
    }
}