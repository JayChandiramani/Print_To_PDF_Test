package com.jetbrain;

import javax.swing.*;
import java.awt.*;
import java.io.FileOutputStream;

import com.itextpdf.text.Document;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfTemplate;
import com.itextpdf.text.pdf.PdfWriter;

public class Main {

    public static void main(String[] args) {
        JPanel spane = new JPanel();
        spane.setVisible(true);

//just to ensure that the panel has content...
        JLabel label = new JLabel("i am a label");
        spane.add(new JLabel("i am a label"));
        spane.add(new JLabel("i am a label"));
        spane.add(new JLabel("i am a label"));
        spane.add(new JLabel("i am a label"));
        spane.add(new JLabel("i am a label"));
        spane.add(new JLabel("i am a label"));
        spane.add(new JLabel("i am a label"));
        spane.add(new JLabel("i am a label"));
        spane.add(new JLabel("i am a label"));
        spane.add(new JLabel("i am a label"));
        spane.add(new JLabel("i am a label"));
        spane.add(new JLabel("i am a label"));
        spane.add(new JLabel("i am a label"));
        spane.add(new JLabel("i am a label"));
        spane.add(new JLabel("i am a label"));
        spane.add(new JLabel("i am a label"));
        spane.add(new JLabel("i am a label"));
        spane.add(new JLabel("i am a label"));
        spane.add(new JLabel("i am a label"));
        spane.add(new JLabel("i am a label"));
        spane.add(new JLabel("i am a label"));
        spane.add(new JLabel("i am a label"));
        spane.add(new JLabel("i am a label"));
        spane.add(new JLabel("i am a label"));
        spane.add(new JLabel("i am a label"));
        spane.add(new JLabel("i am a label"));
        spane.add(new JLabel("i am a label"));
        spane.add(new JLabel("i am a label"));
        spane.add(new JLabel("i am a label"));
        spane.add(new JLabel("i am a label"));
        spane.add(new JLabel("i am a label"));
        spane.add(new JLabel("i am a label"));
        spane.add(new JLabel("i am a label"));
        spane.add(new JLabel("i am a label"));
        spane.add(new JLabel("i am a label"));
        spane.add(new JLabel("i am a label"));
        spane.add(new JLabel("i am a label"));
        spane.add(new JLabel("i am a label"));
        spane.add(new JLabel("i am a label"));
        spane.add(new JLabel("i am a label"));
        spane.add(new JLabel("i am a label"));
        spane.add(new JLabel("i am a label"));
        spane.add(new JLabel("i am a label"));
        spane.add(new JLabel("i am a label"));
        spane.add(new JLabel("i am a label"));
        spane.add(new JLabel("i am a label"));
        spane.add(new JLabel("i am a label"));
        spane.add(new JLabel("i am a label"));
        spane.add(new JLabel("i am a label"));
        spane.add(new JLabel("i am a label"));
        spane.add(new JLabel("i am a label"));
        spane.add(new JLabel("i am a label"));
        spane.add(new JLabel("i am a label"));
        spane.add(new JLabel("i am a label"));
        spane.add(new JLabel("i am a label"));
        spane.add(new JLabel("i am a label"));
        spane.add(new JLabel("i am a label"));
        spane.add(new JLabel("i am a label"));
        spane.add(new JLabel("i am a label"));
        spane.add(new JLabel("i am a label"));
        spane.add(new JLabel("i am a label"));
        spane.add(new JLabel("i am a label"));
        spane.add(new JLabel("i am a label"));
        spane.add(new JLabel("i am a label"));
        spane.add(new JLabel("i am a label"));
        spane.add(new JLabel("i am a label"));
        spane.add(new JLabel("i am a label"));
        spane.add(new JLabel("i am a label"));
        spane.add(new JLabel("i am a label"));
        spane.add(new JLabel("i am a label"));
        spane.add(new JLabel("i am a label"));
        spane.add(new JLabel("i am a label"));
        spane.add(new JLabel("i am a label"));
        spane.add(new JLabel("i am a label"));
        spane.add(new JLabel("i am a label"));
        spane.add(new JLabel("i am a label"));
        spane.add(new JLabel("i am a label"));
        spane.add(new JLabel("i am a label"));
        spane.add(new JLabel("i am a label"));


//so that even if the label doesnt get added...
//i can see that the panel does
        spane.setBackground(Color.red);

//the frame containing the panel
        JFrame f = new JFrame();
        f.add(spane);
        f.setVisible(true);
        f.setSize(100,100);
        f.setLocationRelativeTo(null);

//print the panel to pdf
        Document document = new Document();
        try {
            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("C:\\Users\\Jay V. Chandiramani\\Downloads\\test2.pdf"));
            document.open();

            PdfContentByte contentByte = writer.getDirectContent();
            PdfTemplate template = contentByte.createTemplate(PageSize.A4.getWidth(),PageSize.A4.getHeight());
            contentByte.addTemplate(template, 0, 0);

            Graphics2D g2d = template.createGraphics(PageSize.A4.getWidth(),PageSize.A4.getHeight());
            g2d.scale(0.4, 0.4);

            for(int i=0; i< f.getContentPane().getComponents().length; i++){
                Component c = f.getContentPane().getComponent(i);
                if(c instanceof JLabel || c instanceof JPanel){
                    g2d.translate(c.getBounds().x,c.getBounds().y);
                    if(c instanceof JPanel){
                        c.setBounds(0,0,(int)PageSize.A4.getWidth()*2,(int)PageSize.A4.getHeight()*2);}
                    c.paintAll(g2d);
                    c.addNotify();
                }
            }

            g2d.dispose();

            document.close();
        } catch (Exception e) {
            System.out.println("ERROR: " + e.toString());
        }
        finally{
            if(document.isOpen()){
                document.close();
                
            }
        }
    }
}
