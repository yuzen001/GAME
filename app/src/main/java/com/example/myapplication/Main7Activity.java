package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Main7Activity extends AppCompatActivity {
    private boolean ReturnGame;
    private int guessTime;
    private int random;
    EditText edittext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main7);
        final Button button = (Button) findViewById(R.id.button);
        edittext = (EditText) findViewById(R.id.editText2);

        Intent intent=getIntent();
        ReturnGame = intent.getBooleanExtra("ReturnGame",true);
        guessTime = intent.getIntExtra("guessTime",0);
        random = intent.getIntExtra("random",0);

        if (ReturnGame == true){
            random =  (int)(Math.random()* 40+1);
            intent.putExtra("ReturnGame", false);
        }

        button.setOnClickListener(new View.OnClickListener() {

            public void onClick (View v){
                if(edittext.getText().toString().matches("") ) {
                    Toast toast = Toast.makeText(Main7Activity.this, "還沒輸入數字唷", Toast.LENGTH_LONG);
                    toast.show();}
                else {
                    Intent intent = new Intent(Main7Activity.this, Main8Activity.class);
                    intent.putExtra("random", random);
                    intent.putExtra("portal", Integer.valueOf(edittext.getText().toString()));
                    intent.putExtra("guessTime", guessTime);
                    startActivity(intent);
                }
            }
        });
    }
}