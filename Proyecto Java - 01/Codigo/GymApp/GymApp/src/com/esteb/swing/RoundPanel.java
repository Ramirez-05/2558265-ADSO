package com.esteb.swing;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JPanel;

public class RoundPanel extends JPanel {
    private Color startColor = Color.GRAY; // Color de inicio predeterminado
    private Color endColor = Color.GRAY;  // Color de finalización predeterminado

    public RoundPanel() {
        setOpaque(false);
    }

    public RoundPanel(Color startColor, Color endColor) {
        this.startColor = startColor;
        this.endColor = endColor;
        setOpaque(false);
    }

    @Override
    protected void paintComponent(Graphics grphcs) {
        super.paintComponent(grphcs);
        Graphics2D g2 = (Graphics2D) grphcs.create();

        int width = getWidth();
        int height = getHeight();

        GradientPaint gradient = new GradientPaint(0, 0, startColor, width, 0, endColor); // Cambio en las coordenadas

        g2.setPaint(gradient);

        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.fillRoundRect(0, 0, width, height, 15, 15);
        g2.dispose();
    }

    public void setStartColor(Color startColor) {
        this.startColor = startColor;
        repaint();
    }

    public void setEndColor(Color endColor) {
        this.endColor = endColor;
        repaint();
    }
}
