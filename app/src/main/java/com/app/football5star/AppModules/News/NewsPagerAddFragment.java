package com.app.football5star.AppModules.News;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.app.football5star.Activities.Base.BaseFragment;
import com.app.football5star.Adapter.CustomtabPagerAdapter.FragmentPagerItem;
import com.app.football5star.AppModules.News.NewsAdapter.RecycleViewAdapter;
import com.app.football5star.R;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class NewsPagerAddFragment extends BaseFragment {

    @BindView(R.id.recycleViewNews)
    RecyclerView recycleViewNews;

    RecycleViewAdapter adapter;
    GridLayoutManager mManager;
    ArrayList<String> allData = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_demo, container, false);
        setUnBinder(ButterKnife.bind(this, view));

        allData.clear();
        for (int i = 0; i < 200; i++) {
            allData.add("" + i);
        }

        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        int position = FragmentPagerItem.getPosition(getArguments());


        mManager = new GridLayoutManager(getActivity(), 4);

        recycleViewNews.setLayoutManager(mManager);
        adapter = new RecycleViewAdapter(getActivity(), allData);
        recycleViewNews.setAdapter(adapter);


    }

    @Override
    protected void setUp(View view) {

    }

}
