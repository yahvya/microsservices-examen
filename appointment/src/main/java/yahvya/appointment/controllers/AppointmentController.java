package yahvya.appointment.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import yahvya.appointment.apis.googlecalendar.GoogleCalendarService;

@RestController
@RequestMapping(path="appointment")
public class AppointmentController {
    @Autowired
    private GoogleCalendarService googleCalendarService;

    @GetMapping(path="/test")
    public String test(){
        this.googleCalendarService.test();
        return "test";
    }
}
