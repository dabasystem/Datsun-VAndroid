package com.example.desarrollo.datsun;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SignUp extends AppCompatActivity {

    private Button continu;
    private EditText nick;
    private EditText email;
    private EditText pass;
    private EditText retype;
    private EditText phone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        nick = (EditText) findViewById(R.id.etNickName);
        email = (EditText) findViewById(R.id.etEmailAddress);
        pass = (EditText) findViewById(R.id.etSignupPass);
        retype = (EditText) findViewById(R.id.etRetype);
        phone = (EditText) findViewById(R.id.etPhoneNumber);
        continu = (Button) findViewById(R.id.btnContinu);
        continu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(nick.getText().toString().equals("") || email.getText().toString().equals("") || pass.getText().toString().equals("") || retype.getText().toString().equals("") || phone.getText().toString().equals("")){
                }else {
                    if (pass.getText().toString().equals(retype.getText().toString())) {
                        String arroba = "@";
                        boolean res = email.getText().toString().contains(arroba);
                        if(res){
                            Intent intent = new Intent(SignUp.this, SendPass.class);
                            startActivity(intent);
                        }
                    }
                }
            }
        });
    }
}
