package com.bawei.zhoukaolianxi1.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bawei.zhoukaolianxi1.R;
import com.bawei.zhoukaolianxi1.bean.Bean;
import com.bawei.zhoukaolianxi1.greendao.gen.User;

import java.util.List;

/**
 * Created by 猥琐的熊猫 on 2017/12/2.
 */

public class Rlvadapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private List<User>list;

    public Rlvadapter(Context context, List<User> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item, parent, false);
        return new VHItem(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
         VHItem vhItem= (VHItem) holder;
        vhItem.textView.setText(list.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    class VHItem extends RecyclerView.ViewHolder{
     TextView textView;
        public VHItem(View itemView) {
            super(itemView);
            textView= (TextView) itemView.findViewById(R.id.textView);
        }
    }
}
