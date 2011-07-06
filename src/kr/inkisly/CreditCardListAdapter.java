package kr.inkisly;

import java.util.List;

import org.w3c.dom.Text;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class CreditCardListAdapter<T> extends ArrayAdapter<T>
{
	Context mContext;
	List<T> array;
	int resId;

	public CreditCardListAdapter( Context context, int textViewResourceId,
			List<T> objects )
	{
		super( context, textViewResourceId, objects );

		mContext = context;
		array = objects;
		resId = textViewResourceId;
	}

	@Override
	public int getCount()
	{
		// TODO Auto-generated method stub
		return super.getCount();
	}

	@Override
	public View getView( int position, View convertView, ViewGroup parent )
	{
		View v = convertView;

		LayoutInflater vi = (LayoutInflater)mContext.getSystemService( Context.LAYOUT_INFLATER_SERVICE );
		v = vi.inflate( resId, null );

		CreditCardVo vo = (CreditCardVo)array.get( position );

		TextView tvCreditCardName = (TextView)v.findViewById( R.id.tvCreditCardName );
		TextView tvCreditCardNumber = (TextView)v.findViewById( R.id.tvCreditCardNumber );
		TextView tvCreditCardInfo = (TextView)v.findViewById( R.id.tvCreditCardInfo );

		return v;
	}

}
