package kr.inkisly;

import kr.inkisly.database.DBColumn;
import kr.inkisly.database.DBOpenHelper;
import kr.inkisly.util.LogTrace;
import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class BankAccountModify extends Activity
{
	private Context mContext;

	private EditText etBankName;
	private EditText etBankPerson;
	private EditText etBankNumber;
	private EditText etCallCenter;
	private EditText etMemo;

	private Button btnInit;
	private Button btnAdd;
	private Button btnCancel;

	@Override
	protected void onCreate( Bundle savedInstanceState )
	{
		super.onCreate( savedInstanceState );

		mContext = getApplicationContext();

		setContentView( R.layout.bank_modify );

		loaddAllView();
	}

	private void loaddAllView()
	{
		etBankName = (EditText)findViewById( R.id.etBankName );
		etBankPerson = (EditText)findViewById( R.id.etBankPerson );
		etBankNumber = (EditText)findViewById( R.id.etBankNumber );
		etCallCenter = (EditText)findViewById( R.id.etCallCenter );
		etMemo = (EditText)findViewById( R.id.etMemo );

		btnInit = (Button)findViewById( R.id.btnInit );
		btnAdd = (Button)findViewById( R.id.btnAdd );
		btnCancel = (Button)findViewById( R.id.btnCancel );

		btnInit.setOnClickListener( mOnClickListener );
		btnAdd.setOnClickListener( mOnClickListener );
		btnCancel.setOnClickListener( mOnClickListener );
	}

	View.OnClickListener mOnClickListener = new View.OnClickListener()
	{

		@Override
		public void onClick( View v )
		{
			switch ( v.getId() )
			{
			case R.id.btnInit:

				break;
			case R.id.btnAdd:
				saveBankAccount();
				break;
			case R.id.btnCancel:

				break;

			default:
				break;
			}
		}
	};

	private void saveBankAccount()
	{
		LogTrace.d( "saveBankAccount" );

		ContentValues values = new ContentValues();
		values.put( DBColumn.BankAccount.BANK_COMPANY, "!!" );
		values.put( DBColumn.BankAccount.BANK_NAME,
				etBankName.getText().toString() );
		values.put( DBColumn.BankAccount.BANK_NUMBER,
				etBankNumber.getText().toString() );
		values.put( DBColumn.BankAccount.BANK_PERSON,
				etBankPerson.getText().toString() );
		values.put( DBColumn.CALL_CENTER, etCallCenter.getText().toString() );
		values.put( DBColumn.MEMO, etMemo.getText().toString() );

		DBOpenHelper db = new DBOpenHelper( mContext );
		long rst = db.insert( DBColumn.BankAccount.TABLE_NAME, null, values );
		LogTrace.d( "saveBankAccount : " + rst );
		db.close();
	}
}
