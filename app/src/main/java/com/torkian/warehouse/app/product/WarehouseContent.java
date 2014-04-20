package com.torkian.warehouse.app.product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WarehouseContent {

    public static List<ProductItem> ITEMS = new ArrayList<ProductItem>();

    public static Map<String, ProductItem> ITEM_MAP = new HashMap<String, ProductItem>();

    static {

        addItem(new ProductItem("1", "View"));
        addItem(new ProductItem("2", "Add"));
        addItem(new ProductItem("3", "Exit"));
    }

    private static void addItem(ProductItem item) {
        ITEMS.add(item);
        ITEM_MAP.put(item.id, item);
    }

    public static class ProductItem {
        public String id;
        public String content;

        public ProductItem(String id, String content) {
            this.id = id;
            this.content = content;
        }

        @Override
        public String toString() {
            return content;
        }
    }
}
