package com.example.leadroidtest.common;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.leadroidtest.R;

public class MenuTreeAdapter extends BaseAdapter {

	private Context mContext;
	private LayoutInflater mInflater;
	private TreeElement<MenuInfo> root;

	public MenuTreeAdapter(Context context, TreeElement<MenuInfo> root) {
		super();
		this.mContext = context;
		mInflater = LayoutInflater.from(context);
		// 根节点为一空节点
		this.root = root;
		this.root.setExpanded(true);
	}

	/**
	 * 不包括空的根节点
	 */
	@Override
	public int getCount() {
		return root == null ? 0 : root.getTreeExpandedSize() - 1;
	}

	@Override
	public Object getItem(int position) {
		return root.getExpandedElement(position + 1);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder holder;
		if (convertView == null) {
			convertView = mInflater.inflate(R.layout.list_item_category, null);
			holder = new ViewHolder();
			holder.text = (TextView) convertView.findViewById(R.id.text);
			holder.icon = (ImageView) convertView.findViewById(R.id.icon);
			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}

		final TreeElement<MenuInfo> element = root
				.getExpandedElement(position + 1);

		convertView.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				if (element.isHasChild()) {
					element.setExpanded(!element.isExpanded());
					MenuTreeAdapter.this.notifyDataSetChanged();
				} else if (element.getObject().getCls() != null) {
					mContext.startActivity(new Intent(mContext, element
							.getObject().getCls()));
				}
			}
		});

		int level = element.getLevel();
		holder.icon.setPadding(25 * (level - 1), holder.icon.getPaddingTop(),
				0, holder.icon.getPaddingBottom());
		holder.text.setText(element.getObject().getTitle());
		if (element.isExpanded()) {
			holder.icon.setImageResource(R.drawable.outline_list_expand);
		} else {
			holder.icon.setImageResource(R.drawable.outline_list_collapse);
		}
		if (element.isHasChild()) {
			holder.icon.setVisibility(View.VISIBLE);
		} else {
			holder.icon.setVisibility(View.INVISIBLE);
		}

		return convertView;
	}

	private class ViewHolder {
		TextView text;
		ImageView icon;
	}

}
