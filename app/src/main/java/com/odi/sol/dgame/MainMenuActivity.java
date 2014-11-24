package com.odi.sol.dgame;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class MainMenuActivity extends Activity {

    private Button btnInstruction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //VIEWS
        setContentView(R.layout.activity_main_menu);
        Button btnInstruction = (Button) findViewById(R.id.buttonInstruction);

        //CREATE LISTENERS
        createListeners();
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
