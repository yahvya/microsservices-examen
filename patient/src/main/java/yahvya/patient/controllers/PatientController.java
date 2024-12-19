package yahvya.patient.controllers;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
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

    /**
     * @brief modify a patient
     * @param patient form patient
     * @return response
     */
    @PostMapping(name="patient.modify",path="/modify")
    public Response modifyPatient(@RequestBody @Valid Patient patient) {
        Patient modifiedPatient = this.patientService.modifyPatient(patient);

        return new Response(modifiedPatient != null,modifiedPatient);
    }

    /**
     * @brief patients list
     * @return list
     */
    @GetMapping(name="patient.list",path = "/list")
    public Response listPatient() {
        return new Response(true,this.patientService.getAll());
    }

    /**
     * @brief get particular patient info
     * @param patientId patient id
     * @return patient info
     */
    @GetMapping(name="patient.info",path = "/info/{patientId}")
    public Response getInfo(@PathVariable String patientId) {
        return new Response(true,this.patientService.getPatient(patientId));
    }

    /**
     * @brief delete particular patient info
     * @param patientId patient id
     * @return patient info
     */
    @PostMapping(name="patient.delete",path = "/delete/{patientId}")
    public Response delete(@PathVariable String patientId) {
        return new Response(this.patientService.deletePatient(patientId),null);
    }
}
