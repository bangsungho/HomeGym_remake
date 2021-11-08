package com.example.homegym_remake;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    private FragmentManager fragmentManager = getSupportFragmentManager();
    private FragmentHome fragmentHome = new FragmentHome();
    private FragmentInfor fragmentInfor = new FragmentInfor();
    private FragmentDiet fragmentDiet = new FragmentDiet();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.frameLayout, fragmentHome).commit(); // 가장 먼저 등장할 프래그먼트 화면 레이아웃 fragmentSearch

        BottomNavigationView bottomNavigationView = findViewById(R.id.navigationView); //메인화면에서, bottmnavigationview 연결
        bottomNavigationView.setOnNavigationItemSelectedListener(new ItemSelectedListener());
    }

    class ItemSelectedListener implements BottomNavigationView.OnNavigationItemSelectedListener{ //bottomnavigaion에서 각 아이템을 클릭했을 때

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
            FragmentTransaction transaction = fragmentManager.beginTransaction();

            switch(menuItem.getItemId())
            {
                case R.id.homeItem:
                    transaction.replace(R.id.frameLayout, fragmentHome).commitAllowingStateLoss();
                    break;
                case R.id.inforItem:
                    transaction.replace(R.id.frameLayout, fragmentInfor).commitAllowingStateLoss();
                    break;
                case R.id.dietItem:
                    transaction.replace(R.id.frameLayout, fragmentDiet).commitAllowingStateLoss();
                    break;
            }
            return true;
        }
    }
}
