package kr.inkisly.database;

public class DBColumn
{

	public static final String DEFAULT_SORT_ORDER = "_id ASC";

	public static final String _ID = "_id";
	public static final String CALL_CENTER = "call_center";
	public static final String MEMO = "memo";

	public class SecretCard
	{
		public static final String TABLE_NAME = "SecretCard";
	}

	public class CreditCard
	{
		public static final String TABLE_NAME = "CreditCard";

		public static final String CARD_COMPANY = "card_company";
		public static final String CARD_NAME = "card_name";
		public static final String CARD_NUMBER = "card_number";
		public static final String CARD_VALID = "card_valid";
		public static final String CARD_CSV = "card_csv";
		public static final String CARD_PAYMENT = "card_payment";
	}

	public class BankAccount
	{
		public static final String TABLE_NAME = "BankAccount";

		public static final String _ID = "_id";
		public static final String BANK_COMPANY = "bank_company";
		public static final String BANK_NAME = "bank_name";
		public static final String BANK_PERSON = "bank_person";
		public static final String BANK_NUMBER = "bank_number";
	}
}
