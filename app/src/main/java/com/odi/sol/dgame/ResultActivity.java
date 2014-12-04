package com.odi.sol.dgame;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class ResultActivity extends Activity {
    public int phase, maxPrize, gameInt;
    private TextView resText,resText2,resText3,numText,numText2, msg2;
    private Thread thread;
    public Button btnViewRes, btnAgree,btnDisagree;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);Intent intent = getIntent();
        phase=0;

        gameInt = intent.getIntExtra("GAMEINT",0);
        if (gameInt<3){
            maxPrize=750000;
        }
        else if (gameInt==3){
            maxPrize=3000000;
        }
        else{
            maxPrize=15000000;
        }

        resText = (TextView) findViewById(R.id.txtRes1);
        resText2 = (TextView) findViewById(R.id.txtRes2);
        resText3 = (TextView) findViewById(R.id.txtRes3);
        numText = (TextView) findViewById(R.id.txtResNum1);
        numText2 = (TextView) findViewById(R.id.txtResNum2);
        msg2 = (TextView) findViewById(R.id.txtMsg2);
        msg2.setVisibility(View.INVISIBLE);
        Typeface typeSub = Typeface.createFromAsset(getAssets(), "fonts/game_over.ttf");
        Typeface typeTitle = Typeface.createFromAsset(getAssets(), "fonts/ka1.ttf");
        resText.setTypeface(typeSub);
        resText2.setTypeface(typeSub);
        resText3.setTypeface(typeSub);
        numText.setTypeface(typeTitle);
        numText2.setTypeface(typeTitle);

        btnViewRes = (Button) findViewById(R.id.btnVRes);
        btnViewRes.setVisibility(View.INVISIBLE);
        btnAgree = (Button) findViewById(R.id.btnAgree);
        btnAgree.setVisibility(View.INVISIBLE);
        btnDisagree = (Button) findViewById(R.id.btnDisagree);
        btnDisagree.setVisibility(View.INVISIBLE);

        resText.setText(getString(R.string.txtCongratsTop));
        numText.setText(String.valueOf(maxPrize));
        numText2.setText(getString(R.string.pleaseWait));
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {
                btnViewRes.setVisibility(View.VISIBLE);
            }
        }, 3000);
        btnViewRes.setOnClickListener(btnVRHandler);

        btnDisagree.setOnClickListener(btnDisagreeHandler);

        btnAgree.setOnClickListener(btnAgreeHandler);
    }
    View.OnClickListener btnVRHandler = new View.OnClickListener() {

        public void onClick(View v) {
            // TODO Auto-generated method stub
            btnViewRes.setVisibility(View.INVISIBLE);
            if (gameInt==1){
                resText.setText(getString(R.string.result));
                numText.setText(getString(R.string.result_1_anda));
                numText2.setText(getString(R.string.result_1_saya));
            }
            else if (gameInt==2){

                resText.setText(getString(R.string.result));
                numText.setText(getString(R.string.result_2_anda));
                numText2.setText(getString(R.string.result_2_saya));
            }
            else if (gameInt==3){

                resText.setText(getString(R.string.result));
                numText.setText(getString(R.string.result_3_anda));
                numText2.setText(getString(R.string.result_3_saya));
            }

            else{

                resText.setText(getString(R.string.result));
                numText.setText(getString(R.string.result_4_anda));
                numText2.setText(getString(R.string.result_4_saya));
            }

            resText2.setText(getString(R.string.result_untukanda));
            resText3.setText(getString(R.string.result_untuksaya));

            msg2.setVisibility(View.VISIBLE);
            Handler handlerx = new Handler();
            handlerx.postDelayed(new Runnable() {
                public void run() {
                    btnAgree.setVisibility(View.VISIBLE);
                    if (gameInt!=1) {
                        btnDisagree.setVisibility(View.VISIBLE);
                    }
                }
            }, 1500);

        }
    };
    View.OnClickListener btnDisagreeHandler = new View.OnClickListener() {

        public void onClick(View v) {
            // TODO Auto-generated method stub
            resText.setVisibility(View.INVISIBLE);
            resText2.setVisibility(View.INVISIBLE);
            resText3.setVisibility(View.INVISIBLE);
            numText.setVisibility(View.INVISIBLE);
            numText2.setText(getString(R.string.pleaseWait));
            btnDisagree.setVisibility(View.INVISIBLE);
            btnAgree.setVisibility(View.INVISIBLE);
            msg2.setVisibility(View.INVISIBLE);
            Handler handlerx = new Handler();
            handlerx.postDelayed(new Runnable() {
                public void run() {
                    resText.setVisibility(View.VISIBLE);
                    resText2.setVisibility(View.VISIBLE);
                    resText3.setVisibility(View.VISIBLE);
                    numText.setVisibility(View.VISIBLE);
                    if (gameInt==1){
                        numText.setText(getString(R.string.result_1_anda));
                        numText2.setText(getString(R.string.result_1_saya));
                    }
                    else if (gameInt==2){

                        numText.setText(getString(R.string.result_2r_anda));
                        numText2.setText(getString(R.string.result_2r_saya));
                    }
                    else if (gameInt==3){

                        numText.setText(getString(R.string.result_3r_anda));
                        numText2.setText(getString(R.string.result_3r_saya));
                    }

                    else{

                        numText.setText(getString(R.string.result_4r_anda));
                        numText2.setText(getString(R.string.result_4r_saya));
                    }
                    msg2.setVisibility(View.VISIBLE);
                    msg2.setText("Message: Mohon maaf untuk pembagian sebelumnya.");
                    btnAgree.setVisibility(View.VISIBLE);
                }
            }, 1500);

        }
    };
    View.OnClickListener btnAgreeHandler = new View.OnClickListener() {

        public void onClick(View v) {
            // TODO Auto-generated method stub
            Intent i = new Intent(ResultActivity.this, QuesActivity.class);
            startActivity(i);

        }
    };
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.result, menu);
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
