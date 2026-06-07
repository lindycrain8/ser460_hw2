package hearthealth.view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MainMenuView {

    private Stage stage;

    public MainMenuView(Stage stage) {
        this.stage = stage;
    }

    public void show() {
        Label title = new Label("Welcome to Heart Health Imaging and Recording System");

        Button patientIntakeBtn = new Button("Patient Intake");
        Button ctScanTechBtn = new Button("CT Scan Tech View");
        Button patientViewBtn = new Button("Patient View");
        Button doctorViewBtn = new Button("Doctor View");
        Button exitBtn = new Button("Exit");

        patientIntakeBtn.setPrefWidth(200);
        ctScanTechBtn.setPrefWidth(200);
        patientViewBtn.setPrefWidth(200);
        doctorViewBtn.setPrefWidth(200);
        exitBtn.setPrefWidth(200);

        patientIntakeBtn.setOnAction(e -> new PatientIntakeView(stage).show());
        ctScanTechBtn.setOnAction(e -> new CTScanTechView(stage).show());
        patientViewBtn.setOnAction(e -> new PatientView(stage).show());
        doctorViewBtn.setOnAction(e -> new DoctorView(stage).show());
        exitBtn.setOnAction(e -> System.exit(0));

        VBox layout = new VBox(15);
        layout.setAlignment(Pos.CENTER);
        layout.setPadding(new Insets(20));
        layout.getChildren().addAll(title, patientIntakeBtn, ctScanTechBtn,
                                    patientViewBtn, doctorViewBtn, exitBtn);

        Scene scene = new Scene(layout, 500, 400);
        stage.setTitle("Heart Health Imaging and Recording System");
        stage.setScene(scene);
        stage.show();
    }
}