package com.example.exercise8

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() , SensorEventListener {

    private var mSensorManager : SensorManager ?= null; //Carga las librerias para el manejo de sensores
    private var mAccelerometer : Sensor  ?= null; //es el que vamos a indicar como acelerometro


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mSensorManager = getSystemService(Context.SENSOR_SERVICE)as SensorManager;
        mAccelerometer = mSensorManager!!.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        setContentView(R.layout.activity_main)
    }

    override fun onResume() {
        super.onResume()
        mSensorManager!!.registerListener(this, mAccelerometer, SensorManager.SENSOR_DELAY_NORMAL); //En esta aplicacion, prende el acelerometro con sensiblidad normal
    }

    override fun onSensorChanged(event: SensorEvent?) {
        if(event != null){
            edit1.setText(event.values[0].toString());
            edit2.setText(event.values[1].toString());
            edit3.setText(event.values[2].toString());
        }
    }

    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {

    }

}

//SENSOR ES UN DISPOSITIVO QUE ESTA LEYENDO CONSTANTEMENTE UNA VARIABLE DEL MUNDO REAL
//LOS SENSORES EXISTEN EN EL CELULAR, PERO NO ESTAN TRABAJANDO SIEMPRE
//LOS SENSORES OCUPAN MEMORIA PARA FUNCIONAR
//DENTRO DE NUESTRAS APLICACIONES DEBEMOS DECLARAR EL USO DE SENSORES, TENIENDO CUIDADO DE ENCENDERLOS CUANDO SEA NECESARIO

//EVENTO DEL SENSOR
//TEMPERATURA 36,  NO HACE NADA
//LOS SENSORES SE ACTIVAN CUANDO LOS VALORES CAMBIAN ONCHANGED (LISTENERS)
