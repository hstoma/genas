package com.genas.components.list;

/**
 * Created by henadzistoma on 11/4/16.
 */

public class SimpleItem {
    private String title;
    private String url;

    public SimpleItem(String title, String url) {
        this.title = title;
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public String getTitle() {
        return title;
    }
}
