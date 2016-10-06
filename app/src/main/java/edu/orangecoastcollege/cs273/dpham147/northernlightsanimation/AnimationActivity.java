package edu.orangecoastcollege.cs273.dpham147.northernlightsanimation;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

public class AnimationActivity extends AppCompatActivity {

    private ImageView lightsImageView;
    private Button frameButton;
    private Button shakeButton;
    private Button rotateButton;
    private Button customButton;
    // Frame Animation uses AnimationDrawable type
    private AnimationDrawable frameAnim;
    // Tween Animation uses Animation type
    private Animation rotateAnim;
    private Animation shakeAnim;
    private Animation customAnim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation);

        lightsImageView = (ImageView) findViewById(R.id.lightsImageView);
        frameButton = (Button) findViewById(R.id.frameAnimButton);
        shakeButton = (Button) findViewById(R.id.shakeAnimButton);
        rotateButton = (Button) findViewById(R.id.rotateAnimButton);
        customButton = (Button) findViewById(R.id.customAnimButton);
    }

    public void toggleFrameAnim(View view) {
        // 1) Programatically set the BG of imageview to @drawable/frame_anim xml file
        lightsImageView.setBackgroundResource(R.drawable.frame_anim);
        // 2) Associate the frameAnim with the animation in XML
        frameAnim = (AnimationDrawable) lightsImageView.getBackground();
        // 3) Start the frame animation
        if (frameAnim.isRunning())
            frameAnim.stop();
        else
            frameAnim.start();
    }

    public void toggleRotateAnim(View view) {
        if (rotateAnim != null && rotateAnim.hasStarted()) {
            lightsImageView.clearAnimation();
            rotateAnim = null;
        }
        else {
            rotateAnim = AnimationUtils.loadAnimation(this, R.anim.rotate_anim);
            lightsImageView.startAnimation(rotateAnim);
        }
    }

    public void toggleShakeAnim(View view) {
        if (shakeAnim != null && shakeAnim.hasStarted()) {
            lightsImageView.clearAnimation();
            shakeAnim = null;
        } else {
            shakeAnim = AnimationUtils.loadAnimation(this, R.anim.shake_anim);
            lightsImageView.startAnimation(shakeAnim);
        }
    }

    public void toggleCustomAnim(View view) {
        if (customAnim != null && customAnim.hasStarted()) {
            lightsImageView.clearAnimation();
            frameButton.clearAnimation();
            shakeButton.clearAnimation();
            rotateButton.clearAnimation();
            customButton.clearAnimation();
            customAnim = null;
        } else {
            customAnim = AnimationUtils.loadAnimation(this, R.anim.custom_anim);
            lightsImageView.startAnimation(customAnim);
            frameButton.startAnimation(customAnim);
            shakeButton.startAnimation(customAnim);
            rotateButton.startAnimation(customAnim);
            customButton.startAnimation(customAnim);
        }
    }
}
