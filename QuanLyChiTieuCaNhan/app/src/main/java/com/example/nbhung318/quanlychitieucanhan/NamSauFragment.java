package com.example.nbhung318.quanlychitieucanhan;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Hung on 3/19/2018.
 */

public class NamSauFragment extends Fragment {
    private View xRootView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        xRootView = inflater.inflate(R.layout.fragment_namsau,container,false);
        return xRootView;
    }
}
