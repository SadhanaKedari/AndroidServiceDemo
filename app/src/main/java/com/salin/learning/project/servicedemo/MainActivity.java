package com.salin.learning.project.servicedemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity{

    Button startButton, stopButton;
    String logStr = "ServiceDemo";
    Intent mIntent;
    TextView mTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.i(logStr, "Id: " + Thread.currentThread().getName());
        initUI();
    }

    public void initUI(){

        startButton = (Button) findViewById(R.id.start_button);
        stopButton = (Button) findViewById(R.id.stop_button);
        mTextView = (TextView) findViewById(R.id.textView);
     //   mIntent = new Intent(getApplicationContext(), MyService.class);

        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(logStr, "Service started");
                mTextView.setText("Music playing");
                mTextView.setTextSize(14);
                startService(new Intent(getBaseContext(), MyService.class));
            }
        });

        stopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mTextView.setText("Music Stopped");
                mTextView.setTextSize(14);
                Log.i(logStr, "Service stoped");
                stopService(new Intent(getBaseContext(), MyService.class));
            }
        });
    }
}