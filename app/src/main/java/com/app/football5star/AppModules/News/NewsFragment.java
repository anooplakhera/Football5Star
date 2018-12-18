package com.app.football5star.AppModules.News;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.app.football5star.Activities.Base.BaseFragment;
import com.app.football5star.Adapter.CustomtabPagerAdapter.FragmentPagerItem;
import com.app.football5star.Adapter.CustomtabPagerAdapter.FragmentPagerItemAdapter;
import com.app.football5star.Adapter.CustomtabPagerAdapter.FragmentPagerItems;
import com.app.football5star.R;
import com.ogaclejapan.smarttablayout.SmartTabLayout;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class NewsFragment extends BaseFragment {

    @BindView(R.id.viewPagerTab)
    SmartTabLayout viewPagerTab;
    @BindView(R.id.viewPagerView)
    ViewPager viewPagerView;

    int heading[] = {R.string.demo_tab_1,
            R.string.demo_tab_2,
            R.string.demo_tab_3,
            R.string.demo_tab_4,
            R.string.demo_tab_5,
            R.string.demo_tab_6,
            R.string.demo_tab_7,
            R.string.demo_tab_8,
            R.string.demo_tab_9,
            R.string.demo_tab_10};

    public NewsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_news, container, false);
        setUnBinder(ButterKnife.bind(this, view));


        FragmentPagerItems pages = new FragmentPagerItems(getActivity());
        for (int titleResId : heading) {
            pages.add(FragmentPagerItem.of(getString(titleResId), NewsPagerAddFragment.class));
        }

        FragmentPagerItemAdapter adapter = new FragmentPagerItemAdapter(
                getChildFragmentManager(), pages);

        viewPagerView.setAdapter(adapter);
        viewPagerTab.setViewPager(viewPagerView);

        return view;
    }


    @Override
    protected void setUp(View view) {

    }
}
