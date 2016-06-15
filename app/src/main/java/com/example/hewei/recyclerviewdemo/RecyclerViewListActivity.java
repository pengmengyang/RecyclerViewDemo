package com.example.hewei.recyclerviewdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class RecyclerViewListActivity extends AppCompatActivity {

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
    }
}