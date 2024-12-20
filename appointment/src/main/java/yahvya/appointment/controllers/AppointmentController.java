package yahvya.appointment.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import yahvya.appointment.apis.googlecalendar.CalendarDataContract;
import yahvya.appointment.apis.googlecalendar.GoogleCalendarService;

/**
 * @brief appointment treatment controller
 */
@RestController
@RequestMapping(path= "/appointment")
public class AppointmentController {
    @Autowired
    private GoogleCalendarService googleCalendarService;

    @GetMapping("/test")
    public CalendarDataContract test(){
        return this.googleCalendarService.createNewCalendarFor("asta");
    }
}
