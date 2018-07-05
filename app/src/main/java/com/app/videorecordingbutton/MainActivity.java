package com.app.videorecordingbutton;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.otaliastudios.cameraview.CameraView;
import com.otaliastudios.cameraview.Gesture;
import com.otaliastudios.cameraview.GestureAction;

public class MainActivity extends AppCompatActivity {

    VideoRecordingButton videoRecordingButton ;
    CameraView cameraView ;


    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        cameraView = findViewById(R.id.camera);
        videoRecordingButton = findViewById(R.id.vrb);

        cameraView.start();
        cameraView.setVideoMaxSize(100000);
        cameraView.setVideoMaxDuration(5000);


        videoRecordingButton.setOnRecordListener(new OnRecordListener() {
            @Override
            public void onStart() {
                //Toast.makeText(MainActivity.this, "Start Recording", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onCancel() {
                Toast.makeText(MainActivity.this, "onCancel", Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onZoomIn(float value) {
                Log.e("Zoom" , " " + (value * -1) /100);
                cameraView.setZoom((value * -1) /100);

            }

            @Override
            public void onFinish() {
                Toast.makeText(MainActivity.this, "onFinish", Toast.LENGTH_SHORT).show();

            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onResume() {
        super.onResume();
        cameraView.start();
    }

    @Override
    protected void onPause() {
        super.onPause();
        cameraView.stop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        cameraView.destroy();
    }
}
