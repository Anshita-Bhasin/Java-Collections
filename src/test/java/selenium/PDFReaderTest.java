package selenium;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.junit.Assert;
import org.testng.annotations.Test;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class PDFReaderTest {


    @Test
    public void readPDF() throws IOException {

        URL url = new URL("file:///C:/Users/Dell-pc/Documents/Anshita/Timesheet%20Day%20Wise_July2020.pdf");
        InputStream inputStream = url.openStream();
        BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
        PDDocument pdDocument = PDDocument.load(bufferedInputStream);
        String doc = new PDFTextStripper().getText(pdDocument);
        System.out.println(doc);
        Assert.assertTrue(doc.contains("Anshita Bhasin"));


    }
}
