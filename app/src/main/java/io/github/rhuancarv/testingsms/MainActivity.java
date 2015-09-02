package io.github.rhuancarv.testingsms;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

/*
* author : Rhuan Carvalho @rhuancarv
 */

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void send(View v){
        EditText editName = (EditText) findViewById(R.id.txt_name);
        EditText editPhone = (EditText) findViewById(R.id.txt_phone);
        EditText editEmail = (EditText) findViewById(R.id.txt_email);

        String name = editName.getText().toString();
        String email = editEmail.getText().toString();
        String phone = editPhone.getText().toString();

        if(name.length() < 3){
            editName.setTextColor(Color.RED);
        }else{
            editName.setTextColor(Color.BLACK);
        }

        if(!name.equals("") && !email.equals("") && !phone.equals("")){
            Toast.makeText(getApplicationContext(), "Data sent, " + name, Toast.LENGTH_SHORT).show();

            Bundle param = new Bundle();
            param.putString("name", name);
            param.putString("email", email);
            param.putString("phone", phone);

            Intent it = new Intent(getApplicationContext(), Screen2.class);

            it.putExtras(param);

            startActivity(it);
        }else{
            Toast.makeText(getApplicationContext(), "Fill in all fields", Toast.LENGTH_SHORT).show();
        }
    }
}
