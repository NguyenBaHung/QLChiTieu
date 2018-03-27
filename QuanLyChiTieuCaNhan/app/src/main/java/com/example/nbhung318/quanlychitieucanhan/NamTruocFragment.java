package com.example.nbhung318.quanlychitieucanhan;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by Hung on 3/19/2018.
 */

public class NamTruocFragment extends Fragment {
    private View xRootView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        xRootView = inflater.inflate(R.layout.fragment_namtruoc,container,false);
        return xRootView;
    }
}


