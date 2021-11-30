package com.example.qlist_newlistbydesint;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.etebarian.meowbottomnavigation.MeowBottomNavigation;

import java.util.ArrayList;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
//variabel
    MeowBottomNavigation bottomNavigation;

 DatePickerDialog.OnDateSetListener setListener;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();



        //act variabel
        bottomNavigation=findViewById(R.id.navigasibot);
        //new menu
        bottomNavigation.add(new MeowBottomNavigation.Model(1, R.drawable.ic_home_black_24dp));
        bottomNavigation.add(new MeowBottomNavigation.Model(2, R.drawable.ic_view_list_24));
        bottomNavigation.add(new MeowBottomNavigation.Model(3, R.drawable.ic_playlist_add_24dp));
        bottomNavigation.add(new MeowBottomNavigation.Model(4, R.drawable.ic_shopping_cart_24dp));
        bottomNavigation.add(new MeowBottomNavigation.Model(5, R.drawable.ic_baseline_settings_24dp));

        bottomNavigation.setOnShowListener(new MeowBottomNavigation.ShowListener() {



            @Override
            public void onShowItem(MeowBottomNavigation.Model item) {
                //notif

                bottomNavigation.setOnClickMenuListener( new MeowBottomNavigation.ClickListener(){
                    @Override
                    public void onClickItem(MeowBottomNavigation.Model item){
                        Toast.makeText(getApplicationContext()
                                , "You Clicked"  + item.getId()
                                , Toast.LENGTH_SHORT).show();
                    }
                });

                Fragment fragment =null;
                //CHECK CONDITION
                switch (item.getId()) {
                    case 1:
                        fragment= new homeFragment();
                        break;
                    case 2:
                        fragment= new viewlistFragment();
                        break;
                    case 3:
                        fragment= new newlistFragment();
                        break;
                    case 4:
                        fragment= new hargabarangFragment();
                        break;
                    case 5:
                        fragment= new settingFragment();
                        break;
                }
loadFragment(fragment);

            }
        });


    }

    private void loadFragment(Fragment fragment) {
        //
        getSupportFragmentManager()
            .beginTransaction ()
            .replace(R.id.frame_layout,fragment)
                .commit();






    }
}