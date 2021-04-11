package com.example.work_app;

public class Vacansion {

    private String city;
    private String title;
    private String salary;
    private String briefDescription;
    private boolean favorite;

    public Vacansion(String city, String title, String salary, String briefDescription, boolean favorite) {
        this.city = city;
        this.title = title;
        this.salary = salary;
        this.briefDescription = briefDescription;
        this.favorite = favorite;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public void setBriefDescription(String briefDescription) {
        this.briefDescription = briefDescription;
    }

    public void setFavorite(boolean favorite) {
        this.favorite = favorite;
    }

    public boolean getFavorite() {return favorite;}

    public String getCity() {
        return city;
    }

    public String getTitle() {
        return title;
    }

    public String getSalary() {
        return salary;
    }

    public String getBriefDescription() {
        return briefDescription;
    }

    public boolean isFavorite() {
        return favorite;
    }


}
