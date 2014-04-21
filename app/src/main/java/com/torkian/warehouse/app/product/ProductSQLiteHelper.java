package com.torkian.warehouse.app.product;
/**
 * Created by behradtorkian on 4/20/14.
 */
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class ProductSQLiteHelper extends SQLiteOpenHelper {

    public ProductSQLiteHelper(Context context) {

        super(context, "product_database", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Execute create table SQL
        db.execSQL("CREATE TABLE (_id INTEGER PRIMARY KEY AUTOINCREMENT, todo TEXT NOT NULL);");
    }

    /**
     * Recreates table
     */
    @Override
    public void onUpgrade(SQLiteDatabase database, int oldVer, int newVer) {
        // DROP table
        database.execSQL("DROP TABLE IF EXISTS");
        // Recreate table
        onCreate(database);
    }

}