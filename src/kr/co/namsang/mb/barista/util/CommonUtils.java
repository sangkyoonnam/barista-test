package kr.co.namsang.mb.barista.util;

import java.util.List;

import kr.co.namsang.mb.barista.data.Version;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.ActivityManager.RunningServiceInfo;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.util.Log;

public class CommonUtils 
{
	private static final String LOG_TAG = LogUtils.makeLogTag(CommonUtils.class);
	
	private static Context sContext;
	public static void setContext(Context context) {
		sContext = context;
	}
	
	public static String getPackageName() {
    	return sContext.getPackageName();
    }
    
    public static Version getVersion() {
    	PackageManager packageManager = sContext.getPackageManager();
    	Version version = null;
    	try {
			String versionName = packageManager.getPackageInfo(getPackageName(), 0).versionName;
			version = new Version(versionName);
		}
    	catch (NameNotFoundException e) {
			LogUtils.e(LOG_TAG, "error=%s", e.getMessage());
		}    	
    	catch (IllegalArgumentException e) {
    		LogUtils.e(LOG_TAG, "error=%s", e.getMessage());
    	}
    	return version;
    }
    
	public static boolean isRunningProcess(Context context, String packageName) {		 
		ActivityManager manager = (ActivityManager)context.getSystemService(Context.ACTIVITY_SERVICE); 
		List<RunningAppProcessInfo> list = manager.getRunningAppProcesses();

		for (RunningAppProcessInfo procInfo : list) {          
			if (procInfo.processName.equals(packageName))                                   
				return true;          
		}

		return false;
	}

	public static boolean isRunningService(Context context, String packageName) {		 
		ActivityManager manager = (ActivityManager)context.getSystemService(Context.ACTIVITY_SERVICE); 
		List<RunningServiceInfo> list = manager.getRunningServices(1000);     

		for (RunningServiceInfo procInfo : list) {                                
			if (procInfo.service.getClassName().equals(packageName))                                   
				return true;
		}

		return false;
	}

	public static int getCallState(Context context) {
		TelephonyManager tm = (TelephonyManager)context.getSystemService(Context.TELEPHONY_SERVICE);
		return tm.getCallState();
	}
	
    public static boolean isGingerbread() {
        // Can use static final constants like HONEYCOMB, declared in later versions
        // of the OS since they are inlined at compile time. This is guaranteed behavior.
        return Build.VERSION.SDK_INT >= Build.VERSION_CODES.GINGERBREAD;
    }

    public static boolean isHoneycomb() {
        // Can use static final constants like HONEYCOMB, declared in later versions
        // of the OS since they are inlined at compile time. This is guaranteed behavior.
        return Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB;
    }
    
    
final int MAX_IMEI_LENGTH = 15;

public String getValidIMEI(String imei) {
    String valid_imei = null;
    try {
        int check_digit = calculateCheckDigit(imei);
        valid_imei = imei + check_digit;
    }
    catch (Exception e) {
        Log.e("PHONE", "error=" + e.getMessage());
    }
    return valid_imei;
}
 
public int calculateCheckDigit(String imei) throws Exception {
    if (imei.length() != MAX_IMEI_LENGTH - 1) throw new Exception("Invalid IMEI length, expected 14 digit of IMEI number! (w/o check digit)");
    int digit = 0;
    boolean jumping = false;
    for (int i = imei.length() - 1; i >= 0; i--) {
        int temp = Integer.parseInt(imei.substring(i, i + 1));
        if (jumping = !jumping)
            temp = eachSum(temp * 2);
        digit += temp;
    }
    digit %= 10;
    return (digit != 0) ? 10 - digit : digit;
};
 
public int eachSum(int num) {
    int total = 0;
    do {
        total += num % 10;
        num /= 10;
    } while (num > 0);
    return total;
}
}
