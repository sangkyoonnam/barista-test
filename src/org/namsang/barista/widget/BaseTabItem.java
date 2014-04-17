package org.namsang.barista.widget;

import android.content.Context;
import android.view.Gravity;
import android.widget.Button;

public class BaseTabItem extends Button {
	// tag
	private static final String LOG_TAG = BaseTabItem.class.getName();
	
	public BaseTabItem(Context context) {
		super(context);
		this.setGravity(Gravity.CENTER_HORIZONTAL);
	}
}
