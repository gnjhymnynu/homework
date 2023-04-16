package pu.edu.tw.homework1

import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.GestureDetector
import android.view.GestureDetector.OnGestureListener
import android.view.MotionEvent
import android.view.View
import android.view.View.OnClickListener
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import java.util.jar.Pack200

class MainActivity : AppCompatActivity(), OnGestureListener {

    lateinit var txv: TextView
    lateinit var txv2: TextView
    lateinit var btn: Button
    lateinit var gDetector: GestureDetector
    var count:Int = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        txv2= findViewById(R.id.txv2)
        txv2.text = ""
        txv = findViewById(R.id.txv)
        txv.setTypeface(
            Typeface.createFromAsset(assets,
                "font/HanyiSentyFingerPainting.ttf"))

        btn = findViewById(R.id.btn)
        gDetector = GestureDetector(this, this)
    }

    fun happy(v: View){
        if (txv2.text == ""){
            txv2.text = "林侑縉"
        }
        else{
            txv2.text = ""
        }
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        gDetector.onTouchEvent(event)
        return true
    }




    /*override fun onTouchEvent(event: MotionEvent): Boolean {
        if (btn.text == "姓名"){
            btn.text = "林侑縉"
        }
        else{
            btn.text = "姓名"
        }
        return true
    }*/

    override fun onDown(p0: MotionEvent): Boolean {
        return true
    }

    override fun onShowPress(p0: MotionEvent) {

    }

    override fun onSingleTapUp(p0: MotionEvent): Boolean {
        return true
    }

    override fun onScroll(p0: MotionEvent, p1: MotionEvent, p2: Float, p3: Float): Boolean {
        return true
    }

    override fun onLongPress(p0: MotionEvent) {

    }

    override fun onFling(e1: MotionEvent, e2: MotionEvent, velocityX: Float, velocityY: Float): Boolean {
        if (e1.x <= e2.x){
            txv.text = "往右快滑"
            count++
            if(count>2){
                count=0
            }
        }
        else{
            txv.text = "往左快滑"
            count--
            if(count<0){
                count=2
            }
        }
        txv.text = count.toString()
        var res:Int = getResources().getIdentifier("pu" + count.toString(),
            "drawable", getPackageName())
        findViewById<LinearLayout>(R.id.bg).setBackgroundResource(res)


        return true
    }


}