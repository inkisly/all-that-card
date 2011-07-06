package kr.inkisly;

public class BankVo
{
	int _id;

	String bankCompany;

	String bankName;
	String bankNumber;
	String bankPerson;

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

	public String getBankCompany()
	{
		return bankCompany;
	}

	public void setBankCompany( String bankCompany )
	{
		this.bankCompany = bankCompany;
	}

	public String getBankName()
	{
		return bankName;
	}

	public void setBankName( String bankName )
	{
		this.bankName = bankName;
	}

	public String getBankNumber()
	{
		return bankNumber;
	}

	public void setBankNumber( String bankNumber )
	{
		this.bankNumber = bankNumber;
	}

	public String getmBankPerson()
	{
		return bankPerson;
	}

	public void setmBankPerson( String mBankPerson )
	{
		this.bankPerson = mBankPerson;
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
