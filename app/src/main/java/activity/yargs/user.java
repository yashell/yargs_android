package activity.yargs;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import zxing.Constants;
import zxing.activity.CaptureActivity;

public class user extends Fragment {

    private  String[]
            data={"修改密码","我的相册","分析统计","位置分享","扫二维码","我的二维码","拨打电话"};
    private RecyclerView recyclerview;
    private ArrayList<String> datas;
    private ArrayList<Integer> images;


    private ListView listView;
    private int[] imgResIds={R.drawable.password,R.drawable.album_nav,R.drawable.chart,R.drawable.map,R.drawable.sweep_code,R.drawable.creat_sweep_code,R.drawable.callphone};

    private View parentAvtivity;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.user, container, false);
        parentAvtivity = inflater.inflate(R.layout.activity_main,container,false);

//        Toolbar toolbar = (Toolbar) view.findViewById(R.id.toolbar);
//        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);
//
//        setHasOptionsMenu(true);

        initData();
        recyclerview =(RecyclerView) view.findViewById(R.id.recyclerview);
        MyRecyclerViewAdapter adapter = new MyRecyclerViewAdapter(getActivity(),datas,images);
        recyclerview.setAdapter(adapter);
        recyclerview.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false));

        //添加分割线
        DividerItemDecoration divider = new DividerItemDecoration(getActivity(),DividerItemDecoration.VERTICAL);
        divider.setDrawable(ContextCompat.getDrawable(getActivity(),R.drawable.divider));
        recyclerview.addItemDecoration(divider);
        adapter.setOnItemClickListener(new MyRecyclerViewAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, String data, int index) {
                switch (index)
                {
                    case 4:
                        //扫二维码
                        Intent intent = new Intent(getActivity().getBaseContext(), CaptureActivity.class);
                        startActivityForResult(intent, Constants.REQ_QR_CODE);
                        break;
                    case 6:
                        //获取输入的电话号码
                        break;
                }
                Toast.makeText(getActivity(),"data"+data,Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }


    private void initData() {
        datas = new ArrayList<>();
        datas.add("修改密码");
        datas.add("我的相册");
        datas.add("分析统计");
        datas.add("位置分享");
        datas.add("扫二维码");
        datas.add("我的二维码");
        datas.add("拨打电话");
        datas.add("测试");
        datas.add("测试");
        datas.add("测试");
        datas.add("测试");
        datas.add("测试");
        datas.add("测试");
        datas.add("测试");
        datas.add("测试");

        images = new ArrayList<>();
        images.add(R.drawable.password);
        images.add(R.drawable.album_nav);
        images.add(R.drawable.chart);
        images.add(R.drawable.map);
        images.add(R.drawable.sweep_code);
        images.add(R.drawable.creat_sweep_code);
        images.add(R.drawable.callphone);
        images.add(R.drawable.callphone);
        images.add(R.drawable.callphone);
        images.add(R.drawable.callphone);
        images.add(R.drawable.callphone);
        images.add(R.drawable.callphone);
        images.add(R.drawable.callphone);
        images.add(R.drawable.callphone);
        images.add(R.drawable.callphone);
    }






}
