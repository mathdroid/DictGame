package com.odi.sol.dgame;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.Random;


public class GameActivity extends Activity {
    //public ImageButton btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8;
    public ImageButton[] imgBtns = new ImageButton[8];
    //public Button pair;
    public boolean aMatch, bMatch, cMatch, dMatch, b1, b2, b3, b4, b5, b6, b7, b8;
    public int selected;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        Random rnd = new Random();
        selected=0;
        Intent intent = getIntent();
        final String message = intent.getStringExtra("GAMENUM");
        final int gameInt = intent.getIntExtra("GAMEINT",0);

        //Create text view
        TextView dispText = (TextView) findViewById(R.id.txtGame);
        dispText.setText(message);

        Button btnRes = (Button) findViewById(R.id.buttonResult);
        imgBtns[0] =(ImageButton)findViewById(R.id.imageBtn1);
        imgBtns[1] =(ImageButton)findViewById(R.id.imageBtn2);
        imgBtns[2] =(ImageButton)findViewById(R.id.imageBtn3);
        imgBtns[3] =(ImageButton)findViewById(R.id.imageBtn4);
        imgBtns[4] =(ImageButton)findViewById(R.id.imageBtn5);
        imgBtns[5] =(ImageButton)findViewById(R.id.imageBtn6);
        imgBtns[6] =(ImageButton)findViewById(R.id.imageBtn7);
        imgBtns[7] =(ImageButton)findViewById(R.id.imageBtn8);
        //pair =(Button)findViewById(R.id.pair);

        //pair.setVisibility(View.INVISIBLE);

        imgBtns[0].setOnClickListener(btn1_handler);
        imgBtns[1].setOnClickListener(btn2_handler);
        imgBtns[2].setOnClickListener(btn3_handler);
        imgBtns[3].setOnClickListener(btn4_handler);
        imgBtns[4].setOnClickListener(btn5_handler);
        imgBtns[5].setOnClickListener(btn6_handler);
        imgBtns[6].setOnClickListener(btn7_handler);
        imgBtns[7].setOnClickListener(btn8_handler);

        //pair.setOnClickListener(pair_handler);

        for (int i=0;i<8;i++) {
            imgBtns[i].setBackgroundResource(R.drawable.z);
        }

        aMatch=false;
        bMatch=false;
        cMatch=false;
        dMatch=false;

        b1= false;
        b2= false;
        b3= false;
        b4= false;
        b5= false;
        b6= false;
        b7= false;
        b8= false;

        final Handler handler=new Handler();
        handler.post(new Runnable(){

            @Override
            public void run() {

                // upadte textView here
                if (selected>1) {
                    selected = 0;
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    if (b1 && b2) {
                        aMatch = true;
                    }
                    if (b3 && b4) {
                        bMatch = true;
                    }
                    if (b5 && b6) {
                        cMatch = true;
                    }
                    if (b7 && b8) {
                        dMatch = true;
                    }

                    if (!aMatch) {
                        imgBtns[0].setBackgroundResource(R.drawable.z);
                        imgBtns[1].setBackgroundResource(R.drawable.z);
                        b1 = false;
                        b2 = false;
                    }
                    if (!bMatch) {
                        imgBtns[2].setBackgroundResource(R.drawable.z);
                        imgBtns[3].setBackgroundResource(R.drawable.z);
                        b3 = false;
                        b4 = false;
                    }
                    if (!cMatch) {
                        imgBtns[4].setBackgroundResource(R.drawable.z);
                        imgBtns[5].setBackgroundResource(R.drawable.z);
                        b5 = false;
                        b6 = false;
                    }
                    if (!dMatch) {
                        imgBtns[6].setBackgroundResource(R.drawable.z);
                        imgBtns[7].setBackgroundResource(R.drawable.z);

                        b7 = false;
                        b8 = false;
                    }
                }
                handler.postDelayed(this,500); // set time here to refresh textView

            }

        });

        btnRes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(GameActivity.this, ResultActivity.class);
                i.putExtra("GAMEINT", gameInt);
                startActivity(i);
            }
        });
    }

    View.OnClickListener btn1_handler = new View.OnClickListener() {

        public void onClick(View v) {
            // TODO Auto-generated method stub
            if ((!b1)&&(selected<2)) {
                imgBtns[0].setBackgroundResource(R.drawable.a1);
                selected++;
                b1 = true;
            }

        }
    };
    View.OnClickListener btn2_handler = new View.OnClickListener() {

        public void onClick(View v) {
            // TODO Auto-generated method stub
            if ((!b2)&&(selected<2)) {
                imgBtns[1].setBackgroundResource(R.drawable.a1);
                selected++;
                b2 = true;
            }
        }
    };
    View.OnClickListener btn3_handler = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            // TODO Auto-generated method stub
            if ((!b3)&&(selected<2)) {
                imgBtns[2].setBackgroundResource(R.drawable.b1);
                selected++;
                b3 = true;
            }


        }
    };
    View.OnClickListener btn4_handler = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            // TODO Auto-generated method stub
            if ((!b4)&&(selected<2)) {
                imgBtns[3].setBackgroundResource(R.drawable.b1);
                selected++;
                b4 = true;
            }

        }
    };
    View.OnClickListener btn5_handler = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            // TODO Auto-generated method stub
            if ((!b5)&&(selected<2)) {
                imgBtns[4].setBackgroundResource(R.drawable.c1);
                selected++;
                b5 = true;
            }

        }
    };
    View.OnClickListener btn6_handler = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            // TODO Auto-generated method stub
            if ((!b6)&&(selected<2)) {
                imgBtns[5].setBackgroundResource(R.drawable.c1);
                selected++;
                b6 = true;
            }


        }
    };
    View.OnClickListener btn7_handler = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            // TODO Auto-generated method stub
            if ((!b7)&&(selected<2)) {
                imgBtns[6].setBackgroundResource(R.drawable.d1);
                selected++;
                b7 = true;
            }

        }
    };
    View.OnClickListener btn8_handler = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            // TODO Auto-generated method stub
            if ((!b8)&&(selected<2)) {
                imgBtns[7].setBackgroundResource(R.drawable.d1);
                selected++;
                b8 = true;
            }
        }
    };

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.game, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
