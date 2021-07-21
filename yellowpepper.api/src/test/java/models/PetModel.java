package models;

import java.util.*;

public class PetModel {

    private int id;
    private final Map<String, Object> category;
    private String name;
    private final List<String> photoUrls;
    private final List<Map<String, Object>> tags;
    private String status;

    public PetModel() {
        category = new HashMap<>();
        photoUrls = new ArrayList<>();
        tags = new ArrayList<>();
    }

    public int getId() { return id; }

    public Map<String, Object> getCategory() { return this.category; }

    public String getName() { return this.name; }

    public List<String> getPhotoUrls() { return this.photoUrls; }

    public List<Map<String, Object>> getTags() { return this.tags; }

    public String getStatus() { return this.status; }

    public void setId(int id){ this.id = id; }

    public void setCategoryParameter(String key, Object value){ this.category.put(key, value); }

    public void setName(String name){ this.name = name; }

    public void addPhotoUrl(String url){ this.photoUrls.add(url); }

    public void addTag(Map<String, Object> tag){ this.tags.add(tag); }

    public void setStatus(String status){ this.status = status; }

}