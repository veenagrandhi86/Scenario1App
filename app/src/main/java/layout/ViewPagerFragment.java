package layout;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.veena.scenario1app.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ViewPagerFragment extends Fragment {

    public static final String TAG = "ViewPagerFragment";

    public static ViewPagerFragment newInstance() {
        return new ViewPagerFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_view_pager, container, false);

        final ViewPager pager = (ViewPager) view.findViewById(R.id.viewPager);
        pager.setAdapter(new MyPagerAdapter(getActivity().getSupportFragmentManager()));

        TabLayout tabLayout = (TabLayout) view.findViewById(R.id.tab_layout);
        tabLayout.setupWithViewPager(pager, true);

        final GestureDetector tapGestureDetector;
        tapGestureDetector = new GestureDetector(getContext(), new TapGestureListener());

        pager.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View v, MotionEvent event) {
                tapGestureDetector.onTouchEvent(event);
                Toast.makeText(getContext(),String.valueOf(pager.getCurrentItem()+1),Toast.LENGTH_SHORT).show();
                return false;
            }
        });

        return view;
    }

    private class TapGestureListener extends GestureDetector.SimpleOnGestureListener {

        @Override
        public boolean onSingleTapConfirmed(MotionEvent e) {
            Log.d(TAG, "Inside method onSingleTapConfirmed");
            return true;
        }
    }

    private class MyPagerAdapter extends FragmentPagerAdapter {

        public MyPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public int getItemPosition(Object object) {
            return super.getItemPosition(object);
        }

        @Override
        public Fragment getItem(int pos) {
            switch(pos) {

                case 0: return FirstFragment.newInstance();
                case 1: return SecondFragment.newInstance();
                case 2: return ThirdFragment.newInstance();
                case 3: return FourthFragment.newInstance();
                default: return FirstFragment.newInstance();
            }
        }

        @Override
        public int getCount() {
            return 4;
        }
    }
}
