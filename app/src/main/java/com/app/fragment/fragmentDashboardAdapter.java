package com.app.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.app.diemdanhapp.R;
import com.app.model.fragmentDashboardModel;
import com.app.model.userInfo;

public class fragmentDashboardAdapter extends FragmentPagerAdapter {

    static Context context;
    static fragmentDashboardModel fragmentDashModel ;


    public fragmentDashboardAdapter(FragmentManager fm, Context context) {
        super(fm);
        this.context = context;
        fragmentDashModel = new fragmentDashboardModel(this.context);
    }


    @Override
    public Fragment getItem(int position) {
        return fragmentDashboardAdapter.PlaceholderFragment.newInstance(position + 1);
//            return new fragmentMyClass();
    }


    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "My Class";
            case 1:
                return "All Class";

        }
        return null;
    }


    public static class PlaceholderFragment extends Fragment {

        private static final String KEY = "key_index";

        public PlaceholderFragment() {
        }

        public static fragmentDashboardAdapter.PlaceholderFragment newInstance(int index) {
            fragmentDashboardAdapter.PlaceholderFragment fragment = new fragmentDashboardAdapter.PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(KEY, index);
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_dashboard, container, false);
            LinearLayout scrollLayout = (LinearLayout) rootView.findViewById(R.id.dash_fragment);

            switch (getArguments().getInt(KEY)) {
                case 1:
                    if(userInfo.getType().equals("std")){
                        fragmentDashModel.getDataMyClass(scrollLayout);
                    }else if(userInfo.getType().equals("teacher")){
                        fragmentDashModel.getDataClassTeacher(scrollLayout);
                    }
                    break;
                case 2:
                    fragmentDashModel.getDataAllClass(scrollLayout);
                    break;
                default:
                    break;
            }

            return rootView;
        }



    }

}


