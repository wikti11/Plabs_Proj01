import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import java.io.IOException;

public class Statistics {

    public static void savingStatistics(int amount, String type) throws IOException {

        PDDocument document = new PDDocument();
        PDPage page = new PDPage();
        document.addPage(page);
        PDPageContentStream contentStream = new PDPageContentStream(document,page);

        contentStream.beginText();
        contentStream.setFont(PDType1Font.TIMES_ROMAN,12);
        contentStream.newLineAtOffset(25,500);
        contentStream.showText("Amount of searched words: "+amount);
        contentStream.showText("    Most recent language that a word was found in: "+type);
        contentStream.endText();
        contentStream.close();
        document.save("Statistics.pdf");
        document.close();
    }

}
