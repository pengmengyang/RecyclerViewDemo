package com.example.hewei.recyclerviewdemo;

/**
 * Created by ${Administrator} on ${2016-06-07}.
 */

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

/**
 * 带图片GridView适配器
 */
class RecyclerViewImageGridAdapter extends RecyclerView.Adapter<RecyclerViewImageGridAdapter.MyViewHolder>{


    private List<ItemBean> list;

    RecyclerViewImageGridAdapter(List<ItemBean> list){
        this.list=list;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.activity_recycler_view_image_grid_item,viewGroup,false);
        MyViewHolder myViewHolder=new MyViewHolder(view);
        /**初始化布局的高度和宽度*/
        LinearLayout.LayoutParams ll=new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT);
        view.setLayoutParams(ll);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder myViewHolder, int i) {

        ItemBean itemBean = list.get(i);
        myViewHolder.iv_show_image.setImageResource(itemBean.getDrawbleID());
        myViewHolder.tv_show_image_name.setText(itemBean.getDrawbleName());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        private ImageView iv_show_image;
        private TextView tv_show_image_name;


        MyViewHolder(View itemView) {
            super(itemView);
            iv_show_image= (ImageView) itemView.findViewById(R.id.iv_show_image);
            tv_show_image_name= (TextView) itemView.findViewById(R.id.tv_show_image_name);
        }
    }

}
