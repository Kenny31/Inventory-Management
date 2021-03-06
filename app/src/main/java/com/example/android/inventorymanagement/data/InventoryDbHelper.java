package com.example.android.inventorymanagement.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.example.android.inventorymanagement.data.*;


public class InventoryDbHelper extends SQLiteOpenHelper {
    public static final int DATABSE_VERSION = 6;
    public static final String DATABSE_NAME = "inventory.db";

    public InventoryDbHelper(Context context) {
        super(context, DATABSE_NAME, null, DATABSE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String InventoryCreateTable = "CREATE TABLE " + InventoryContract.InventoryEntry.TABLE_NAME + " (" +

                InventoryContract.InventoryEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                InventoryContract.InventoryEntry.COLLUMN_PROD_NAME + " TEXT NOT NULL , " +
                InventoryContract.InventoryEntry.COLLUMN_PROD_PRICE + " INTEGER NOT NULL  , " +
                InventoryContract.InventoryEntry.COLLUMN_PROD_QTY + " INTEGER DEFAULT 0 , " +
                InventoryContract.InventoryEntry.COLLUMN_PROD_SUPPLIER + " TEXT , " +
                InventoryContract.InventoryEntry.COLLUMN_PROD_PICTURE + " BLOB );";
        db.execSQL(InventoryCreateTable);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + InventoryContract.InventoryEntry.TABLE_NAME);
        onCreate(db);
    }
}
