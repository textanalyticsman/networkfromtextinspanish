/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.awt.Color;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JTextArea;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultHighlighter;

/**
 *
 * @author osboxes
 */
public class HighlightText {
    
    public JTextArea highLightText(String message)
    {
        /*
        I am taking this code from:
        https://stackoverflow.com/questions/15893235/java-highlighting-text-between-two-chars-jtextpane#comment22645825_15894004
        */
        JTextArea ed = new JTextArea(10, 30);
        ed.setEditable(false);
        ed.setFont(ed.getFont().deriveFont(16f)); // will only change size to 12pt
        
        //ed.setText("This \"text\" contains \"quotes\". The \"contents\" of which are highlighted");
        ed.setText(message);
        Pattern pl;
        pl=Pattern.compile("<");
        Matcher matcher = pl.matcher(ed.getText());
        int end=0,beg=0;
        while(matcher.find())
        {
            beg=matcher.start();
            matcher.find(); //finding the next quote
            end=matcher.start();
            DefaultHighlighter.DefaultHighlightPainter d =  new DefaultHighlighter.DefaultHighlightPainter(Color.YELLOW);
            try {
                ed.getHighlighter().addHighlight(beg+1, end+6,d);
            } catch (BadLocationException ex) {
                ex.printStackTrace();
            }
        }
        
        return ed;
    }    
    
}
