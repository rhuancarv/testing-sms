package io.github.rhuancarv.testingsms;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Screen2 extends AppCompatActivity {

    String name;
    String phone;
    String email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen2);

        Bundle param = getIntent().getExtras();

        name = param.getString("name");
        phone = param.getString("phone");
        email = param.getString("email");

        TextView txtAnswer = (TextView) findViewById(R.id.txt_answer);
        txtAnswer.setText("Name: " + name + "\nE-mail: " + email + "\nPhone: " + phone);
    }

    public void send(View v){
        EditText editMessage = (EditText) findViewById(R.id.txt_message);
        String message = editMessage.getText().toString();

        SmsManager sms = SmsManager.getDefault();
        sms.sendTextMessage(phone, null, message, null, null);

        Toast.makeText(getApplicationContext(), "Message sent successfully", Toast.LENGTH_SHORT).show();
        finish();
    }

    public void back(View v){
        finish();
    }
}
