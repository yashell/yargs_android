package activity.yargs;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

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

import androidx.fragment.app.Fragment;
import zxing.Constants;
import zxing.activity.CaptureActivity;

public class user extends Fragment {

    private  String[]
            data={"修改密码","我的相册","分析统计","位置分享","扫二维码","我的二维码","拨打电话"};


    private ListView listView;
    private int[] imgResIds={R.drawable.password,R.drawable.album_nav,R.drawable.chart,R.drawable.map,R.drawable.sweep_code,R.drawable.creat_sweep_code,R.drawable.callphone};

    private View parentAvtivity;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.user, container, false);

        parentAvtivity = inflater.inflate(R.layout.activity_main,container,false);


        listView=(ListView)view.findViewById(R.id.ssk);  //绑定ListView
        listView.setAdapter(new MyAdapter());


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //parent为每一项的父容器，也就是那个ListView
                // view是每一项，也就是item
                //position是每一项的索引
                //id 没说哪的id

                switch (position)
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

            }
        });
        return view;
    }


    class MyAdapter extends BaseAdapter {
        //数据源中项的个数
        @Override
        public int getCount() {
            return data.length;
        }
        //项
        @Override
        public Object getItem(int position) {
            return position;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }
        //项显示的View position 项的索引
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            //解析布局文件，成为View
            View view;
            ViewHolder holder=null;
            if(convertView==null){  //使用converView来提高效率
                LayoutInflater inflater=LayoutInflater.from(parentAvtivity.getContext());
                view=inflater.inflate(R.layout.compent_user_list,null);
                holder=new ViewHolder(view);
                view.setTag(holder); //在view上保存程序所需要的数据
            }
            else {
                view=convertView;
                holder=(ViewHolder) view.getTag();  //取出之前的数据
            }

            //填充当前项的数据
            //图片的写法
//            ImageView image=holder.getImage();  //这个图片ID是布局文件中显示图片的ImageView的ID
            ImageView image=holder.getImage();  //这个图片ID是布局文件中显示图片的ImageView的ID
            image.setImageResource(imgResIds[position%data.length]);
            //文本的写法
            TextView text=holder.getText(); //这个文本ID是布局文件中显示图片的TextView的ID
            text.setText(data[position%data.length]);

            return view;
        }
    }

    //为了优化，创建持有者类
    class ViewHolder{
        private View view;
        private ImageView image;
        private TextView title;
        public ViewHolder(View view)
        {
            this.view=view;
        }
        public ImageView getImage(){
            if (image==null)
            {
                image= (ImageView) view.findViewById(R.id.imageView);
            }
            return image;
        }
        public TextView getText(){
            if(title==null)
            {
                title=(TextView) view.findViewById(R.id.textk);
            }
            return title;
        }


    }








}
