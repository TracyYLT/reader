package com.app.model;

import org.xutils.db.annotation.Column;
import org.xutils.db.annotation.Table;

@Table(name = "configmodel",
onCreated = "") 
public class ConfigModel {
   @Column(
           name = "ID",
           isId = true,
           autoGen = true
   )
   private long id;
   @Column(name = "TEXTSIZE",property = "NOT NULL")//NAME not null
   private int textSize;

   @Column(name = "TYPE",property = "NOT NULL")//NAME not null
   private int type;
   
   
   
   

public ConfigModel() {
}

public long getId() {
	return id;
}

public void setId(long id) {
	this.id = id;
}

public int getTextSize() {
	return textSize;
}

public void setTextSize(int textSize) {
	this.textSize = textSize;
}

public int getType() {
	return type;
}

public void setType(int type) {
	this.type = type;
}

public ConfigModel(long id, int textSize, int type) {
	super();
	this.id = id;
	this.textSize = textSize;
	this.type = type;
}

@Override
public String toString() {
	return "ConfigModel [id=" + id + ", textSize=" + textSize + ", type="
			+ type + "]";
}
   


}
   
   
