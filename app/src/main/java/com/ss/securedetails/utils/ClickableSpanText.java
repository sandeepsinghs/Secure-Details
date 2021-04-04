package com.ss.securedetails.utils;

import android.content.Context;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;

public class ClickableSpanText extends ClickableSpan {

	private OnClickListener mListener;
	private Context ctx ;
	private int color;

	public ClickableSpanText(Context ctx, int color, OnClickListener listener) {
		mListener = listener;
		this.ctx = ctx ;
		this.color = color;
	
	}

	@Override
	public void onClick(View widget) {

		if (mListener != null)
			mListener.onClick();
	}

	public interface OnClickListener {
		void onClick();
	}
	
	@Override
	public void updateDrawState(TextPaint ds) {
		// TODO Auto-generated method stub
		super.updateDrawState(ds);
		ds.setUnderlineText(true);
		ds.setColor(ctx.getResources().getColor(color));
	}
	
}