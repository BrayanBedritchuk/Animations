package br.com.sailboat.animations.base;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

import br.com.sailboat.animations.R;

public abstract class BaseActivity extends AppCompatActivity {

    private static final String TAG_BASE_FRAGMENT = "TAG_BASE_FRAGMENT";
    private Fragment fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.frame_layout);
        initViews();
        checkStateAndAddFragment();
    }

    protected void initViews() {}

    private void checkStateAndAddFragment() {
        fragment = getSupportFragmentManager().findFragmentByTag(TAG_BASE_FRAGMENT);

        if (fragment == null) {
            fragment = newFragmentInstance();
            addFragment();
        }
    }

    private void addFragment() {
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.frameLayout, fragment, TAG_BASE_FRAGMENT)
                .commit();
    }

    protected abstract Fragment newFragmentInstance();

}
