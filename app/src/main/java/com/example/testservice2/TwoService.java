package com.example.testservice2;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

public class TwoService extends Service {
    private DownloadBinder mBinder = new DownloadBinder();

    //绑定的服务有
    public  class DownloadBinder extends Binder {
        public void startDowndload(){
            Log.d("tag","startDownload executed");
        }
        public int getProgress(){
            Log.d("tag","getProgress executed");
            return 0;
        }
    }
    @Override
    public IBinder onBind(Intent intent){
        return mBinder;
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.i("tag", "onUnbind: ");
        return super.onUnbind(intent);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d("tag", "onDestroy execute");
    }
}
    