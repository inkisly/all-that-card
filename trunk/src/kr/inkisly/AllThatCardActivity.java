package kr.inkisly;

import kr.inkisly.util.LogTrace;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class AllThatCardActivity extends Activity
{
	/** Called when the activity is first created. */
	@Override
	public void onCreate( Bundle savedInstanceState )
	{
		super.onCreate( savedInstanceState );
		setContentView( R.layout.main );
	}

	@Override
	public boolean onCreateOptionsMenu( Menu menu )
	{
		LogTrace.d( "onCreateOptionsMenu" );
		MenuInflater inflater = getMenuInflater();
		inflater.inflate( R.menu.option_menu, menu );

		return super.onCreateOptionsMenu( menu );
	}

	@Override
	public boolean onPrepareOptionsMenu( Menu menu )
	{
		// TODO Auto-generated method stub
		LogTrace.d( "onPrepareOptionsMenu" );
		return super.onPrepareOptionsMenu( menu );
	}

	@Override
	public boolean onOptionsItemSelected( MenuItem item )
	{
		LogTrace.d( "onOptionsItemSelected" );
		LogTrace.d( "item.getItemId() : " + item.getItemId() );
		LogTrace.d( "item.getItemId() : " + R.id.add );

		Intent intent = new Intent();

		switch ( item.getItemId() )
		{
		case R.id.add:
			intent.setClass( AllThatCardActivity.this, BankList.class );
			startActivity( intent );
			break;
		case R.id.delete:
			intent.setClass( AllThatCardActivity.this, BankAccountModify.class );
			startActivity( intent );
			break;

		default:
			break;
		}

		return super.onOptionsItemSelected( item );
	}

	@Override
	public void onOptionsMenuClosed( Menu menu )
	{
		// TODO Auto-generated method stub
		LogTrace.d( "onOptionsMenuClosed" );
		super.onOptionsMenuClosed( menu );
	}

}