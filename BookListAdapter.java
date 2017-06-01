package com.app.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import com.app.activity.R;
import com.app.model.FileMsg;
import com.app.model.FileMsg;
import com.app.utils.StringUtil;

import org.xutils.x;

import java.util.List;

/**
 * Created by Alpha 
 */

public class BookListAdapter extends BaseAdapter{
    private Context context;
    private List<FileMsg> pubList;
    private LayoutInflater mInflater;
    private String[] DOMAINARRAY;

    public BookListAdapter(Context context, List<FileMsg> pubList){
        this.context=context;
        this.pubList=pubList;

        mInflater=LayoutInflater.from(context);
//        DOMAINARRAY=context.getResources().getStringArray(R.array.domains);
    }

    @Override
    public int getCount() {
    	
        return pubList.size();
    }

    @Override
    public Object getItem(int position) {
    	System.out.println("getITEM");
        return pubList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
    	FileMsg fileModel=pubList.get(position);
        ViewHolder viewHolder=null;

        if(convertView==null){
            viewHolder=new ViewHolder();

            convertView=mInflater.inflate(R.layout.list_item_abstract,null);

            viewHolder.tvTitle= (TextView) convertView.findViewById(R.id.tv_pub_title);
            viewHolder.tvTime= (TextView) convertView.findViewById(R.id.tv_pub_item_date);
            viewHolder.tvType= (TextView) convertView.findViewById(R.id.tv_pub_item_type);

            convertView.setTag(viewHolder);
        }else {
            viewHolder=(ViewHolder)convertView.getTag();
        }

        viewHolder.tvTitle.setText(fileModel.getFileName());
        viewHolder.tvTime.setText(fileModel.getSize()+" kb");
//        viewHolder.tvType.setText(fileModel.getuName( ));

        
        return convertView;
    }

    class ViewHolder{
//        ImageView ivPic;
        TextView tvTitle;
        TextView tvTime;
        TextView tvType;

    }
}
