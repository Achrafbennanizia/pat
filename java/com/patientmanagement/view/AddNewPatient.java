package com.patientmanagement.view;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;
import javax.swing.text.AbstractDocument;
import javax.swing.text.DocumentFilter;

public class AddNewPatient extends JPanel {
    
    public AddNewPatient() {
        // Set layout manager
        setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets = new Insets(10, 10, 10, 10); // Increase padding
        constraints.fill = GridBagConstraints.HORIZONTAL;
        
        // Common font for labels and text fields
        Font font = new Font("Arial", Font.PLAIN, 18);

        // First Name
        JLabel lbFirstName = new JLabel("First Name:");
        lbFirstName.setFont(font);
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 1;  // Span 1 column
        add(lbFirstName, constraints);
        
        JTextField txFirstName = new JTextField(20);
        txFirstName.setPreferredSize(new Dimension(250, 30)); // Increase size
        txFirstName.setFont(font);
        constraints.gridx = 1;
        constraints.gridwidth = 3;  // Span 3 columns
        add(txFirstName, constraints);
        
        // Last Name
        JLabel lbLastName = new JLabel("Last Name:");
        lbLastName.setFont(font);
        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.gridwidth = 1;  // Span 1 column
        add(lbLastName, constraints);
        
        JTextField txLastName = new JTextField(20);
        txLastName.setPreferredSize(new Dimension(250, 30)); // Increase size
        txLastName.setFont(font);
        constraints.gridx = 1;
        constraints.gridwidth = 3;  // Span 3 columns
        add(txLastName, constraints);
        
        // Gender
        JLabel lbGender = new JLabel("Gender:");
        lbGender.setFont(font);
        constraints.gridx = 0;
        constraints.gridy = 2;
        constraints.gridwidth = 1;  // Span 1 column
        add(lbGender, constraints);
        
        JPanel genderPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 0));
        ButtonGroup genderGroup = new ButtonGroup();
        JRadioButton btnGenderMale = new JRadioButton("Male");
        JRadioButton btnGenderFemale = new JRadioButton("Female");
        btnGenderMale.setFont(font);
        btnGenderFemale.setFont(font);
        genderGroup.add(btnGenderMale);
        genderGroup.add(btnGenderFemale);
        genderPanel.add(btnGenderMale);
        genderPanel.add(btnGenderFemale);
        
        constraints.gridx = 1;
        constraints.gridwidth = 3;  // Span 3 columns
        add(genderPanel, constraints);
        
        // Birthday
        // Birthday Label
        JLabel lbBirthday = new JLabel("Birthday:");
        lbBirthday.setFont(font);
        constraints.gridx = 0;
        constraints.gridy = 3;
        constraints.gridwidth = 1;  // Span 1 column
        constraints.anchor = GridBagConstraints.WEST;
        add(lbBirthday, constraints);

        // JXDatePicker for Birthday
        SpinnerDateModel dateModel = new SpinnerDateModel();
        JSpinner dateSpinner = new JSpinner(dateModel);
        dateSpinner.setFont(font);
        JSpinner.DateEditor dateEditor = new JSpinner.DateEditor(dateSpinner, "dd/MM/yyyy");
        dateSpinner.setEditor(dateEditor);
        dateSpinner.setPreferredSize(new Dimension(250, 30)); // Increase size
        constraints.gridx = 1;
        constraints.gridwidth = 3;  // Span 3 columns
        add(dateSpinner, constraints);
        
        // Address
        JLabel lbAddress = new JLabel("Address:");
        lbAddress.setFont(font);
        constraints.gridx = 0;
        constraints.gridy = 4;
        constraints.gridwidth = 1;  // Span 1 column
        add(lbAddress, constraints);
        
        JTextField txAddress = new JTextField(20);
        txAddress.setPreferredSize(new Dimension(250, 30)); // Increase size
        txAddress.setFont(font);
        constraints.gridx = 1;
        constraints.gridwidth = 3;  // Span 3 columns
        add(txAddress, constraints);
        
        // Number
        JLabel lbNumber = new JLabel("Number:");
        lbNumber.setFont(font);
        constraints.gridx = 0;
        constraints.gridy = 5;
        constraints.gridwidth = 1;  // Span 1 column
        add(lbNumber, constraints);
        
        JTextField txNumber = new JTextField(20);
        txNumber.setPreferredSize(new Dimension(250, 30)); // Increase size
        txNumber.setFont(font);
       ((AbstractDocument) txNumber.getDocument()).setDocumentFilter(new NumericDocumentFilter());
        constraints.gridx = 1;
        constraints.gridwidth = 3;  // Span 3 columns
        add(txNumber, constraints);
        
        // Submit Button
        JButton btnSubmit = new JButton("Submit");
        btnSubmit.setPreferredSize(new Dimension(150, 40)); // Increase size
        btnSubmit.setFont(new Font("Arial", Font.BOLD, 18));
        constraints.gridx = 0;
        constraints.gridy = 6;
        constraints.gridwidth = 4;  // Span all 4 columns to center it
        constraints.anchor = GridBagConstraints.CENTER;
        add(btnSubmit, constraints);
        
        // ActionListener for submit button
        btnSubmit.addActionListener(e -> {
            String firstName = txFirstName.getText();
            String lastName = txLastName.getText();
            String gender = btnGenderMale.isSelected() ? "Male" : "Female";
            String birthday = dateModel.toString();
            String address = txAddress.getText();
            String number = txNumber.getText();
            
            // Handle form submission (e.g., save to database or display a message)
            System.out.println("Patient Info: " + firstName + " " + lastName + ", " + gender + ", " + birthday + ", " + address + ", " + number);
        });
    }
    static class NumericDocumentFilter extends DocumentFilter {
        @Override
        public void insertString(FilterBypass fb, int offset, String string, javax.swing.text.AttributeSet attr) throws javax.swing.text.BadLocationException {
            if (string == null) {
                return;
            }
            if (isNumeric(string)) {
                super.insertString(fb, offset, string, attr);
            }
        }

        @Override
        public void replace(FilterBypass fb, int offset, int length, String text, javax.swing.text.AttributeSet attrs) throws javax.swing.text.BadLocationException {
            if (text == null) {
                return;
            }
            if (isNumeric(text)) {
                super.replace(fb, offset, length, text, attrs);
            }
        }

        @Override
        public void remove(FilterBypass fb, int offset, int length) throws javax.swing.text.BadLocationException {
            super.remove(fb, offset, length);
        }

        private boolean isNumeric(String text) {
            try {
                Integer.parseInt(text);
                return true;
            } catch (NumberFormatException e) {
                return false;
            }
        }
    }
}
