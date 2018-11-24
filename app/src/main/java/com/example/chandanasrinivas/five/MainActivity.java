package com.example.chandanasrinivas.five;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final int MY_PERMISSION_REQUEST_SEND_SMS=0;
    Button sendBtn,btnSendEmail,btnPhone;
    String phoneno,message;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sendBtn=(Button) findViewById(R.id.btnSendSMS);
        btnSendEmail=(Button) findViewById(R.id.btnSendEmail);
        btnPhone=(Button) findViewById(R.id.btnDialPhone);

        sendBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendSMSMessage();
            }
        });

        btnSendEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendEmail();
            }
        });

        btnPhone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                phoneDail();
            }
        });
    }
    protected void sendEmail() {
        Intent emailIntent=new Intent(Intent.ACTION_SEND);
        emailIntent.setData(Uri.parse("mailto:"));
        emailIntent.setType("text/plain");
        emailIntent.putExtra(Intent.EXTRA_EMAIL,new String[]{"chandana.s.1997@gmail.com"});
        emailIntent.putExtra(Intent.EXTRA_SUBJECT,"Subject Test");
        emailIntent.putExtra(Intent.EXTRA_TEXT,"Message Body Test");
        startActivity(emailIntent);
    }

    protected void sendSMSMessage() {
        Intent sendIntent=new Intent(Intent.ACTION_VIEW);
        sendIntent.putExtra("sms body","default content");
        sendIntent.setType("vnd.android-dir/mms-sms");
        startActivity(sendIntent);
        Toast.makeText(getApplicationContext(),"SMS Sent",Toast.LENGTH_SHORT).show();
    }

    protected void phoneDail() {
        Intent intent = new Intent(Intent.ACTION_DIAL);
        startActivity(intent);
    }
}
