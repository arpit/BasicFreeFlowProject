package com.arpitonline.samplefreeflowproject.views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.RelativeLayout;

public class ItemView extends RelativeLayout {

	Paint stroke;
	Paint checkMark;
	
	public ItemView(Context context) {
		super(context);
		init();
	}

	public ItemView(Context context, AttributeSet attrs) {
		super(context, attrs);
		init();
	}

	public ItemView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		init();
	}
	
	protected void init(){
		setWillNotDraw(false);
		stroke = new Paint();
		stroke.setColor(0xffeeeeee);
		stroke.setStyle(Style.STROKE);
		stroke.setStrokeWidth(2);
		
		checkMark = new Paint();
		checkMark.setColor(0xffFE848E);
		checkMark.setStyle(Style.STROKE);
		checkMark.setStrokeWidth(2);
		
	}
	
	@Override
	protected void onDraw(Canvas c){
		super.onDraw(c);
		c.drawLine(0, getMeasuredHeight()-2, getMeasuredWidth(), getMeasuredHeight()-2, stroke);
		c.drawCircle(getHeight()/2+20, getHeight()/2 , getHeight()/2-22, checkMark);
	}

}
