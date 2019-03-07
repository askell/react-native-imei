package codes.simen.IMEI;

import android.content.Context;
import android.telephony.TelephonyManager;

import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;

public class RNImeiModule extends ReactContextBaseJavaModule {

    ReactApplicationContext reactContext;

    public RNImeiModule(ReactApplicationContext reactContext) {
        super(reactContext);
        this.reactContext = reactContext;
    }

    @Override
    public String getName() {
        return "IMEI";
    }

    @ReactMethod
    public void getImei(Promise promise) {
        try {
            TelephonyManager tm = (TelephonyManager) this.reactContext.getSystemService(Context.TELEPHONY_SERVICE);
            String imei;
            if (android.os.Build.VERSION.SDK_INT >= 26) {
                imei = tm.getImei().trim();
            } else {
                imei = tm.getDeviceId();
            }
            promise.resolve(imei);
        } catch (NullPointerException npe) {
            promise.reject(npe);
        } catch (SecurityException se) {
            promise.reject(se);
        }

    }

}
