package com.firstapp.tic_tac_toe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    public static final String Player ="player1";
    public static final String Player2 ="player2";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void start(View view)
    {
        Intent intent=new Intent(this, Game.class);
        EditText editText1=findViewById(R.id.editText);
        EditText editText2=findViewById(R.id.editText2);
        String player1=editText1.getText().toString();
        String player2=editText2.getText().toString();
        intent.putExtra(Player,player1);
        intent.putExtra(Player2,player2);
        startActivity(intent);
    }
}
