package yahvya.appointment.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import yahvya.appointment.apis.googlecalendar.CalendarDataContract;
import yahvya.appointment.apis.googlecalendar.GoogleCalendarService;
import yahvya.appointment.response.Response;

import java.util.Map;

/**
 * @brief appointment treatment controller
 */
@RestController
@RequestMapping(path= "/appointment")
public class AppointmentController {
    @Autowired
    private GoogleCalendarService googleCalendarService;

    /**
     * @brief provide practitionner data contract
     * @param practitionnerId practionner id
     * @return response
     */
    @GetMapping(path = "/calendar/{practitionnerId}")
    public Response getPractitionnerCalendar(@PathVariable String practitionnerId) {
        CalendarDataContract practitionnerCalendar = this.googleCalendarService.getCalendarFor(practitionnerId);

        return new Response(practitionnerCalendar != null,practitionnerCalendar);
    }

    /**
     * @brief add a next appointment
     * @param requestBody body
     */
    @PostMapping("calendar/add")
    public Response addAppointment(
            @RequestBody Map<String, Object> requestBody
    ){
        CalendarDataContract practitionnerCalendar = this.googleCalendarService.addAppointmentToCalendar(
            (String) requestBody.get("practionner-id"),
            (String) requestBody.get("start-date"),
            (String) requestBody.get("end-date"),
            (String) requestBody.get("reason"),
            (String) requestBody.get("price"),
            (String) requestBody.get("patient-id")
        );

        return new Response(practitionnerCalendar != null,practitionnerCalendar);
    }
}
