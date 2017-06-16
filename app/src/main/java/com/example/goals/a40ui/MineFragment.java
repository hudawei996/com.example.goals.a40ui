package com.example.goals.a40ui;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Chenyc on 2015/6/29.
 */
public class MineFragment extends Fragment {
    public static MineFragment mineFragment;

    public static MineFragment newInstance(String info) {
        Bundle args = new Bundle();
        MineFragment fragment = new MineFragment();
        args.putString("info", info);
        fragment.setArguments(args);
        return fragment;
    }


    public static MineFragment newInstance(int index) {
        if(mineFragment==null){
            mineFragment = new MineFragment();
        }
        Bundle args = new Bundle();
        args.putInt("index", index);
        mineFragment.setArguments(args);
        return mineFragment;
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_mine, null);

        return view;
    }
}
