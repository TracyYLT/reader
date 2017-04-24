package com.app.app;

import org.xutils.BuildConfig;
import org.xutils.x;
import org.xutils.ex.DbException;

import com.app.dao.DaoMs;


import android.app.Application;
import android.content.Context;

public class MyApplicaction extends Application {
	
	private static MyApplicaction app;
	@Override
	public void onCreate() {
		super.onCreate();
		x.Ext.init(this);
		//initialize the database 
		DaoMs.getInstance().initDb();
		try {
			DaoMs.getInstance().dbAdd();
			System.out.println("add=---app");
		} catch (DbException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public static Context getAppContext(){
		if(app==null){
			app =  new MyApplicaction();
		}
		return app;
	}
}
