package yahvya.appointment.apis.googlecalendar;

import com.google.api.client.util.DateTime;
import com.google.api.services.calendar.model.Calendar;
import com.google.api.services.calendar.model.Event;

import java.util.ArrayList;
import java.util.List;

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

    public List<CalendarEventDataContract> events = new ArrayList<CalendarEventDataContract>();

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

    /**
     * @brief event data contract
     */
    public static class CalendarEventDataContract {
        /**
         * @brief event id
         */
        public String id;

        /**
         * @brief patient id
         */
        public String patientId;

        /**
         * @brief appointment reason
         */
        public String reason;

        /**
         * @brief start date
         */
        public DateTime startDate;

        /**
         * @brief end date
         */
        public DateTime endDate;

        /**
         * @brief price
         */
        public String price;

        /**
         * @brief convert google event to this
         * @param event google event
         * @return this instance
         */
        public static CalendarEventDataContract fromGoogleEvent(Event event){
            CalendarEventDataContract data = new CalendarEventDataContract();

            data.id = event.getId();
            data.patientId = event.getSummary();
            data.reason = event.getDescription();
            data.startDate = event.getStart().getDateTime();
            data.endDate = event.getEnd().getDateTime();
            Event.ExtendedProperties properties = event.getExtendedProperties();
            if(properties != null)
                data.price = properties.get("price").toString();

            return data;
        }
    }
}
