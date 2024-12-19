package yahvya.patient.controllers;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import yahvya.patient.datacontracts.patient.Patient;
import yahvya.patient.datacontracts.patient.PatientService;
import yahvya.patient.response.Response;

/**
 * @brief patient management controller
 */
@RestController
@RequestMapping(path= "/patient",name = "patient")
public class PatientController {
    @Autowired
    private PatientService patientService;

    /**
     * @brief create a new patient
     * @param patient form patient
     * @return response
     */
    @PostMapping(name="patient.add",path="/add")
    public Response addPatient(@RequestBody @Valid Patient patient) {
        Patient createdPatient = this.patientService.addPatient(patient);

        return new Response(createdPatient != null,createdPatient);
    }
}
