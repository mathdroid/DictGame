package com.odi.sol.dgame;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;


public class ResultActivity extends Activity {
    public int phase, maxPrize, gameInt;
    private TextView resText,resText2,resText3,numText,numText2;

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
        Typeface typeSub = Typeface.createFromAsset(getAssets(), "fonts/game_over.ttf");
        Typeface typeTitle = Typeface.createFromAsset(getAssets(), "fonts/ka1.ttf");
        resText.setTypeface(typeSub);
        resText2.setTypeface(typeSub);
        resText3.setTypeface(typeSub);
        numText.setTypeface(typeTitle);
        numText2.setTypeface(typeTitle);

        if (gameInt==1) {
            resText.setText(getString(R.string.result));
        }
        if (gameInt==3) {
            numText.setText(getString(R.string.result_3_anda));
            numText2.setText(getString(R.string.result_3_saya));
        }
        if (gameInt==4) {
            numText.setText(getString(R.string.result_4_anda));
            numText2.setText(getString(R.string.result_4_saya));
        }

        phaseOne();






    }
    private void phaseOne(){
        //phase0: loading
        resText.setText("You both won:");
        resText2.setVisibility(View.INVISIBLE);
        resText3.setVisibility(View.INVISIBLE);
        numText.setText(String.valueOf(maxPrize));
        numText2.setText("Please wait...");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        phaseTwo();
    }
    private void phaseTwo(){

        if (gameInt==1) {
            resText.setText(getString(R.string.result));
        }
        if (gameInt==3) {
            numText.setText(getString(R.string.result_3_anda));
            numText2.setText(getString(R.string.result_3_saya));
        }
        if (gameInt==4) {
            numText.setText(getString(R.string.result_4_anda));
            numText2.setText(getString(R.string.result_4_saya));
        }
    }

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
