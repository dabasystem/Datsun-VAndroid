package com.example.desarrollo.datsun;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SendPass extends AppCompatActivity {

    private Button sendPass;
    private EditText email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_pass);
        setTitle(getResources().getString(R.string.sendpass));

        email = (EditText) findViewById(R.id.etEmail);
        sendPass = (Button) findViewById(R.id.btnSendPass);
        sendPass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String arroba = "@";
                boolean res = email.getText().toString().contains(arroba);
                if (res) {
                    Intent intent = new Intent(SendPass.this, AlertSendPass.class);
                    startActivity(intent);
                }
            }
        });
    }
}
