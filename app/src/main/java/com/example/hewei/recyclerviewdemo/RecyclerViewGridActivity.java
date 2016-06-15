package com.example.hewei.recyclerviewdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class RecyclerViewGridActivity extends AppCompatActivity {

    private List<String> list;

    @Bind(R.id.id_recyclerview_grid)
    RecyclerView idRecyclerviewGrid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view_grid);
        ButterKnife.bind(this);

        initView();
        initData();
        initAdapter();
    }

    private void initView() {
        /**使RecyclerView保持固定的大小,这样会提高RecyclerView的性能*/
        idRecyclerviewGrid.setHasFixedSize(true);
        /**GridView*/
        RecyclerView.LayoutManager layoutManager=new GridLayoutManager(this,4);
        idRecyclerviewGrid.setLayoutManager(layoutManager);
    }

    private void initData(){
        list= new ArrayList<>();
        for(int i=1;i<200;i++){
            list.add("张三"+i);
        }
    }

    private void initAdapter(){
        MyAdapter adapter=new MyAdapter(list,this);
        idRecyclerviewGrid.setAdapter(adapter);
        /**添加分割线*/
        /**GridView*/
        idRecyclerviewGrid.addItemDecoration(new DividerGridItemDecoration(this));
    }
}
