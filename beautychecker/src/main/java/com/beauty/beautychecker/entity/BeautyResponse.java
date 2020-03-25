package com.beauty.beautychecker.entity;

import java.io.Serializable;
import java.util.List;

public class BeautyResponse implements Serializable {
    private String name;
    private List<AlbumListBean> albumList;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<AlbumListBean> getAlbumList() {
        return albumList;
    }

    public void setAlbumList(List<AlbumListBean> albumList) {
        this.albumList = albumList;
    }

    public static class AlbumListBean implements Serializable {
        private String albumName;
        private String thumbnail;
        private List<String> imgList;

        public String getAlbumName() {
            return albumName;
        }

        public void setAlbumName(String albumName) {
            this.albumName = albumName;
        }

        public String getThumbnail() {
            return thumbnail;
        }

        public void setThumbnail(String thumbnail) {
            this.thumbnail = thumbnail;
        }

        public List<String> getImgList() {
            return imgList;
        }

        public void setImgList(List<String> imgList) {
            this.imgList = imgList;
        }
    }
}
