package activity.yargs;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import androidx.fragment.app.Fragment;

public class info extends Fragment {
    private ListView listView;
    private String[] titles;
    private String[] times;

    private View parentAvtivity;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.info, container, false);
        parentAvtivity = inflater.inflate(R.layout.activity_main,container,false);
        listView=(ListView) view.findViewById(R.id.listview_info);  //绑定ListView




//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//
//                Intent intent=new Intent();
//                intent.setClass(parentAvtivity.getContext(),info_show.class);
//                startActivity(intent);
//
//            }
//        });


        try {
            String data  =getConent(getResources(),R.raw.json);
            JSONArray dataList=new JSONArray(data);

            titles = new String[dataList.length()];
            times = new String[dataList.length()];

            for(int index=0;index<dataList.length();index++)
            {
                JSONObject obj=dataList.getJSONObject(index);
                String title=obj.getString("title");

                JSONObject timeT=obj.getJSONObject("systm");
                String time = timeT.getString("$date");
                if (time!=""){
                    time=time.substring(0,10);
                }








                titles[index]=title;
                times[index]=time;


            }


            listView.setAdapter(new MyAdapter());


        } catch (Exception e) {
            e.printStackTrace();
        }
        return view;
    }



    class MyAdapter extends BaseAdapter {
        //数据源中项的个数
        @Override
        public int getCount() {
            return titles.length;
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
                view=inflater.inflate(R.layout.compent_info_list,parent,false);
                holder=new ViewHolder(view);
                view.setTag(holder); //在view上保存程序所需要的数据
            }
            else {
                view=convertView;
                holder=(ViewHolder) view.getTag();  //取出之前的数据
            }

            Log.i("text", titles.length+"");
            //填充当前项的数据
            //图片的写法
//            ImageView image=holder.getImage();  //这个图片ID是布局文件中显示图片的ImageView的ID
//            image.setImageResource(imgResIds[position%names.length]);
            //文本的写法



            TextView text=holder.getTitle(); //这个文本ID是布局文件中显示图片的TextView的ID
            Log.i("text", "我要看进不进");
            Log.i("text",  titles[position]);

            text.setText(titles[position%titles.length]);




            TextView text2=holder.getTime(); //这个文本ID是布局文件中显示图片的TextView的ID

            text2.setText(times[position%titles.length]);


            return view;
        }
    }

    //为了优化，创建持有者类
    class ViewHolder{
        private View view;
        private TextView title;
        private TextView time;
        public ViewHolder(View view)
        {
            this.view=view;
        }

        public TextView getTitle(){
            if(title==null)
            {
                title=(TextView) view.findViewById(R.id.title_info);
            }
            return title;
        }
        public TextView getTime(){
            if(time==null)
            {
                time=(TextView) view.findViewById(R.id.time_info);
            }
            return time;
        }

    }






    /*
     * 得到json文件中的内容
     * @parm res
     * @id
     * @return
     *  @throws
     */
    private String getConent(Resources res, int id) throws IOException {
        InputStream is = null;
        StringBuffer sb = new StringBuffer();
        try {
            is = res.openRawResource(id);
            byte[] buffer = new byte[1024];
            int len = is.read(buffer, 0, 1024);
            while (len != -1) {
                String s = new String(buffer, 0, len);
                sb.append(s);
                len = is.read(buffer, 0, 1024);
            }
        } finally {
            if (is != null) {
                is.close();
            }
        }
        return sb.toString();
    }
}
