package com.example.admin.lapnew06part2.jsonmodels;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Admin on 10/13/2016.
 */

public class FlickrItem {
    @SerializedName("title")
    private String title;
    @SerializedName("date_taken")
    private String dateTaken;
    @SerializedName("media")
    private Media media;
    private String link;

    public String getImageLink() {
        return media.getLink();
    }

    private class Media {
        @SerializedName("m")
        private String link;

        public String getLink() {
            return link;
        }
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDateTaken() {
        return dateTaken;
    }

    public void setDateTaken(String dateTaken) {
        this.dateTaken = dateTaken;
    }

    public Media getMedia() {
        return media;
    }

    public void setMedia(Media media) {
        this.media = media;
    }

    @Override
    public String toString() {
        return getImageLink();
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
