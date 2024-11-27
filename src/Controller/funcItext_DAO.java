
package Controller;

import java.io.FileOutputStream;
import java.io.OutputStream;
import com.itextpdf.text.Document;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Desktop;
import java.io.File;
import javax.swing.JOptionPane;

public class funcItext_DAO {
    
    public static void imprime()throws Exception {
 
        Document doc = null;
        OutputStream os = null;
    
    String nome = JOptionPane.showInputDialog(null, "Digite o nome");
    String identidade = JOptionPane.showInputDialog(null, "Digite a identidade");
    String periodo = JOptionPane.showInputDialog(null, "Digite o inicio do periodo de afastamento");
    String ate = JOptionPane.showInputDialog(null, "Digite o fim do periodo de afastamento");
    String y = JOptionPane.showInputDialog(null, "Digite a data "); 
    String motivo = JOptionPane.showInputDialog(null, "Digite o Motivo ");  
    String infos = JOptionPane.showInputDialog(null, "Digite as informações adicionais");
   String ass = JOptionPane.showInputDialog(null, "Digite a assinatura");
  try {
 
            //cria o documento tamanho A4, margens de 2,54cm
            doc = new Document(PageSize.A4, 72, 72, 72, 72);
 
            //cria a stream de saída
            os = new FileOutputStream("Relatorio1.pdf");
 
            //associa a stream de saída ao
            PdfWriter.getInstance(doc, os);
 
            //abre o documento
            doc.open();
 
            //adiciona o texto ao PDF
            Paragraph par = new Paragraph("ATESTADO MÉDICO   \nAtesto para os devidos afins  que o Sr.(a) "+ nome +" portador da Carteira de Identidade nº "+identidade+ " deverá ser afastado de suas atividades pelo período de: "+ periodo + " até: "+ate+" por motivos de "+ motivo +"\n \nInformações Relevantes:\n" + infos+ "\n\nData de atendimento: "+ y+ "\nAssinatura: "+ass);
            doc.add(par);
           
 
        } finally {
 
            if (doc != null) {
 
                //fechamento do documento
                doc.close();
            }
 
            if (os != null) {
                //fechamento da stream de saída
                os.close();
            }
        }
        Desktop.getDesktop().open(new File("Relatorio1.pdf"));
        
}
}