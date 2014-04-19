package com.torkian.warehouse.app.product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 * <p>
 * TODO: Replace all uses of this class before publishing your app.
 */
public class WarehouseContent {

    /**
     * An array of sample (dummy) items.
     */
    public static List<ProductItem> ITEMS = new ArrayList<ProductItem>();

    /**
     * A map of sample (dummy) items, by ID.
     */
    public static Map<String, ProductItem> ITEM_MAP = new HashMap<String, ProductItem>();

    static {
        // Add 3 sample items.
        addItem(new ProductItem("1", "View"));
        addItem(new ProductItem("2", "Add"));
        addItem(new ProductItem("3", "Exit"));
    }

    private static void addItem(ProductItem item) {
        ITEMS.add(item);
        ITEM_MAP.put(item.id, item);
    }

    /**
     * A dummy item representing a piece of content.
     */
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
