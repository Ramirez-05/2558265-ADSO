
package com.esteb.swing;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Area;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RoundRectangle2D;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class MenuButton extends JButton{
    
    
    public float getAnimate(){
        return animate;
    }
    
    public void setAnimate(float animate){
        this.animate = animate;
        repaint();
    }
    
    public int getIndex(){
        return index;
    }
    
    private float animate;
    private int index;
    
    public MenuButton(int index){
        this.index = index;
        setContentAreaFilled(false);
        setForeground(new Color(189,189,189));
        setCursor(new Cursor(Cursor.HAND_CURSOR));
        setHorizontalAlignment(SwingConstants.LEFT);
        setBackground(new Color(65, 65 ,65) );
        setBorder(new EmptyBorder(8,20,8,15));
    }
    
    
    public void paint(Graphics graphics) {
        Graphics2D g2 = (Graphics2D) graphics.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        double width = getWidth();
        double height = getHeight();
        double x = animate * width - width;

        // Dibuja el rectángulo principal
        g2.setColor(new Color(65, 65, 65));
        g2.fillRect((int) x, 0, (int) width, (int) height);

        // Dibuja el rectángulo redondeado
        int cornerRadius = 10; // Ajusta según tu preferencia
        RoundRectangle2D roundedRectangle = new RoundRectangle2D.Double(x, 0, width, height, cornerRadius, cornerRadius);
        g2.setColor(new Color(65, 65, 65));
        g2.fill(roundedRectangle);

        super.paint(g2);
        g2.dispose();
}


}
