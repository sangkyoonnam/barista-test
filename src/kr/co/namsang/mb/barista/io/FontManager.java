package kr.co.namsang.mb.barista.io;

import kr.co.namsang.mb.barista.util.LogUtils;
import android.content.Context;
import android.graphics.Typeface;
import android.util.Pair;
import android.util.SparseArray;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public final class FontManager {
	
//	public static SparseArray<Typeface> typefaces = new SparseArray<Typeface>();
//	
//	public static Typeface setFont(Context context, int key, String fontName) {		
//		try {
//			String path = String.format("fonts/%s.ttf", "NanumGothicB");
//			path += ".mp3";  // FIXED: froyo 이하에서는 폰트 크기가 2MB 이하로 제한됨, 확장자를 미디어 타입인 mp3로 변경하여 해결
//			typeface = Typeface.createFromAsset(context.getAssets(), path);
//		}
//		catch (Exception e) {
//			LogUtils.e(LOG_TAG, "error=%s", e.getMessage());
//		}
//		
//		typefaces.append(key, getTypefcae(fontName));
//	}
//	
//	public static Typeface getTypeface(Context context, String fontName) {
//		Typeface typeface = null;
//		try {
//			String path = String.format("fonts/%s.ttf", fontName);;
//			typeface = Typeface.createFromAsset(context.getAssets(), path);
//			if (typeface == null) {
//				path += ".mp3";
//				typeface = Typeface.createFromAsset(context.getAssets(), path);
//			}
//		}
//		catch (Exception e) {
////			LogUtils.e(LOG_TAG, "error=%s", e.getMessage());
//		}
//		
//		return typeface;
//	}
//	
//	
//	/**
//	 * 
//	 * @param style
//	 * @param views
//	 */
//	public static adaptDefaultFont(int style, View... views) {
//		Typeface tf = getDefaultFont();
//		
//		for (View view : views) {
//			if (view instanceof TextView)
//				((TextView) view).setTypeface(tf, style);		
//			else if (view instanceof Button)
//				((Button) view).setTypeface(tf, style);
//		}
//	}
//	
//	/**
//	 * 
//	 * @param pairs
//	 */
//	public void adaptDefaultFont(Pair<Integer, View[]>... pairs) {
//		for (Pair<Integer, View[]> pair : pairs) {
//			int style = pair.first;
//			View[] views = pair.second;
//			this.adaptDefaultFont(style, views);
//		}
//	}
//	
//	/**
//	 * 
//	 * @param views
//	 */
//	public void adaptDefaultFont(View... views) {
//		this.adaptDefaultFont(Typeface.NORMAL, views);
//	}
}
