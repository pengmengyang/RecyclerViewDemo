package com.example.hewei.recyclerviewdemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

    }

    @OnClick({R.id.btn_recyclerview_list, R.id.btn_recyclerview_grid,R.id.btn_recyclerview_stagere_grid,R.id.btn_recyclerview_image_grid})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_recyclerview_list:
                openOterActivity(RecyclerViewListActivity.class);
                break;
            case R.id.btn_recyclerview_grid:
                openOterActivity(RecyclerViewGridActivity.class);
                break;
            case R.id.btn_recyclerview_stagere_grid:
                openOterActivity(RecyclerViewStagereGridActivity.class);
                break;
            case R.id.btn_recyclerview_image_grid:
                openOterActivity(RecyclerViewImageGridActivity.class);
                break;
        }
    }

    /**跳转Activity界面的方法*/
    private void openOterActivity(Class<?> cls){
        Intent intent=new Intent(this,cls);
        startActivity(intent);
    }
}
