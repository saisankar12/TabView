package com.example.saisankar.tabview;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    TabLayout tl;
    ViewPager vp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tl=findViewById(R.id.tab);
        vp=findViewById(R.id.pager);

        vp.setAdapter(new TabAdapter(getSupportFragmentManager()));

        tl.setupWithViewPager(vp);

    }

    private class TabAdapter extends FragmentStatePagerAdapter {
        public TabAdapter(FragmentManager supportFragmentManager) {
            super(supportFragmentManager);
        }

        @Override
        public Fragment getItem(int position) {

            switch (position){
                case 0:
                    return new Channel();
                case 1:
                    return new PlayList();
                case 2:
                    return new Live();
            }
            return null;
        }

        @Override
        public int getCount() {
            return 3;
        }

        @Override
        public CharSequence getPageTitle(int position) {

            switch (position){
                case 0:
                    return "Channel";
                case 1:
                    return "PlayList";
                case 2:
                    return "Live";
            }
            return super.getPageTitle(position);
        }
    }
}
