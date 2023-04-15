package com.egabi.eg.projectmanagement.constant;

public class AppConstants {

    public final static String DEFAULT_NS ="urn:oasis:names:specification:ubl:schema:xsd:Invoice-2";
    public final static String DEFAULT_CAC ="urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2";
    public final static String DEFAULT_CBC ="urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2";
    public final static String DEFAULT_EXT ="urn:oasis:names:specification:ubl:schema:xsd:CommonExtensionComponents-2";
    public final static String DEFAULT_SIG ="urn:oasis:names:specification:ubl:schema:xsd:CommonSignatureComponents-2";
    public final static String DEFAULT_SAC ="urn:oasis:names:specification:ubl:schema:xsd:SignatureAggregateComponents-2";
    public final static String DEFAULT_SBC ="urn:oasis:names:specification:ubl:schema:xsd:SignatureBasicComponents-2";

    public final static String DEFAULT_DS ="http://www.w3.org/2000/09/xmldsig#";
    public static final String GENERATE_INV_STEP_NAME="GENERAT_INVOICE";
    public static final String SIGN_INV_STEP_NAME="SIGN_INVOICE";
    public static final String GENERATE_REQ_INV_STEP_NAME="GENERAT_INVOICE_REQUEST";
    public static final String VALIDATE_INV_STEP_NAME="VALIDATE_INVOICE_XML";
    public static final String COMPLAINCE_INV_STEP_NAME="COMPLAINCE_INVOICE";
    public static final String REPORT_INV_STEP_NAME="REPORT_INVOICE";
    public static final String CLEARANCE_INV_STEP_NAME="CLEARANCE_INVOICE";

    public static final String INVOICE_GENERATED_STATUS="INVOICE_GENERATED";
    public static final String INVOICE_GENERATED_FAILD_STATUS="INVOICE_GENERATED_FAILD";
    public static final String INVOICE_SIGNED_STATUS="INVOICE_SIGNED";
    public static final String INVALID_INVOICE_XML="INVALID_XML_INVOICE";
    public static final String INVOICE_REPORT_SUCC_STATUS="INVOICE_REPORT_SUCC";
    public static final String INVOICE_COMPLAINCE_SUCC_STATUS="INVOICE_COMPLAINCE_SUCC";
    public static final String INVOICE_COMPLAINCE_FAILD_STATUS="INVOICE_COMPLAINCE_FAILD";
    public static final String INVOICE_REPORT_FAILD_STATUS="INVOICE_REPORT_FAILD";
    public static final String INVOICE_CLEAR_FAILD_STATUS="INVOICE_CLEAR_FAILD";
    public static final String INVOICE_CLEAR_SUCC_STATUS="INVOICE_CLEAR_SUCC";
    public static final String INVOICE_SUCCESS_STATUS="SUCCESS";




    public static String [] ROLE_CLAIMS = new String[] {"1","2","3","5","6","7","8","10"};

    public static String USER_DEFAULT_PASSWORD = "Hello123";

    // OTP
    public final static int OTP_LENGTH = 6;
    public final static long MINS_TO_MILLIS_FACTOR = 1000L * 60L;

    public static final String ORACLE_DB_TYPE="ORACLE";
    public static final String POSTGRESQL_DB_TYPE="POSTGRESQL";

    //   ------------------ Egabi Environment ---------------------
    public static final String dbUsername = "AQALAT";
    public static final String dbPassword = "AQALAT";
    public static final String dbThinConn = "jdbc:oracle:thin:@//10.3.1.245:1521/ORCL";



}
