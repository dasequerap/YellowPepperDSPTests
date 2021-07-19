package models;

import java.util.List;
import java.util.Map;

public class PetModel {

    private int id;
    private Map<Integer, String> category;
    private String name;
    private List<String> photoUrls;
    private List<Map<String, String>> tags;
    private String status;

    public PetModel() {}

    public int getId() { return id; }

    public Map<Integer, String> getCategory() { return category; }

    public String getName() { return name; }

    public List<String> getPhotoUrls() { return photoUrls; }

    public List<Map<String, String>> getTags() { return tags; }

    public String getStatus() { return status; }

    public void setId(int id){ this.id = id; }

    public void setCategory(int id, String categoryName){ category.put(id, categoryName); }

    public void setName(String name){ this. name = name; }

    public void addPhotoUrl(String url){ photoUrls.add(url); }

    public void addTags(Map<String, String> tag){ tags.add(tag); }

    public void setStatus(String status){ this.status = status; }

}