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
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;


public class GameActivity extends Activity {
    //public ImageButton btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8;
    public ImageButton[] imgBtns = new ImageButton[8];
    public boolean[] bs = new boolean[8];
    //public Button pair;
    public boolean aMatch, bMatch, cMatch, dMatch,gameRun;
    public int selected, playerNum, turnNum, aCount,bCount,cCount,dCount;
    public int m, maxPrize, curPrize;
    public Button btnRes;
    private Thread thread;
    public ImageView imgP1, imgP2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        final Random rnd = new Random();
        selected=0;
        playerNum=0;
        turnNum=0;
        m=0;
        Intent intent = getIntent();
        final String message = intent.getStringExtra("GAMENUM");
        final int gameInt = intent.getIntExtra("GAMEINT",0);
        if (gameInt<3){
            maxPrize=750000;
        }
        else if (gameInt==3){
            maxPrize=3000000;
        }
        else{
            maxPrize=15000000;
        }
        curPrize=0;
        aCount=0;
        bCount=0;
        cCount=0;
        dCount=0;


        //Create text view
        final TextView dispText = (TextView) findViewById(R.id.txtGame);
        dispText.setText(message+" Player "+ String.valueOf(playerNum));


        btnRes = (Button) findViewById(R.id.buttonResult);
        imgBtns[0] =(ImageButton)findViewById(R.id.imageBtn1);
        imgBtns[1] =(ImageButton)findViewById(R.id.imageBtn2);
        imgBtns[2] =(ImageButton)findViewById(R.id.imageBtn3);
        imgBtns[3] =(ImageButton)findViewById(R.id.imageBtn4);
        imgBtns[4] =(ImageButton)findViewById(R.id.imageBtn5);
        imgBtns[5] =(ImageButton)findViewById(R.id.imageBtn6);
        imgBtns[6] =(ImageButton)findViewById(R.id.imageBtn7);
        imgBtns[7] =(ImageButton)findViewById(R.id.imageBtn8);
        //pair =(Button)findViewById(R.id.pair);

        btnRes.setVisibility(View.INVISIBLE);

        imgBtns[0].setOnClickListener(btn1_handler);
        imgBtns[1].setOnClickListener(btn2_handler);
        imgBtns[2].setOnClickListener(btn3_handler);
        imgBtns[3].setOnClickListener(btn4_handler);
        imgBtns[4].setOnClickListener(btn5_handler);
        imgBtns[5].setOnClickListener(btn6_handler);
        imgBtns[6].setOnClickListener(btn7_handler);
        imgBtns[7].setOnClickListener(btn8_handler);

        imgP1 = (ImageView) findViewById(R.id.imgP1);
        imgP2 = (ImageView) findViewById(R.id.imgP2);

        //pair.setOnClickListener(pair_handler);

        for (int i=0;i<8;i++) {
            imgBtns[i].setBackgroundResource(R.drawable.z);
        }

        aMatch=false;
        bMatch=false;
        dMatch=false;
        cMatch=false;
        gameRun=true;



        for (int i=0;i<8;i++) {
            bs[i]=false;
        }

        /*thread=  new Thread(){
            @Override
            public void run(){
                while(gameRun){
                    if (playerNum==0){
                        imgP1.setBackgroundResource(R.drawable.ic_active1);
                        imgP2.setBackgroundResource(R.drawable.ic_passive2);
                    }
                    else{
                        imgP1.setBackgroundResource(R.drawable.ic_passive1);
                        imgP2.setBackgroundResource(R.drawable.ic_active2);

                    }
                }

                // TODO
            }
        };

        thread.start();*/
        final Handler handler=new Handler();
        handler.post(new Runnable(){

            @Override
            public void run() {

                // upadte textView here
                if (playerNum==0){
                    imgP1.setBackgroundResource(R.drawable.ic_active1);
                    imgP2.setBackgroundResource(R.drawable.ic_passive2);
                }
                else{
                    imgP1.setBackgroundResource(R.drawable.ic_passive1);
                    imgP2.setBackgroundResource(R.drawable.ic_active2);

                }
                if (selected>1) {
                    selected = 0;
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    if (bs[0] && bs[1]) {
                        aMatch = true;
                        if (aCount<1){
                            curPrize=curPrize+maxPrize/4;
                        }
                        aCount++;
                    }
                    if (bs[2] && bs[3]) {
                        bMatch = true;
                        if (bCount<1){
                            curPrize=curPrize+maxPrize/4;
                        }
                        bCount++;
                    }
                    if (bs[4] && bs[5]) {
                        cMatch = true;
                        if (cCount<1){
                            curPrize=curPrize+maxPrize/4;
                        }
                        cCount++;
                    }
                    if (bs[6] && bs[7]) {
                        dMatch = true;
                        if (dCount<1){
                            curPrize=curPrize+maxPrize/4;
                        }
                        dCount++;
                    }

                    if (!aMatch) {
                        imgBtns[0].setBackgroundResource(R.drawable.z);
                        imgBtns[1].setBackgroundResource(R.drawable.z);
                        bs[0] = false;
                        bs[1] = false;
                    }
                    if (!bMatch) {
                        imgBtns[2].setBackgroundResource(R.drawable.z);
                        imgBtns[3].setBackgroundResource(R.drawable.z);
                        bs[2] = false;
                        bs[3] = false;
                    }
                    if (!cMatch) {
                        imgBtns[4].setBackgroundResource(R.drawable.z);
                        imgBtns[5].setBackgroundResource(R.drawable.z);
                        bs[4] = false;
                        bs[5] = false;
                    }
                    if (!dMatch) {
                        imgBtns[6].setBackgroundResource(R.drawable.z);
                        imgBtns[7].setBackgroundResource(R.drawable.z);

                        bs[6] = false;
                        bs[7] = false;
                    }
                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                m=0;
                // BASE TURN: PLAYER FIRST CPU LATER
                if (turnNum==0) {

                    if (playerNum != 0) {

                        m = rnd.nextInt(8);
                        if (!bs[m]) {
                            try {
                                Thread.sleep(100 + rnd.nextInt(10) * 100);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            if (m == 1 || m == 0) {
                                imgBtns[m].setBackgroundResource(R.drawable.a1);
                            } else if (m == 2 || m == 3) {
                                imgBtns[m].setBackgroundResource(R.drawable.b1);
                            } else if (m == 4 || m == 5) {
                                imgBtns[m].setBackgroundResource(R.drawable.c1);
                            } else if (m == 6 || m == 7) {
                                imgBtns[m].setBackgroundResource(R.drawable.d1);
                            }
                            selected++;
                            bs[m] = true;
                            turnNum=1;
                            playerNum=1;

                        }

                    }
                }
                // ODD TURN
                else{
                    if (playerNum != 0) {

                        m = rnd.nextInt(8);
                        if (!bs[m]) {
                            try {
                                Thread.sleep(100 + rnd.nextInt(10) * 100);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            if (m == 1 || m == 0) {
                                imgBtns[m].setBackgroundResource(R.drawable.a1);
                            } else if (m == 2 || m == 3) {
                                imgBtns[m].setBackgroundResource(R.drawable.b1);
                            } else if (m == 4 || m == 5) {
                                imgBtns[m].setBackgroundResource(R.drawable.c1);
                            } else if (m == 6 || m == 7) {
                                imgBtns[m].setBackgroundResource(R.drawable.d1);
                            }
                            selected++;
                            bs[m] = true;
                            playerNum=0;

                        }

                    }
                }
                if (aMatch&&bMatch&&cMatch&&dMatch){
                    btnRes.setVisibility(View.VISIBLE);
                    imgP1.setBackgroundResource(R.drawable.ic_passive1);
                    imgP2.setBackgroundResource(R.drawable.ic_passive2);
                }
                dispText.setText("SCORE: " + String.valueOf(curPrize));
                handler.postDelayed(this,100); // set time here to refresh textView

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
            if ((!bs[0])&&(selected<2)&&(playerNum==0)) {
                imgBtns[0].setBackgroundResource(R.drawable.a1);
                selected++;
                bs[0] = true;

                if (turnNum==0){
                    playerNum=1;
                }
                else{
                    turnNum=0;
                    playerNum=0;
                }

            }

        }
    };
    View.OnClickListener btn2_handler = new View.OnClickListener() {

        public void onClick(View v) {
            // TODO Auto-generated method stub
            if ((!bs[1])&&(selected<2)&&(playerNum==0)) {
                imgBtns[1].setBackgroundResource(R.drawable.a1);
                selected++;
                bs[1] = true;
                if (turnNum==0){
                    playerNum=1;
                }
                else{
                    turnNum=0;
                    playerNum=0;
                }
            }
        }
    };
    View.OnClickListener btn3_handler = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            // TODO Auto-generated method stub
            if ((!bs[2])&&(selected<2)&&(playerNum==0)) {
                imgBtns[2].setBackgroundResource(R.drawable.b1);
                selected++;
                bs[2] = true;
                if (turnNum==0){
                    playerNum=1;
                }
                else{
                    turnNum=0;
                    playerNum=0;
                }
            }


        }
    };
    View.OnClickListener btn4_handler = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            // TODO Auto-generated method stub
            if ((!bs[3])&&(selected<2)&&(playerNum==0)) {
                imgBtns[3].setBackgroundResource(R.drawable.b1);
                selected++;
                bs[3] = true;
                if (turnNum==0){
                    playerNum=1;
                }
                else{
                    turnNum=0;
                    playerNum=0;
                }
            }

        }
    };
    View.OnClickListener btn5_handler = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            // TODO Auto-generated method stub
            if ((!bs[4])&&(selected<2)&&(playerNum==0)) {
                imgBtns[4].setBackgroundResource(R.drawable.c1);
                selected++;
                bs[4] = true;
                if (turnNum==0){
                    playerNum=1;
                }
                else{
                    turnNum=0;
                    playerNum=0;
                }
            }

        }
    };
    View.OnClickListener btn6_handler = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            // TODO Auto-generated method stub
            if ((!bs[5])&&(selected<2)&&(playerNum==0)) {
                imgBtns[5].setBackgroundResource(R.drawable.c1);
                selected++;
                bs[5] = true;
                if (turnNum==0){
                    playerNum=1;
                }
                else{
                    turnNum=0;
                    playerNum=0;
                }
            }


        }
    };
    View.OnClickListener btn7_handler = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            // TODO Auto-generated method stub
            if ((!bs[6])&&(selected<2)&&(playerNum==0)) {
                imgBtns[6].setBackgroundResource(R.drawable.d1);
                selected++;
                bs[6] = true;
                if (turnNum==0){
                    playerNum=1;
                }
                else{
                    turnNum=0;
                    playerNum=0;
                }
            }

        }
    };
    View.OnClickListener btn8_handler = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            // TODO Auto-generated method stub
            if ((!bs[7])&&(selected<2)&&(playerNum==0)) {
                imgBtns[7].setBackgroundResource(R.drawable.d1);
                selected++;
                bs[7] = true;
                if (turnNum==0){
                    playerNum=1;
                }
                else{
                    turnNum=0;
                    playerNum=0;
                }
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
