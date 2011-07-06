package kr.inkisly.util;

import android.content.Context;
import android.widget.Toast;

public class CommonUtil
{
	private static Toast mToast = null;

	public static void showToast( Context _context, int resid )
	{
		if ( mToast == null )
		{
			mToast = Toast.makeText( _context, "", Toast.LENGTH_SHORT );
		}

		mToast.setText( resid );
		mToast.show();
	}

	public static void showToast( Context _context, String _text )
	{
		if ( mToast == null )
		{
			mToast = Toast.makeText( _context, "", Toast.LENGTH_SHORT );
		}

		mToast.setText( _text );
		mToast.show();
	}
}
