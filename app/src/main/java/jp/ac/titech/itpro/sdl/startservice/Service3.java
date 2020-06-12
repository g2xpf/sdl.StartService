package jp.ac.titech.itpro.sdl.startservice;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;

public class Service3 extends IntentService {
    private final static String TAG = jp.ac.titech.itpro.sdl.startservice.Service3.class.getSimpleName();
    public final static String EXTRA_MYARG = "MYARG";
    public final static String EXTRA_ANSWER = "ANSWER";
    public final static String ACTION = "jp.ac.titech.itpro.sdl.startservice.action.TEST_BROADCAST";

    public Service3() {
        super(TAG);
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        Log.d(TAG, "onHandleIntent in " + Thread.currentThread());
        Log.d(TAG, "myarg = " + intent.getStringExtra(EXTRA_MYARG));

        Intent sendIntent = new Intent();
        sendIntent.setAction(Service3.ACTION);
        sendIntent.putExtra(EXTRA_ANSWER, "Broadcast by Service3");
        sendBroadcast(sendIntent);

        try {
            Thread.sleep(5000); // 5 sec
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "onCreate in " + Thread.currentThread());
    }

    @Override
    public void onDestroy() {
        Log.d(TAG, "onDestroy in " + Thread.currentThread());
        super.onDestroy();
    }
}
