package com.patientmanagement.view;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent; // Changed import

import com.patientmanagement.controller.*;

public class CalendarView extends Component {
    private CalendarController controller;

    public CalendarView(CalendarController controller) {
        this.controller = controller;
        setupListeners();  // Delegates handling to the controller
    }
 
    @Override // Override annotation added
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Drawing logic goes here
    }

    private void setupListeners() {
        this.addMouseListener(new MouseAdapter() {
            @Override // Override annotation added
            public void mouseClicked(MouseEvent e) {
                controller.handleMouseClick(e.getPoint());  // Delegate to controller
            }
        });
    }
}

