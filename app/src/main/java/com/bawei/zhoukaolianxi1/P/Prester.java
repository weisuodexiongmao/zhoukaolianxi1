package com.bawei.zhoukaolianxi1.P;

import com.bawei.zhoukaolianxi1.M.Mod;
import com.bawei.zhoukaolianxi1.V.V_VIew;
import com.bawei.zhoukaolianxi1.bean.Bean;

/**
 * Created by 猥琐的熊猫 on 2017/12/2.
 */

public class Prester  {
    private V_VIew v_vIew;
    private Mod mod;
    public Prester(V_VIew v_vIew) {
        this.v_vIew = v_vIew;
        this.mod=new Mod();
    }
    public void prest(){
        mod.Data(new Mod.getData() {
            @Override
            public void Datas(Bean bean) {
                v_vIew.getData(bean);
            }
        });
    }
}
