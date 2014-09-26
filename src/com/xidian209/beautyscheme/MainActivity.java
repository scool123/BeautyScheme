package com.xidian209.beautyscheme;

import com.astuetz.PagerSlidingTabStrip;

import android.app.Activity;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentManager;
import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class MainActivity extends ActionBarActivity implements
		NavigationDrawerFragment.NavigationDrawerCallbacks {

	/**
	 * Fragment managing the behaviors, interactions and presentation of the
	 * navigation drawer.
	 */
	private NavigationDrawerFragment mNavigationDrawerFragment;

	/**
	 * Used to store the last screen title. For use in
	 * {@link #restoreActionBar()}.
	 */
	private CharSequence mTitle;
	
	//我的计划fragment
	private MineFragment Mine;
	//排行
	private RankItemFragmentFragment Rank;
	//朋友
	private FriendsItemFragmentFragment Friends;
	// PagerSlidingTabStrip的实例
	private PagerSlidingTabStrip tabs;
	//获取当前屏幕的密度 
	private DisplayMetrics dm;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		mNavigationDrawerFragment = (NavigationDrawerFragment) getSupportFragmentManager()
				.findFragmentById(R.id.navigation_drawer);
		mTitle = getTitle();

		// Set up the drawer.
		mNavigationDrawerFragment.setUp(R.id.navigation_drawer,
				(DrawerLayout) findViewById(R.id.drawer_layout));
		
		dm = getResources().getDisplayMetrics();  
        ViewPager pager = (ViewPager) findViewById(R.id.pager);  
        tabs = (PagerSlidingTabStrip) findViewById(R.id.tabs);  
        pager.setAdapter(new MyPagerAdapter(getSupportFragmentManager()));  
        tabs.setViewPager(pager);  
        setTabsValue();
	}
	
	/** 
     * 对PagerSlidingTabStrip的各项属性进行赋值。 
     */  
    private void setTabsValue() {  
        // 设置Tab是自动填充满屏幕的  
        tabs.setShouldExpand(true);  
        // 设置Tab的分割线颜色  
        tabs.setDividerColor(Color.WHITE);
        // 设置Tab颜色 
        tabs.setBackgroundColor(Color.parseColor("#03a9f4"));
     // 设置Tab底部线的高度 
        tabs.setUnderlineHeight((int) TypedValue.applyDimension(  
                TypedValue.COMPLEX_UNIT_DIP, 1, dm));  
        // 设置Tab Indicator的高度  
        tabs.setIndicatorHeight((int) TypedValue.applyDimension(  
                TypedValue.COMPLEX_UNIT_DIP, 4, dm));  
        // 设置Tab标题文字的大小  
        tabs.setTextSize((int) TypedValue.applyDimension(  
                TypedValue.COMPLEX_UNIT_SP, 16, dm));  
        // 设置Tab Indicator的颜色  
        tabs.setIndicatorColor(Color.WHITE);  
        // 设置选中Tab文字的颜色 (这是我自定义的一个方法)
        tabs.setTextColor(Color.WHITE);
        //tabs.setSelectedTextColor(Color.parseColor("#45c01a"));  
        // 取消点击Tab时的背景色  
        tabs.setTabBackground(0);  
    }
    
    public class MyPagerAdapter extends FragmentPagerAdapter {  
    	  
        public MyPagerAdapter(FragmentManager fm) {  
            super(fm);  
        }  
  
        private final String[] titles = { "最热排名", "朋友们", "我的计划" };  
  
        @Override  
        public CharSequence getPageTitle(int position) {  
            return titles[position];  
        }  
  
        @Override  
        public int getCount() {  
            return titles.length;  
        }  
        @Override  
        public Fragment getItem(int position) {  
            switch (position) {  
            case 0:  
                if (Rank == null) {  
                    Rank = new RankItemFragmentFragment();  
                }  
                return Rank;  
            case 1:  
                if (Friends == null) {  
                    Friends = new FriendsItemFragmentFragment();  
                }  
                return Friends;  
            case 2:  
                if (Mine == null) {  
                    Mine = new MineFragment();  
                }  
                return Mine;  
            default:  
                return null;  
            }  
        }
        
  
    }
	@Override
	public void onNavigationDrawerItemSelected(int position) {
		// update the main content by replacing fragments
		FragmentManager fragmentManager = getSupportFragmentManager();
		fragmentManager
				.beginTransaction()
				.replace(R.id.container,
						PlaceholderFragment.newInstance(position + 1)).commit();
	}

	public void onSectionAttached(int number) {
		switch (number) {
		case 1:
			mTitle = "主页";
			break;
		case 2:
			mTitle = "设置"; 
			//getString(R.string.title_section2);
			break;
		case 3:
			mTitle = "帮助";
			//getString(R.string.title_section3);
			break;
		}
	}

	public void restoreActionBar() {
		ActionBar actionBar = getSupportActionBar();
		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_STANDARD);
		actionBar.setDisplayShowTitleEnabled(true);
		if(mTitle=="主页")
			actionBar.setTitle("美丽计划");
		actionBar.setTitle(mTitle);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		if (!mNavigationDrawerFragment.isDrawerOpen()) {
			// Only show items in the action bar relevant to this screen
			// if the drawer is not showing. Otherwise, let the drawer
			// decide what to show in the action bar.
			getMenuInflater().inflate(R.menu.main, menu);
			restoreActionBar();
			return true;
		}
		return super.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	/**
	 * A placeholder fragment containing a simple view.
	 */
	public static class PlaceholderFragment extends Fragment {
		/**
		 * The fragment argument representing the section number for this
		 * fragment.
		 */
		private static final String ARG_SECTION_NUMBER = "section_number";

		/**
		 * Returns a new instance of this fragment for the given section number.
		 */
		public static PlaceholderFragment newInstance(int sectionNumber) {
			PlaceholderFragment fragment = new PlaceholderFragment();
			Bundle args = new Bundle();
			args.putInt(ARG_SECTION_NUMBER, sectionNumber);
			fragment.setArguments(args);
			return fragment;
		}

		public PlaceholderFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_main, container,
					false);
			return rootView;
		}

		@Override
		public void onAttach(Activity activity) {
			super.onAttach(activity);
			((MainActivity) activity).onSectionAttached(getArguments().getInt(
					ARG_SECTION_NUMBER));
		}
	}

}
