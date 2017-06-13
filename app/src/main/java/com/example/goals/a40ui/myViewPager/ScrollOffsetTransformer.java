package com.example.goals.a40ui.myViewPager;

import android.support.v4.view.ViewPager.PageTransformer;
import android.util.Log;
import android.view.View;

/**
 * Created by huyongqiang on 17/6/8.
 */
public class ScrollOffsetTransformer implements PageTransformer {
    @Override
    public void transformPage(View page, float position) {
        Log.d("azzz", "page = " + page + ",pos = " + position);

        if (position > 0) {
            page.setTranslationX(-100 * position);
        }
    }
}
