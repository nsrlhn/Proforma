package veri;

import java.awt.Color;
import java.net.URISyntaxException;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;
import org.apache.pdfbox.pdmodel.graphics.state.PDExtendedGraphicsState;

public class Pdf_LOG {
    PDDocument document = new PDDocument();
    PDPage page = new PDPage();
    PDPageContentStream contentStream = new PDPageContentStream(document, page);
    float opacity = 0.4f;
    PDExtendedGraphicsState graphicsState = new PDExtendedGraphicsState();
    PDExtendedGraphicsState defaultgraphicsState = new PDExtendedGraphicsState();
    Project project;
    Client client;
    PDImageXObject image;
    String currency;
    float line = 14.4f;
    float y;
    int yaziboyutu = 9;
    DecimalFormat format= new DecimalFormat();
    PDType1Font dataFont = PDType1Font.HELVETICA;
    int[] columnLines = {70,100,150,290,340,390,440,490,540};
    int tableStart_y = 600;
    float tableEnd_y;
    float amount,rejected,pending,approved;
    
    public Pdf_LOG(Project project) throws IOException, URISyntaxException{
        currency = project.currency;
        format.setDecimalFormatSymbols(new DecimalFormatSymbols(Locale.US));
        format.setMinimumIntegerDigits(1);
        format.setMaximumFractionDigits(2);
        format.setMinimumFractionDigits(2);
        this.project = project;
        
        try{this.image = PDImageXObject.createFromFile("logo.jpg", document);}catch(Exception e){}
        document.addPage(page);
        
        graphicsState.setNonStrokingAlphaConstant(opacity);
        defaultgraphicsState.setNonStrokingAlphaConstant(1f);
        bosrapor();
        
        //y = 792 - (792 - project.model_RCO.getRowCount()*line)/2;
        y = tableStart_y;
        upperpart();
        tablo();
        belowpart();
        dikine(columnLines);
        
        contentStream.close();
        document.save(project.pdfpath+"/LOG.pdf");
        document.close();
    }
    private void upperpart() throws IOException{
        contentStream.beginText();
        contentStream.newLineAtOffset(75, y);
        contentStream.newLineAtOffset(0, line);
        contentStream.showText("Client : "+project.clientName);
        contentStream.newLineAtOffset(400, 0);
        contentStream.showText(project.date);
        contentStream.newLineAtOffset(-400, 2*line);
        contentStream.setFont(PDType1Font.HELVETICA_BOLD, 20);
        contentStream.showText("Project : "+project.name);
        contentStream.endText();
        contentStream.setFont(dataFont, yaziboyutu);
    }
    private void tablo() throws IOException{
        drawline();
        y -= line-3;
        contentStream.setFont(PDType1Font.HELVETICA_BOLD, yaziboyutu);
        drawCenterText(columnLines[0],columnLines[1],"RCO#");
        drawCenterText(columnLines[1],columnLines[2],"Date");
        drawCenterText(columnLines[2],columnLines[3],"Description");
        drawCenterText(columnLines[3],columnLines[4],"Amount");
        drawCenterText(columnLines[4],columnLines[5],"Rejected");
        drawCenterText(columnLines[5],columnLines[6],"Pending");
        drawCenterText(columnLines[6],columnLines[7],"Approved");
        drawCenterText(columnLines[7],columnLines[8],"Status");
        y -= 3;
        drawline();
        y -= line-3;
        contentStream.setFont(dataFont, yaziboyutu);
        for (RCO rco : project.getAllRCO()){
            y -= 3;
            Color color = null;
            if (rco.status.equals("APPROVED")) color = Color.GREEN;
            else if (rco.status.equals("REJECTED")) color = Color.RED;
            else if (rco.status.equals("PENDING")) color = Color.YELLOW;
            contentStream.setGraphicsStateParameters(graphicsState);
            contentStream.setNonStrokingColor(color);
            contentStream.addRect(70, y+0.5f , 470, line-1f);
            contentStream.fill();
            contentStream.setNonStrokingColor(0, 0, 0);
            contentStream.setGraphicsStateParameters(defaultgraphicsState);
            y += 3;
            drawCenterText(columnLines[0],columnLines[1],rco.name);
            String date = rco.date.substring(0, 6)+rco.date.substring(8,10);
            drawCenterText(columnLines[1],columnLines[2],date);
            drawCenterText(columnLines[2],columnLines[3],rco.describtion);
            if (rco.getAraToplam() != 0) drawCenterText(columnLines[3],columnLines[4],format.format(rco.getAraToplam()));
            if (rco.rejected != 0) drawCenterText(columnLines[4],columnLines[5],format.format(rco.rejected));
            if (rco.pending != 0) drawCenterText(columnLines[5],columnLines[6],format.format(rco.pending));
            if (rco.approved != 0) drawCenterText(columnLines[6],columnLines[7],format.format(rco.approved));
            drawCenterText(columnLines[7],columnLines[8],rco.status);
            y -= 3;
            drawline();
            
            tableEnd_y = y;
            y -= line-3;
        }
        for (RCO rco : project.rcolist){
            if(!rco.revisions.isEmpty())rco = rco.revisions.get(rco.revisions.size()-1);
            amount += rco.getAraToplam();
            rejected += rco.rejected;
            pending += rco.pending;
            approved += rco.approved;
        }
    }
    private void belowpart() throws IOException {
        y -= line;
        //contentStream.setFont(PDType1Font.HELVETICA_BOLD, yaziboyutu);
        drawCenterText(columnLines[2],columnLines[3],"                                   TOTAL :");
        drawCenterText(columnLines[3],columnLines[4],currency+format.format(amount));
        drawCenterText(columnLines[4],columnLines[5],currency+format.format(rejected));
        drawCenterText(columnLines[5],columnLines[6],currency+format.format(pending));
        drawCenterText(columnLines[6],columnLines[7],currency+format.format(approved));
        //contentStream.setFont(dataFont, yaziboyutu);
        
        for (int i=0 ; i<columnLines.length ; i++){
            if ( i==3 || i==4 || i==5 || i==6 || i==7 )
            contentStream.moveTo(columnLines[i], y-3);
            contentStream.lineTo(columnLines[i],y-3+line);
            contentStream.stroke();
        }
        contentStream.moveTo(columnLines[3], y-3);
        contentStream.lineTo(columnLines[7],y-3);
        contentStream.stroke();
        contentStream.moveTo(columnLines[3], y-3+line);
        contentStream.lineTo(columnLines[7],y-3+line);
        contentStream.stroke();
        
        if (project.originalContractAmount != 0){
            y -= 2*line;
            drawCenterText(columnLines[4],columnLines[6],"original contract amount :          ");
            drawCenterText(columnLines[6],columnLines[7],currency+" "+format.format(project.originalContractAmount));
            y -= 1.2*line;
            drawCenterText(columnLines[4],columnLines[6],"revised contract amount :          ");
            drawCenterText(columnLines[6],columnLines[7],currency+" "+format.format(project.originalContractAmount+approved));
        }
    }
    private void dikine(int[] x) throws IOException{
        for (int i : x){
            contentStream.moveTo(i, tableEnd_y);
            contentStream.lineTo(i,tableStart_y);
            contentStream.stroke();
        }
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
    private void drawCenterText(int start, int end, String input) throws IOException{
        if(input != null){
            contentStream.beginText();
            float titleWidth = dataFont.getStringWidth(input) / 1000 * yaziboyutu;
            float x = start + (end-start-titleWidth)/2;    
            contentStream.newLineAtOffset(x, y);
            contentStream.showText(input);
            contentStream.endText();
        }
    }
    private void drawline() throws IOException{
        contentStream.setLineWidth(1f);
        contentStream.moveTo(70, y);
        contentStream.lineTo(540,y);
        contentStream.stroke();
    }
}