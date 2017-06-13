package com.example.goals.a40ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Chenyc on 2015/6/29.
 */
public class ContentFragment extends Fragment {

    public static ContentFragment newInstance(String info) {
        Bundle args = new Bundle();
        ContentFragment fragment = new ContentFragment();
        args.putString("info", info);
        fragment.setArguments(args);
        return fragment;
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.block_sunshine_content, null);

        return view;
    }
}
