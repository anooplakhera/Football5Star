package com.app.football5star.AppModules.Match;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.app.football5star.Adapter.CustomtabPagerAdapter.FragmentPagerItem;
import com.app.football5star.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class MatchPagerAddFragment extends Fragment {


    public MatchPagerAddFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_match_pager_add, container, false);

        int position = FragmentPagerItem.getPosition(getArguments());
        TextView title = (TextView) view.findViewById(R.id.item_title);
        title.setText(String.valueOf(position));

        return view;
    }

}
