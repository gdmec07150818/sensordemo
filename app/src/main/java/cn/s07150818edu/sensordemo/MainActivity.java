package cn.s07150818edu.sensordemo;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements SensorEventListener {
    private SensorManager sensorManager;
    private Sensor sensor3;
    private Sensor sensor1;
    private  Sensor sensor2;
    private TextView tAcceleromerter;
    private TextView tOrientation;
    private TextView tLight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tAcceleromerter= (TextView) this.findViewById(R.id.acceleromer);
        tOrientation= (TextView) this.findViewById(R.id.orientation);
        tLight= (TextView) this.findViewById(R.id.ligtht);
        sensorManager= (SensorManager) getSystemService(SENSOR_SERVICE);
        sensor3=sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        sensor1=sensorManager.getDefaultSensor(Sensor.TYPE_ORIENTATION);
        sensor2=sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);

    }

    @Override
    protected void onResume() {
        super.onResume();
        sensorManager.registerListener(this,sensor3,SensorManager.SENSOR_DELAY_NORMAL);
        sensorManager.registerListener(this,sensor1,SensorManager.SENSOR_DELAY_NORMAL);
        sensorManager.registerListener(this,sensor2,SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    protected void onPause() {
        super.onPause();
        sensorManager.unregisterListener(this);

    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        float x=event.values[SensorManager.DATA_X];
        float y=event.values[SensorManager.DATA_Y];
        float z=event.values[SensorManager.DATA_Z];
        if (event.sensor.getType()==Sensor.TYPE_ORIENTATION){
            tOrientation.setText("方向："+x+","+y+","+z);
        }else if (event.sensor.getType()==Sensor.TYPE_ACCELEROMETER){
            tOrientation.setText("加速度：" +x+", " +y+", " +z);
        }else if (event.sensor.getType()==Sensor.TYPE_LIGHT){
            tOrientation.setText("光线："+event.values[0]);
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
}
