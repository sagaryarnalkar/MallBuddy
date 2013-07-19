package com.sagar.mallbuddy.adapters;

import java.util.ArrayList;

import com.sagar.mallbuddy.R;
import com.sagar.mallbuddy.beans.Category;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class AdapterCategoryList  extends BaseAdapter {

	ArrayList<Category> mList;
	Context mContext;
	private LayoutInflater mInflator;
	
	public AdapterCategoryList(ArrayList<Category> list,Context ctx)
	{
		mList = list;
		mContext = ctx;
		mInflator = (LayoutInflater) mContext
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	}
	
	@Override
	public int getCount() {
		return mList.size();
	}

	@Override
	public Object getItem(int index) {
		return mList.get(index);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		
		View v = convertView;
		
		if(null == v)
		{
			v = mInflator.inflate(R.layout.item_category_list_item, null);
		}
		
		TextView tvName = (TextView) v.findViewById(R.id.tvCatName);
		ImageView ivIcon = (ImageView) v.findViewById(R.id.ivCatIcon);
		
		Category cat = mList.get(position);
		
		tvName.setText(cat.getName());
		
		if(cat.getImg() != 0)
			ivIcon.setImageResource(cat.getImg());
		
		return v;
	}

}
