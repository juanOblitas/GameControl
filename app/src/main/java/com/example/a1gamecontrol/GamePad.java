package com.example.a1gamecontrol;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class GamePad extends AppCompatActivity implements View.OnTouchListener{
    TextView up,left,down,right;
    TextView message;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_pad);
        up=(TextView) findViewById(R.id.arrow_up);
        left=(TextView ) findViewById(R.id.arrow_left);
        down=(TextView ) findViewById(R.id.arrow_down);
        right=(TextView ) findViewById(R.id.arrow_right);
        message=(TextView)findViewById(R.id.message);
        up.setOnTouchListener(this);
        down.setOnTouchListener(this);
        left.setOnTouchListener(this);
        right.setOnTouchListener(this);
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN){
            if(v.getId()==up.getId()){
                message.setText("Arriba");
                up.setBackgroundColor(Color.parseColor("#CAA615"));
            } else if(v.getId()==down.getId()){
                message.setText("Abajo");
                down.setBackgroundColor(Color.parseColor("#CAA615"));
            }else if(v.getId()==left.getId()){
                message.setText("Izquierda");
                left.setBackgroundColor(Color.parseColor("#CAA615"));
            }else if(v.getId()==right.getId()){
                message.setText("Derecha");
                right.setBackgroundColor(Color.parseColor("#CAA615"));
            }
        } else if (event.getAction() == MotionEvent.ACTION_UP){
            message.setText("Null");
            up.setBackgroundColor(Color.parseColor("#D81B60"));
            down.setBackgroundColor(Color.parseColor("#D81B60"));
            left.setBackgroundColor(Color.parseColor("#D81B60"));
            right.setBackgroundColor(Color.parseColor("#D81B60"));
        }
        return true;


    }
}
