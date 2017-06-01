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
import com.app.model.NoteModel;
import com.app.utils.StringUtil;

import org.xutils.x;

import java.util.List;

/**
 * Created by Alpha 
 */

public class NoteListAdapter extends BaseAdapter{
    private Context context;
    private List<NoteModel> pubList;
    private LayoutInflater mInflater;
    private String[] DOMAINARRAY;

    public NoteListAdapter(Context context, List<NoteModel> pubList){
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
    	NoteModel noteModel=pubList.get(position);
        ViewHolder viewHolder=null;

        if(convertView==null){
            viewHolder=new ViewHolder();

            convertView=mInflater.inflate(R.layout.list_item_note,null);

            viewHolder.tvTitle= (TextView) convertView.findViewById(R.id.tv_pub_title);
            viewHolder.tvTime= (TextView) convertView.findViewById(R.id.tv_pub_item_date);
            viewHolder.tvType= (TextView) convertView.findViewById(R.id.tv_pub_item_type);

            convertView.setTag(viewHolder);
        }else {
            viewHolder=(ViewHolder)convertView.getTag();
        }
        
        viewHolder.tvTitle.setText(noteModel.getTitle());
        viewHolder.tvTime.setText(noteModel.getDate().toLocaleString()+"");
//        viewHolder.tvType.setText(noteModel.getuName( ));

        
        return convertView;
    }

    class ViewHolder{
//        ImageView ivPic;
        TextView tvTitle;
        TextView tvTime;
        TextView tvType;

    }
}
