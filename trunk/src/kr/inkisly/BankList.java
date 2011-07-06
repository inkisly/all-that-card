package kr.inkisly;

import java.util.ArrayList;

import kr.inkisly.database.DBColumn;
import kr.inkisly.database.DBOpenHelper;
import kr.inkisly.util.LogTrace;
import android.app.ListActivity;
import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ContextMenu.ContextMenuInfo;
import android.widget.AdapterView;
import android.widget.ListView;

public class BankList extends ListActivity
{
	Context mContext;

	ListView mList;
	BankListAdapter<BankVo> mBankListAdapter;
	ArrayList<BankVo> mBankArray;

	@Override
	protected void onCreate( Bundle savedInstanceState )
	{
		super.onCreate( savedInstanceState );

		mContext = getApplicationContext();

		setContentView( R.layout.bank_list );

		loadAllView();

		getBankList();
	}

	private void loadAllView()
	{
		mList = getListView();
		mBankArray = new ArrayList<BankVo>();
		mBankListAdapter = new BankListAdapter<BankVo>( mContext,
				R.layout.listitem_bank, mBankArray );
		mList.setAdapter( mBankListAdapter );

		mList.setOnCreateContextMenuListener( mOnCreateContextMenuListener );
	}

	private void getBankList()
	{
		DBOpenHelper db = new DBOpenHelper( mContext );
		Cursor c = db.query( DBColumn.BankAccount.TABLE_NAME );

		if ( c != null )
		{

			if ( c.getCount() > 0 )
			{
				c.moveToFirst();

				do
				{
					BankVo vo = new BankVo();

					vo.setId( c.getInt( c.getColumnIndex( DBColumn._ID ) ) );
					vo.setBankName( c.getString( c.getColumnIndex( DBColumn.BankAccount.BANK_NAME ) ) );
					vo.setmBankPerson( c.getString( c.getColumnIndex( DBColumn.BankAccount.BANK_PERSON ) ) );
					vo.setBankNumber( c.getString( c.getColumnIndex( DBColumn.BankAccount.BANK_NUMBER ) ) );
					vo.setCallCenter( c.getString( c.getColumnIndex( DBColumn.CALL_CENTER ) ) );

					mBankArray.add( vo );
				}
				while ( c.moveToNext() );
			}

			c.close();
		}

		db.close();

		mBankListAdapter.notifyDataSetChanged();
	}

	View.OnCreateContextMenuListener mOnCreateContextMenuListener = new View.OnCreateContextMenuListener()
	{

		@Override
		public void onCreateContextMenu( ContextMenu menu, View v,
				ContextMenuInfo menuInfo )
		{
			MenuInflater inflater = getMenuInflater();
			inflater.inflate( R.menu.option_menu, menu );
		}
	};

	@Override
	public boolean onContextItemSelected( MenuItem item )
	{
		AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo)item.getMenuInfo();

		LogTrace.d( "onContextItemSelected : " + info.id );
		LogTrace.d( "onContextItemSelected : " + info.position );

		switch ( item.getItemId() )
		{
		case R.id.delete:
			deleteList( (int)info.position );
			break;

		default:
			break;
		}
		return super.onContextItemSelected( item );
	}

	private void deleteList( int position )
	{
		DBOpenHelper db = new DBOpenHelper( mContext );

		String whereClause = DBColumn.BankAccount._ID + " = ? ";
		String[] whereArgs = new String[] { Long.toString( mBankArray.get(
				position ).getId() ) };

		int count = db.delete( DBColumn.BankAccount.TABLE_NAME, whereClause,
				whereArgs );

		if ( count != 0 )
		{
			mBankArray.remove( position );
			mBankListAdapter.notifyDataSetChanged();
		}

		db.close();
	}
}
