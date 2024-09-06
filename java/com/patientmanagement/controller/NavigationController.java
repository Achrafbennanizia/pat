package com.patientmanagement.controller;

import javax.swing.*;
import java.awt.*;

public class NavigationController {
    private CardLayout cardLayout;
    private JPanel contentPanel;

    public NavigationController(CardLayout cardLayout, JPanel contentPanel) {
        this.cardLayout = cardLayout;
        this.contentPanel = contentPanel;
    }

    public void showPanel(String panelName) {
        cardLayout.show(contentPanel, panelName);
    }
}
