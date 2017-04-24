package com.app.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.xutils.DbManager;
import org.xutils.x;
import org.xutils.db.table.TableEntity;
import org.xutils.ex.DbException;

import com.app.model.ConfigModel;
import com.app.model.NoteModel;
import com.app.utils.ToastUtils;

public class DaoMs {
	
	public static DaoMs daoMs;
	
	public DaoMs(){}
	
	public static DaoMs getInstance(){
		if(daoMs==null){
			daoMs =  new DaoMs();
		}
		
		return daoMs;
	}
	
	protected DbManager db;
	public void initDb(){
	        //The initialization of local data 
	        DbManager.DaoConfig daoConfig = new DbManager.DaoConfig()
	                .setDbName("text_reader_db") 
	                //set the database name
	                .setDbVersion(1)
	                //Set up the database version, each time start the application will check the version number
	                //find the database version is lower than the value set here will be upgrading our database and trigger DbUpgradeListener 
	                .setAllowTransaction(true)
	                //Settings are open transaction, the default is false close the transaction 
	                .setTableCreateListener(new DbManager.TableCreateListener() {
	                   
						@Override
						public void onTableCreate(DbManager arg0,
								TableEntity<?> arg1) {
							// TODO Auto-generated method stub
							
						}
	                })//Set up the database creation time of the Listener 
	                .setDbUpgradeListener(new DbManager.DbUpgradeListener() {
	                    @Override
	                    public void onUpgrade(DbManager db, int oldVersion, int newVersion) {
	                        //...
	                    }
	                });
	        		//set up the database upgrade when the Listener, 
	        		//here can perform relevant changes to the related database table, 
	        		//such as the alter statement increase the fields, and so on 
	                //.setDbDir(null);
	        		//set up the database. The db file storage directory, default databases for package name directory 
	        db = x.getDb(daoConfig);
	}
	
	
	public void dbAdd() throws DbException {
        //User user = new User("Kevingo","caolbmail@gmail.com","13299999999",new Date());
        //db.save(user);
		//After successfully saved [wouldn't] the primary key of the user assignment binding 
        //db.saveOrUpdate(user);
		//save after successful [will be] the primary key of the user assignment binding 
        //db.saveBindingId(user);
		//save after successful [will be] the primary key of the user assignment binding, and returns the save is successful 
		if(db==null){
			initDb();
		}
        List<ConfigModel> cfigs = new ArrayList<ConfigModel>();
        cfigs.add(new ConfigModel(System.currentTimeMillis(),25, 1));
        db.save(cfigs);
//        showDbMessage("¡¾dbAdd¡¿The first object:" + users.get(0).toString());//user's primary key Id not 0
    }
	
	public void dbAdd(int textSize,int type) throws DbException {
		if(db==null){
			initDb();
		}
		
		System.out.println("add....");

        List<ConfigModel> cfigs = new ArrayList<ConfigModel>();
        cfigs.add(new ConfigModel(System.currentTimeMillis(),textSize, type));
        db.save(cfigs);
        
        System.out.println("¡¾dbAdd¡¿The first object:" + cfigs.get(0).toString());
//      showDbMessage("¡¾dbAdd¡¿The first object:" + cfigs.get(0).toString());//user's primary key Id not 0
//        return flag;
    }
	
	
	public ConfigModel dbFind() throws DbException {
		
		if(db==null){
			initDb();
		}
		
		List<ConfigModel> cfigs = db.selector(ConfigModel.class)
//                .where("name","like","%kevin%")
//                .and("email", "=", "caolbmail@gmail.com")
                .orderBy("id",true)
//                .limit(2) //query only two records
//                .offset(2) //migration, starting from the third record return, limit with offset to sqlite limit m, n query 
                .findAll();
		
		for (int i = 0; i < cfigs.size(); i++) {
			System.out.println("******"+cfigs.get(i).toString());
		}
        if(cfigs == null || cfigs.size() == 0){
           dbAdd();
           return dbFind();
        }else{
        	System.out.println(cfigs.get(0).toString());
        	return cfigs.get(0);
        }
	}
	
	public void dbNoteAdd(String title,String content) throws DbException {
		if(db==null){
			initDb();
		}
		
		System.out.println("add....");

        List<NoteModel> notes = new ArrayList<NoteModel>();
        notes.add(new NoteModel(title,content,new Date()));
        db.save(notes);
        
        System.out.println("¡¾dbNoteAdd¡¿The first object:" + notes.get(0).toString());
//      showDbMessage("¡¾dbAdd¡¿The first object:" + cfigs.get(0).toString());//user's primary key Id not to be 0
//        return flag;
    }
	
	
	
	
	

}
