/**
 * limteng
 * Date: Jan 26, 2016.
 */
package edu.rpi.nile;

import edu.rpi.nile.model.Segment;
import edu.rpi.nile.model.Token;
import nu.xom.Builder;
import nu.xom.*;
import edu.rpi.nile.model.Document;
import nu.xom.ParsingException;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.*;

public class LTFReader {
    private static Builder parser;
    private static XMLReader xmlReader;

    private File file;

    static  {
        try {
            xmlReader = XMLReaderFactory.createXMLReader();
            xmlReader.setFeature("http://apache.org/xml/features/nonvalidating/load-external-dtd", false);
        } catch (SAXException e) {
            e.printStackTrace();
        }
        parser = new Builder(xmlReader);
    }

    /* Constructors */
    public LTFReader(File file) {
        this.file = file;
    }

    public LTFReader(String file) {
        this.file = new File(file);
    }

    /* Read *.ltf files */
    public Document read() throws IOException, ParsingException {
        nu.xom.Document doc = parser.build(file);

        Element doc_element = doc.getRootElement().getFirstChildElement("DOC");
        String doc_id       = doc_element.getAttributeValue("id");
        String doc_lang     = doc_element.getAttributeValue("lang");
        Document document   = new Document(doc_id, doc_lang);

        Elements segments   = doc_element.getFirstChildElement("TEXT").getChildElements();
        for (int i = 0; i < segments.size(); i++) {
            Element seg_element = segments.get(i);
            String id       = seg_element.getAttributeValue("id");
            int start_char  = Integer.parseInt(seg_element.getAttributeValue("start_char"));
            int end_char    = Integer.parseInt(seg_element.getAttributeValue("end_char"));
            String text     = seg_element.getFirstChildElement("ORIGINAL_TEXT").getValue();
            Segment segment = new Segment(text, start_char, end_char, id);

            Elements tokens = seg_element.getChildElements("TOKEN");
            for (int j = 0; j < tokens.size(); j++) {
                Element token_element = tokens.get(j);
                String token_id       = token_element.getAttributeValue("id");
                String token_text     = token_element.getValue();
                int token_start_char  = Integer.parseInt(token_element.getAttributeValue("start_char"));
                int token_end_char    = Integer.parseInt(token_element.getAttributeValue("end_char"));
                Token token = new Token(token_text, token_start_char, token_end_char, token_id);
                segment.add_token(token);
            }

            document.add_segment(segment);
        }

        return document;
    }

    public static Document read(File file) throws IOException, ParsingException {
        nu.xom.Document doc = parser.build(file);

        Element doc_element = doc.getRootElement().getFirstChildElement("DOC");
        String doc_id       = doc_element.getAttributeValue("id");
        String doc_lang     = doc_element.getAttributeValue("lang");
        Document document   = new Document(doc_id, doc_lang);

        Elements segments   = doc_element.getFirstChildElement("TEXT").getChildElements();
        for (int i = 0; i < segments.size(); i++) {
            Element seg_element = segments.get(i);
            String id       = seg_element.getAttributeValue("id");
            int start_char  = Integer.parseInt(seg_element.getAttributeValue("start_char"));
            int end_char    = Integer.parseInt(seg_element.getAttributeValue("end_char"));
            String text     = seg_element.getFirstChildElement("ORIGINAL_TEXT").getValue();
            Segment segment = new Segment(text, start_char, end_char, id);

            Elements tokens = seg_element.getChildElements("TOKEN");
            for (int j = 0; j < tokens.size(); j++) {
                Element token_element = tokens.get(j);
                String token_id       = token_element.getAttributeValue("id");
                String token_text     = token_element.getValue();
                int token_start_char  = Integer.parseInt(token_element.getAttributeValue("start_char"));
                int token_end_char    = Integer.parseInt(token_element.getAttributeValue("end_char"));
                Token token = new Token(token_text, token_start_char, token_end_char, token_id);
                segment.add_token(token);
            }

            document.add_segment(segment);
        }

        return document;
    }

    public static Document read(String file) throws IOException, ParsingException {
        return read(new File(file));
    }
}
