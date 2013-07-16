package com.sagar.mallbuddy.localdata;

import java.util.ArrayList;

import com.sagar.mallbuddy.beans.Category;
import com.sagar.mallbuddy.beans.Entity;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class CategoryDB extends BaseDBObject{

    public CategoryDB(Context context) {
    	super(context);
        }
   
    public ArrayList<Category> getCategoryArray(String where){
    	Cursor result = mdatabase.query(DatabaseOpenHelper.CATEGORIES_TBL_NAME, null, where, null,
    			null, null, "cat_id");
    	
    	ArrayList<Category> arr=new ArrayList<Category> ();
    	
    	Category lbn = new Category();
    	
    	for (boolean hasItem = result.moveToFirst(); hasItem; hasItem = result
    			.moveToNext()) {
    		
    		lbn = new Category();
    		
    		lbn.setName(result.getString(result.getColumnIndex("Name")));
    		
    		lbn.setShortDesc(result.getString(result.getColumnIndex("shortDesc")));
    		
    		int img=result.getColumnIndex("Img");
    		
    		if(img>0)
    			lbn.setImg(ctx.getResources().getIdentifier(result.getString(result.getColumnIndex("Img")), "drawable", ctx.getPackageName()));
    		
    		lbn.setCatId(result.getInt(result.getColumnIndex("cat_id")));
    		
    		arr.add(lbn);
    		}
    	
    	return arr;
    }
}
