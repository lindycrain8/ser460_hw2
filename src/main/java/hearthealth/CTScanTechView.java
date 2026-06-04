package hearthealth;

import hearthealth.model.CTTest;
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

public class CTScanTechView {

    private Stage stage;

    public CTScanTechView(Stage stage) {
        this.stage = stage;
    }

    public void show() {

        GridPane form = new GridPane();
        form.setHgap(10);
        form.setVgap(10);
        form.setAlignment(Pos.CENTER);

        TextField patientIDField = new TextField();
        TextField totalCACField = new TextField();
        TextField lmField = new TextField();
        TextField ladField = new TextField();
        TextField lcxField = new TextField();
        TextField rcaField = new TextField();
        TextField pdaField = new TextField();

        form.add(new Label("Patient ID:"), 0, 0);
        form.add(patientIDField, 1, 0);
        form.add(new Label("Total Agatston CAC Score:"), 0, 1);
        form.add(totalCACField, 1, 1);
        form.add(new Label("Vessel Level Agatston CAC Score:"), 0, 2);
        form.add(new Label(""), 1, 2);
        form.add(new Label("LM:"), 0, 3);
        form.add(lmField, 1, 3);
        form.add(new Label("LAD:"), 0, 4);
        form.add(ladField, 1, 4);
        form.add(new Label("LCX:"), 0, 5);
        form.add(lcxField, 1, 5);
        form.add(new Label("RCA:"), 0, 6);
        form.add(rcaField, 1, 6);
        form.add(new Label("PDA:"), 0, 7);
        form.add(pdaField, 1, 7);

        Button saveBtn = new Button("Save");
        Label confirmationLabel = new Label("");
        Button backBtn = new Button("Back to Main Menu");
        backBtn.setVisible(false);

        saveBtn.setOnAction(e -> {
            String patientID = patientIDField.getText();
            if (FileManager.loadPatientRecord(patientID) == null) {
                confirmationLabel.setText("Error: Wrong patient ID.");
                return;
            }
            try {
                CTTest ctTest = new CTTest(
                    patientID,
                    Integer.parseInt(totalCACField.getText()),
                    Integer.parseInt(lmField.getText()),
                    Integer.parseInt(ladField.getText()),
                    Integer.parseInt(lcxField.getText()),
                    Integer.parseInt(rcaField.getText()),
                    Integer.parseInt(pdaField.getText())
                );
                CTScanTechnician tech = new CTScanTechnician();
                tech.saveCTScanResults(ctTest);
                confirmationLabel.setText("CT scan results saved for patient ID: " + patientID);
                backBtn.setVisible(true);
            } catch (NumberFormatException ex) {
                confirmationLabel.setText("Error: All scores must be numbers.");
            }
        });

        backBtn.setOnAction(e -> new MainMenuView(stage).show());

        VBox layout = new VBox(15);
        layout.setAlignment(Pos.CENTER);
        layout.setPadding(new Insets(20));
        layout.getChildren().addAll(form, saveBtn, confirmationLabel, backBtn);

        Scene scene = new Scene(layout, 500, 500);
        stage.setScene(scene);
    }
}