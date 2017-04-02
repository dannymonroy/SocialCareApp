package com.example.fs.socialcareapp;

/**
 *
 * Created by Danny Monroy on 20/02/2017.
 */

public class VisitItem {

    private String title;
    private String fullName;
    private String area;
        private String startDate;

    public VisitItem(String title, String fullName, String area, String startDate) {
        this.title = title;
        this.fullName = fullName;
        this.area = area;
        this.startDate = startDate;
    }

    public String getTitle() {
        return title;
    }

    public String getFullName() {
        return fullName;
    }

    public String getArea() {
        return area;
    }

    public String getStartTime() {
        return startDate;
    }
}
