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

class MyAdapter extends RecyclerView.Adapter{

    private List<String> list;
    private Context context;

    MyAdapter(List<String> list, Context context){

        this.list=list;
        this.context=context;

    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        /**绑定布局*/
        View view= LayoutInflater.from(context).inflate(R.layout.recyclerview_item,viewGroup,false);
        /**初始化布局的高度和宽度*/
        LinearLayout.LayoutParams ll=new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT);
        view.setLayoutParams(ll);
        return new MyViewHolder(view,myItemClickListener,myItemLongClickListener);
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
    /**为Item设置监听事件*/
    private class  MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener,View.OnLongClickListener{

        TextView id_num;


        MyViewHolder(View itemView, MyItemClickListener myItemClickListener, MyItemLongClickListener myItemLongClickListener) {
            super(itemView);
            id_num= (TextView) itemView.findViewById(R.id.id_num);
            MyAdapter.myItemClickListener=myItemClickListener;
            MyAdapter.myItemLongClickListener=myItemLongClickListener;
            itemView.setOnClickListener(this);
            itemView.setOnLongClickListener(this);
        }

        @Override
        public void onClick(View v) {

            if(myItemClickListener!=null){
                myItemClickListener.onItemClick(v,getPosition());
            }

        }

        @Override
        public boolean onLongClick(View v) {
            if(myItemLongClickListener!=null){
                myItemLongClickListener.onItemLongClickListener(v,getPosition());
            }
            return true;
        }
    }

    /**
     * 设置Item点击监听
     * @param listener
     */
    void setOnItemClickListener(MyItemClickListener listener){
        MyAdapter.myItemClickListener = listener;
    }

    void setOnItemLongClickListener(MyItemLongClickListener listener){
        MyAdapter.myItemLongClickListener = listener;
    }

    /**接口回调*/
    /**Item点击*/
    interface MyItemClickListener{
        void onItemClick(View view, int position);
    }
    /**Item长按*/
    interface MyItemLongClickListener{
        void onItemLongClickListener(View view, int positon);
    }
    /**声明接口属性*/
    private static MyItemClickListener myItemClickListener;
    private static MyItemLongClickListener myItemLongClickListener;

}
