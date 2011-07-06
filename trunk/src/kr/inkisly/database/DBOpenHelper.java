package kr.inkisly.database;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

import kr.inkisly.R;
import kr.inkisly.util.LogTrace;
import android.content.ContentValues;
import android.content.Context;
import android.content.res.AssetManager;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class DBOpenHelper extends SQLiteOpenHelper
{

	private Context mContext;
	private SQLiteDatabase mSQLiteDB = null;

	public static final String DB_NAME = "allThatCard.db";
	public static final int DB_VERSION = 1;

	public DBOpenHelper( Context context )
	{
		this( context, DBOpenHelper.DB_NAME, null, DBOpenHelper.DB_VERSION );
	}

	public DBOpenHelper( Context context, String name, CursorFactory factory,
			int version )
	{
		// super(context, name, factory, version);
		super( context, DBOpenHelper.DB_NAME, null, DBOpenHelper.DB_VERSION );
		mContext = context;
	}

	@Override
	public void onCreate( SQLiteDatabase db )
	{
		LogTrace.d( "onCreate" );

		String[] query = openSqlFile( R.raw.allthatcard ).split( ";" );

		for ( int i = 0; i < query.length; i++ )
		{
			db.execSQL( query[i] + ";" );
		}
	}

	@Override
	public void onUpgrade( SQLiteDatabase db, int oldVersion, int newVersion )
	{
		LogTrace.d( "onUpgrade" );

		// db.execSQL("DROP TABLE IF EXISTS " +
		// For100DaysDBColumn.Goal.TABLE_NAME );
		// db.execSQL("DROP TABLE IF EXISTS " +
		// For100DaysDBColumn.Memo.TABLE_NAME );
		// db.execSQL("DROP TABLE IF EXISTS " +
		// For100DaysDBColumn.Supporters.TABLE_NAME );
		// db.execSQL("DROP TABLE IF EXISTS " +
		// For100DaysDBColumn.Todo.TABLE_NAME );

		this.onCreate( db );
	}

	@Override
	public void onOpen( SQLiteDatabase db )
	{
		LogTrace.d( "onOpen" );
	}

	public boolean open()
	{
		if ( mSQLiteDB != null && mSQLiteDB.isOpen() )
			return true;

		synchronized ( this )
		{
			mSQLiteDB = this.getWritableDatabase();

			if ( mSQLiteDB == null )
			{
				return false;
			}
			else
			{
				return true;
			}

		}
	}

	public void close()
	{
		if ( mSQLiteDB != null && mSQLiteDB.isOpen()
				&& !mSQLiteDB.isDbLockedByOtherThreads()
				&& !mSQLiteDB.isDbLockedByCurrentThread() )
			mSQLiteDB.close();
	}

	public void beginTransaction()
	{
		if ( !open() )
		{
			return;
		}

		mSQLiteDB.beginTransaction();
	}

	public void setTransactionSuccessful()
	{
		mSQLiteDB.setTransactionSuccessful();
	}

	public void endTransaction()
	{
		mSQLiteDB.endTransaction();
	}

	public Cursor query( String table )
	{
		return query( table, null, null, null, null );
	}

	public Cursor query( String table, String[] columns, String selection,
			String[] selectionArgs, String orderBy )
	{
		return query( table, columns, selection, selectionArgs, null, null,
				orderBy );
	}

	public Cursor query( String table, String[] columns, String selection,
			String[] selectionArgs, String groupBy, String having,
			String orderBy )
	{

		if ( !open() )
		{
			return null;
		}

		if ( orderBy == null )
		{
			orderBy = DBColumn.DEFAULT_SORT_ORDER;
		}

		return mSQLiteDB.query( table, columns, selection, selectionArgs,
				groupBy, having, orderBy );
	}

	public Cursor rawQuery( String sql, String[] selectionArgs )
	{
		if ( !open() )
		{
			return null;
		}

		return mSQLiteDB.rawQuery( sql, selectionArgs );
	}

	public long insert( String table, String nullColumnHack,
			ContentValues values )
	{
		if ( !open() )
		{
			return 0;
		}

		return mSQLiteDB.insert( table, nullColumnHack, values );
	}

	public long replace( String table, String nullColumnHack,
			ContentValues initialValues )
	{
		if ( !open() )
		{
			return 0;
		}

		return mSQLiteDB.replace( table, nullColumnHack, initialValues );
	}

	public long bulkinsert( String table, String nullColumnHack,
			ContentValues[] values )
	{
		if ( !open() )
		{
			return 0;
		}

		long count = 0;

		try
		{
			mSQLiteDB.beginTransaction();
			for ( int i = 0; i < values.length; i++ )
			{
				long row = mSQLiteDB.insert( table, nullColumnHack, values[i] );

				if ( row != -1 )
				{
					count++;
				}
			}
			mSQLiteDB.setTransactionSuccessful();
		}
		catch ( Exception e )
		{
			count = 0;
		}
		finally
		{
			mSQLiteDB.endTransaction();
		}

		return count;
	}

	public long bulkreplace( String table, String nullColumnHack,
			ContentValues[] values )
	{

		if ( !open() )
		{
			return 0;
		}

		long count = 0;

		try
		{
			mSQLiteDB.beginTransaction();
			for ( int i = 0; i < values.length; i++ )
			{
				long row = mSQLiteDB.replace( table, nullColumnHack, values[i] );

				if ( row != -1 )
				{
					count++;
				}
			}
			mSQLiteDB.setTransactionSuccessful();
		}
		catch ( Exception e )
		{
			count = 0;
		}
		finally
		{
			mSQLiteDB.endTransaction();
		}

		return count;
	}

	public long update( String table, ContentValues values, String whereClause,
			String[] whereArgs )
	{
		if ( !open() )
		{
			return 0;
		}
		return mSQLiteDB.update( table, values, whereClause, whereArgs );
	}

	public int delete( String table, String whereClause, String[] whereArgs )
	{
		if ( !open() )
		{
			return 0;
		}
		return mSQLiteDB.delete( table, whereClause, whereArgs );
	}

	public String openSqlFile( int resId )
	{
		InputStream is = mContext.getResources().openRawResource( resId );
		InputStreamReader isr = null;

		try
		{
			isr = new InputStreamReader( is, "euc-kr" );
		}
		catch ( UnsupportedEncodingException e1 )
		{
			e1.printStackTrace();
			isr = new InputStreamReader( is );
		}

		BufferedReader br = new BufferedReader( isr );
		String readLine;
		String sqlStr = "";

		try
		{
			while ( ( readLine = br.readLine() ) != null )
			{
				sqlStr += readLine;
			}
		}
		catch ( Exception e )
		{
			// TODO: handle exception
		}
		finally
		{
			try
			{
				br.close();
				isr.close();
				is.close();
			}
			catch ( IOException e )
			{
				e.printStackTrace();
			}
		}

		LogTrace.d( sqlStr );

		return sqlStr;
	}

	/**
	 * @deprecated
	 * @Method Name : initialize
	 * @작성일 : Feb 24, 2011
	 * @author : sangjig.kim
	 * @Comment : assets에 있는 db를 복사하는 구분
	 * @param ctx
	 *            Context
	 */
	public static void initialize( Context ctx )
	{
		LogTrace.d( "initialize" );
		FileOutputStream fo = null;
		try
		{
			File outfile = ctx.getDatabasePath( DB_NAME );
			LogTrace.d( "initialize : " + outfile.getAbsolutePath() );

			if ( outfile.length() <= 0 )
			{
				AssetManager assetManager = ctx.getResources().getAssets();

				InputStream is = assetManager.open( DB_NAME,
						AssetManager.ACCESS_BUFFER );
				long filesize = is.available();
				byte[] tempdata = new byte[(int)filesize];
				is.read( tempdata );
				is.close();

				outfile.createNewFile();
				fo = new FileOutputStream( outfile );
				fo.write( tempdata );
			}
		}
		catch ( IOException e )
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				if ( fo != null )
					fo.close();
			}
			catch ( Exception e2 )
			{
			}
		}
	}
}
