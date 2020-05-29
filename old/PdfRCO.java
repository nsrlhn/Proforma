package veri;

import pencereler.Anapencere;
import java.net.URISyntaxException;
import java.text.NumberFormat;
import java.util.Locale;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationWidget;
import org.apache.pdfbox.pdmodel.interactive.form.PDTextField;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import pencereler.ClientWindow;

public class PdfRCO {
    PDDocument document = new PDDocument();
    PDPage page = new PDPage();
    PDPageContentStream contentStream = new PDPageContentStream(document, page);
    String pdfName;
    RCO rco;
    PDImageXObject image;
    
    public PdfRCO(RCO rco) throws IOException, URISyntaxException{
        this.rco = rco;
        
        /*URL url = getClass().getResource("/resources/logo.jpg");
        String str = url.getPath();
        System.out.println(str);
        this.image = PDImageXObject.createFromFile(str, document);*/
        this.image = PDImageXObject.createFromFile("logo.jpg", document);
        document.addPage(page);
        
        bosrapor();
        firmailetisim();
        basliklar();
        ustyazi();
        
        contentStream.setFont(PDType1Font.HELVETICA_BOLD, 10);
        contentStream.beginText();
        contentStream.newLineAtOffset(75, 513);
        contentStream.showText("Project :      " + Anapencere.anapencere.getProjectName());
        contentStream.newLineAtOffset(0, -28.8f);
        contentStream.setFont(PDType1Font.HELVETICA, 10);
        contentStream.showText("Describtion :      "+rco.describtion);
        contentStream.endText();
        
        material();
        labour();
        total();
        person();
        
        contentStream.close();
        pdfName = (rco.name+".pdf").replaceAll("\\s+", "");
        document.save(pdfName);
        document.close();
        
        Desktop desktop = Desktop.getDesktop();
        File file = new File(pdfName);
        if(file.exists()) desktop.open(file);
    }
    
    private void ustyazi() throws IOException{
        contentStream.setFont(PDType1Font.HELVETICA_BOLD, 20);
        contentStream.beginText();
        contentStream.newLineAtOffset(75, 655);
        contentStream.showText(rco.name);
        contentStream.newLineAtOffset(0, -28.8f);
        contentStream.setFont(PDType1Font.HELVETICA, 10);
        contentStream.showText(rco.date);
        contentStream.endText();
        
        contentStream.beginText();
        try{String[] client = ClientWindow.clientContact.split("\\r?\\n");
        contentStream.newLineAtOffset(75, 528);
        for(int i = 0 ; i < client.length;){
            i++;
            contentStream.showText(client[client.length-i]);
            contentStream.newLineAtOffset(0, 14);
        }}catch(Exception e){}
        contentStream.endText();
    }
    
    private void material() throws IOException{
        Material m = this.rco.material.get(0);
        contentStream.setFont(PDType1Font.HELVETICA ,10);
        contentStream.beginText();
        contentStream.newLineAtOffset(77, 414.2f);
        contentStream.showText(m.name);
        contentStream.newLineAtOffset(200, 0);
        contentStream.showText(Integer.toString(m.quantity)+"  Sqft");
        contentStream.newLineAtOffset(110, 0);       
        contentStream.showText("$ "+NumberFormat.getNumberInstance(Locale.US).format((int)m.unitprice));
        contentStream.newLineAtOffset(90, 0);       
        contentStream.showText("$ "+NumberFormat.getNumberInstance(Locale.US).format((int)m.subtotal));
        contentStream.endText();
        
        contentStream.beginText();
        contentStream.newLineAtOffset(77, 399.8f);
        contentStream.showText("Tax");
        contentStream.newLineAtOffset(200, 0);
        contentStream.showText(NumberFormat.getNumberInstance(Locale.US).format((int)m.subtotal));
        contentStream.newLineAtOffset(110, 0);       
        contentStream.showText(Float.toString(m.tax));
        contentStream.newLineAtOffset(90, 0);       
        contentStream.showText("$ "+NumberFormat.getNumberInstance(Locale.US).format((int)(m.subtotal*m.tax/100)));
        contentStream.endText();
    }
    
    private void labour() throws IOException{
        float[] y = {342.2f,327.8f};
        int i =0;
        for(Labour l:this.rco.labour){
        contentStream.setFont(PDType1Font.HELVETICA ,10);
        contentStream.beginText();
        contentStream.newLineAtOffset(77, y[i]);
        contentStream.showText(l.name);
        contentStream.newLineAtOffset(200, 0);
        contentStream.showText(Integer.toString(l.man));
        contentStream.newLineAtOffset(60, 0);       
        contentStream.showText(Integer.toString(l.day));
        contentStream.newLineAtOffset(50, 0);       
        contentStream.showText("$ "+NumberFormat.getNumberInstance(Locale.US).format((int)l.unitprice));
        contentStream.newLineAtOffset(90, 0);       
        contentStream.showText("$ "+NumberFormat.getNumberInstance(Locale.US).format((int)l.subtotal));
        contentStream.endText();i++;}
    }
    
    private void total() throws IOException{
        Material m = this.rco.material.get(0);
        Labour l1 = this.rco.labour.get(0);
        Labour l2 = this.rco.labour.get(1);
        contentStream.setFont(PDType1Font.HELVETICA ,10);
        contentStream.beginText();
        contentStream.newLineAtOffset(477, 308);
        float aratoplam = m.subtotal*m.tax/100+m.subtotal+l1.subtotal+l2.subtotal;
        contentStream.showText("$ "+NumberFormat.getNumberInstance(Locale.US).format((int)aratoplam));
        contentStream.newLineAtOffset(0, -14.4f);
        contentStream.showText("$ "+NumberFormat.getNumberInstance(Locale.US).format((int)(aratoplam*0.15f)));
        contentStream.newLineAtOffset(0, -16.4f);
        contentStream.showText("$ "+NumberFormat.getNumberInstance(Locale.US).format((int)(aratoplam*1.15f)));
        contentStream.endText();
        
        contentStream.beginText();
        contentStream.newLineAtOffset(277, 277.6f);
        contentStream.showText(Integer.toString(m.quantity)+"  Sqft");
        contentStream.endText();
        
        contentStream.beginText();
        contentStream.newLineAtOffset(325, 293.6f);
        contentStream.showText("OH&P             15%");
        contentStream.endText();
        }
    
    private void person() throws IOException{
        contentStream.setFont(PDType1Font.HELVETICA ,10);
        contentStream.beginText();
        contentStream.newLineAtOffset(77, 229.8f);
        contentStream.showText("Thank you,");
        contentStream.newLineAtOffset(0, -14.4f);
        contentStream.showText("ENTERPRISE ARCHITECTURAL SALES, INC.");
        contentStream.newLineAtOffset(0, -14.4f);
        contentStream.showText("Jorge Cobos");
        contentStream.newLineAtOffset(0, -14.4f);
        contentStream.showText("Project Manager,");        
        contentStream.endText();        
    }
    
    private void bosrapor() throws IOException{
        
        contentStream.drawImage(this.image, 165f, 694f, 282f, 75f);
        
        /*
        contentStream.moveTo(72, 0);
        contentStream.lineTo(72,792);
        contentStream.stroke(); 
        contentStream.moveTo(540, 0);
        contentStream.lineTo(540,792);
        contentStream.stroke(); 
        contentStream.moveTo(209, 0);
        contentStream.lineTo(209,792);
        contentStream.stroke(); 
        contentStream.moveTo(306, 0);
        contentStream.lineTo(306,792);
        contentStream.stroke(); 
        contentStream.moveTo(346.5f, 0);
        contentStream.lineTo(346.5f,792);
        contentStream.stroke(); 
        contentStream.moveTo(445.5f, 0);
        contentStream.lineTo(445.5f,792);
        contentStream.stroke();*/
        
        contentStream.moveTo(72, 694f);
        contentStream.lineTo(540,694f);
        contentStream.stroke(); 
        contentStream.moveTo(72, 769f);
        contentStream.lineTo(540,769f);
        contentStream.stroke();

        contentStream.moveTo(72, 524);
        contentStream.lineTo(540,524);
        contentStream.stroke();
        contentStream.moveTo(72, 510);
        contentStream.lineTo(540,510);
        contentStream.stroke();        
        
        contentStream.moveTo(72, 440);
        contentStream.lineTo(540,440);
        contentStream.stroke();
        
        contentStream.moveTo(72, 370.5f);
        contentStream.lineTo(540,370.5f);
        contentStream.stroke();
        
        contentStream.moveTo(540f-94.4f, 322);
        contentStream.lineTo(540,322);
        contentStream.stroke();
                
        contentStream.moveTo(72, 287);
        contentStream.lineTo(540,287);
        contentStream.stroke();        
        
        contentStream.moveTo(72, 273);
        contentStream.lineTo(540,273);
        contentStream.stroke();
        
        contentStream.moveTo(72, 88);
        contentStream.lineTo(540,88);
        contentStream.stroke();
    }
    
    private void firmailetisim() throws IOException{
        String[] title = {"TELEPHONE (212) 362-6577","NEW YORK, NY 10023","20 WEST 64TH STREET – LOWER LEVEL"};
        float[] y = {50,50+13.9f,50+2*13.9f};
        PDType1Font font = PDType1Font.TIMES_BOLD;
        int fontSize = 10;
        int i =0;
        for (String s : title){
        float titleWidth = font.getStringWidth(s) / 1000 * fontSize;
        contentStream.setFont(font, fontSize);
        contentStream.beginText();
        contentStream.newLineAtOffset((612-titleWidth)/2, y[i]);
        contentStream.showText(s);
        contentStream.endText();i++;}
    }
    
    private void basliklar() throws IOException{
           
        contentStream.setFont(PDType1Font.HELVETICA ,10);
        contentStream.beginText();
        contentStream.newLineAtOffset(77, 443);
        contentStream.showText("Material :");
        contentStream.newLineAtOffset(190, 0);       
        contentStream.showText("Quantity");
        contentStream.newLineAtOffset(120, 0);       
        contentStream.showText("$/Unit");
        contentStream.newLineAtOffset(90, 0);       
        contentStream.showText("Subtotal");
        contentStream.endText();
        
        contentStream.setFont(PDType1Font.HELVETICA ,10);
        contentStream.beginText();
        contentStream.newLineAtOffset(77, 373.5f);
        contentStream.showText("Labor :");
        contentStream.newLineAtOffset(190, 0);       
        contentStream.showText("Man");
        contentStream.newLineAtOffset(60, 0);         
        contentStream.showText("Days");
        contentStream.newLineAtOffset(60, 0);       
        contentStream.showText("$/Day");
        contentStream.newLineAtOffset(90, 0);       
        contentStream.showText("Subtotal");
        contentStream.endText();
    }
    
    public void textfield() throws IOException{
        PDAcroForm doc = new PDAcroForm(document);
        PDTextField tf = new PDTextField(doc);
        tf.setPartialName("asdfasdf");
        doc.getFields().add(tf);
        
        PDAnnotationWidget widget = tf.getWidgets().get(0);
        PDRectangle rect = new PDRectangle(50, 50, 50, 50);
        widget.setRectangle(rect);
        widget.setPage(page);
        widget.setPrinted(true);
        page.getAnnotations().add(widget);
                      
        
    }
}
