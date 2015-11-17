package com.example.testsearchview;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.SearchView.OnQueryTextListener;
import android.text.TextUtils;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.ListView;

public class MainActivity extends Activity {
	SearchView searchview;
	List<String> list = new ArrayList<String>();
	private SearchView.SearchAutoComplete edit;
	ListView listv;
	MyAdapter<String> adapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		initData();
		initView();
	}

	private void initView() {
		// TODO Auto-generated method stub
		
		searchview = (SearchView) findViewById(R.id.searchview);
		
		listv = (ListView) findViewById(R.id.listv);
		
		adapter = new MyAdapter<String>(this, list);

		listv.setAdapter(adapter);		

		listv.setTextFilterEnabled(true);

		searchview.setQueryHint("请输入你要查询的关键字");
		searchview.setIconified(false);
		searchview.setIconifiedByDefault(false);

		searchview.setOnQueryTextListener(new OnQueryTextListener() {

			@Override
			public boolean onQueryTextSubmit(String arg0) {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public boolean onQueryTextChange(String queryText) {
				if (TextUtils.isEmpty(queryText)) {
					adapter.getFilter().filter(null);
				} else {
					adapter.getFilter().filter(queryText);
				}
				return true;
			}
		});

	}

	private void initData() {
		// TODO Auto-generated method stub
		list.add("张三");
		list.add("李思");
		list.add("王麻子");
		list.add("张三");
		list.add("aaaa");
		list.add("cccc");
		list.add("dd");
		list.add("qwe三");
		list.add("2444");
		list.add("vvvv");
		list.add("55522");
		list.add("667732f");
	}
}
