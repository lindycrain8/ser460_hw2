# Heart Health Imaging and Recording System

A JavaFX-based GUI application for heart health imaging labs to manage patient records and CT scan results.

## Requirements
- Java 11
- JavaFX 11 SDK

## Running the Application
1. Open the project in Eclipse
2. Configure the JavaFX SDK in your build path
3. Add the following VM arguments to your run configuration:
   `--module-path "path/to/javafx-sdk-11/lib" --add-modules javafx.controls,javafx.fxml`
4. Right-click `Main.java` → Run As → Java Application

## Data Storage
All data is stored in text files in the following folders:
- `patients/` — patient information files (`patientID_PatientInfo.txt`)
- `records/` — CT scan results files (`patientID_CTResults.txt`)
- `appointments/` — appointment files (`patientID_Appointment.txt`)

## Features
- **Patient Intake** — Receptionist enters patient information and schedules exam date. A unique 5-digit patient ID is automatically generated.
- **CT Scan Tech View** — Technician looks up patient by ID, views appointment date, and records Agatston CAC scores.
- **Patient View** — Patient enters their ID to view CT scan results.
- **Doctor View** — Heart specialist views CT scan results and determines patient risk based on Agatston CAC score criteria.

## Project Structure
- `hearthealth.model` — Entity classes (User, Role, PatientRecord, CTTest, Appointment)
- `hearthealth` — Boundary classes (Patient, Receptionist, CTScanTechnician, HeartSpecialist)
- `hearthealth.view` — JavaFX view classes