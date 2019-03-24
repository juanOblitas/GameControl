package com.example.a1gamecontrol;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class KeyTouch extends AppCompatActivity {
    ImageView imageVolumAlto;
    ImageView imageVolumBajo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_key_touch);
        imageVolumAlto=(ImageView)findViewById(R.id.imageVolumAlto);
        imageVolumBajo=(ImageView)findViewById(R.id.imageVolumBajo);
    }

    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_VOLUME_DOWN) {
            imageVolumAlto.setVisibility(View.INVISIBLE);
            imageVolumBajo.setVisibility(View.VISIBLE);
            Toast.makeText(this, "Bajamos volumen!", Toast.LENGTH_SHORT).show();
            return true;
        } else if (keyCode == KeyEvent.KEYCODE_VOLUME_UP) {
            imageVolumBajo.setVisibility(View.INVISIBLE);
            imageVolumAlto.setVisibility(View.VISIBLE);
            Toast.makeText(this, "Subimos volumen!", Toast.LENGTH_SHORT).show();
            return true;
        }
        return super.onKeyUp(keyCode, event);
    }

}
