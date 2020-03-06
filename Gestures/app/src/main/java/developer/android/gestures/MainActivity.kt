package developer.android.gestures

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.GestureDetector
import android.view.MotionEvent
import android.view.View
import android.widget.Toast
import androidx.core.view.MotionEventCompat
import kotlinx.android.synthetic.main.activity_main.*

private const val DEBUG_TAG = "Gestures"

class MainActivity : AppCompatActivity(), GestureDetector.OnGestureListener, GestureDetector.OnDoubleTapListener {

    lateinit var info: SharedPreferences
    lateinit var mDetector: GestureDetector

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        info = getSharedPreferences("Store", Context.MODE_PRIVATE)
        mDetector = GestureDetector(this,this)
        mDetector.setOnDoubleTapListener(this)
        btn_reset.setOnClickListener { reset() }
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        mDetector.onTouchEvent(event)
        val pCount = event.pointerCount
        for (i in 0 until pCount){
            val act = event.action
            val id = event.getPointerId(i)
            var actString = ""

            when(act){
                MotionEvent.ACTION_DOWN -> actString = "Down"
                MotionEvent.ACTION_UP -> actString = "Up"
                MotionEvent.ACTION_POINTER_DOWN -> actString = "PTR Down"
                MotionEvent.ACTION_POINTER_UP -> actString = "PTR Up"
                MotionEvent.ACTION_MOVE -> actString = "Down"
                else -> ""
            }

            if (id==0 && act==MotionEvent.ACTION_MOVE){
                action1.setText("Finger ${id+1} $actString")
            }
            if (id==1 && act==MotionEvent.ACTION_MOVE && action2.text.equals("")){
                action2.setText("Finger ${id+1} $actString")
            }
            if (id==0 && act==MotionEvent.ACTION_POINTER_UP || id==1 && act==MotionEvent.ACTION_MOVE && action2.text.equals("Finger 1 Right")){
                action3.setText("Finger ${id+1} $actString")
            }
            if (id==0 && act==MotionEvent.ACTION_POINTER_DOWN){
                action4.setText("Finger ${id+1} $actString")
            }

            /*Valid Combinations
            * Finger 1 Move > Finger 2 Move > Finger 1 PTR Up > Finger 2 PTR Down
            * Finger 1 Down > Finger 1 Scroll > Finger 2 PTR Down*/
            if (action1.text.equals("Finger 1 Down") && action2.text.equals("Finger 2 Down") && action3.text.equals("Finger 1 PTR Up") && action4.text.equals("Finger 1 PTR Down")
                || action1.text.equals("Finger 1 Down") && action2.text.equals("Finger 1 Right") && action3.text.equals("Finger 2 Down")){
                locked.setImageResource(R.drawable.unlock)
                btn_reset.visibility = View.VISIBLE
                btn_reset.isClickable = true
            }
        }
        return true
    }

    private fun reset(){
        action1.setText("")
        action2.setText("")
        action3.setText("")
        action4.setText("")
        locked.setImageResource(R.drawable.lock)
        btn_reset.visibility = View.GONE
        btn_reset.isClickable = false
    }

    override fun onDown(event: MotionEvent?): Boolean {
        Log.d(DEBUG_TAG,"onDown: $event")
        return false
    }

    override fun onFling(event1: MotionEvent?, event2: MotionEvent?, p2: Float, p3: Float): Boolean {
        Log.d(DEBUG_TAG,"onFling: $event1 $event2")
        return false
    }

    override fun onLongPress(event: MotionEvent?) {
        Log.d(DEBUG_TAG,"onLongPress: $event")
    }

    override fun onScroll(event1: MotionEvent?, event2: MotionEvent?, p2: Float, p3: Float): Boolean {
        if ((event2!!.getX()-event1!!.getX()) > 80 && action2.text.equals("")){//E2-E1 > 80 -- Moved Right By 80+
            action2.setText("Finger 1 Right")
        }
        Log.d(DEBUG_TAG,"onScroll: $event1 $event2")
        return false
    }

    override fun onShowPress(event: MotionEvent?) {
        Log.d(DEBUG_TAG,"onShowPress: $event")
    }

    override fun onSingleTapUp(event: MotionEvent?): Boolean {
        Log.d(DEBUG_TAG,"onSingleTapUp: $event")
        return false
    }

    override fun onDoubleTap(event: MotionEvent?): Boolean {
        Log.d(DEBUG_TAG,"onDoubleTap: $event")
        return false
    }

    override fun onDoubleTapEvent(event: MotionEvent?): Boolean {
        Log.d(DEBUG_TAG,"onDoubleTapEvent: $event")
        return false
    }

    override fun onSingleTapConfirmed(event: MotionEvent?): Boolean {
        Log.d(DEBUG_TAG,"onSingleTapConfirmed: $event")
        return false
    }
}
