package com.example.a1gamecontrol;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    Button btnAcelerometro,btnKeyTouch,btnGamePad;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnAcelerometro=(Button)findViewById(R.id.btn_acelerometro);
        btnKeyTouch=(Button)findViewById(R.id.btn_key_touch);
        btnGamePad=(Button)findViewById(R.id.btn_game_pad);
        btnAcelerometro.setOnClickListener(this);
        btnKeyTouch.setOnClickListener(this);
        btnGamePad.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==btnAcelerometro.getId()){
            startActivity(new Intent("android.intent.action.Acelerometro"));
        }
        if(v.getId()==btnGamePad.getId()){
            startActivity(new Intent("android.intent.action.GamePad"));
        }
        if(v.getId()==btnKeyTouch.getId()){
            startActivity(new Intent("android.intent.action.KeyTouch"));
        }
    }
}
