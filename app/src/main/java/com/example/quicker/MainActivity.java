package com.example.quicker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText userName;
    Button go;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        userName = findViewById(R.id.edtUserName);
        go=findViewById(R.id.btnGo);
        go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name=userName.getText().toString();
                if(name.isEmpty())
                {
                    userName.setError("Please enter your name");
                }
                else {
//                    Toast.makeText(getApplicationContext(),"Name:"+name,Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(MainActivity.this,MenuItemsActivity.class);
                    startActivity(intent);
                }

            }
        });
    }
}
