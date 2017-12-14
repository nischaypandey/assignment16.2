package com.example.user.processbar;

import android.os.AsyncTask;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

//main activity class extending AppCompatActivity class
public class MainActivity extends AppCompatActivity {

    //making the objects of button,and four progress bars
    Button button;
    ProgressBar b1,b2,b3,b4;

    //making handler object
    Handler handler=new Handler();

    //onCreate method
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //seeting content View of activity_main xml file
        setContentView(R.layout.activity_main);

        //setting objects by there respective id's
        button=findViewById(R.id.start);
        b1=findViewById(R.id.bar1);
        b2=findViewById(R.id.bar2);
        b3=findViewById(R.id.bar3);
        b4=findViewById(R.id.bar4);

        //setting click Listner for start button
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(getApplicationContext(),"Starting...",Toast.LENGTH_SHORT).show();
                //making a thread for first process Bar
                new Thread(new Runnable() {
                    int i=0;
                    int progressStatus;

                    //run method
                    @Override
                    public void run() {

                        while(progressStatus<100)
                        {
                            progressStatus+=10;
                            try {

                                //sleep for 500 milliseconds
                                Thread.sleep(500);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            //post method for setting progress of process bar
                            handler.post(new Runnable() {

                                //run method
                                @Override
                                public void run() {
                                    b1.setProgress(progressStatus);

                                }
                            });



                        }

                    }
                }).start();

                //setting thread for second process bar
                new Thread(new Runnable() {
                    int i=0;
                    int progressStatus;
                    //run method
                    @Override
                    public void run() {

                        while(progressStatus<100)
                        {
                            progressStatus+=10;
                            try {

                                //sleep for 50milliseconds
                                Thread.sleep(500);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            //post method
                            handler.post(new Runnable() {
                                //run method
                                @Override
                                public void run() {
                                    b2.setProgress(progressStatus);

                                }
                            });



                        }

                    }
                }).start();

                //setting thread for third process bar
                new Thread(new Runnable() {
                    int i=0;
                    int progressStatus;

                    //run method to execute in background
                    @Override
                    public void run() {

                        while(progressStatus<100)
                        {
                            progressStatus+=10;
                            try {
                                //sleep for 500 milliseconds
                                Thread.sleep(500);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            //post method to update process Bar
                            handler.post(new Runnable() {

                                //run method
                                @Override
                                public void run() {
                                    b3.setProgress(progressStatus);

                                }
                            });



                        }

                    }
                }).start();

                //thread for fourth process bar
                new Thread(new Runnable() {
                    int i=0;
                    int progressStatus;

                    //run method for working in thread
                    @Override
                    public void run() {

                        while(progressStatus<100)
                        {
                            progressStatus+=10;
                            try {

                                //sleep for 500 milliseconds
                                Thread.sleep(500);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            //post method for updating process Bar
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    b4.setProgress(progressStatus);

                                }
                            });



                        }

                    }
                }).start();


            }
        });
    }


}
