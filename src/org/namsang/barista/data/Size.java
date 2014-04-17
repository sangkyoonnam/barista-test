package org.namsang.barista.data;

import android.graphics.Point;
import android.util.DisplayMetrics;

public class Size {
	public int width = 0;
	public int height = 0;
	
	public Size() {
		this.width = 0;
		this.height = 0;
	}
	
	public Size(int width, int height) {
		this.width = width;
		this.height = height;
	}
	
	public Size(Point p) {
		this.width = p.x;
		this.height = p.y;
	}
	
	public Size(int width, int height, float ratio) {
		this((int) (width * ratio), (int) (height * ratio));
	}
	
	public Size(DisplayMetrics displayMetrics) {
		this(displayMetrics.widthPixels, displayMetrics.heightPixels);
	}
	
	public Size(DisplayMetrics displayMetrics, float ratio) {
		this(displayMetrics.widthPixels, displayMetrics.heightPixels, ratio);
	}
	
	public int getWidth() {
		return width;
	}
	
	public int getHeight() {
		return height;
	}
}
