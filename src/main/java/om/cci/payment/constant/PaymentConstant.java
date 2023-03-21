package om.cci.payment.constant;

public final class PaymentConstant {
	
	private PaymentConstant() {
	}

	public static final String AC_INFO_ERROR_TITLE = "Invalid Request";
	public static final String AC_INFO_ERROR_DETAIL = "The entered Account number and PIN was not found";
	public static final String AC_INFO_ERROR_INSTANCE = "urn:consolidated:error:invalidAccountPinCombination";
	//For NNE, Env – GOLD
	public static final String AC_INFO_ENTERPRISEID = "204.1";
	public static final String AC_INFO_MESSAGE_TRACKING_ID = "12345678001";
	public static final String AC_INFO_SEARCH_ID = "118964303303";
	public static final String AC_INFO_SEARCH_TYPE = "BAN";
	public static final String AC_INFO_URL = "http://skigold.fptest.fairpointtest.com:8180/CPI/CPI/CPIFRPServices";
	public static final String AC_INFO_USERNAME = "paymentus";
	public static final String AC_INFO_PASSWORD = "pymtsgld123";
	
}
