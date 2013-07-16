package com.sagar.mallbuddy.localdata;

import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseOpenHelper extends SQLiteOpenHelper {

	private static DatabaseOpenHelper mInstance = null;

	private static final String DB_NAME = "MallDB";
	public static final String ENTITY_TBL_NAME = "entities_tbl";
	public static final String CATEGORIES_TBL_NAME = "cat_tbl";

	private DatabaseOpenHelper(Context ctx) throws NameNotFoundException {
		super(ctx, DB_NAME, null, ctx.getPackageManager().getPackageInfo(
				ctx.getPackageName(), 0).versionCode);
	}

	private DatabaseOpenHelper(Context context, String name,
			CursorFactory factory, int version) {
		super(context, name, factory, version);

	}

	public static DatabaseOpenHelper getInstance(Context ctx) {

		if (mInstance == null) {
			try {
				mInstance = new DatabaseOpenHelper(ctx.getApplicationContext());

			} catch (NameNotFoundException e) {
				mInstance = new DatabaseOpenHelper(ctx.getApplicationContext(),
						DB_NAME, null, 1);
			}
		}
		return mInstance;
	}

	@Override
	public void onCreate(SQLiteDatabase db) {

		db.execSQL(categoriesDBCreate);
		db.execSQL(entitiesDBCreate);
		
		for(String insert:categoryInserts)
		{
			db.execSQL(insert); //Creating Categories
		}
		for(String insert:entityInserts)
		{
			db.execSQL(insert);  //Creating Entities
		}
		
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int arg1, int arg2) {
		db.execSQL("DROP TABLE IF EXISTS "+ENTITY_TBL_NAME);
		// Create tables again
		onCreate(db);
	}
	
	private static final String entitiesDBCreate = "CREATE TABLE IF NOT EXISTS "
    	    + ENTITY_TBL_NAME+" ("
    	    + "_id integer primary key autoincrement,"
    	    + "Name TEXT, category TEXT, "
    	    + "Img TEXT,shortDesc TEXT);";
    
    private static final String insertEntitiesTemplate=ENTITY_TBL_NAME+"(Name,category,Img,shortDesc)";
	
    private static final String[] entityInserts = {
	    "INSERT INTO "+insertEntitiesTemplate+" VALUES('Washing Machine'  , '1' ,   'washingmachine'  , 'Washine Machine');",
	    "INSERT INTO "+insertEntitiesTemplate+" VALUES('Camera'  , '1' ,   'camera'  , 'Washine Machine');",
	    "INSERT INTO "+insertEntitiesTemplate+" VALUES('Mobile'  , '1' ,   'mobiles'  , 'Washine Machine');",
	    "INSERT INTO "+insertEntitiesTemplate+" VALUES('Fridge'  , '1' ,   'fridge'  , 'Washine Machine');",
	    "INSERT INTO "+insertEntitiesTemplate+" VALUES('TV (TeleVision)'  , '1' ,   'television'  , 'Washine Machine');",
	    "INSERT INTO "+insertEntitiesTemplate+" VALUES('Microwave'  , '1' ,   'microwave'  , 'Washine Machine');",
	    "INSERT INTO "+insertEntitiesTemplate+" VALUES('Set Top Box'  , '1' ,   'dishtv'  , 'Washine Machine');",
	    "INSERT INTO "+insertEntitiesTemplate+" VALUES('Laptop/Computer'  , '1' ,   'laptopcomputer'  , 'Washine Machine');",
	    "INSERT INTO "+insertEntitiesTemplate+" VALUES('Air Conditioner'  , '1' ,   'ac'  , 'Washine Machine');",
	    "INSERT INTO "+insertEntitiesTemplate+" VALUES('Sewing Machine'  , '1' ,   'sewingmachine'  , 'Washine Machine');",
	    "INSERT INTO "+insertEntitiesTemplate+" VALUES('Sunglasses'  , '1' ,   'sunglasses'  , 'Washine Machine');",
	    "INSERT INTO "+insertEntitiesTemplate+" VALUES('Shoes'  , '1' ,   'shoes'  , 'Washine Machine');"
    };
	
    private static final String categoriesDBCreate = "CREATE TABLE IF NOT EXISTS "
    	    + CATEGORIES_TBL_NAME+" ("
    	    + "_id integer primary key autoincrement,"
    	    + "Name TEXT, cat_id integer, "
    	    + "Img TEXT,shortDesc TEXT);";
    
    private static final String insertCategoriesTemplate=CATEGORIES_TBL_NAME+"(Name,cat_id,Img,shortDesc)";
	
    private static final String[] categoryInserts = {
	    "INSERT INTO "+insertCategoriesTemplate+" VALUES('Food Court'  , 1 ,   'icon_restaurant'  , 'Food Court');",
	    "INSERT INTO "+insertCategoriesTemplate+" VALUES('Clothes'  , 2 ,   'apparelico'  , 'Apparels');",
	    "INSERT INTO "+insertCategoriesTemplate+" VALUES('Search'  , 3 ,   'search'  , 'Search');",
	    "INSERT INTO "+insertCategoriesTemplate+" VALUES('Movies'  , 4 ,   'movies'  , 'Movies');",
	    "INSERT INTO "+insertCategoriesTemplate+" VALUES('Utilities'  , 5 ,   'utilities'  , 'Food Court');"
    };
}
