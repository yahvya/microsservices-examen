package yahvya.appointment.apis.googlecalendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.google.api.services.calendar.Calendar;

/**
 * @brief calendar service
 */
@Service
public class GoogleCalendarService {
    /**
     * @brief calendar service
     */
    @Autowired
    private Calendar calendarService;

    /**
     * @brief create a calendar for a practitionner
     * @param practitionnerId practitionner id
     * @return the created calendar data
     */
    public CalendarDataContract createNewCalendarFor(String practitionnerId){
        try{
            com.google.api.services.calendar.model.Calendar newCalendar = new com.google.api.services.calendar.model.Calendar();
            newCalendar.setSummary(practitionnerId);

            return CalendarDataContract.fromGoogleCalendar(this.calendarService.calendars().insert(newCalendar).execute());
        }
        catch(Exception e){
            return null;
        }
    }

    public void test(){
        try{

            // créer un
            /*
            var testCalendaer = new com.google.api.services.calendar.model.Calendar();

            testCalendaer.setSummary("Test Summary");
            testCalendaer.setTimeZone("UTC");

            System.out.println(service.calendars().insert(testCalendaer).execute());
            */
            // récupérer la liste
            /*
             System.out.println(service.calendarList().list().execute().getItems());
             */
            // ajouter un évènement
            /*
            var id = service.calendarList().list().execute().getItems().get(0).getId();
            var event = new Event().setSummary("Réunion avec l'équipe")
                    .setDescription("Discuter du projet X et de l'avancement")
                    .setLocation("Paris, France")
                    .setStart(new EventDateTime()
                            .setDateTime(new DateTime("2024-12-20T10:00:00+01:00"))
                            .setTimeZone("Europe/Paris"))
                    .setEnd(new EventDateTime()
                            .setDateTime(new DateTime("2024-12-20T11:00:00+01:00"))
                            .setTimeZone("Europe/Paris"));

            System.out.println(service.events().insert(id, event).execute());
             */
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
}
