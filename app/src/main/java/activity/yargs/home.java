package activity.yargs;

import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

public class home extends Fragment {

    private ViewPager mvp;
    private List<ImageView> mlist;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.home, container, false);


        View parentAvtivity = inflater.inflate(R.layout.activity_main,container,false);

        mvp=(ViewPager) view.findViewById(R.id.vp);

        mlist=new ArrayList<ImageView>();

        int[] imageRes=new int[] { R.drawable.swiper1,R.drawable.swiper2,R.drawable.swiper3,R.drawable.swiper4};
        for (int i=0;i<imageRes.length;i++)
        {
            ImageView iv=new ImageView(parentAvtivity.getContext());
            iv.setBackgroundResource(imageRes[i]);
            mlist.add(iv);
        }
        mvp.setAdapter(new MyAdapter());

        return view;

    }

    class MyAdapter extends PagerAdapter {
        //用来决定ViewPager中到底可以显示多少个子视图
        @Override
        public int getCount() {
            return mlist!=null?mlist.size():0 ;
        }
        //判断是否需要重新生成新的子视图
        @Override
        public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
            return view==o;
        }
        //产生一个新视图
        @NonNull
        @Override
        public Object instantiateItem(@NonNull ViewGroup container, int position) {

            container.addView(mlist.get(position));
            return mlist.get(position);
        }
        //从viewpager中移除某个条目
        @Override
        public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {

            container.removeView(mlist.get(position));
        }
    }

}
