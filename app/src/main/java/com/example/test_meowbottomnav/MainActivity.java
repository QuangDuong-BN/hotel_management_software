package com.example.test_meowbottomnav;

import android.os.Build;
import android.os.Bundle;
import android.view.Window;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.test_meowbottomnav.FragmentMain.HomeBlankFragment;
import com.example.test_meowbottomnav.FragmentMain.InfoBlankFragment;
import com.example.test_meowbottomnav.FragmentMain.NotiBlankFragment;
import com.example.test_meowbottomnav.FragmentMain.SettingBlankFragment;

import me.ibrahimsn.lib.OnItemSelectedListener;
import me.ibrahimsn.lib.SmoothBottomBar;


public class MainActivity extends AppCompatActivity {
    private SmoothBottomBar smoothBottomBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Window window = getWindow();

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.setStatusBarColor(getResources().getColor(R.color.statusBar));
        }
        rePlace(new HomeBlankFragment());
        smoothBottomBar = findViewById(R.id.bottomBar);
        smoothBottomBar.setOnItemSelectedListener(new OnItemSelectedListener() {
            @Override
            public boolean onItemSelect(int i) {
                switch (i) {
                    case 0:
                        rePlace(new HomeBlankFragment());
                        break;
                    case 1:
                        rePlace(new SettingBlankFragment());
                        break;
                    case 2:
                        rePlace(new NotiBlankFragment());
                        break;
                    case 3:
                        rePlace(new InfoBlankFragment());
                        break;
                }
                return false;
            }
        });
    }

    private void rePlace(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.Fragment_main, fragment);
        transaction.commit();
    }

}
