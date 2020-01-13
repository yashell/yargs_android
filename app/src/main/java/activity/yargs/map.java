package activity.yargs;

import android.graphics.Color;
import android.os.Bundle;


import android.util.Log;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;



import com.amap.api.maps.AMap;
import com.amap.api.maps.CameraUpdateFactory;
import com.amap.api.maps.MapView;
import com.amap.api.maps.model.BitmapDescriptorFactory;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.LatLngBounds;
import com.amap.api.maps.model.Marker;
import com.amap.api.maps.model.MarkerOptions;
import com.amap.api.maps.model.MyLocationStyle;
import com.amap.api.maps.model.Polyline;
import com.amap.api.maps.model.PolylineOptions;
import com.amap.api.maps.utils.SpatialRelationUtil;
import com.amap.api.maps.utils.overlay.SmoothMoveMarker;

import java.util.ArrayList;
import java.util.List;

import androidx.fragment.app.Fragment;
import store.AllAmap;


public class map extends Fragment {
    AMap aMap;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.map, container, false);
        MapView mMapView = (MapView) view.findViewById(R.id.map);   //获取地图控件引用
        mMapView.onCreate(savedInstanceState);// 此方法须覆写，虚拟机需要在很多情况下保存地图绘制的当前状态。
        aMap = mMapView.getMap(); //初始化地图控制器对象

//        AllAmap.myMap= mMapView.getMap(); //初始化地图控制器对象

        aMap.setTrafficEnabled(true);// 显示实时交通状况>


//        MyLocationStyle showMyLocation(boolean visible)//设置是否显示定位小蓝点，用于满足只想使用定位，不想使用定位小蓝点的场景，设置false以后图面上不再有定位蓝点的概念，但是会持续回调位置信息

        MyLocationStyle myLocationStyle;
        myLocationStyle = new MyLocationStyle();//初始化定位蓝点样式类

//        myLocationStyle.myLocationType(MyLocationStyle.LOCATION_TYPE_LOCATION_ROTATE_NO_CENTER);//连续定位、蓝点不会移动到地图中心点，定位点依照设备方向旋转，并且蓝点会跟随设备移动。
        myLocationStyle.myLocationType(MyLocationStyle.LOCATION_TYPE_LOCATE);//定位一次，且将视角移动到地图中心点。

        myLocationStyle.interval(2000); //设置连续定位模式下的定位间隔，只在连续定位模式下生效，单次定位模式下不会生效。单位为毫秒。
        aMap.setMyLocationStyle(myLocationStyle);//设置定位蓝点的Style


        aMap.getUiSettings().setMyLocationButtonEnabled(false);  //设置默认定位按钮是否显示，非必需设置。
        aMap.getUiSettings().setLogoBottomMargin(-100);


        aMap.setMyLocationEnabled(true);// 设置为true表示启动显示定位蓝点，false表示隐藏定位蓝点并不进行定位，默认是false。


        AllAmap.myMap=aMap;
        LatLng latLng = new LatLng(25.906901, 102);
        final Marker marker =  AllAmap.myMap.addMarker(new MarkerOptions().position(latLng).title("北京").snippet("DefaultMarker"));

//        DrawLine();

        Log.d("fds", "大家好 "+AllAmap.ss);

        return view;
    }



}
