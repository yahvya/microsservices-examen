package yahvya.appointment.apis.googlecalendar;

import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.gson.GsonFactory;
import com.google.api.client.util.DateTime;
import com.google.api.services.calendar.CalendarScopes;
import com.google.api.services.calendar.model.Event;
import com.google.api.services.calendar.model.EventDateTime;
import com.google.auth.oauth2.ServiceAccountCredentials;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import com.google.api.services.calendar.Calendar;
import com.google.api.services.calendar.Calendar;

import java.io.FileInputStream;
import java.util.List;

@Service
public class GoogleCalendarService {
    @Autowired
    private Calendar service;

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
