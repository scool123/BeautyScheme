package com.xidian209.beautyscheme;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.FrameLayout.LayoutParams;

/**
 * 鑱婂ぉFragment鐨勭晫闈�
 * 
 * http://blog.csdn.net/guolin_blog/article/details/26365683
 * 
 * @author guolin
 */
public class MineFragment extends Fragment {
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.fragment_mine_list, container,
				false);
		return rootView;
	}
}