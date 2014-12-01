package com.odi.sol.dgame;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;


public class MainMenuActivity extends Activity {

    Button btnInstruction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //VIEWS
        setContentView(R.layout.activity_main_menu);
        Button btnInstruction = (Button) findViewById(R.id.buttonInstruction);
        Button btnGame = (Button) findViewById(R.id.buttonGame1);
        Button btnAbout = (Button) findViewById(R.id.buttonAbout);
        TextView txtTitle = (TextView) findViewById(R.id.textView2);
        TextView txtSubTitle = (TextView) findViewById(R.id.textView3);
        final RadioGroup radG1 = (RadioGroup) findViewById(R.id.radG);
        final RadioButton diff1, diff2, diff3, diff4;

        diff1 = (RadioButton) findViewById(R.id.radioButton1);
        diff2 = (RadioButton) findViewById(R.id.radioButton2);
        diff3 = (RadioButton) findViewById(R.id.radioButton3);
        diff4 = (RadioButton) findViewById(R.id.radioButton4);

        //Set Fonts
        Typeface typeTitle = Typeface.createFromAsset(getAssets(), "fonts/ka1.ttf");
        Typeface typeSub = Typeface.createFromAsset(getAssets(), "fonts/game_over.ttf");
        txtTitle.setTypeface(typeTitle);
        txtSubTitle.setTypeface(typeSub);


        //CREATE LISTENERS
        //createListeners();
        btnInstruction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainMenuActivity.this, InstructionActivity.class);
                startActivity(i);
            }
        });
        btnGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainMenuActivity.this, GameActivity.class);

                int gameInt =1;
                String message = "THIS IS GAME MODE DEFAULT = 1";
                if (radG1.getCheckedRadioButtonId() == -1)
                {
                    // no radio buttons are checked

                    message = "THIS IS GAME MODE 1";
                }
                else
                {
                    // one of the radio buttons is checked
                    if(diff1.isChecked())
                    {
                         //not checked
                        message = "THIS IS GAME MODE 1";
                    }
                    if(diff2.isChecked())
                    {
                        //not checked
                        message = "THIS IS GAME MODE 2";
                        gameInt = 2;
                    }
                    if(diff3.isChecked())
                    {
                        //not checked
                        message = "THIS IS GAME MODE 3";
                        gameInt = 3;
                    }
                    if(diff4.isChecked())
                    {
                        //not checked
                        message = "THIS IS GAME MODE 4";
                        gameInt = 4;
                    }

                }

                i.putExtra("GAMENUM", message);
                i.putExtra("GAMEINT", gameInt);
                startActivity(i);
            }
        });
        btnAbout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainMenuActivity.this, AboutActivity.class);
                startActivity(i);
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_menu, menu);
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

    private void createListeners() {
        btnInstruction.setOnClickListener(new View.OnClickListener(){
            public void onClick(View V){
                Intent i = new Intent(V.getContext(),InstructionActivity.class);
                //String message = srchBar.getText().toString();
                //i.putExtra(EXTRA_MESSAGE, message);
                startActivity(i);
            }
        });
    }
}
