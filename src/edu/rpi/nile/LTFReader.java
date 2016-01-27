/**
 * limteng
 * Date: Jan 26, 2016.
 */
package edu.rpi.nile;

import edu.rpi.nile.model.Document;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;

public class LTFReader {
    private File file;
    private static Logger logger = LogManager.getLogger(LTFReader.class);

    /* Constructors */
    public LTFReader(File file) {
        this.file = file;
    }

    public LTFReader(String file) {
        this.file = new File(file);
    }

    /* Read *.ltf files */
    public Document read() {
        Document document = new Document();

        return document;
    }
}
