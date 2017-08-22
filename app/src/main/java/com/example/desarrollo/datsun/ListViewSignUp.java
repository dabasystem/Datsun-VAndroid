package com.example.desarrollo.datsun;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;


public class ListViewSignUp extends AppCompatActivity {

    private ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view_sign_up);

        String [] array;
        Bundle dif = getIntent().getExtras();
        lv = (ListView) findViewById(R.id.listViewSignUp);
        if(dif.getInt("num")==0){
            array = getResources().getStringArray(R.array.vin_number_array);
            int num=0;
            metodoArray(array,num);
        }else if(dif.getInt("num")==1){
            array = getResources().getStringArray(R.array.car_model_array);
            int num=1;
            metodoArray(array,num);
        }
    }

    private void metodoArray(String[] array, final int num){
        final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>
                (this, android.R.layout.simple_list_item_1, array);
        lv.setAdapter(arrayAdapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String data=(String)parent.getItemAtPosition(position);
                SharedPreferences prefs = getSharedPreferences("SignUp", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = prefs.edit();
                if(num==0){
                    editor.putString("Vin", data);
                }else if(num==1){
                    editor.putString("Car",data);
                }

                editor.commit();

                Intent intent = new Intent(ListViewSignUp.this,SecondSignUp.class);
                startActivity(intent);

            }
        });
    }
}
