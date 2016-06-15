package com.example.hewei.recyclerviewdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * 图片GridView
 */
public class RecyclerViewImageGridActivity extends AppCompatActivity {

    @Bind(R.id.id_recycler_view_image_grid)
    RecyclerView idRecyclerViewImageGrid;
    private List<ItemBean> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view_image_grid);
        ButterKnife.bind(this);

        initView();
        initData();
        initAdapter();
    }

    private void initView(){

        /**使RecyclerView保持固定的大小,这样会提高RecyclerView的性能*/
        idRecyclerViewImageGrid.setHasFixedSize(true);
        /**GridView*/
//        RecyclerView.LayoutManager layoutManager=new GridLayoutManager(this,1);
//        idRecyclerViewImageGrid.setLayoutManager(layoutManager);
        idRecyclerViewImageGrid.setLayoutManager(new StaggeredGridLayoutManager(1,StaggeredGridLayoutManager.VERTICAL));

    }

    private void initData(){
        list= new ArrayList<>();
        ItemBean itemBean=new ItemBean(R.mipmap.car_benley,"宾利");
        ItemBean itemBean1=new ItemBean(R.mipmap.car_benz,"奔驰");
        ItemBean itemBean2=new ItemBean(R.mipmap.car_bmw,"宝马");
        ItemBean itemBean3=new ItemBean(R.mipmap.car_buick,"别克");
        ItemBean itemBean4=new ItemBean(R.mipmap.car_bujiadi,"布加迪");
        ItemBean itemBean5=new ItemBean(R.mipmap.car_cadillc,"凯迪拉克");
        ItemBean itemBean6=new ItemBean(R.mipmap.car_dazhong,"大众");
        ItemBean itemBean7=new ItemBean(R.mipmap.car_falali,"法拉利");
        ItemBean itemBean8=new ItemBean(R.mipmap.car_lanborghini,"兰博基尼");
        ItemBean itemBean9=new ItemBean(R.mipmap.car_porsche,"保时捷");
        list.add(itemBean);
        list.add(itemBean1);
        list.add(itemBean2);
        list.add(itemBean3);
        list.add(itemBean4);
        list.add(itemBean5);
        list.add(itemBean6);
        list.add(itemBean7);
        list.add(itemBean8);
        list.add(itemBean9);

    }

    private void initAdapter() {
        RecyclerViewImageGridAdapter recyclerViewImageGridAdapter=new RecyclerViewImageGridAdapter(list);
        idRecyclerViewImageGrid.setAdapter(recyclerViewImageGridAdapter);
        /**添加分割线*/
        /**GridView*/
        idRecyclerViewImageGrid.addItemDecoration(new DividerGridItemDecoration(this));
        /**添加默认动画*/
        idRecyclerViewImageGrid.setItemAnimator(new DefaultItemAnimator());
    }
}
