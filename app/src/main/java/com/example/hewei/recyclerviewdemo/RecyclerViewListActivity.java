package com.example.hewei.recyclerviewdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class RecyclerViewListActivity extends AppCompatActivity implements MyAdapter.MyItemClickListener,MyAdapter.MyItemLongClickListener{

    private List<String> list;

    @Bind(R.id.id_recyclerview_list)
    RecyclerView idRecyclerviewList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view_list);
        ButterKnife.bind(this);

        initView();
        initData();
        initAdapter();
    }

    private void initView() {
        /**使RecyclerView保持固定的大小,这样会提高RecyclerView的性能*/
        idRecyclerviewList.setHasFixedSize(true);
        /**listview*/
        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(this);
        idRecyclerviewList.setLayoutManager(layoutManager);
        /**设置动画*/
        idRecyclerviewList.setItemAnimator(new DefaultItemAnimator());
    }

    private void initData(){
        list= new ArrayList<>();
        for(int i=1;i<200;i++){
            list.add("张三"+i);
        }
    }

    private void initAdapter(){
        MyAdapter adapter=new MyAdapter(list,this);
        idRecyclerviewList.setAdapter(adapter);
        /**添加分割线*/
        /**listview*/
        idRecyclerviewList.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL_LIST));
        adapter.setOnItemClickListener(this);
        adapter.setOnItemLongClickListener(this);
    }

    @Override
    public void onItemClick(View view, int position) {
        String a=list.get(position);
        Toast.makeText(this, "你点击了　　"+a, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onItemLongClickListener(View view, int positon) {
        String a=list.get(positon);
        Toast.makeText(this, "长按了　　"+a, Toast.LENGTH_SHORT).show();
    }
}
