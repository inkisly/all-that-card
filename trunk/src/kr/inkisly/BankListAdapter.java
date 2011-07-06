package kr.inkisly;

import java.util.List;

import org.w3c.dom.Text;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class BankListAdapter<T> extends ArrayAdapter<T>
{
	Context mContext;
	List<T> array;
	int resId;

	public BankListAdapter( Context context, int textViewResourceId,
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

		BankVo vo = (BankVo)array.get( position );

		TextView tvBankName = (TextView)v.findViewById( R.id.tvBankName );
		TextView tvBankNumber = (TextView)v.findViewById( R.id.tvBankNumber );

		tvBankName.setText( vo.getBankName() );
		tvBankNumber.setText( vo.getBankNumber() );

		return v;
	}

}
