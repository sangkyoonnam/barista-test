package org.namsang.barista.util;

import java.util.ArrayList;
import java.util.List;

import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.util.Pair;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class FontUtils {
	

	private static Typeface normal;
	private static Typeface bold;
	private static Typeface italic;
	
	public static Typeface getNormal() { return normal; }
	public static Typeface getBold() { return bold; }
	public static Typeface getItalic() { return italic; }
	
	public static void setCustomFont(AssetManager assetManager, 
			String normalFont, String boldFont, String italicFont) {
		if (normalFont != null)
			normal = Typeface.createFromAsset(assetManager, normalFont);
		if (boldFont != null)
			bold = Typeface.createFromAsset(assetManager, boldFont);
		if (italicFont != null)
			italic = Typeface.createFromAsset(assetManager, italicFont);
	}
	
	public static void setCustomFont(ViewGroup root) {
		try {
			for (int i = 0; i < root.getChildCount(); i++) {
				View view = root.getChildAt(i);
				if (view instanceof ViewGroup)
					setCustomFont((ViewGroup) view);
				else if (view instanceof TextView)
					setCustomFont((TextView) view);			
				else if (view instanceof Button)
					setCustomFont((Button) view);
			}
		}
		catch (Exception e) {}
	}

	public static void setCustomFont(TextView textView) {
		try {
			int style = textView.getTypeface().getStyle();
			if (style == Typeface.BOLD_ITALIC)
				textView.setTypeface(italic);
			else if (style == Typeface.BOLD)
				textView.setTypeface(bold);
			else if (style == Typeface.ITALIC)
				textView.setTypeface(italic);
			else 
				textView.setTypeface(normal);		
		}
		catch (Exception e) {
			textView.setTypeface(normal);
		}
	}
	
	public static void setCustomFont(Button button) {
		try {	
			int style = button.getTypeface().getStyle();
			if (style == Typeface.BOLD_ITALIC)
				button.setTypeface(italic);
			else if (style == Typeface.BOLD)
				button.setTypeface(bold);
			else if (style == Typeface.ITALIC)
				button.setTypeface(italic);
			else
				button.setTypeface(normal);
		}
		catch(Exception e) {
			button.setTypeface(normal);
		}
	}
}
