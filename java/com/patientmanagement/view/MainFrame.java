package com.patientmanagement.view;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class MainFrame extends JFrame {
    public MainFrame() {
        setTitle("Patient Management System");
        setSize(800, 600);
        setMinimumSize(new Dimension(700, 500));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Create the logoTop panel
        JPanel logoTop = new JPanel();
        logoTop.setBackground(Color.blue);
        add(logoTop, BorderLayout.NORTH);

        // Create the navigation panel
        JPanel navigationPanel = new JPanel();
        navigationPanel.setLayout(new GridLayout(4, 1));
        JButton createPatientButton = new JButton("Create Patient");
        JButton addNewPatientButton = new JButton("Add new Patient");
        JButton searchPatientButton = new JButton("Search Patient");
        JButton viewAllPatientsButton = new JButton("View All Patients");

        navigationPanel.add(createPatientButton);
        navigationPanel.add(addNewPatientButton);
        navigationPanel.add(searchPatientButton);
        navigationPanel.add(viewAllPatientsButton);

        add(navigationPanel, BorderLayout.WEST);

        // Create the content panel with CardLayout
        CardLayout cardLayout = new CardLayout();
        JPanel contentPanel = new JPanel(cardLayout);

        contentPanel.add(new CalendarMain(), "CalendarView");
        contentPanel.add(new AddNewPatient(), "AddNewPatient");
        contentPanel.add(new SearchPatientPanel(), "SearchPatient");
        contentPanel.add(new ViewAllPatientsPanel(), "ViewAllPatients");

        add(contentPanel, BorderLayout.CENTER);

        // Adjust logoTop height to be 15% of the frame height
        adjustLogoTopSize(logoTop);

        // Add component listener to handle resizing
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                adjustLogoTopSize(logoTop);
            }
        });

        createPatientButton.addActionListener(e -> cardLayout.show(contentPanel, "CreatePatient"));
        addNewPatientButton.addActionListener(e -> cardLayout.show(contentPanel, "AddNewPatient"));
        searchPatientButton.addActionListener(e -> cardLayout.show(contentPanel, "SearchPatient"));
        viewAllPatientsButton.addActionListener(e -> cardLayout.show(contentPanel, "ViewAllPatients"));
    }

    // Method to adjust the size of logoTop
    private void adjustLogoTopSize(JPanel logoTop) {
        int height = getHeight();
        double ratio;
    
        // Use a continuous formula for smoother scaling
        if (height < 600) {
            ratio = 0.15;  // Higher ratio for smaller heights
        } else if (height < 1000) {
            ratio = 0.15 - ((height - 600) * 0.05 / 400);  // Gradually decrease the ratio as height increases
        } else {
            ratio = 0.10 - ((height - 1000) * 0.02 / 500);  // Further decrease the ratio for larger heights
            ratio = Math.max(ratio, 0.08);  // Ensure the ratio doesn't go below 0.08
        }
    
        logoTop.setPreferredSize(new Dimension(getWidth(), (int) (height * ratio)));
        logoTop.revalidate();
    }
    

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MainFrame frame = new MainFrame();
            frame.setVisible(true);
        });
    }
}
