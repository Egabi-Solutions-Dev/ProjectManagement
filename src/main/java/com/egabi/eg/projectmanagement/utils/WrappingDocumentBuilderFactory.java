package com.egabi.eg.projectmanagement.utils;


import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.validation.Schema;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * JAXP document builder factory that disables loading of external DTDs
 * when reading XML documents using document builders created by this
 * factory.
 * When activated, this document builder factory will wrap the current
 * document builder factory and become the current document builder
 * factory, delegating to the previous document builder factory.
 * When deactivated, the previous document builder factory will be
 * restored as the default document builder factory.
 *
 * @author Ivan Krizsan
 */
public class WrappingDocumentBuilderFactory extends DocumentBuilderFactory {
    /* Constant(s): */
    /** Class logger. */
    private static final Logger LOGGER = Logger
            .getLogger(WrappingDocumentBuilderFactory.class.getCanonicalName());
    /** JAXP document builder factory system property name. */
    private static final String DOCUMENTBUILDERFACTORY_SYSTEM_PROPERTY_NAME = "javax.xml.parsers.DocumentBuilderFactory";
    /** Name of load external DTD feature. */
    private static final String LOADEXTERNALDTD_FEATURE = "http://apache.org/xml/features/nonvalidating/load-external-dtd";
    /**
     * Xerces validation feature. Turn off to be able to deactivate
     * DTD loading.
     */
    private static final String XML_VALIDATION_FEATURE = "http://xml.org/sax/features/validation";

    /* Class variable(s): */
    /** Previous document builder factory class. */
    protected static Class<?> sPreviousDocumentBuilderFactoryClass = null;
    /** Previous value of document builder factory system property. */
    protected static String sPreviousDocumentBuilderFactorySystemPropertyValue = null;

    /* Instance variable(s): */
    /** Document builder factory to delegate to. */
    protected DocumentBuilderFactory mDocumentBuilderFactoryDelegateBuilderFactory;

    /**
     * Activates this document builder factory wrapper.
     */
    public static void activate() {
        /*
         * Save value of current JAXP document builder factory
         * system property.
         */
        sPreviousDocumentBuilderFactorySystemPropertyValue = System.getProperty(DOCUMENTBUILDERFACTORY_SYSTEM_PROPERTY_NAME);

        /*
         * Save previous document builder factory class.
         * Use JAXP to request an instance is easier than trying to
         * find the class name ourselves.
         */
        sPreviousDocumentBuilderFactoryClass = DocumentBuilderFactory.newInstance().getClass();

        LOGGER.info("Previous document builder factory class: " +
                sPreviousDocumentBuilderFactoryClass.getCanonicalName());

        /*
         * Set JAXP document builder factory system property name to this
         * class, causing this class to be the first choice when requesting
         * document builder factories from JAXP.
         */
        System.setProperty(DOCUMENTBUILDERFACTORY_SYSTEM_PROPERTY_NAME,WrappingDocumentBuilderFactory.class.getCanonicalName());

        LOGGER.info("Enabled document builder factory wrapper. " +
                "Delegating to: " +
                sPreviousDocumentBuilderFactoryClass.getCanonicalName());
    }

    /**
     * Deactivates this document builder factory wrapper.
     */
    public static void deactivate() {

        if (sPreviousDocumentBuilderFactoryClass != null) {
            /*
             * Restore previous JAXP document builder factory system
             * property value.
             */
            if (sPreviousDocumentBuilderFactorySystemPropertyValue != null) {
                System.setProperty(DOCUMENTBUILDERFACTORY_SYSTEM_PROPERTY_NAME,
                        sPreviousDocumentBuilderFactorySystemPropertyValue);
            } else {
                System.clearProperty(DOCUMENTBUILDERFACTORY_SYSTEM_PROPERTY_NAME);
            }
            /* Clears variables to indicate that wrapper is deactivated. */
            sPreviousDocumentBuilderFactorySystemPropertyValue = null;
            sPreviousDocumentBuilderFactoryClass = null;

            LOGGER.info("Deactivated document builder factory wrapper.");
        } else {
            LOGGER
                    .info("Document builder factory wrapper not active, do nothing.");
        }
    }

    /**
     * Default constructor.
     * Sets features in the delegate document builder factory as to
     * disable DTD validation.
     */
    public WrappingDocumentBuilderFactory() {
        if (sPreviousDocumentBuilderFactoryClass != null) {
            /* Create delegate document builder factory. */
            try {
                mDocumentBuilderFactoryDelegateBuilderFactory =
                        (DocumentBuilderFactory) sPreviousDocumentBuilderFactoryClass.newInstance();

                /* Set features to turn off loading of external DTDs. */
                mDocumentBuilderFactoryDelegateBuilderFactory.setFeature(LOADEXTERNALDTD_FEATURE, false);
                mDocumentBuilderFactoryDelegateBuilderFactory.setFeature(XML_VALIDATION_FEATURE, false);
            } catch (final Exception theException) {
                LOGGER.log(Level.SEVERE,
                        "Error occurred creating wrapping document "
                                + "builder factory instance", theException);
            }
        } else {
            throw new Error("No previous document builder factory class set.");
        }
    }

    /*
     * The following are delegate methods that ensures that all information
     * is conveyed to the delegate.
     */

    @Override
    public DocumentBuilder newDocumentBuilder()
            throws ParserConfigurationException {
        return mDocumentBuilderFactoryDelegateBuilderFactory
                .newDocumentBuilder();
    }

    @Override
    public void setNamespaceAware(final boolean inAwareness) {
        mDocumentBuilderFactoryDelegateBuilderFactory
                .setNamespaceAware(inAwareness);
    }

    @Override
    public void setValidating(final boolean inValidating) {
        mDocumentBuilderFactoryDelegateBuilderFactory
                .setValidating(inValidating);
    }

    @Override
    public void setIgnoringElementContentWhitespace(final boolean inWhitespace) {
        mDocumentBuilderFactoryDelegateBuilderFactory
                .setIgnoringElementContentWhitespace(inWhitespace);
    }

    @Override
    public void setExpandEntityReferences(final boolean inExpandEntityRef) {
        mDocumentBuilderFactoryDelegateBuilderFactory
                .setExpandEntityReferences(inExpandEntityRef);
    }

    @Override
    public void setIgnoringComments(final boolean inIgnoreComments) {
        mDocumentBuilderFactoryDelegateBuilderFactory
                .setIgnoringComments(inIgnoreComments);
    }

    @Override
    public void setCoalescing(final boolean inCoalescing) {
        mDocumentBuilderFactoryDelegateBuilderFactory
                .setCoalescing(inCoalescing);
    }

    @Override
    public boolean isNamespaceAware() {
        return mDocumentBuilderFactoryDelegateBuilderFactory.isNamespaceAware();
    }

    @Override
    public boolean isValidating() {
        return mDocumentBuilderFactoryDelegateBuilderFactory.isValidating();
    }

    @Override
    public boolean isIgnoringElementContentWhitespace() {
        return mDocumentBuilderFactoryDelegateBuilderFactory
                .isIgnoringElementContentWhitespace();
    }

    @Override
    public boolean isExpandEntityReferences() {
        return mDocumentBuilderFactoryDelegateBuilderFactory
                .isExpandEntityReferences();
    }

    @Override
    public boolean isIgnoringComments() {
        return mDocumentBuilderFactoryDelegateBuilderFactory
                .isIgnoringComments();
    }

    @Override
    public boolean isCoalescing() {
        return mDocumentBuilderFactoryDelegateBuilderFactory.isCoalescing();
    }

    @Override
    public void setAttribute(final String inName, final Object inValue)
            throws IllegalArgumentException {
        mDocumentBuilderFactoryDelegateBuilderFactory.setAttribute(inName,
                inValue);
    }

    @Override
    public Object getAttribute(final String inName)
            throws IllegalArgumentException {
        return mDocumentBuilderFactoryDelegateBuilderFactory
                .getAttribute(inName);
    }

    @Override
    public void setFeature(final String inName, final boolean inValue)
            throws ParserConfigurationException {
        mDocumentBuilderFactoryDelegateBuilderFactory.setFeature(inName,
                inValue);
    }

    @Override
    public boolean getFeature(final String inName)
            throws ParserConfigurationException {
        return mDocumentBuilderFactoryDelegateBuilderFactory.getFeature(inName);
    }

    @Override
    public Schema getSchema() {
        return mDocumentBuilderFactoryDelegateBuilderFactory.getSchema();
    }

    @Override
    public void setSchema(final Schema inSchema) {
        mDocumentBuilderFactoryDelegateBuilderFactory.setSchema(inSchema);
    }

    @Override
    public void setXIncludeAware(final boolean inState) {
        mDocumentBuilderFactoryDelegateBuilderFactory.setXIncludeAware(inState);
    }

    @Override
    public boolean isXIncludeAware() {
        return mDocumentBuilderFactoryDelegateBuilderFactory.isXIncludeAware();
    }
}