package hearthealth;

import hearthealth.model.PatientRecord;
import hearthealth.util.FileManager;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class PatientIntakeView {

    private Stage stage;

    public PatientIntakeView(Stage stage) {
        this.stage = stage;
    }

    public void show() {
        Label title = new Label("Patient Intake Form");

        GridPane form = new GridPane();
        form.setHgap(10);
        form.setVgap(10);
        form.setAlignment(Pos.CENTER);

        TextField firstNameField = new TextField();
        TextField lastNameField = new TextField();
        TextField emailField = new TextField();
        TextField phoneField = new TextField();
        TextArea healthHistoryField = new TextArea();
        healthHistoryField.setPrefRowCount(3);
        TextField insuranceIDField = new TextField();

        form.add(new Label("First Name:"), 0, 0);
        form.add(firstNameField, 1, 0);
        form.add(new Label("Last Name:"), 0, 1);
        form.add(lastNameField, 1, 1);
        form.add(new Label("Email:"), 0, 2);
        form.add(emailField, 1, 2);
        form.add(new Label("Phone Number:"), 0, 3);
        form.add(phoneField, 1, 3);
        form.add(new Label("Health History:"), 0, 4);
        form.add(healthHistoryField, 1, 4);
        form.add(new Label("Insurance ID:"), 0, 5);
        form.add(insuranceIDField, 1, 5);

        Button saveBtn = new Button("Save");
        Button backBtn = new Button("Back to Main Menu");
        backBtn.setVisible(false);

        Label confirmationLabel = new Label("");

        saveBtn.setOnAction(e -> {
            String patientID = new Receptionist().generatePatientID();
            PatientRecord record = new PatientRecord(
                patientID,
                firstNameField.getText(),
                lastNameField.getText(),
                emailField.getText(),
                phoneField.getText(),
                healthHistoryField.getText(),
                insuranceIDField.getText()
            );
            FileManager.savePatientRecord(record);
            confirmationLabel.setText("Patient saved. ID: " + patientID);
            backBtn.setVisible(true);
        });
        
        backBtn.setOnAction(e -> new MainMenuView(stage).show());

        VBox layout = new VBox(15);
        layout.setAlignment(Pos.CENTER);
        layout.setPadding(new Insets(20));
        layout.getChildren().addAll(title, form, saveBtn, confirmationLabel, backBtn);

        Scene scene = new Scene(layout, 500, 500);
        stage.setScene(scene);
    }
}