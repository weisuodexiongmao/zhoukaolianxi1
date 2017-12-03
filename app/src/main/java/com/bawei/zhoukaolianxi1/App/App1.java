package com.bawei.zhoukaolianxi1.App;

import android.app.Application;
import android.database.sqlite.SQLiteDatabase;

import com.bawei.zhoukaolianxi1.greendao.gen.DaoMaster;
import com.bawei.zhoukaolianxi1.greendao.gen.DaoSession;

public class App1 extends Application {
    private static App1 mInstance;
    private DaoSession daoSession;

    @Override
    public void onCreate() {
        super.onCreate();
       mInstance=this;
        setDB();
    }


    public static App1 getinstance(){
return mInstance;
    }

    private void setDB() {
        DaoMaster.DevOpenHelper devOpenHelper = new DaoMaster.DevOpenHelper(this, "bw.db", null);
        SQLiteDatabase writableDatabase = devOpenHelper.getWritableDatabase();
        DaoMaster daoMaster = new DaoMaster(writableDatabase);
        daoSession= daoMaster.newSession();
    }
public DaoSession getdaoSession(){
    return daoSession;
}
}