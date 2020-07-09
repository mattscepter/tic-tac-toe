package com.firstapp.tic_tac_toe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class Game extends AppCompatActivity {

     int C=0;
    String player1;
    String player2;
    boolean gameActive=true;
    int activeplayer=0;
    int[] gamestate={2,2,2,2,2,2,2,2,2};
    int[][] winpos={{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};
    public int tap(View view)
    {

        ImageView img=(ImageView)view;
     int tapimg=Integer.parseInt(img.getTag().toString());
     if(!gameActive)
     {
         reset(view);
         return 0;
     }

     if(gamestate[tapimg]==2)
     {
         gamestate[tapimg]=activeplayer;
         img.setTranslationY(-1000f);
         if(activeplayer==0)
         {
             img.setImageResource(R.drawable.x);
             activeplayer=1;
             TextView status=findViewById(R.id.status);
             status.setText(player2+"'s Turn Tap To Play");
         }
         else
         {
             img.setImageResource(R.drawable.o);
             activeplayer=0;
             TextView status=findViewById(R.id.status);
             status.setText(player1+"'s Turn Tap To Play");
         }
         img.animate().translationYBy(1000f).setDuration(400);
     }
     for(int[] winposition: winpos) {
         if (gamestate[winposition[0]] == gamestate[winposition[1]] && gamestate[winposition[1]] == gamestate[winposition[2]] && gamestate[winposition[0]] != 2) {
             String winner;
             gameActive = false;
             if (gamestate[winposition[0]] == 0) {
                 winner = player1 + " Has Won";
             } else {
                 winner = player2 + " Has Won";
             }
             TextView status = findViewById(R.id.status);
             status.setText(winner);
         }
     }
         int c=0;
     for(int i=0;i<9;i++)
     {
         if(gamestate[i]!=2)
         {
             c++;
         }
     }
     if(c==8)
     {
         reset(view);
         c=0;
     }
     return  0;

    }

    public void reset(View view)
    {
        gameActive=true;
        activeplayer=0;
        for(int i=0;i<gamestate.length;i++)
        {
            gamestate[i]=2;
        }
        ((ImageView)findViewById(R.id.imageView1)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView2)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView3)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView4)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView5)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView6)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView7)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView8)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView9)).setImageResource(0);
        TextView status=findViewById(R.id.status);
        status.setText(player1+"'s Turn Tap To Play");
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        Intent intent=getIntent();
        player1=intent.getStringExtra(MainActivity.Player);
        player2=intent.getStringExtra(MainActivity.Player2);
        TextView status=findViewById(R.id.status);
        status.setText(player1+"'s Turn Tap To Play");
    }
}
