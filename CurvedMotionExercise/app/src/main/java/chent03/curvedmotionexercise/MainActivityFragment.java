package chent03.curvedmotionexercise;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.FragmentTransaction;
import android.graphics.Path;
import android.graphics.PointF;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.PathInterpolator;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {
    boolean status = false;
    ImageButton img;
    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View v =  inflater.inflate(R.layout.fragment_main, container, false);
        img = (ImageButton)v.findViewById(R.id.khaled);
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!status){
                    float ax = img.getX();
                    float ay = img.getY();
                    float bx = ax+ 400;
                    float by = ax+ 400;
                    float mx = bx;
                    float my = by/2;


                    Path path = new Path();
                    path.moveTo(ax+0, ay+0);
                    path.quadTo(mx, my, bx, by);
                    ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(view, View.X, View.Y, path);
                    objectAnimator.setDuration(3000);
                    objectAnimator.start();
                    status = true;
                }else {
                    float x = img.getX();
                    float y = img.getY();
                    Path path = new Path();
                    path.moveTo(x +0, y+0);
                    path.lineTo(x - 400, y - 400);
                    ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(view, View.X, View.Y, path);
                    objectAnimator.setDuration(3000);
                    objectAnimator.start();
                    status = false;
                }
            }
        });





        return v;

    }
}
