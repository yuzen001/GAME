package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Main8Activity extends AppCompatActivity {
    private int guessTime;
    private int random;
    private int input_N;
    private boolean ReturnGame;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main8);
        final Button button = (Button) findViewById(R.id.button);

        Intent intent=getIntent();
        random = intent.getIntExtra("random",0);
        input_N = intent.getIntExtra("portal",0);
        guessTime = intent.getIntExtra("guessTime",0);

        TextView text_prompt = (TextView)findViewById(R.id.text_prompt);
        TextView text_result = (TextView)findViewById(R.id.text_result);
        if (random == input_N){
            text_result.setText("恭喜猜中!");
            guessTime++;
            text_prompt.setText(getString(R.string.bingo)+guessTime+"次");
            ReturnGame=true;
            guessTime=0;
            button.setText("下一關");

            button.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    Intent intent = new Intent(Main8Activity.this, Main9Activity.class);
                    startActivity(intent);
                }
            });

        }
        else  if (random < input_N){
            text_result.setText("X");
            text_prompt.setText("猜太大");
            ReturnGame=false;
            guessTime++;

            button.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    Intent intent = new Intent(Main8Activity.this, Main7Activity.class);
                    intent.putExtra("guessTime",guessTime );
                    intent.putExtra("random", random);
                    intent.putExtra("ReturnGame", ReturnGame);
                    startActivity(intent);
                }
            });

        }
        else if (random > input_N){
            text_result.setText("不對喔");
            text_prompt.setText("猜太小");
            ReturnGame=false;
            guessTime++;

            button.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    Intent intent = new Intent(Main8Activity.this, Main7Activity.class);
                    intent.putExtra("guessTime",guessTime );
                    intent.putExtra("random", random);
                    intent.putExtra("ReturnGame", ReturnGame);
                    startActivity(intent);
                }
            });

        }
    }
}