package com.example.hewei.recyclerviewdemo;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.hewei.recyclerviewdemo.R;

import java.util.List;

/**
 * Created by ${Administrator} on ${2016-06-07}.
 */

/**
 * 适配器
 */

public class MyAdapter extends RecyclerView.Adapter{

    private List<String> list;
    private Context context;

    public MyAdapter(List<String> list,Context context){

        this.list=list;
        this.context=context;

    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        /**绑定布局*/
        View view= LayoutInflater.from(context).inflate(R.layout.recyclerview_item,null);
        /**初始化布局的高度和宽度*/
        LinearLayout.LayoutParams ll=new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT);
        view.setLayoutParams(ll);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {

        MyViewHolder myViewHolder=(MyViewHolder)viewHolder;
        String str=list.get(i);
        myViewHolder.id_num.setText(str);

    }


    @Override
    public int getItemCount() {
        return list.size();
    }

    class  MyViewHolder extends RecyclerView.ViewHolder {

        public TextView id_num;

        public MyViewHolder(View itemView) {
            super(itemView);
            id_num= (TextView) itemView.findViewById(R.id.id_num);
        }
    }
}
