package com.example.work_app;

public class ResumeView {

    private String work;
    private String me;
    private String languages;

    public ResumeView(String work, String me, String languages) {
        this.work = work;
        this.me = me;
        this.languages = languages;
    }

    public String getWork() {
        return work;
    }

    public String getMe() {
        return me;
    }

    public String getLanguages() {
        return languages;
    }

    public void setWork(String work) {
        this.work = work;
    }

    public void setMe(String me) {
        this.me = me;
    }

    public void setLanguages(String languages) {
        this.languages = languages;
    }
}
