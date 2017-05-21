package com.home.helpmarket.Services;

import android.net.Uri;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;

import com.home.helpmarket.R;
import com.home.helpmarket.Services.dummy.DummyContent;

public class FilterServiceActivity extends AppCompatActivity implements SelectTypeFragment.OnListFragmentInteractionListener, SelectRangeFragment.OnFragmentInteractionListener {

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
        .add(R.id.container, SelectTypeFragment.newInstance(0))
        .commit();
    }

    /**
     * 1st page callback, click on list item
     * @param item
     */
    @Override
    public void onListFragmentInteraction(DummyContent.DummyItem item) {

    }

    /**
     * 2nd page call back
     * @param uri
     */
    @Override
    public void onFragmentInteraction(Uri uri) {

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

    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return SelectTypeFragment(1st page) or SelectRangeFragment(2nd page)
            Fragment fragment;
            switch (position) {
                case 0:
                    fragment = SelectTypeFragment.newInstance(0);
                    return fragment;
                case 1:
                    fragment = SelectRangeFragment.newInstance(null, null);
                    return fragment;
                default:
                    return null;
            }
        }

        @Override
        public int getCount() {
            // Show 2 total pages.
            return 2;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "SECTION 1";
                case 1:
                    return "SECTION 2";
            }
            return null;
        }
    }
}
