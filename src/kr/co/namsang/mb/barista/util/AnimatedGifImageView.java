package kr.co.namsang.mb.barista.util;

import java.io.InputStream;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.util.AttributeSet;
import android.widget.ImageView;

public class AnimatedGifImageView extends ImageView {
	
	private boolean mIsPlayingGif = false;    
	private GifDecoder mGifDecoder;    
	private Bitmap mTmpBitmap;   
	final Handler mHandler = new Handler(); 
	
	final Runnable mUpdateResults = new Runnable() { 
		public void run() { 
			if (mTmpBitmap != null && !mTmpBitmap.isRecycled()) { 
				AnimatedGifImageView.this.setImageBitmap(mTmpBitmap); 
			} 
		}
	};

	public AnimatedGifImageView(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
	}

	public void setInputStream(InputStream stream) {
		mGifDecoder = new GifDecoder(); 
		mGifDecoder.read(stream); 
		mIsPlayingGif = true;
	}
	
	public void play() {
		Thread thread = new Thread(
			new Runnable() { 
				public void run() {
					final int n = mGifDecoder.getFrameCount(); 
					final int ntimes = mGifDecoder.getLoopCount(); 
					int repetitionCounter = 0; 
					do { 
						for (int i = 0; i < n; i++) {
							mTmpBitmap = mGifDecoder.getFrame(i); 
							final int t = mGifDecoder.getDelay(i);
							mHandler.post(mUpdateResults); 
							try {
								Thread.sleep(t);
							} 
							catch (InterruptedException e) {
								e.printStackTrace(); 
							} 
						} 
						if (ntimes != 0) {
							repetitionCounter ++;
						}
					} while (mIsPlayingGif && (repetitionCounter <= ntimes)); 
				}
			});
		thread.start();
	}
}
