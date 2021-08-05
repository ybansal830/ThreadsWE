package com.myfirst.threadswe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button mBtnTask1,mBtnTask2;
    private WorkerThread workerThread;
    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        workerThread = new WorkerThread();
        workerThread.start();
    }

    private void initViews() {
        mBtnTask1 = findViewById(R.id.task1);
        mBtnTask2 = findViewById(R.id.task2);
        mBtnTask1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                workerThread.addTaskToMessageQueue(taskOne);
            }
        });
        mBtnTask2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                workerThread.addTaskToMessageQueue(taskTwo);
            }
        });
    }

    private Runnable taskOne = new Runnable() {
        @Override
        public void run() {
            Log.d(TAG,"Task 1");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    };

    private Runnable taskTwo = new Runnable() {
        @Override
        public void run() {
            Log.d(TAG,"Task 2");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    };
}