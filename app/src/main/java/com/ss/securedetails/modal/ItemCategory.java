package com.ss.securedetails.modal;

import com.google.firebase.database.Exclude;

import java.util.HashMap;
import java.util.Map;

public class ItemCategory {

    private String id;
    private String catg_name;
    private String catg_description;
    private String status;
    private String toPin_first;

    public ItemCategory(String id, String catg_name, String catg_description, String status, String toPin_first) {
        this.id = id;
        this.catg_name = catg_name;
        this.catg_description = catg_description;
        this.status = status;
        this.toPin_first = toPin_first;
    }

    @Exclude
    public Map<String, Object> toMap() {
        HashMap<String, Object> result = new HashMap<>();
        result.put("id", id);
        result.put("catg_name", catg_name);
        result.put("catg_description", catg_description);
        result.put("status", status);
        result.put("toPin_first", toPin_first);

        return result;
    }

    public String getId() {
        return id;
    }

    public String getCatg_name() {
        return catg_name;
    }

    public String getCatg_description() {
        return catg_description;
    }

    public String getStatus() {
        return status;
    }

    public String getToPin_first() {
        return toPin_first;
    }
}
