package com.example.testservice2;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class TwoActivity extends AppCompatActivity implements View.OnClickListener {

    /**
     * 开启服务
     */
    private Button mBtnStart;
    /**
     * 停止服务
     */
    private Button mBtnStop;
    /**
     * 绑定服务
     */
    private Button mBtnBind;
    /**
     * 解绑服务
     */
    private Button mBtnUnbind;
    private TwoService.DownloadBinder mDownloadBinder;
    private ServiceConnection connection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            mDownloadBinder = (TwoService.DownloadBinder) service;
            mDownloadBinder.startDowndload();
            mDownloadBinder.getProgress();
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);
        initView();
    }

    private void initView() {
        mBtnStart = (Button) findViewById(R.id.btn_start);
        mBtnStart.setOnClickListener(this);
        mBtnStop = (Button) findViewById(R.id.btn_stop);
        mBtnStop.setOnClickListener(this);
        mBtnBind = (Button) findViewById(R.id.btn_bind);
        mBtnBind.setOnClickListener(this);
        mBtnUnbind = (Button) findViewById(R.id.btn_unbind);
        mBtnUnbind.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.btn_start:
                Intent startIntent = new Intent(this,TwoService.class);
                startService(startIntent);
                break;
            case R.id.btn_stop:
                Intent stopIntent  = new Intent(this,TwoService.class);
                startService(stopIntent );
                break;
            case R.id.btn_bind:
                Intent bindIntent  = new Intent(this,TwoService.class);
                bindService(bindIntent,connection,BIND_AUTO_CREATE);
                break;
            case R.id.btn_unbind:
                unbindService(connection);
                break;
        }
    }
}
