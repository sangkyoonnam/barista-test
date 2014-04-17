package kr.co.namsang.barista.util;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.os.Build;

public class BitmapHelper {
	public static boolean canUseForInBitmap(Bitmap candidate, BitmapFactory.Options targetOptions) {
	    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
	        // From Android 4.4 (KitKat) onward we can re-use if the byte size of
	        // the new bitmap is smaller than the reusable bitmap candidate
	        // allocation byte count.
	        int width = targetOptions.outWidth / targetOptions.inSampleSize;
	        int height = targetOptions.outHeight / targetOptions.inSampleSize;
	        int byteCount = width * height * getBytesPerPixel(candidate.getConfig());
	        return byteCount <= candidate.getAllocationByteCount();
	    }

	    // On earlier versions, the dimensions must match exactly and the inSampleSize must be 1
	    return candidate.getWidth() == targetOptions.outWidth
	            && candidate.getHeight() == targetOptions.outHeight
	            && targetOptions.inSampleSize == 1;
	}
	
	
	
	
	
	public static int calculateInSampleSize(
            BitmapFactory.Options options, int reqWidth, int reqHeight) {
    // Raw height and width of image
    final int height = options.outHeight;
    final int width = options.outWidth;
    int inSampleSize = 1;

    if (height > reqHeight || width > reqWidth) {

        final int halfHeight = height / 2;
        final int halfWidth = width / 2;

        // Calculate the largest inSampleSize value that is a power of 2 and keeps both
        // height and width larger than the requested height and width.
        while ((halfHeight / inSampleSize) > reqHeight
                && (halfWidth / inSampleSize) > reqWidth) {
            inSampleSize *= 2;
        }
    }

    return inSampleSize;
}
	

	/**
	 * A helper function to return the byte usage per pixel of a bitmap based on its configuration.
	 */
	public static int getBytesPerPixel(Config config) {
		switch (config) {
		case ARGB_8888:
			return 4;
		case RGB_565:
		case ARGB_4444:
			return 2;
		case ALPHA_8:
		default:
			return 1;
		}
	}
}
