package com.torkian.warehouse.app.product;

/**
 * Created by behradtorkian on 4/20/14.
 */

import java.util.ArrayList;
import java.util.List;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.torkian.warehouse.app.product.Product;
import com.torkian.warehouse.app.product.ProductSQLiteHelper;

public class ProductDAO {

    private SQLiteDatabase database;
    private ProductSQLiteHelper dbHelper;

    public ProductDAO(Context context) {
        dbHelper = new ProductSQLiteHelper(context);
        database = dbHelper.getWritableDatabase();
    }

    // Close the db
    public void close() {
        database.close();
    }

    /**
     * Create new PRODUCT object
     * @param productText
     */
    public void createProduct(String productText) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("product", productText);
        // Insert into DB
        database.insert("product", null, contentValues);
    }

    /**
     * Delete PRODUCT object
     * @param productId
     */
    public void deleteProduct(int productId) {
        // Delete from DB where id match
        database.delete("Product", "_id = " + productId, null);
    }

    /**
     * Get all TODOs.
     * @return
     */
    public List getProduct() {
        List ProductList = new ArrayList();

        // Name of the columns we want to select
        String[] tableColumns = new String[] {"_id","Product"};

        // Query the database
        Cursor cursor = database.query("products", tableColumns, null, null, null, null, null);
        cursor.moveToFirst();

        // Iterate the results
        while (!cursor.isAfterLast()) {
            Product product = new Product();
            // Take values from the DB
            product.setName(cursor.getString(0));
            product.setId(cursor.getString(1));
            product.setDis(cursor.getString(2));

            // Add to the DB
            ProductList.add(product);

            // Move to the next result
            cursor.moveToNext();
        }

        return ProductList;
    }

}
