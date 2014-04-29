/**
 * Copyright 2012-present Namsang Labs.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.namsang.barista.util;

import android.graphics.Typeface;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public final class SimpleFontUtils {	

	private static Typeface[] typefaces = new Typeface[4];
	
	public static Typeface getNormal() { return typefaces[Typeface.NORMAL]; }
	public static void setNormal(Typeface typeface) { typefaces[Typeface.NORMAL] = typeface; }
	public static Typeface getBold() { return typefaces[Typeface.BOLD]; }
	public static void setBold(Typeface typeface) { typefaces[Typeface.BOLD] = typeface; }
	public static Typeface getItalic() { return typefaces[Typeface.ITALIC]; }
	public static void setItalic(Typeface typeface) { typefaces[Typeface.ITALIC] = typeface; }
	public static Typeface getBoldItalic() { return typefaces[Typeface.BOLD_ITALIC]; }
	public static void setBoldItalic(Typeface typeface) { typefaces[Typeface.BOLD_ITALIC] = typeface; }
	
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
				textView.setTypeface(typefaces[Typeface.BOLD_ITALIC]);
			else if (style == Typeface.BOLD)
				textView.setTypeface(typefaces[Typeface.BOLD]);
			else if (style == Typeface.ITALIC)
				textView.setTypeface(typefaces[Typeface.ITALIC]);
			else 
				textView.setTypeface(typefaces[Typeface.NORMAL]);		
		}
		catch (Exception e) {
			textView.setTypeface(typefaces[Typeface.NORMAL]);
		}
	}
	
	public static void setCustomFont(Button button) {
		try {	
			int style = button.getTypeface().getStyle();
			if (style == Typeface.BOLD_ITALIC)
				button.setTypeface(typefaces[Typeface.BOLD_ITALIC]);
			else if (style == Typeface.BOLD)
				button.setTypeface(typefaces[Typeface.BOLD]);
			else if (style == Typeface.ITALIC)
				button.setTypeface(typefaces[Typeface.ITALIC]);
			else
				button.setTypeface(typefaces[Typeface.NORMAL]);
		}
		catch(Exception e) {
			button.setTypeface(typefaces[Typeface.NORMAL]);
		}
	}
}
