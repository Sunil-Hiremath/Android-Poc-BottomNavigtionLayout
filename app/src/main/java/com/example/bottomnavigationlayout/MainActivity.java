package com.example.bottomnavigationlayout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bnView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bnView=findViewById(R.id.bnView);

        //here if on click listner took on clicking view will bw clicked not inside the items in it.
        bnView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                int id=item.getItemId();

                if(id==R.id.nav_home){
                    loadFrag(new AFragment(),false);
                    
                } else if (id==R.id.nav_contact) {
                    loadFrag(new BFragment(),false);
                    
                } else if (id==R.id.nav_myProfile) {
                    loadFrag(new CFragment(),false);


                } else if (id==R.id.nav_utilities) {
                    loadFrag(new DFragment(),false);

                }else{
                    loadFrag(new EFragment(),true);
                }

                return true;//true because selected items should also navigate according to fragments
            }
        });

        //by default
        bnView.setSelectedItemId(R.id.nav_myProfile);

        }
    public void loadFrag(Fragment fragment, boolean flag){
        //loading the fragments in frameLayout
        FragmentManager fm=getSupportFragmentManager();
        FragmentTransaction ft=fm.beginTransaction();
        if(flag)
            ft.add(R.id.Container,fragment);
        else
            ft.replace(R.id.Container,fragment);
        ft.commit();
    }
    }
