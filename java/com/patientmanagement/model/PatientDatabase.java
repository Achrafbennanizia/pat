package com.patientmanagement.model;

import java.util.ArrayList;
import java.util.List;

public class PatientDatabase {
    private List<Patient> patients;

    public PatientDatabase() {
        patients = new ArrayList<>();
    }

    public void addPatient(Patient patient) {
        patients.add(patient);
    }

    public List<Patient> getAllPatients() {
        return patients;
    }

    public Patient searchPatientById(String id) {
        for (Patient patient : patients) {
            if (patient.getId().equals(id)) {
                return patient;
            }
        }
        return null;
    }

    // Additional methods like delete, update, etc.
}
