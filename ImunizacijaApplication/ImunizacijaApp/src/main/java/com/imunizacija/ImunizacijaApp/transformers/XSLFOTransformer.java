package com.imunizacija.ImunizacijaApp.transformers;


import java.io.*;
import java.nio.charset.StandardCharsets;

import javax.xml.transform.Result;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.sax.SAXResult;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.apache.fop.apps.FOUserAgent;
import org.apache.fop.apps.Fop;
import org.apache.fop.apps.FopFactory;
import org.apache.fop.apps.MimeConstants;
import org.springframework.stereotype.Component;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

import net.sf.saxon.TransformerFactoryImpl;

import static com.imunizacija.ImunizacijaApp.transformers.Constants.*;

/**
 *
 * Primer demonstrira koriscenje Apache FOP programskog API-a za
 * renderovanje PDF-a primenom XSL-FO transformacije na XML dokumentu.
 *
 */
@Component
public class XSLFOTransformer {

    private final FopFactory fopFactory;

    private final TransformerFactory transformerFactory;

    public static final String OUTPUT_FILE = "src/main/java/com/imunizacija/ImunizacijaApp/transformers/xsl-fo/interesovanje.pdf";

    public XSLFOTransformer() throws SAXException, IOException {

        // Initialize FOP factory object
        fopFactory = FopFactory.newInstance(new File(FOP_CONFIG));

        // Setup the XSLT transformer factory
        transformerFactory = new TransformerFactoryImpl();
    }

    public void generatePDF(Node xmlAsDOMNode, String xslFilePath) throws Exception {

        System.out.println("[INFO] " + XSLFOTransformer.class.getSimpleName());

        // Point to the XSL-FO file
        File xslFile = new File(xslFilePath);

        // Create transformation source
        StreamSource transformSource = new StreamSource(xslFile);

        // Node to String
        StringWriter writer = new StringWriter();
        Transformer transformer = TransformerFactory.newInstance().newTransformer();
        transformer.transform(new DOMSource(xmlAsDOMNode), new StreamResult(writer));
        String xmlString = writer.toString();

        // String to byte[] in UTF8
        String text = new String(xmlString.getBytes(), StandardCharsets.UTF_8);
        byte[] xmlEncodedUTF8 = text.getBytes(StandardCharsets.UTF_8);

        // byte[] to InputStream
        InputStream inputStream = new ByteArrayInputStream(xmlEncodedUTF8);

        // Initialize the transformation subject
        StreamSource source = new StreamSource(inputStream);

        // Initialize user agent needed for the transformation
        FOUserAgent userAgent = fopFactory.newFOUserAgent();

        // Create the output stream to store the results
        ByteArrayOutputStream outStream = new ByteArrayOutputStream();

        // Initialize the XSL-FO transformer object
        Transformer xslFoTransformer = transformerFactory.newTransformer(transformSource);

        // Construct FOP instance with desired output format
        Fop fop = fopFactory.newFop(MimeConstants.MIME_PDF, userAgent, outStream);

        // Resulting SAX events
        Result res = new SAXResult(fop.getDefaultHandler());

        // Start XSLT transformation and FOP processing
        xslFoTransformer.transform(source, res);

        // Generate PDF file
        File pdfFile = new File(OUTPUT_FILE);
        if (!pdfFile.getParentFile().exists()) {
            System.out.println("[INFO] A new directory is created: " + pdfFile.getParentFile().getAbsolutePath() + ".");
            pdfFile.getParentFile().mkdir();
        }

        OutputStream out = new BufferedOutputStream(new FileOutputStream(pdfFile));
        out.write(outStream.toByteArray());

        System.out.println("[INFO] File \"" + pdfFile.getCanonicalPath() + "\" generated successfully.");
        out.close();

        System.out.println("[INFO] End.");

    }
}

