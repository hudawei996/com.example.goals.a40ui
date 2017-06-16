package com.example.goals.a40ui;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Chenyc on 2015/6/29.
 */
public class ContentFragment extends Fragment {
    public static ContentFragment contentFragment;

//    public static ContentFragment newInstance(String info) {
        public static ContentFragment newInstance(int index) {
        /*Bundle args = new Bundle();
        ContentFragment contentFragment = new ContentFragment();
        args.putString("info", info);
        contentFragment.setArguments(args);
        return contentFragment;*/

        if(contentFragment==null){
            contentFragment = new ContentFragment();
        }
        Bundle args = new Bundle();
        args.putInt("index", index);
        contentFragment.setArguments(args);
        return contentFragment;
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.block_sunshine_content, null);

        return view;
    }
}
