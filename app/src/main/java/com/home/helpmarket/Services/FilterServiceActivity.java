package com.home.helpmarket.Services;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;

import android.support.v4.app.FragmentManager;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;

import com.home.helpmarket.Constant;
import com.home.helpmarket.Maps.MapsActivity;
import com.home.helpmarket.R;
import com.home.helpmarket.Services.dummy.DummyContent;

import java.util.ArrayList;
import java.util.List;

public class FilterServiceActivity extends AppCompatActivity
        implements SelectTypeFragment.OnListFragmentInteractionListener,
        SelectRangeFragment.OnFragmentInteractionListener,
        SelectTypeFragment.OnEditListener {

    private int mMan = 0;
    private int mDistance = 0;
    public static List<DummyContent.DummyItem> queryList = DummyContent.ITEMS;

    /**
     * The {@link FrameLayout} that will host the section contents.
     */
    private FrameLayout mFrameLayout;

    private FragmentManager fm = getSupportFragmentManager();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filter_service);

        // Set up the ViewPager with the sections adapter.
        mFrameLayout = (FrameLayout) findViewById(R.id.container);

        fm.beginTransaction()
        .add(R.id.container, SelectTypeFragment.newInstance())
        .commit();
    }

    /**
     * 1st page callback, click on list item
     * @param item
     * @param position
     */
    @Override
    public void onListFragmentInteraction(DummyContent.DummyItem item, int position) {
        item.isSelected = !item.isSelected;
    }

    /**
     * 2nd page callback
     * @param man service provider number
     */
    @Override
    public void onManInteraction(int man) {
        mMan = man;
    }

    /**
     * 2nd page callback
     * @param distance service provider distance
     */
    @Override
    public void onDistanceInteraction(int distance) {
        mDistance = distance;
    }

    @Override
    public void onBackPressed() {
        if (fm.getBackStackEntryCount() > 0) {
            fm.popBackStackImmediate();
        } else {
            super.onBackPressed();
        }
    }

    public void onClickTiepTuc(View view) {
        fm.beginTransaction()
        .replace(R.id.container, SelectRangeFragment.newInstance(null, null))
        .addToBackStack(null)
        .commit();
    }

    public void onCLickTimKiem(View view) {
        // Hard code
        if (mMan == 0) {
            mMan = 10;
            return;
        } else if (mDistance == 0) {
            mDistance = 2;
        }
        Intent intent = new Intent(FilterServiceActivity.this, MapsActivity.class);
        Bundle args = new Bundle();
        args.putInt(Constant.ARG_DISTANCE, mDistance);
        args.putInt(Constant.ARG_MAN, mMan);
        intent.putExtras(args);
        startActivity(intent);
    }

    @Override
    public void onEditListener(String query) {
        if (query.isEmpty()) {
            queryList = DummyContent.ITEMS;
            return;
        }
        queryList = new ArrayList<>();
        for (DummyContent.DummyItem item :
                DummyContent.ITEMS) {
            if (item.content.toLowerCase().contains(query.toLowerCase())) {
                queryList.add(item);
            }
        }
    }
}
