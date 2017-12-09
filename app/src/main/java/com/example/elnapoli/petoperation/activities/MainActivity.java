package com.example.elnapoli.petoperation.activities;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.example.elnapoli.petoperation.R;
import com.example.elnapoli.petoperation.adapters.PageAdapter;
import com.example.elnapoli.petoperation.adapters.PetAdapter;
import com.example.elnapoli.petoperation.fragments.MyPetFragment;
import com.example.elnapoli.petoperation.fragments.PetFragment;
import com.example.elnapoli.petoperation.models.Pets;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewpager;


    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.main_menu,menu);
        return true;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolbar);
        tabLayout = findViewById(R.id.tabLayout);
        viewpager = findViewById(R.id.viewPager);

        setUpViewPager();
        if(toolbar != null){
            setSupportActionBar(toolbar);
        }
    }

    private ArrayList<Fragment> addFragment(){
        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(new PetFragment());
        fragments.add(new MyPetFragment());
        return  fragments;

    }

    private void setUpViewPager(){
        viewpager.setAdapter(new PageAdapter(getSupportFragmentManager(),addFragment()));
        tabLayout.setupWithViewPager(viewpager);
        tabLayout.getTabAt(0).setIcon(R.drawable.ic_profile_dog);
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_dog_my_profile);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.iFavourite:
               /* Intent intent = new Intent(MainActivity.this,FavouritePet.class);
                Bundle bundle = new Bundle();
                ArrayList<Pets> requestPet = new ArrayList<Pets>();
                int count = 0;
                Iterator<Pets> it = myPets.iterator();
                for(int i = 0; i < myPets.size(); i++){
                    if(count > 4){
                        break;
                    }
                    if(myPets.get(i).getIsLike()){
                        count++;
                        requestPet.add(myPets.get(i));
                    }

                }
                bundle.putSerializable("myPets",requestPet);
                intent.putExtras(bundle);
                startActivity(intent);*/
                break;
            case R.id.iContact:
                Intent intentContact = new Intent(MainActivity.this,ContactActivity.class);
                startActivity(intentContact);
                break;
            case R.id.iAbout:
                Intent intentAbout = new Intent(MainActivity.this,AboutActivity.class);
                startActivity(intentAbout);
                break;


        }
        return super.onOptionsItemSelected(item);
    }

}
