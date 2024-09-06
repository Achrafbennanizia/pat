package com.patientmanagement.view;

import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

public class ViewAllPatientsPanel extends JPanel {
    public ViewAllPatientsPanel() {
        String [] columnName = {"Fist Name", "Last Name", "Birthday", "Phone Number", "Adress"};
        String[][] dummyData = {
            {"John", "Doe", "1990-01-15", "555-1234", "123 Maple Street"},
            {"Jane", "Smith", "1985-07-24", "555-5678", "456 Oak Avenue"},
            {"Alice", "Johnson", "1992-11-30", "555-8765", "789 Pine Lane"},
            {"Bob", "Brown", "1988-03-12", "555-4321", "321 Cedar Road"},
            {"Charlie", "Davis", "1995-08-05", "555-6789", "654 Spruce Street"}
        };
        JTable patienTable = new JTable(dummyData,columnName){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        patienTable.setRowHeight(30);
        patienTable.getTableHeader().setFont(new Font("Arial", Font.BOLD, 18));
        patienTable.setFont(new Font("Arial", Font.PLAIN, 16)); 
        patienTable.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        patienTable.setColumnSelectionAllowed(false);
        JScrollPane scrollPane = new JScrollPane(patienTable);
        setLayout(new BorderLayout());
        add(scrollPane, BorderLayout.CENTER);
    }
}
