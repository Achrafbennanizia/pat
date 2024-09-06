package com.patientmanagement.view;

import com.patientmanagement.controller.CalendarController;
import com.patientmanagement.model.CalendarModel;
import java.awt.Panel;

public class CalendarMain extends Panel {
    public CalendarMain() {
        CalendarModel model = new CalendarModel();
        CalendarView view = new CalendarView(new CalendarController(model, null)); // Create a separate view object
        CalendarController controller = new CalendarController(model, view); // Pass the view object

        add(view); // Add the view to the panel
    }
}
