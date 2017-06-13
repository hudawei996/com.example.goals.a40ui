package com.example.goals.a40ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by huyongqiang on 2017/6/8.
 */
public class WeekFragment extends Fragment {

    public static WeekFragment newInstance(String info) {
        Bundle args = new Bundle();
        WeekFragment fragment = new WeekFragment();
        args.putString("info", info);
        fragment.setArguments(args);
        return fragment;
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.block_sunshine_every_week, null);
        TextView tvInfo = (TextView) view.findViewById(R.id.tvWeekDate);
        tvInfo.setText(getArguments().getString("info"));
//        tvInfo.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Snackbar.make(v,"hello",Snackbar.LENGTH_SHORT).show();
//            }
//        });
        return view;
    }
}
