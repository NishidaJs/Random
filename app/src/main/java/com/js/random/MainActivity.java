package com.js.random;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Locale;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    public static final int PROC = 1;

    private int rollCounter = 0;
    private int marcoRoll = 0;

    private LinearLayout wrapper;
    private Button buttonRefresh;

    private int europeCount = 0;
    private int africanCount = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        wrapper = findViewById(R.id.wrapper);
        buttonRefresh = findViewById(R.id.buttonRefresh);
        buttonRefresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                recount();
            }
        });
    }

    private void recount() {
        wrapper.removeAllViews();
        for(int x = 0; x < 20; x++) {
            while (!isProc()) {
                rollCounter++;
            }
            TextView tv = new TextView(this);
            tv.setText(String.format(Locale.ENGLISH, "Test %d, Trial: %d", x, rollCounter));
            if(rollCounter >= 100) {
                africanCount++;
            }
            if(rollCounter < 10) {
                europeCount++;
            }
            wrapper.addView(tv);
            rollCounter = 0;
        }
        TextView tv = new TextView(this);
        tv.setText(String.format(Locale.ENGLISH, "Europe Count: %d", europeCount));
        wrapper.addView(tv);
        TextView t2 = new TextView(this);
        t2.setText(String.format(Locale.ENGLISH, "African Count: %d", africanCount));
        wrapper.addView(t2);
        TextView t3 = new TextView(this);
        t3.setText(String.format(Locale.ENGLISH, "Marco Count: %d", marcoRoll));
        wrapper.addView(t3);
    }

    private boolean isProc() {
        marcoRoll++;
        Random r = new Random();
        int l = r.nextInt(1000);
        if (rollCounter >= 100) {
            return true;
        }
        return l < PROC;
    }

    private boolean procModel01() {
        marcoRoll++;
        Random r = new Random();
        int bound = 1000;
        int currentRollCounter = rollCounter;
        while(currentRollCounter > 10) {
            bound -= 1;
            currentRollCounter -= 10;
        }
        int l = r.nextInt(bound);
//        if(rollCounter >= 100) {
//            return true;
//        }
        return l < PROC;
    }

}
