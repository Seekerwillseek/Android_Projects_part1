package com.example.loanemicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView textView1, textView2, textView3;
    Button button1 , button2;
    EditText editTextPersonName;
    EditText editTextPassword;
    ImageView imageView1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button1 = (Button)findViewById(R.id.button1);
        button2 = (Button)findViewById(R.id.button2);
        editTextPersonName= (EditText)findViewById(R.id.editTextPersonName);
        editTextPassword =(EditText)findViewById(R.id.editTextPassword);
        imageView1= (ImageView)findViewById(R.id.imageView1);
        button1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v)
            {
                Resources res = getResources();
                String [] usernames =res.getStringArray(R.array.users);
                String [] passwords = res.getStringArray(R.array.passwords);
                String cur_username = editTextPersonName.getText().toString();
                String cur_password = editTextPassword.getText().toString();
                boolean found = false;
                for(int i=0;i<usernames.length;i++)
                {
                   if(cur_username.equals(usernames[i]) && cur_password.equals(passwords[i]))
                   {
                     found= true;
                     break;
                   }
                }
                Context context = getApplicationContext();
                int duration = Toast.LENGTH_SHORT;
                CharSequence text = "";
                if(found) {
                    text = "Login sucessfull";
                }
                else
                {
                    text = "Invalid username and password";
                }
                Toast.makeText(context, text, Toast.LENGTH_SHORT).show();
                if(found)
                {
                    Intent second = new Intent(MainActivity.this, LoanDataEntry.class);
                    startActivity(second);
                    finish();
                }
            }
        });

    }
}