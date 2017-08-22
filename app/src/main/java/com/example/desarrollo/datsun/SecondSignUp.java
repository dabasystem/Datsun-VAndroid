package com.example.desarrollo.datsun;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class SecondSignUp extends AppCompatActivity {

    private ImageView vinImg;
    private TextView vintxt;
    private ImageView modelImg;
    private TextView modeltxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_sign_up);

        vintxt = (TextView) findViewById(R.id.txtVin);
        vinImg = (ImageView) findViewById(R.id.imagVin);
        modeltxt = (TextView) findViewById(R.id.txtCarModel);
        modelImg = (ImageView) findViewById(R.id.imagCarModel);

        SharedPreferences pref=getSharedPreferences("SignUp",Context.MODE_PRIVATE);
        /*SharedPreferences.Editor limpiar = pref.edit();
        limpiar.clear();
        limpiar.commit();*/
        vintxt.setText(pref.getString("Vin", getResources().getString(R.string.vin_number)));
        modeltxt.setText(pref.getString("Car", getResources().getString(R.string.car_model)));

        vinImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SecondSignUp.this,ListViewSignUp.class);
                intent.putExtra("num",0);
                startActivity(intent);
            }
        });

        modelImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SecondSignUp.this,ListViewSignUp.class);
                intent.putExtra("num",1);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onRestart() {
        super.onRestart();


    }
}
