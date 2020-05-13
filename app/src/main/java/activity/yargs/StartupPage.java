package activity.yargs;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;



public class StartupPage extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);//隐藏状态栏
        getSupportActionBar().hide();//隐藏标题栏
        setContentView(R.layout.activity_startup_page);
        StartAnimation();
//        Thread myThread=new Thread(){//创建子线程
//            @Override
//            public void run() {
//                try{
//                    sleep(10000);//使程序休眠10秒
//                    Intent it=new Intent(getApplicationContext(),MainActivity.class);//启动MainActivity
//                    startActivity(it);
//                    finish();//关闭当前活动
//                }catch (Exception e){
//                    e.printStackTrace();
//                }
//            }
//        };
//        myThread.start();//启动线程

    }

    public void gotoActive (final View view){
        Intent i = new Intent(StartupPage.this, MainActivity.class);
        startActivity(i);
    }


    private void StartAnimation(){
        ImageView imgA = (ImageView) findViewById(R.id.imgA) ;
        ImageView imgB = (ImageView) findViewById(R.id.imgB) ;
        ImageView imgC = (ImageView) findViewById(R.id.imgC) ;
        ImageView imgC_1 = (ImageView) findViewById(R.id.imgC_1) ;
        ImageView imgC_2 = (ImageView) findViewById(R.id.imgC_2) ;
        ImageView imgD = (ImageView) findViewById(R.id.imgD) ;

        //step 1
        ObjectAnimator animatorA = ObjectAnimator.ofFloat(imgA, "scaleX", 1.5f, 0.4f);
        ObjectAnimator animatorA_1 = ObjectAnimator.ofFloat(imgA, "scaleY", 1.5f, 0.4f);

        //step 2
        ObjectAnimator animatorB = ObjectAnimator.ofFloat(imgA, "scaleX", 0.4f, 100f);
        ObjectAnimator animatorB_1 = ObjectAnimator.ofFloat(imgA, "scaleY", 0.4f, 100f);
        ObjectAnimator animatorB_2 = ObjectAnimator.ofFloat(imgA, "alpha", 1f, 0.5f);
        ObjectAnimator animatorB_3 = ObjectAnimator.ofFloat(imgB, "scaleX", 1f, 350f);
        ObjectAnimator animatorB_4 = ObjectAnimator.ofFloat(imgB, "scaleY", 1f, 350f);
        ObjectAnimator animatorB_5 = ObjectAnimator.ofFloat(imgB, "alpha", 0f, 1f);

        //step 3
        ObjectAnimator animatorC = ObjectAnimator.ofFloat(imgA, "alpha", 0.5f, 0.0f);
        ObjectAnimator animatorC_1 = ObjectAnimator.ofFloat(imgC, "scaleX", 1f, 1500f);
        animatorC_1.setInterpolator(new LinearInterpolator());
        ObjectAnimator animatorC_2 = ObjectAnimator.ofFloat(imgC, "scaleY", 1f, 1500f);
        animatorC_2.setInterpolator(new LinearInterpolator());
        ObjectAnimator animatorC_3 = ObjectAnimator.ofFloat(imgC, "Rotation", 0, 360);
        animatorC_3.setRepeatCount(-1);
        animatorC_3.setRepeatMode(ValueAnimator.RESTART);
        animatorC_3.setDuration(100);
        animatorC_3.setInterpolator(new LinearInterpolator());

        //step 4
        ObjectAnimator animatorD = ObjectAnimator.ofFloat(imgC, "scaleX", 1f, 3000f);
        animatorD.setInterpolator(new LinearInterpolator());
        ObjectAnimator animatorD_1 = ObjectAnimator.ofFloat(imgC, "scaleY", 1f, 3000f);
        animatorD_1.setInterpolator(new LinearInterpolator());
        ObjectAnimator animatorD_2 = ObjectAnimator.ofFloat(imgC_1, "scaleX", 1f, 1500f);
        animatorD_2.setInterpolator(new LinearInterpolator());
        ObjectAnimator animatorD_3 = ObjectAnimator.ofFloat(imgC_1, "scaleY", 1f, 1500f);
        animatorD_3.setInterpolator(new LinearInterpolator());
        ObjectAnimator animatorD_4 = ObjectAnimator.ofFloat(imgC_1, "Rotation", 0, 360);
        animatorD_4.setRepeatCount(-1);
        animatorD_4.setRepeatMode(ValueAnimator.RESTART);
        animatorD_4.setDuration(100);
        animatorD_4.setInterpolator(new LinearInterpolator());

        //step 5
        ObjectAnimator animatorE = ObjectAnimator.ofFloat(imgC, "scaleX", 1f, 5000f);
        animatorE.setInterpolator(new LinearInterpolator());
        ObjectAnimator animatorE_1 = ObjectAnimator.ofFloat(imgC, "scaleY", 1f, 5000f);
        animatorE_1.setInterpolator(new LinearInterpolator());
        ObjectAnimator animatorE_2 = ObjectAnimator.ofFloat(imgC_1, "scaleX", 1f, 3200f);
        animatorE_2.setInterpolator(new LinearInterpolator());
        ObjectAnimator animatorE_3 = ObjectAnimator.ofFloat(imgC_1, "scaleY", 1f, 3200f);
        animatorE_3.setInterpolator(new LinearInterpolator());
        ObjectAnimator animatorE_4 = ObjectAnimator.ofFloat(imgC_2, "scaleX", 1f, 1500f);
        animatorE_4.setInterpolator(new LinearInterpolator());
        ObjectAnimator animatorE_5 = ObjectAnimator.ofFloat(imgC_2, "scaleY", 1f, 1500f);
        animatorE_5.setInterpolator(new LinearInterpolator());
        ObjectAnimator animatorE_6 = ObjectAnimator.ofFloat(imgC_2, "Rotation", 0, 360);
        animatorE_6.setRepeatCount(-1);
        animatorE_6.setRepeatMode(ValueAnimator.RESTART);
        animatorE_6.setDuration(100);
        animatorE_6.setInterpolator(new LinearInterpolator());
        ObjectAnimator animatorE_7 = ObjectAnimator.ofFloat(imgB, "scaleX", 350f, 8500f);
        ObjectAnimator animatorE_8 = ObjectAnimator.ofFloat(imgB, "scaleY", 350f, 8500f);

        //step 6
        ObjectAnimator animatorF = ObjectAnimator.ofFloat(imgC_1, "alpha", 1f, 0f);
        ObjectAnimator animatorF_1 = ObjectAnimator.ofFloat(imgC_2, "alpha", 1f, 0f);
        ObjectAnimator animatorF_2 = ObjectAnimator.ofFloat(imgD, "scaleX", 1f, 1500f);
        ObjectAnimator animatorF_3 = ObjectAnimator.ofFloat(imgD, "scaleY", 1f, 1500f);

        //Start
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration(500);
        animatorSet.play(animatorA);
        animatorSet.play(animatorA_1).after(animatorA);
        animatorSet.play(animatorB).with(animatorB_1).with(animatorB_2).with(animatorB_3).with(animatorB_4).with(animatorB_5).after(animatorA);
        animatorSet.play(animatorC).with(animatorC_1).with(animatorC_2).with(animatorC_3).after(animatorB);
        animatorSet.play(animatorD).with(animatorD_1).with(animatorD_2).with(animatorD_3).with(animatorD_4).after(animatorC);
        animatorSet.play(animatorE).with(animatorE_1).with(animatorE_2).with(animatorE_3).with(animatorE_4).with(animatorE_5).with(animatorE_6).with(animatorE_7).with(animatorE_8).after(animatorD);
        animatorSet.play(animatorF).with(animatorF_1).with(animatorF_2).with(animatorF_3).after(animatorE);
        animatorSet.start();
    }


}
