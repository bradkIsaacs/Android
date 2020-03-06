package com.vogella.android.flashbeepshake

import android.content.Context
import android.hardware.camera2.CameraAccessException
import android.hardware.camera2.CameraManager
import android.media.AudioManager
import android.media.ToneGenerator
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.VibrationEffect
import android.os.Vibrator
import android.widget.Button
import android.widget.ToggleButton
import java.lang.Exception

class MainActivity : AppCompatActivity() {

    private var cManager : CameraManager?=null
    private var mCameraid : String ?= null
    private var flashlight : ToggleButton ?= null
    private var beep : Button ?= null
    private var vibrate : Button ?=null
    private var v : Vibrator ?= null
    private var isTorch : Boolean ?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        flashlight = findViewById(R.id.tb_flash) as ToggleButton
        beep = findViewById(R.id.btn_beep) as Button
        vibrate = findViewById(R.id.btn_vibrate) as Button
        v = getSystemService(Context.VIBRATOR_SERVICE) as Vibrator
        isTorch = false
        cManager = getSystemService(Context.CAMERA_SERVICE) as CameraManager
        try{
            mCameraid = cManager!!.cameraIdList[0]
        } catch (e: CameraAccessException){
            e.printStackTrace()
        }
        flashlight!!.setOnCheckedChangeListener{ _, isChecked ->
            if (isChecked){
                try {
                    if (Build.VERSION.SDK_INT>=Build.VERSION_CODES.M){
                        cManager!!.setTorchMode(mCameraid!!,true)
                    }
                }catch (e:Exception){
                    e.printStackTrace()
                }
            } else {
                try {
                    if (Build.VERSION.SDK_INT>=Build.VERSION_CODES.M){
                        cManager!!.setTorchMode(mCameraid!!,false)
                    }
                }catch (e:Exception){
                    e.printStackTrace()
                }
            }
        }
        beep!!.setOnClickListener { view ->
            val tone = ToneGenerator(AudioManager.STREAM_MUSIC, 100)
            tone.startTone(ToneGenerator.TONE_DTMF_P,3600)
        }
        vibrate!!.setOnClickListener { view ->
            v!!.vibrate(VibrationEffect.createOneShot(3600,VibrationEffect.DEFAULT_AMPLITUDE))
        }
    }
}
