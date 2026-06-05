package hearthealth;

import hearthealth.model.CTTest;
import hearthealth.model.PatientRecord;
import hearthealth.util.FileManager;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class PatientView {

    private Stage stage;

    public PatientView(Stage stage) {
        this.stage = stage;
    }

    public void show() {
        TextField patientIDField = new TextField();
        Button resultsBtn = new Button("View Results");
        Label messageLabel = new Label("");

        VBox layout = new VBox(15);
        layout.setAlignment(Pos.CENTER);
        layout.setPadding(new Insets(20));

        GridPane idForm = new GridPane();
        idForm.setHgap(10);
        idForm.setVgap(10);
        idForm.setAlignment(Pos.CENTER);
        idForm.add(new Label("Patient ID:"), 0, 0);
        idForm.add(patientIDField, 1, 0);

        resultsBtn.setOnAction(e -> {
            String patientID = patientIDField.getText();
            PatientRecord record = FileManager.loadPatientRecord(patientID);
            if (record == null) {
                messageLabel.setText("Error: Wrong patient ID.");
                return;
            }
            CTTest ctTest = FileManager.loadCTTest(patientID);
            if (ctTest == null) {
                messageLabel.setText("No CT scan data is available.");
                return;
            }
            showResults(record, ctTest);
        });

        layout.getChildren().addAll(idForm, resultsBtn, messageLabel);
        Scene scene = new Scene(layout, 500, 200);
        stage.setScene(scene);
    }

    private void showResults(PatientRecord record, CTTest ctTest) {
        Label greeting = new Label("Hello " + record.getFirstName() + " " + record.getLastName());
        Label totalCAC = new Label("Total Agatston CAC Score: " + ctTest.getTotalCACScore());
        Label lm = new Label("LM: " + ctTest.getLMScore());
        Label lad = new Label("LAD: " + ctTest.getLADScore());
        Label lcx = new Label("LCX: " + ctTest.getLCXScore());
        Label rca = new Label("RCA: " + ctTest.getRCAScore());
        Label pda = new Label("PDA: " + ctTest.getPDAScore());
        Button backBtn = new Button("Back to Main Menu");
        backBtn.setOnAction(e -> new MainMenuView(stage).show());

        VBox layout = new VBox(15);
        layout.setAlignment(Pos.CENTER);
        layout.setPadding(new Insets(20));
        layout.getChildren().addAll(greeting, totalCAC, lm, lad, lcx, rca, pda, backBtn);

        Scene scene = new Scene(layout, 500, 400);
        stage.setScene(scene);
    }
}