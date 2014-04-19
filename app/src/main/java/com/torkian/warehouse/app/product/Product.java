package com.torkian.warehouse.app.product;

/**
 * Created by behradtorkian on 4/19/14.
 */
public class Product {
    private String id;
    private String name;
    private String dis;
    public Product(){
        id = null;
        name = null;
        dis = null;
    }
     public Product(String id,String name,String dis){

        this.id = id;
        this.name = name;
        this.dis = dis;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDis() {
        return dis;
    }

    public void setDis(String dis) {
        this.dis = dis;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", dis='" + dis + '\'' +
                '}';
    }
}
