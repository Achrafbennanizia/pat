package com.patientmanagement.controller;

import com.patientmanagement.model.Patient;
import com.patientmanagement.model.PatientDatabase;

public class PatientController {
    private PatientDatabase patientDatabase;

    public PatientController(PatientDatabase patientDatabase) {
        this.patientDatabase = patientDatabase;
    }

    public void addPatient(Patient patient) {
        patientDatabase.addPatient(patient);
    }

    public Patient searchPatientById(String id) {
        return patientDatabase.searchPatientById(id);
    }

    // Other methods to handle different operations
}
