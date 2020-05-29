package veri;

import java.net.URISyntaxException;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.Locale;
import javax.swing.JOptionPane;

public class Pdf_RCO {
    PDDocument document = new PDDocument();
    PDPage page = new PDPage();
    PDPageContentStream contentStream = new PDPageContentStream(document, page);
    String pdfName;
    String currency;
    RCO rco;
    Client client;
    PDImageXObject image;
    float line = 14.4f;
    float y;
    int yaziboyutu = 9;
    DecimalFormat format;
    PDType1Font dataFont = PDType1Font.HELVETICA;
    int[] columnLines_m = {70,280,330,380,430,480,540};
    int[] columnLines_l = {70,280,330,380,430,480,540};
    int[] columnLines_o = {70,280,330,380,430,480,540};
    float m_tax,m_subtotal,l_subtotal,o_tax,o_subtotal;
    
    public Pdf_RCO(RCO rco) throws IOException, URISyntaxException{
        currency = rco.project.currency;
        
        format = new DecimalFormat();
        format.setDecimalFormatSymbols(new DecimalFormatSymbols(Locale.US));
        format.setMinimumIntegerDigits(1);
        format.setMaximumFractionDigits(2);
        format.setMinimumFractionDigits(2);
        this.rco = rco;
        try{
            FileInputStream fi = new FileInputStream(new File("Clients/"+rco.project.clientName+".clt"));
            ObjectInputStream oi = new ObjectInputStream(fi);
            client = (Client) oi.readObject();
            oi.close();
            fi.close();
        }catch(IOException | ClassNotFoundException e){JOptionPane.showMessageDialog(null,"Client file cannot open");  }
        /*URL url = getClass().getResource("/resources/logo.jpg");
        String str = url.getPath();
        JOptionPane.showConfirmDialog(null,"str : "+str);
        this.image = PDImageXObject.createFromFile(str, document);*/
        try{this.image = PDImageXObject.createFromFile("logo.jpg", document);}catch(Exception e){}
        document.addPage(page);
        
        //dikine(columnLines_l);
        bosrapor();
        startpage();
        contentStream.close();
        document.save(rco.project.pdfpath+"/RCO#"+rco.name+".pdf");
        document.close();
    }
    private void dikine(int[] x) throws IOException{
        for (int i : x){
            contentStream.moveTo(i, 0);
            contentStream.lineTo(i,792);
            contentStream.stroke();
        }
    }
    private void startpage() throws IOException{
        y = 655;
        contentStream.setFont(PDType1Font.HELVETICA_BOLD, 20);
        contentStream.beginText();
        contentStream.newLineAtOffset(75, y);
        contentStream.showText("RCO #"+rco.name);
        contentStream.endText();
        y -= 2*line;
        contentStream.beginText();
        contentStream.newLineAtOffset(75, y);
        contentStream.setFont(dataFont, yaziboyutu);
        contentStream.showText(rco.date);
        contentStream.endText();
        y -= 2*line;
    
        contentStream.beginText();
        contentStream.newLineAtOffset(75, y);
        contentStream.showText(client.name);
        contentStream.endText();  
        y -= line;
        
        try{String[] s = this.client.adress.split("\\r?\\n");
            for (String item : s) {
                if (!"".equals(item)) {
                    contentStream.beginText();
                    contentStream.newLineAtOffset(75, y);
                    contentStream.showText(item);
                    contentStream.endText();
                    y -= line;
                }
            }}catch(IOException e){}
        
        if (!"".equals(client.phone)){
            contentStream.beginText();
            contentStream.newLineAtOffset(75, y);
            contentStream.showText(client.phone);
            contentStream.endText();  
            y -= line;}
        
        try{String[] s = this.client.note.split("\\r?\\n");
            for (String item : s) {
                if (!"".equals(item)) {
                contentStream.beginText();
                contentStream.newLineAtOffset(75, y);
                contentStream.showText(item);
                contentStream.endText();
                y -= line;
                }
            }}catch(IOException e){}
        
        if (!"".equals(rco.project.attention)){
            contentStream.beginText();
            contentStream.newLineAtOffset(75, y);
            contentStream.showText("Attention : "+rco.project.attention);
            contentStream.endText();
            y -= line;}
        
        drawline();
        y -= line-3;
        contentStream.setFont(PDType1Font.HELVETICA_BOLD, yaziboyutu);
        contentStream.beginText();
        contentStream.newLineAtOffset(75, y);
        contentStream.showText("Project :      " + rco.project.name);
        contentStream.endText();
        y -= 3;
        drawline();
        y -= 2*line;
        contentStream.beginText();
        contentStream.newLineAtOffset(75, y);
        contentStream.setFont(dataFont, yaziboyutu);
        contentStream.showText("Description :      "+rco.describtion);
        contentStream.endText();
        
        if (!rco.materials.isEmpty()) materials();
        if (!rco.labours.isEmpty()) labours();
        if (!rco.others.isEmpty()) others(rco.others);
        if (!rco.others2.isEmpty()) others(rco.others2);
        if (!rco.others3.isEmpty()) others(rco.others3);
        
        if (y < 88+3*line)newPage();
        contentStream.moveTo(480, y);
        contentStream.lineTo(540,y);
        contentStream.stroke();
        y -= line;
        float aratoplam = this.rco.getAraToplam();
        drawCenterText(columnLines_m[5],columnLines_m[6],currency+" "+format.format(aratoplam));
        if (y < 88+3*line)newPage();
        y -= line;
        drawCenterText(columnLines_m[2],columnLines_m[3],"OH&P");
        drawCenterText(columnLines_m[3],columnLines_m[4],this.rco.karpayi+" %");
        drawCenterText(columnLines_m[5],columnLines_m[6],currency+" "+format.format(aratoplam*this.rco.karpayi/100));
        y -= 3;
        drawline();
        if (y < 88+3*line)newPage();
        y -= line;
        drawCenterText(columnLines_m[5],columnLines_m[6],currency+" "+format.format(aratoplam*this.rco.karpayi/100+aratoplam));
        y -= 3;
        drawline();
        if (y < 88+3*line)newPage();
        y -= line;
        if (!rco.note.isEmpty()){
            int n = rco.note.length()/60+1;
            if (y < 88+n*line)newPage();
            y -= line;
            contentStream.beginText();
            contentStream.newLineAtOffset(80, y);
            contentStream.showText("Note :");
            contentStream.newLineAtOffset(35, 0);
            String[] note = rco.note.split("\\s+");
                System.out.println(rco.note.length());
            float x = 0;
            float w = 0;
            for(String s : note){
                w = dataFont.getStringWidth(s) / 1000 * yaziboyutu;
                if (w+x > 420){
                    contentStream.newLineAtOffset(-x, -line);
                    y-=line;
                    x = 0;
                }
                contentStream.showText(s);
                contentStream.newLineAtOffset(w+3, 0);
                x+=w+3;
            }
            contentStream.endText();
            y-=2*line;
        }
        if (y < 88+6*line)newPage();
        y -= line;
        contentStream.beginText();
        contentStream.newLineAtOffset(77, y);
        contentStream.showText("Thank you,");
        contentStream.newLineAtOffset(0, -line);
        contentStream.showText("ENTERPRISE ARCHITECTURAL SALES, INC.");
        if (!rco.user.name.isEmpty()){
        contentStream.newLineAtOffset(0, -line);
        contentStream.showText(rco.user.name);}
        contentStream.newLineAtOffset(0, -line);
        if (!rco.user.title.isEmpty()){
        contentStream.showText(rco.user.title);        
        contentStream.endText();}
    }
    private void materials() throws IOException{
        y -= 2*line;
        contentStream.setFont(dataFont ,yaziboyutu);
        contentStream.beginText();
        contentStream.newLineAtOffset(77, y);
        contentStream.showText(rco.title_M);
        contentStream.endText();
        drawCenterText(columnLines_m[1],columnLines_m[2],"Quantity");
        drawCenterText(columnLines_m[2],columnLines_m[3],"Unit");
        drawCenterText(columnLines_m[3],columnLines_m[4],currency+"/Unit");
        drawCenterText(columnLines_m[4],columnLines_m[5],"Tax");
        drawCenterText(columnLines_m[5],columnLines_m[6],"Subtotal");
        y -= 3;
        drawline();
        y -= line;
        for (Material m : rco.materials) {
            if (y < 88+2*line)newPage();
            contentStream.beginText();
            if (m.quantity==0 && m.unitprice==0 && m.tax==0){
                if (rco.materials.get(0) != m) y-=line;
                contentStream.newLineAtOffset(85, y);
                contentStream.setFont(PDType1Font.HELVETICA_BOLD, yaziboyutu);
                contentStream.showText(m.name);
                contentStream.endText();
                contentStream.setFont(dataFont, yaziboyutu);
                y-=line;
            }
            else{
                contentStream.newLineAtOffset(85, y);
                contentStream.showText(m.name);
                contentStream.endText();
                if (m.quantity != 0) drawCenterText(columnLines_m[1],columnLines_m[2],Integer.toString(m.quantity));
                if (m.unit != null) drawCenterText(columnLines_m[2],columnLines_m[3],m.unit);
                if (m.unitprice != 0) drawCenterText(columnLines_m[3],columnLines_m[4],currency+" "+Float.toString(m.unitprice));
                if (m.tax != 0) drawCenterText(columnLines_m[4],columnLines_m[5],Float.toString(m.tax)+" %");
                if (m.subtotal != 0) drawCenterText(columnLines_m[5],columnLines_m[6],currency+" "+(format.format(m.subtotal)));
                y-=line;
                m_subtotal += m.subtotal;
                m_tax += m.subtotal*m.tax/100;
            }
        }
    }
    private void labours() throws IOException{
        y-= 2*line;
        if (y < 88+5*line)newPage();
        contentStream.setFont(dataFont ,yaziboyutu);
        contentStream.beginText();
        contentStream.newLineAtOffset(77, y);
        contentStream.showText(rco.title_L);
        contentStream.endText();
        drawCenterText(columnLines_m[1],columnLines_m[2],"Man");
        drawCenterText(columnLines_m[2],columnLines_m[3],"Days");
        drawCenterText(columnLines_m[3],columnLines_m[4],currency+"/Day");
        drawCenterText(columnLines_m[4],columnLines_m[5],"");
        drawCenterText(columnLines_m[5],columnLines_m[6],"Subtotal");
        y -= 3;
        drawline();
        y -= line;
        for (Labour l : rco.labours) {
            if (y < 88+2*line)newPage();
            contentStream.beginText();
            if (l.man==0 && l.unitprice==0 && l.day==0){
                if (rco.labours.get(0) != l) y-=line;
                contentStream.newLineAtOffset(85, y);
                contentStream.setFont(PDType1Font.HELVETICA_BOLD, yaziboyutu);
                contentStream.showText(l.name);
                contentStream.endText();
                contentStream.setFont(dataFont, yaziboyutu);
                y-=line;
            }
            else{
                contentStream.newLineAtOffset(85, y);
                contentStream.showText(l.name);
                contentStream.endText();
                if (l.man != 0) drawCenterText(columnLines_m[1],columnLines_m[2],Integer.toString(l.man));
                if (l.day != 0) drawCenterText(columnLines_m[2],columnLines_m[3],Integer.toString(l.day));
                if (l.unitprice != 0) drawCenterText(columnLines_m[3],columnLines_m[4],currency+" "+Float.toString(l.unitprice));
                drawCenterText(columnLines_m[4],columnLines_m[5],"");
                if (l.subtotal != 0) drawCenterText(columnLines_m[5],columnLines_m[6],currency+" "+format.format(l.subtotal));
                y-=line;
            }
        }
    }
    private void others(ArrayList<Other> others) throws IOException{
        y -= 2*line;
        if (y < 88+5*line)newPage();
        contentStream.setFont(dataFont ,yaziboyutu);
        contentStream.beginText();
        contentStream.newLineAtOffset(77, y);
        contentStream.showText(rco.title_O);
        contentStream.endText();
        drawCenterText(columnLines_m[1],columnLines_m[2],"Quantity");
        drawCenterText(columnLines_m[2],columnLines_m[3],"");
        drawCenterText(columnLines_m[3],columnLines_m[4],currency+"/Unit");
        drawCenterText(columnLines_m[4],columnLines_m[5],"Tax");
        drawCenterText(columnLines_m[5],columnLines_m[6],"Subtotal");
        y -= 3;
        drawline();
        y -= line;
        for (Other o : others) {
            if (y < 88+2*line)newPage();
            contentStream.beginText();
            if (o.quantity==0 && o.unitprice==0 && o.tax==0){
                if (others.get(0) != o) y-=line;
                contentStream.newLineAtOffset(85, y);
                contentStream.setFont(PDType1Font.HELVETICA_BOLD, yaziboyutu);
                contentStream.showText(o.name);
                contentStream.endText();
                contentStream.setFont(dataFont, yaziboyutu);
                y-=line;
            }
            else{
                contentStream.newLineAtOffset(85, y);
                contentStream.showText(o.name);
                contentStream.endText();
                if (o.quantity != 0) drawCenterText(columnLines_m[1],columnLines_m[2],Integer.toString(o.quantity));
                drawCenterText(columnLines_m[2],columnLines_m[3],"");
                if (o.unitprice != 0) drawCenterText(columnLines_m[3],columnLines_m[4],currency+" "+Float.toString(o.unitprice));
                if (o.tax != 0) drawCenterText(columnLines_m[4],columnLines_m[5],Float.toString(o.tax)+" %");
                if (o.subtotal != 0) drawCenterText(columnLines_m[5],columnLines_m[6],currency+" "+format.format(o.subtotal));
                y-=line;
            }
        }
    }
    private void newPage() throws IOException{
        contentStream.close();
        PDPage p = new PDPage();
        document.addPage(p);
        contentStream = new PDPageContentStream(document, p);
        y = 655;
        bosrapor();
    }
    private void bosrapor() throws IOException{
        
        contentStream.drawImage(this.image, 165f, 694f, 282f, 75f);
        
        contentStream.moveTo(72, 694f);
        contentStream.lineTo(540,694f);
        contentStream.stroke(); 
        contentStream.moveTo(72, 769f);
        contentStream.lineTo(540,769f);
        contentStream.stroke();
        
        contentStream.moveTo(72, 88);
        contentStream.lineTo(540,88);
        contentStream.stroke();
        
        String[] title = {"TELEPHONE (212) 362-6577","NEW YORK, NY 10023","20 WEST 64TH STREET – LOWER LEVEL"};
        float[] ye = {50,50+13.9f,50+2*13.9f};
        PDType1Font font = PDType1Font.TIMES_BOLD;
        int fontSize = 10;
        int i =0;
        for (String s : title){
        float titleWidth = font.getStringWidth(s) / 1000 * fontSize;
        contentStream.setFont(font, fontSize);
        contentStream.beginText();
        contentStream.newLineAtOffset((612-titleWidth)/2, ye[i]);
        contentStream.showText(s);
        contentStream.setFont(dataFont, yaziboyutu);
        contentStream.endText();i++;}
    }
    private float getMid(int start, int end, String input) throws IOException{
        float titleWidth = dataFont.getStringWidth(input) / 1000 * yaziboyutu;
        return start + (end-titleWidth)/2;
    }
    private void drawCenterText(int start, int end, String input) throws IOException{
        contentStream.beginText();
        float titleWidth = dataFont.getStringWidth(input) / 1000 * yaziboyutu;
        float x = start + (end-start-titleWidth)/2;    
        contentStream.newLineAtOffset(x, y);
        contentStream.showText(input);
        contentStream.endText();
    }
    private void drawline() throws IOException{
        contentStream.moveTo(70, y);
        contentStream.lineTo(540,y);
        contentStream.stroke();
    }
}