package br.com.sailboat.animations;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private static final String TAG_MAIN_FRAGMENT = "TAG_MAIN_FRAGMENT";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initFragment();
    }

    private void initFragment() {
        MainFragment fragment = (MainFragment) getSupportFragmentManager().findFragmentByTag(TAG_MAIN_FRAGMENT);
        if (fragment == null) {
            fragment = new MainFragment();
            addFragment(fragment);
        }
    }

    private void addFragment(Fragment fragment) {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.add(R.id.activity_main__fl__fragment, fragment, TAG_MAIN_FRAGMENT);
        ft.commit();
    }

}
