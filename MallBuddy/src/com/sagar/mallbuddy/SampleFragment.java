package com.sagar.mallbuddy;

import java.util.ArrayList;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import com.sagar.mallbuddy.adapters.AdapterCategoryList;
import com.sagar.mallbuddy.beans.Category;
import com.sagar.mallbuddy.localdata.CategoryDB;

public class SampleFragment extends Fragment {
    private Bundle mArguments;

    public static final String ARG_IMAGE_RES = "image_source";
    public static final String ARG_ACTION_BG_RES = "image_action_bs_res";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_scrollview, null);

//        if (mArguments != null){
//            ImageView img = (ImageView) view.findViewById(R.id.image_header);
//            img.setImageResource(mArguments.getInt(ARG_IMAGE_RES));
//        }
//        
        CategoryDB catDB = new CategoryDB(getActivity());
        catDB.open();
        ArrayList<Category> categories = catDB.getCategoryArray(null);
        ListView listView = (ListView) view.findViewById(R.id.lvCustom);
        AdapterCategoryList catAdapter = new AdapterCategoryList(categories, getActivity());
        listView.setAdapter(catAdapter);

        return view;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        //mArguments = getArguments();
        //int actionBarBg = mArguments != null ? mArguments.getInt(ARG_ACTION_BG_RES) : R.drawable.ab_background_light;

//        mFadingHelper = new FadingActionBarHelper()
//            .actionBarBackground(actionBarBg)
//            .headerLayout(R.layout.header_light)
//            .contentLayout(R.layout.activity_scrollview)
//            .lightActionBar(actionBarBg == R.drawable.ab_background_light);
//        mFadingHelper.initActionBar(activity);
    }
}