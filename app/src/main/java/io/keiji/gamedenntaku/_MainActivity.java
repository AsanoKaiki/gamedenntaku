package io.keiji.gamedenntaku;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;


public class _MainActivity extends AppCompatActivity {
    TextView textView;
    int kazu;
    int charText1;
    int charText2;
    int charText3;
    int charText4;
    int charText5;

    TextView chartext1;
    TextView chartext2;
    TextView chartext3;
    TextView chartext4;
    TextView chartext5;

    int size = 5;

    int[] charNumbers = new int[size]; // charNumbers[0] ~ charNumbers[4]
    TextView[] charTextViews = new TextView[size];

    int conut;
    int mTime;

    TextView textView1;
    Handler mHandler;
    Timer mTimer;
    TextView textView2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView) findViewById(R.id.textview);

        charTextViews[0] = (TextView) findViewById(R.id.charText1);
        charTextViews[1] = (TextView) findViewById(R.id.charText2);
        charTextViews[2] = (TextView) findViewById(R.id.charText3);
        charTextViews[3] = (TextView) findViewById(R.id.charText4);
        charTextViews[4] = (TextView) findViewById(R.id.charText5);

        textView1 = (TextView) findViewById(R.id.textView1);

        textView2 = (TextView) findViewById(R.id.textView2);
        mHandler = new Handler();

    }
    private void setNumber(int number) {
        kazu = number;
        textView.setText(String.valueOf(number));
    }


    public void one(View v) {
        setNumber(1);
    }

    public void two(View v) {
        setNumber(2);
    }

    public void three(View v) {
        setNumber(3);
    }

    public void four(View v) {
        setNumber(4);
    }

    public void five(View v) {
        setNumber(5);
    }

    public void six(View v) {
        setNumber(6);
    }

    public void seven(View v) {
        setNumber(7);
    }

    public void eight(View v) {
        setNumber(8);
    }

    public void nine(View v) {
        setNumber(9);
    }

    public void zero(View v) {
        setNumber(0);
    }


    public void start(View v) {
            mTime = 15;

            mTimer = new Timer(false);
            mTimer.schedule(new TimerTask(){
                @Override
            public void run(){
                    mHandler.post(new Runnable() {
                        @Override
                        public void run() {


                            mTime--;
                            textView2.setText("後" + mTime + "秒");
                            if (mTime == 0){
                                textView1.setText("残念");

                            }

                            Log.d("timeの数字=",String.valueOf(mTime));
                        }
                    });
                }
            }, 0, 1000);



//        charText1 = getRandomNumber(9);
//        charText2 = getRandomNumber(9);
//        charText4 = getRandomNumber(9);
//        charText3 = getRandomNumber(9);
//        charText5 = getRandomNumber(9);
//
//        charNumbers[0] = getRandomNumber(9);
//        charNumbers[1] = getRandomNumber(9);
//        charNumbers[2] = getRandomNumber(9);
//        charNumbers[3] = getRandomNumber(9);
//        charNumbers[4] = getRandomNumber(9);

        for (int i = 0; i < charNumbers.length; i++) {
            // for (int i = 0; i < 5; i++) {
            charNumbers[i] = getRandomNumber(9);
        }

        chartext1.setText(String.valueOf(charText1));
        chartext2.setText(String.valueOf(charText2));
        chartext3.setText(String.valueOf(charText3));
        chartext4.setText(String.valueOf(charText4));
        chartext5.setText(String.valueOf(charText5));

//        findViewById(R.id.charText3).setVisibility(View.VISIBLE);
//        findViewById(R.id.charText1).setVisibility(View.VISIBLE);
//        findViewById(R.id.charText2).setVisibility(View.VISIBLE);
//        findViewById(R.id.charText4).setVisibility(View.VISIBLE);
//        findViewById(R.id.charText5).setVisibility(View.VISIBLE);

        // index: i
        for (int i = 0; i < charTextViews.length; i++) {
            charTextViews[i].setText(String.valueOf(charNumbers[i]));
            charTextViews[i].setVisibility(View.VISIBLE);

        }



        conut++;

        if (conut == 6){
            for (int i = 0; i < charTextViews.length; i++) {
                charTextViews[i].setVisibility(View.INVISIBLE);
            }

            textView1.setText("おめでとう ");

        }


    }

    public void attack(View v) {


//        if (charNumbers[0] == kazu) {
//            charTextViews[0].setVisibility(View.INVISIBLE);
//        }
//
//        if (charNumbers[1] == kazu) {
//            charTextViews[1].setVisibility(View.INVISIBLE);
//        }


//        if (charNumbers[2] == kazu){
//            charTextViews[2].setVisibility(View.INVISIBLE);
//        }

//
//        if (charNumbers[3] == kazu){
//            charTextViews[3].setVisibility(View.INVISIBLE);
//        }

//        if (charNumbers[4] == kazu){
//            charTextViews[4].setVisibility(View.INVISIBLE);
//        }
        for (int i = 0; i < charTextViews.length; i++) {
            removeCharNumber(i);
        }


//        if (conut == 6) {
//            for (int i = 0; i < charTextViews.length; i++) {
//                charTextViews[i].setVisibility(View.INVISIBLE);
//            }

        removeCharNumber(5);

        textView1.setText("おめでとう ");
    }

    private void removeCharNumber(int i) {
        if (charNumbers[i] == kazu){
            charTextViews[i].setVisibility(View.INVISIBLE);
        }
    }

    private int getRandomNumber(int max) {
        Random random = new Random();
        return random.nextInt(max);
    }
}

