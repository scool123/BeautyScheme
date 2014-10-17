package com.xidian209.beautyscheme;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import com.xidian209.beautyscheme.MyListView.OnRefreshListener;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.FrameLayout.LayoutParams;


public class MineFragment extends Fragment {
	private ListView listView;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
	Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_mine_list, null);
		listView = (ListView) view.findViewById(R.id.listView);
		init();
		return view;
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
	// TODO Auto-generated method stub
	super.onActivityCreated(savedInstanceState);
	}

	private void init() {
	List<String> items = new ArrayList<String>();
	for (int i = 0; i < 2; i++) {
	if(i == 0){
	items.add("课程表");
	}else{
	items.add("考试");
	}
	}
	ArrayAdapter<String> adapter = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_list_item_1, items);
	listView.setAdapter(adapter);
	}
}