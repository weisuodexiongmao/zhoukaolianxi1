package com.bawei.zhoukaolianxi1;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.provider.Settings;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.bawei.zhoukaolianxi1.bean.Data;
import com.bawei.zhoukaolianxi1.fragment.Fragment1;
import com.bawei.zhoukaolianxi1.fragment.Fragment2;
import com.bawei.zhoukaolianxi1.fragment.Fragment3;
import com.bawei.zhoukaolianxi1.fragment.Fragment4;
import com.bawei.zhoukaolianxi1.fragment.Fragment5;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.but1)
    Button but1;
    @BindView(R.id.but2)
    Button but2;
    @BindView(R.id.but3)
    Button but3;
    @BindView(R.id.but4)
    Button but4;
    @BindView(R.id.but5)
    Button but5;
    private List<Fragment> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        if (isOnline()){
            EventBus.getDefault().postSticky(new Data("有网络"));

        }else {
            EventBus.getDefault().postSticky(new Data("无网络"));
        }
        update(new Fragment1());
    }

    @OnClick({R.id.but1, R.id.but2, R.id.but3, R.id.but4, R.id.but5})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.but1:
                update(new Fragment1());
                break;
            case R.id.but2:
                update(new Fragment2());
                break;
            case R.id.but3:
                update(new Fragment3());
                break;
            case R.id.but4:
                update(new Fragment4());
                break;
            case R.id.but5:
                update(new Fragment5());
                break;
        }
    }
    public void update(Fragment f){
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
       fragmentTransaction.replace(R.id.fra,f).commit();
    }

        public boolean isOnline(){
                ConnectivityManager connectivityManager= (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
                NetworkInfo info = connectivityManager.getActiveNetworkInfo();
                return (info!=null&&info.isConnected());
            }
}

