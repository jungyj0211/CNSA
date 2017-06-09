package com.example.codenex.eventtest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.GestureDetector;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView textView;

    GestureDetector detector;

    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView)findViewById(R.id.textView);

        View view = findViewById(R.id.view1);

        view.setOnTouchListener(new View.OnTouchListener(){
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {

                int action = motionEvent.getAction();
                float culX = motionEvent.getX();
                float culY = motionEvent.getY();

                if(action == MotionEvent.ACTION_DOWN){
                    println("눌림 : " + culX + ", " + culY);
                }else if (action == MotionEvent.ACTION_MOVE){
                    println("움직임 : " + culX + ", " + culY);
                }else if (action == MotionEvent.ACTION_UP){
                    println("떨어짐 : " + culX + ", " + culY);
                }

                return true;
            }
        });

        View view2 = findViewById(R.id.view2);
        view2.setOnTouchListener(new View.OnTouchListener(){

            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                detector.onTouchEvent(motionEvent);
                return true;
            }
        });
//--------------------------------------------------------------------------------------------
        detector = new GestureDetector(this, new GestureDetector.OnGestureListener() {
            @Override
            public boolean onDown(MotionEvent motionEvent) {
                println("onDown()호출");

                return true;
            }

            @Override
            public void onShowPress(MotionEvent motionEvent) {
                println("onShowPress()호출");
            }

            @Override
            public boolean onSingleTapUp(MotionEvent motionEvent) {
                println("onSingleTapUp()호출");

                return true;
            }

            @Override
            public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent1, float v, float v1) {
                println("onScroll()호출 : " + v + "," + v1);

                return true;
            }

            @Override
            public void onLongPress(MotionEvent motionEvent) {
                println("onLongPress()호출");

            }

            @Override
            public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent1, float v, float v1) {
                println("onFling()호출 : " + v + "," + v1);

                return true;
            }
        });

//-------------------------------------------------------------------------
        btn = (Button)findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"버튼 Clicked",Toast.LENGTH_LONG).show();
            }
        });

    }
//---------------------------------------------------------------------
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        if(keyCode == KeyEvent.KEYCODE_BACK){
            Toast.makeText(this,"시스템 Back키 눌림",Toast.LENGTH_LONG).show();

            return true;
        }

        return false;
    }
//---------------------------------------------
    public void println(String str){
        textView.append(str + "\n");
    }

}
