package com.ss.securedetails.utils;

import android.content.Context;
import android.view.Gravity;
import android.widget.Toast;

public class Toas {

	
	
	/**
	 * Custom Toast
	 * 
	 * @param context
	 * @param message
	 */
	public static void show(Context context, String message) {
		
    	
    	Toast toast = Toast.makeText(context, "" + message, Toast.LENGTH_SHORT);
    	toast.setGravity(Gravity.TOP, 0, 100);
    	toast.show();		
    	
		
		/*
		LayoutInflater inflater = getLayoutInflater();
		View layout = inflater.inflate(R.layout.toast_layout, (ViewGroup) findViewById(R.id.toast_layout_root));
		
		ImageView image = (ImageView) layout.findViewById(R.id.image);
		image.setImageResource(R.drawable.android);
		TextView text = (TextView) layout.findViewById(R.id.text);
		text.setText("Hello! This is a custom toast!");
		
		
		Toast toast = new Toast(context);
		toast.setDuration(Toast.LENGTH_SHORT);
    	toast.setGravity(Gravity.CENTER, 0, 0);
		
    	LayoutInflater inflaterUnequal = LayoutInflater.from(context);
		View view = inflaterUnequal.inflate(R.layout.toast, null);
		LinearLayout main 	= (LinearLayout) view.findViewById(R.id.main);
		TextView textView 	= (TextView) view.findViewById(R.id.message);
		
		MyFont font = new MyFont(context);
		font.setAppFont(main, MyFont.DEFAULT_FONT);
		
		textView.setText(""+message);
		toast.setView(view);
    	
		toast.show();*/
	}	

}
