package com.sagar.mallbuddy.localdata;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class BaseDBObject {
	protected SQLiteDatabase mdatabase;
    protected DatabaseOpenHelper mdbOpenHelper;
    protected Context ctx;

    public BaseDBObject(Context context) {
    	ctx = context;
    	mdbOpenHelper = DatabaseOpenHelper.getInstance(context);
        }
    
    public void open() throws SQLException {
	// open database in reading/writing mode
	if (null == mdatabase || !mdatabase.isOpen())
	    mdatabase = mdbOpenHelper.getWritableDatabase();
    }

    public void close() {
	if (mdatabase != null)
	    mdatabase.close();
    }
}
