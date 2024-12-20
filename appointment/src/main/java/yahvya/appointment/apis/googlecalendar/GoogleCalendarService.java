package yahvya.appointment.apis.googlecalendar;

import com.google.api.client.util.DateTime;
import com.google.api.services.calendar.model.CalendarListEntry;
import com.google.api.services.calendar.model.Event;
import com.google.api.services.calendar.model.EventDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.google.api.services.calendar.Calendar;

import java.util.List;

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
     * @return the created calendar data or null on failure
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

    /**
     * @brief get a practitionner calendar
     * @param practitionnerId practitionner id
     * @return the calendar or null
     */
    public CalendarDataContract getCalendarFor(String practitionnerId){
        try{
             List<CalendarListEntry> items = this.calendarService.calendarList().list().execute().getItems();

            for(CalendarListEntry item : items){
                // find calendar
                if(item.getSummary().equals(practitionnerId)){
                    CalendarDataContract calendar = CalendarDataContract.fromGoogleCalendar(this.calendarService.calendars().get(item.getId()).execute());

                    // fill calendar with his events
                    this.calendarService.events().list(calendar.id).execute().getItems().forEach(event -> calendar.events.add(CalendarDataContract.CalendarEventDataContract.fromGoogleEvent(event)));

                    return calendar;
                }
            }

            return this.createNewCalendarFor(practitionnerId);
        }
        catch(Exception e){
            System.out.println(e);
            return null;
        }
    }

    /**
     * @brief add appointment
     * @param practitionnerId practionner id
     * @param startDate start date
     * @param endDate end date
     * @param reason reason
     * @param price price
     * @param patientId patient id
     * @return whole calendar
     */
    public CalendarDataContract addAppointmentToCalendar(String practitionnerId, String startDate,String endDate,String reason,String price,String patientId){
        try {
            CalendarDataContract calendar = this.getCalendarFor(practitionnerId);

            if (calendar == null)
                calendar = this.createNewCalendarFor(practitionnerId);

            if (calendar == null)
                return null;

            Event event = new Event()
                    .setSummary(patientId)
                    .setDescription(reason)
                    .setStart(new EventDateTime().setDateTime(new DateTime(startDate)))
                    .setEnd(new EventDateTime().setDateTime(new DateTime(endDate)))
                    .setExtendedProperties(new Event.ExtendedProperties().set("price", price));

            Event createdEvent =this.calendarService.events().insert(calendar.id,event).execute();

            calendar.events.add(CalendarDataContract.CalendarEventDataContract.fromGoogleEvent(createdEvent));

            return calendar;
        }
        catch(Exception e){
            return null;
        }
    }
}
