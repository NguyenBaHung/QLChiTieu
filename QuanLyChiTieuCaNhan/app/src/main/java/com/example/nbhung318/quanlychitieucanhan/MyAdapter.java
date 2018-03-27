package com.example.nbhung318.quanlychitieucanhan;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by Hung on 3/19/2018.
 */

public class MyAdapter extends FragmentStatePagerAdapter {
    private String listTab[] = {"Năm trước", "Năm nay", "Năm sau"};
    private NamTruocFragment namTruocFragment;
    private NamNayFragment namNayFragment;
    private NamSauFragment namSauFragment;

    public MyAdapter(FragmentManager fm) {
        super(fm);
        namTruocFragment = new NamTruocFragment();
        namNayFragment = new NamNayFragment();
        namSauFragment = new NamSauFragment();
    }


    @Override
    public Fragment getItem(int position) {
        if (position==0){
            return namTruocFragment;
        }
        else if (position==1){
            return namNayFragment;
        }else if (position==2){
            return namSauFragment;
        }else {
            // todo somthing
        }
        return null;
    }

    @Override
    public int getCount() {
        return listTab.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return listTab[position];
    }
}
