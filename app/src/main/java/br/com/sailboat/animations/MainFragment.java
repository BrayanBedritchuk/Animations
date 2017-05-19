package br.com.sailboat.animations;

import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

public class MainFragment extends Fragment {

    private Button btAnimate;
    private ImageView imgAlpha;
    private ImageView imgRotation;
    private ImageView imgX;

    private boolean isAlphaShown = true;
    private boolean isXYLeft = true;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        initViews(view);
        return view;
    }

    private void initViews(View view) {
        inflateViews(view);
        initListeners();
    }

    private void inflateViews(View view) {
        btAnimate = (Button) view.findViewById(R.id.fragment_main__bt__animate);
        imgAlpha = (ImageView) view.findViewById(R.id.fragment_main__img__alpha);
        imgRotation = (ImageView) view.findViewById(R.id.fragment_main__img__rotation);
        imgX = (ImageView) view.findViewById(R.id.fragment_main__img__x);
    }

    private void initListeners() {
        btAnimate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (isAlphaShown) {
                    ObjectAnimator anim = ObjectAnimator.ofFloat(imgAlpha, "alpha", 1f, 0f);
                    anim.setDuration(1000);
                    anim.start();

                } else {
                    ObjectAnimator anim = ObjectAnimator.ofFloat(imgAlpha, "alpha", 0f, 1f);
                    anim.setDuration(1000);
                    anim.start();
                }

                isAlphaShown = !isAlphaShown;
            }

        });

        imgRotation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ObjectAnimator anim = ObjectAnimator.ofFloat(imgRotation, "rotation", 0f, 360f);
                anim.setDuration(1000);
                anim.start();
            }

        });

        imgX.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isXYLeft) {
                    ObjectAnimator animX = ObjectAnimator.ofFloat(imgX, "x", 300f);
                    animX.setDuration(300);
                    animX.start();
                } else {
                    ObjectAnimator animX = ObjectAnimator.ofFloat(imgX, "x", 0f);
                    animX.setDuration(300);
                    animX.start();
                }
                isXYLeft = !isXYLeft;
            }

        });
    }
}
