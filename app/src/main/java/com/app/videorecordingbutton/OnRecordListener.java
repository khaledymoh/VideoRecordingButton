package com.app.videorecordingbutton;

/**
 * Created by Khaled on 7/5/18.
 */

public interface OnRecordListener {
    void onZoomIn(float value);
    void onStart();
    void onCancel();
    void onFinish();

}
