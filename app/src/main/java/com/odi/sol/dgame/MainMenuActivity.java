package com.odi.sol.dgame;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


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
