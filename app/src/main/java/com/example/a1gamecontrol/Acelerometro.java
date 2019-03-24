package com.example.a1gamecontrol;

import android.content.Context;
import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.widget.LinearLayout;
import android.widget.TextView;

/*
* El acelerómetro es unos de los sensores que más información nos da sobre el usuario. Nos permite conocer en
* en que posición se encuentra el móvil cuando el usuario gira la pantalla.
* */
public class Acelerometro extends AppCompatActivity implements SensorEventListener {
    TextView coordinateX, coordinateY, coordinateZ;
    SensorManager sensorMgr;
    Sensor sensor;
    LinearLayout linearLayoutAcelerometro;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acelerometro);
        coordinateX=(TextView)findViewById(R.id.coordinateX);
        coordinateY=(TextView)findViewById(R.id.coordinateY);
        coordinateZ=(TextView)findViewById(R.id.coordinateZ);
        sensorMgr = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        sensor = sensorMgr.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        sensorMgr.registerListener(this, sensor , SensorManager.SENSOR_DELAY_NORMAL);
        linearLayoutAcelerometro=(LinearLayout)findViewById(R.id.layout_acelerometro);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        if(event.sensor.getType() == Sensor.TYPE_ACCELEROMETER) {
            coordinateX.setText(String.valueOf(event.values[0]));
            coordinateY.setText(String.valueOf(event.values[1]));
            coordinateZ.setText(String.valueOf(event.values[2]));
        }
        //vamos a controlar el cambio de color
        //Creamos un array con los distintos colores
        String [] colors={"#800000","#854646","#5A5858","#5B0202","#D30202","#713030","#ED7373","#BE1693",
        "#08C4D8","#CAA615"};
        //suma de variables x,y and z
        float sumVariables=Float.parseFloat(coordinateX.getText().toString())
                +Float.parseFloat(coordinateY.getText().toString())+
                Float.parseFloat(coordinateZ.getText().toString());
        int redondear=(int)Math.round(sumVariables);
        if(redondear>=0 && redondear<colors.length)
            linearLayoutAcelerometro.setBackgroundColor(Color.parseColor(colors[redondear]));
        else
            linearLayoutAcelerometro.setBackgroundColor(Color.parseColor("#C0561D"));

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
    /*
    * Para dejar de controlar la actividad de los sensores cuando no estamos en la aplicación y evitar así los
    * problemas de batería debemos de agregar los siguientes 2 métodos (onPause() y onResume())
    * Cuando nuestra actividad no esté en primer plano (onPause ()) dejamos de seguir los cambios producidos
    * en el sensor (sensorMgr.unregisterListener (this);) y lo volvemos a grabar cuando
    * el usuario vuelve a la aplicación (onResume ()).
    * */
    @Override
    protected void onPause() {
        super.onPause();
        sensorMgr.unregisterListener(this);
    }
    @Override
    protected void onResume() {
        super.onResume();
        sensorMgr.registerListener(this,sensor, SensorManager.SENSOR_DELAY_NORMAL);
    }
}
