package com.bawei.zhoukaolianxi1.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.bawei.zhoukaolianxi1.App.App1;
import com.bawei.zhoukaolianxi1.P.Prester;
import com.bawei.zhoukaolianxi1.R;
import com.bawei.zhoukaolianxi1.V.V_VIew;
import com.bawei.zhoukaolianxi1.adapter.Rlvadapter;
import com.bawei.zhoukaolianxi1.bean.Bean;
import com.bawei.zhoukaolianxi1.bean.Data;
import com.bawei.zhoukaolianxi1.greendao.gen.DaoSession;
import com.bawei.zhoukaolianxi1.greendao.gen.User;
import com.bawei.zhoukaolianxi1.greendao.gen.UserDao;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by 猥琐的熊猫 on 2017/12/2.
 */

public class Fragment1 extends Fragment implements V_VIew {
    @BindView(R.id.Rlv)
    RecyclerView Rlv;
    Unbinder unbinder;
    private UserDao userDao;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.fragment, null);
        unbinder = ButterKnife.bind(this, view);
        DaoSession daoSession = App1.getinstance().getdaoSession();
        userDao = daoSession.getUserDao();
        Prester prester=new Prester(this);
        prester.prest();
        List<User> users = userDao.loadAll();
        for (User list:users){
            System.out.println("<<<<<<<<<<<"+list.getName());
        }
        Rlv.setLayoutManager(new LinearLayoutManager(getActivity()));
        Rlvadapter rlvadapter=new Rlvadapter(getActivity(),users);

        Rlv.setAdapter(rlvadapter);
        rlvadapter.notifyDataSetChanged();
        EventBus.getDefault().register(this);
        return view;
    }

    @Override
    public void getData(Bean bean) {
        List<Bean.ResultsBean> results = bean.getResults();
        for (Bean.ResultsBean resultsBean:results){
            User user=new User(null,resultsBean.getDesc());
         userDao.insert(user);
        }



    }
    @Subscribe(threadMode = ThreadMode.MAIN,sticky = true)
public void getData1(Data data){
    Toast.makeText(getActivity(),data.getName(),Toast.LENGTH_SHORT).show();
}
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(true);
    }
}
