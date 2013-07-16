package com.sagar.mallbuddy.localdata;

import java.util.ArrayList;

import com.sagar.mallbuddy.beans.Entity;

import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils.InsertHelper;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class EntityDB extends BaseDBObject{

    public EntityDB(Context context) {
    	super(context);
        }

    public ArrayList<Entity> getEntityArray(String where){
    	Cursor result = mdatabase.query(DatabaseOpenHelper.ENTITY_TBL_NAME, null, where, null,
    			null, null, "time,Name");
    	
    	ArrayList<Entity> arr=new ArrayList<Entity> ();
    	
    	Entity lbn = new Entity();
    	
    	for (boolean hasItem = result.moveToFirst(); hasItem; hasItem = result
    			.moveToNext()) {
    		
    		lbn = new Entity();
    		
//    		lbn.setName(result.getString(result.getColumnIndex("Name")));
//    		
//    		int img=result.getColumnIndex("Img");
//    		
//    		if(img>0)
//    			lbn.setPhoto(ctx.getResources().getIdentifier(result.getString(result.getColumnIndex("Img")), "drawable", ctx.getPackageName()));
//    		
//    		lbn.setTimestamp(result.getLong(result.getColumnIndex("time")));
    		
    		arr.add(lbn);
    		}
    	
    	return arr;
    }
    
    public void insertCategory(Entity cat)
    {
		
	InsertHelper ih = new InsertHelper(mdatabase, DatabaseOpenHelper.ENTITY_TBL_NAME);
	
	final int nameColumn = ih.getColumnIndex("Name");
	
        final int categoryColumn = ih.getColumnIndex("category");
        
        final int ImgColumn = ih.getColumnIndex("Img");
    	
        final int shortDescColumn = ih.getColumnIndex("shortDesc");
        
        final int isDefColumn = ih.getColumnIndex("isDef");
        
        final int timeColumn = ih.getColumnIndex("time");
        
        try {

        	    ih.prepareForInsert();
        	    
//        	    ih.bind(nameColumn, cat.getName());
        	    
                    ih.bind(categoryColumn, "2");
                    
                    ih.bind(ImgColumn,"");
                    
                    ih.bind(shortDescColumn,"");
                    ih.bind(isDefColumn,"N");
//                    ih.bind(timeColumn,cat.getTimestamp());
        	    
                    ih.execute();
        		
        	
        }
        finally
        {
            ih.close();
        }
    }
}
