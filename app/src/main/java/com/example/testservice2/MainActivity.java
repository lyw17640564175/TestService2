package com.example.testservice2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    /**
     * 开启服务
     */
    private Button mBtnStart;
    /**
     * 停止服务
     */
    private Button mBtnStop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        Log.i("tag", "onCreate: "+"kskkssk");
    }

    private void initView() {
        mBtnStart = (Button) findViewById(R.id.btn_start);
        mBtnStart.setOnClickListener(this);
        mBtnStop = (Button) findViewById(R.id.btn_stop);
        mBtnStop.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.btn_start:
                Intent startIntent = new Intent(this, MyService.class);
                startService(startIntent);
                break;
            case R.id.btn_stop:
                Intent stopIntent = new Intent(this, MyService.class);
                stopService(stopIntent);
                break;
        }
    }
}
