package com.example.hewei.recyclerviewdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    private List<String> list;

    @Bind(R.id.id_recyclerview)
    RecyclerView idRecyclerview;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        initView();
        initData();
        initAdapter();
    }

    private void initView() {
        /**使RecyclerView保持固定的大小,这样会提高RecyclerView的性能*/
        idRecyclerview.setHasFixedSize(true);
        /**listview*/
//        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(this);
//        idRecyclerview.setLayoutManager(layoutManager);
        /**GridView*/
        RecyclerView.LayoutManager layoutManager=new GridLayoutManager(this,4);
        idRecyclerview.setLayoutManager(layoutManager);
    }

    private void initData(){
        list= new ArrayList<>();
        for(int i=1;i<200;i++){
            list.add("张三"+i);
        }
    }

    private void initAdapter(){
        MyAdapter adapter=new MyAdapter(list,this);
        idRecyclerview.setAdapter(adapter);
        /**添加分割线*/
        /**listview*/
//        idRecyclerview.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL_LIST));
        /**GridView*/
        idRecyclerview.addItemDecoration(new DividerGridItemDecoration(this));
    }

}
