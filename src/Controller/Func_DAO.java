/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.PrintJob;
import java.awt.Toolkit;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;


public class Func_DAO {
    
        public static void impressao() {
            
         String nome = JOptionPane.showInputDialog(null,"Insira seu Nome");
         String declaração = JOptionPane.showInputDialog(null,"Insira a declaração");
         String periodo  = JOptionPane.showInputDialog(null,"Insira o período da consulta");
         String ass  = JOptionPane.showInputDialog(null,"Insira a assinatura");
        LocalDate data = java.time.LocalDate.now();
        String recebe = data.format(DateTimeFormatter.ISO_DATE);
        Frame f = new Frame("Imp");
        Toolkit tk = f.getToolkit();
        PrintJob pj = tk.getPrintJob(f, "Recibo", null);
        if (pj != null) {
            Graphics m = pj.getGraphics();
             m.drawString("Declaração de Comparecimento" ,  220, 60);
             m.drawString("Declaro para fins de  " + declaração , 160, 80);
             m.drawString("que o senhor(a) "+ nome, 160, 100);
             m.drawString("Esteve em consulta odontolódiga no dia:  "+ recebe  ,160, 120);
             m.drawString("no período: " + periodo , 160, 140); 
             m.drawString("Assinado por: " + ass , 160, 180); 
            m.dispose();
            m.finalize();
            pj.end();
            pj.finalize();
        }
        f.dispose();
}
    
}
