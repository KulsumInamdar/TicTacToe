package com.example.tictacto;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //to check playeractive 0:o,  1: x
    public int check = 0;

    //2:Empty
    int gameState[]= {2,2,2,2,2,2,2,2,2};
    public  static int count  = 0;

    public boolean active = true;

    int win[][] = { {0, 1, 2}, {3, 4, 5}, {6, 7, 8},
                    {0, 3, 6}, {1, 4, 7}, {2, 5, 8},
                    {0, 4, 8}, {2, 4, 6}
                  };

    public void OnImg(View view)
    {
        ImageView imageView = (ImageView) view;
        imageView.setTranslationY(-1000);

        //will tell which image is tapped
        int imageSelected = Integer.parseInt(imageView.getTag().toString());
        if(gameState[imageSelected] == 2 && active)
        {
            count++;
            //reset
            if(count ==9)
            {
                active = false;
            }
            //current game state
            gameState[imageSelected]= check;
            if (check == 0) {
                imageView.setImageResource(R.drawable.o);
                check = 1; // after o to x
                TextView status = findViewById(R.id.textView4);
                status.setText("X's turn");
            } else {
                imageView.setImageResource(R.drawable.x);
                check = 0; //after x to o
                TextView status = findViewById(R.id.textView4);
                status.setText("O's turn");
            }
        }

        imageView.animate().translationYBy(1000).setDuration(200);

        int draw =1;
        //winnig foreach
        for(int[] wins: win)
        {
            if(gameState[wins[0]] == gameState[wins[1]]
                    && gameState[wins[1]]== gameState[wins[2]]
                    && gameState[wins[0]]!=2)//no empty
            {
                draw = 0; // no draw
                String winner;
                if(gameState[wins[0]]==0)
                {
                    winner ="O has won!";
                }
                else {
                    winner  = "X's has won!";
                }
                TextView status = findViewById(R.id.textView4);
                status.setText(winner);

                Button pla = findViewById(R.id.button);
                pla.setVisibility(View.VISIBLE);

            }
        }
        //Draw
        if(count == 9 && draw == 1)
        {
            TextView status = findViewById(R.id.textView4);
            status.setText("Draw!");

            Button pla = findViewById(R.id.button);
            pla.setVisibility(View.VISIBLE);

        }


    }

    public  void playAgain(View view)
    {
        Button pla = findViewById(R.id.button);
        pla.setVisibility(View.INVISIBLE);

        TextView status = findViewById(R.id.textView4);
        status.setText("O's Turn!");

        active = true; // play again
        check = 0; //no wins
        count = 0; //no draw

        //empty
        for(int i = 0; i <gameState.length; i++)
        {
            gameState[i]=2;
        }
        //((ImageView)findViewById(R.id.imageView3)).setImageResource(0);
        ((ImageView)findViewById(R.id.img0)).setImageDrawable(null);
        ((ImageView)findViewById(R.id.img1)).setImageDrawable(null);
        ((ImageView)findViewById(R.id.img2)).setImageDrawable(null);

        ((ImageView)findViewById(R.id.img3)).setImageDrawable(null);
        ((ImageView)findViewById(R.id.img4)).setImageDrawable(null);
        ((ImageView)findViewById(R.id.img5)).setImageDrawable(null);

        ((ImageView)findViewById(R.id.img6)).setImageDrawable(null);
        ((ImageView)findViewById(R.id.img7)).setImageDrawable(null);
        ((ImageView)findViewById(R.id.img8)).setImageDrawable(null);

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button pla = findViewById(R.id.button);
        pla.setVisibility(View.INVISIBLE);
    }
}