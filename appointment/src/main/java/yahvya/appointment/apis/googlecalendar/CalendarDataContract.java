package yahvya.appointment.apis.googlecalendar;

import com.google.api.services.calendar.model.Calendar;

/**
 * @brief calendar data contract
 */
public class CalendarDataContract {
    /**
     * @brief calendar id
     */
    public String id;

    /**
     * @brief practitioner id
     */
    public String practitionerId;

    /**
     * @brief create an instance from google calendar
     * @param calendar calendar from google
     * @return instance
     */
    public static CalendarDataContract fromGoogleCalendar(Calendar calendar) {
        CalendarDataContract data = new CalendarDataContract();

        data.id = calendar.getId();
        data.practitionerId = calendar.getSummary();

        return data;
    }
}
