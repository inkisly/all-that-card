package kr.inkisly;

public class CreditCardVo
{
	int _id;

	String cardCompany;

	String cardName;
	String cardNumber;
	String cardMonth;
	String cardYear;
	String cardCSV;
	String cardPayment;

	String callCenter;
	String memo;

	public int getId()
	{
		return _id;
	}

	public void setId( int _id )
	{
		this._id = _id;
	}

	public String getCardCompany()
	{
		return cardCompany;
	}

	public void setCardCompany( String cardCompany )
	{
		this.cardCompany = cardCompany;
	}

	public String getCardName()
	{
		return cardName;
	}

	public void setCardName( String cardName )
	{
		this.cardName = cardName;
	}

	public String getCardNumber()
	{
		return cardNumber;
	}

	public void setCardNumber( String cardNumber )
	{
		this.cardNumber = cardNumber;
	}

	public String getCardMonth()
	{
		return cardMonth;
	}

	public void setCardMonth( String cardMonth )
	{
		this.cardMonth = cardMonth;
	}

	public String getCardYear()
	{
		return cardYear;
	}

	public void setCardYear( String cardYear )
	{
		this.cardYear = cardYear;
	}

	public String getCardCSV()
	{
		return cardCSV;
	}

	public void setCardCSV( String cardCSV )
	{
		this.cardCSV = cardCSV;
	}

	public String getCardPayment()
	{
		return cardPayment;
	}

	public void setCardPayment( String cardPayment )
	{
		this.cardPayment = cardPayment;
	}

	public String getCallCenter()
	{
		return callCenter;
	}

	public void setCallCenter( String callCenter )
	{
		this.callCenter = callCenter;
	}

	public String getMemo()
	{
		return memo;
	}

	public void setMemo( String memo )
	{
		this.memo = memo;
	}

}
