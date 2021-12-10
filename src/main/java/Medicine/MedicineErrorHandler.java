package Medicine;

import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXParseException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Class which implements ErrorHandler for handling and logging all errors.
 */
public class MedicineErrorHandler implements ErrorHandler {
    private Logger logger = LogManager.getLogger();
    public void warning(SAXParseException e) {
        logger.warn(getLineColumnNumber(e) + "-" + e.getMessage());
    }
    public void error(SAXParseException e) {
        logger.error(getLineColumnNumber(e) + " - " + e.getMessage());
    }
    public void fatalError(SAXParseException e) {
        logger.fatal(getLineColumnNumber(e) + " - " + e.getMessage());
    }
    private String getLineColumnNumber(SAXParseException e) {
        // determine line and position of error
        return e.getLineNumber() + " : " + e.getColumnNumber();
    }
}
