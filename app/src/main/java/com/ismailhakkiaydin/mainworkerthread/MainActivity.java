package com.ismailhakkiaydin.mainworkerthread;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private final static String TAG = MainActivity.class.getSimpleName();

    boolean donguCalisiyor;
    int donguSayisi;
    TextView textView;
    //Thread thread;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView) findViewById(R.id.tvSayi);

        /*MyThread myThread=new MyThread();
        thread=new Thread(myThread);*/
    }


    public void startThread(View view) {

        // thread.start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                donguCalisiyor = true;

                while (donguCalisiyor) {
                    try {
                        Thread.sleep(1000);
                        Log.i(TAG, "Döngü sayısı :" + donguSayisi + " Thread adı :" + Thread.currentThread().getName());

                        /*
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(getApplicationContext(), ""+donguSayisi, Toast.LENGTH_SHORT).show();
                            }
                        });*/

                        /*textView.post(new Runnable() {
                            @Override
                            public void run() {
                                textView.setText(""+donguSayisi);
                            }
                        });*/

                        textView.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                textView.setText("" + donguSayisi);
                            }
                        }, 5000);


                        donguSayisi++;
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            }
        }).start();

    }

    public void stopThread(View view) {

        donguCalisiyor = false;

    }

   /* public class MyThread implements Runnable{

        @Override
        public void run() {
            donguCalisiyor=true;

            while(donguCalisiyor){
                try {
                    Thread.sleep(1000);
                    Log.i(TAG, "Döngü sayısı :"+ donguSayisi + " Thread adı :"+ Thread.currentThread().getName());
                    donguSayisi ++;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }
    }
*/
}