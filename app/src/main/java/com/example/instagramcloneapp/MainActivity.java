package com.example.instagramcloneapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.SaveCallback;
import com.shashank.sony.fancytoastlib.FancyToast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText punchSpeed, punchForce, punchPower;
    Button updateBTN;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        updateBTN = findViewById(R.id.button);
        updateBTN.setOnClickListener(MainActivity.this);
        punchSpeed = findViewById(R.id.punchSpeed);
        punchForce = findViewById(R.id.punchForce);
        punchPower = findViewById(R.id.punchPower);
    }


    @Override
    public void onClick(View v) {
        ParseObject boxer = new ParseObject("Boxer");

        try {
            boxer.put("punch_speed",Integer.parseInt(punchSpeed.getText().toString()));
            boxer.put("punch_force",Integer.parseInt(punchForce.getText().toString()));
            boxer.put("punch_power",Integer.parseInt(punchPower.getText().toString()));




        boxer.saveInBackground(new SaveCallback() {
            @Override
            public void done(ParseException e) {
                if(e == null){
                    FancyToast.makeText(MainActivity.this,"boxer is saved successfully",FancyToast.LENGTH_LONG,FancyToast.SUCCESS,true).show();
                } else {
                    FancyToast.makeText(MainActivity.this,"boxer not saved",FancyToast.LENGTH_LONG,FancyToast.ERROR,true).show();
                    Log.i("TAG","error message   "+ e.getMessage());
               }


            }
        });
        }catch (Exception e){
            FancyToast.makeText(MainActivity.this,"boxer not saved "+ e.getMessage(),FancyToast.LENGTH_LONG,FancyToast.ERROR,true).show();

        }
    }
}