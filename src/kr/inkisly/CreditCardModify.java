package kr.inkisly;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class CreditCardModify extends Activity
{
	private Context mContext;

	private EditText etCardName;
	private EditText etCardNumber;
	private EditText etTermMonth;
	private EditText etTermYear;
	private EditText etCSV;
	private EditText etPayment;
	private EditText etCallCenter;
	private EditText etMemo;

	private Button btnInit;
	private Button btnAdd;
	private Button btnCancel;

	@Override
	protected void onCreate( Bundle savedInstanceState )
	{
		super.onCreate( savedInstanceState );

		setContentView( R.layout.credit_card_modify );

		loaddAllView();
	}

	private void loaddAllView()
	{
		etCardName = (EditText)findViewById( R.id.etCardName );
		etCardNumber = (EditText)findViewById( R.id.etCardNumber );
		etTermMonth = (EditText)findViewById( R.id.etMonth );
		etTermYear = (EditText)findViewById( R.id.etYear );
		etCSV = (EditText)findViewById( R.id.etCSV );
		etPayment = (EditText)findViewById( R.id.etPayment );
		etCallCenter = (EditText)findViewById( R.id.etCallCenter );
		etMemo = (EditText)findViewById( R.id.etMemo );

		btnInit = (Button)findViewById( R.id.btnInit );
		btnAdd = (Button)findViewById( R.id.btnAdd );
		btnCancel = (Button)findViewById( R.id.btnCancel );
	}
}
