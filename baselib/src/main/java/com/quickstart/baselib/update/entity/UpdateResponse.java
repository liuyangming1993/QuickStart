package com.quickstart.baselib.update.entity;

public class UpdateResponse {


    /**
     * isNecessary : false
     * latestCode : 1
     * latestVersionName : v1.0.0
     * description : 描述
     * url : {"channelYingyongbao":"url","channelOppo":"url","channelVivo":"url","channel360":"url"}
     */

    private boolean isNecessary;
    private int latestCode;
    private String latestVersionName;
    private String description;
    private UrlBean url;

    public boolean isNecessary() {
        return isNecessary;
    }

    public void setIsNecessary(boolean isNecessary) {
        this.isNecessary = isNecessary;
    }

    public int getLatestCode() {
        return latestCode;
    }

    public void setLatestCode(int latestCode) {
        this.latestCode = latestCode;
    }

    public String getLatestVersionName() {
        return latestVersionName;
    }

    public void setLatestVersionName(String latestVersionName) {
        this.latestVersionName = latestVersionName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public UrlBean getUrl() {
        return url;
    }

    public void setUrl(UrlBean url) {
        this.url = url;
    }

    public static class UrlBean {
        /**
         * channelYingyongbao : url
         * channelOppo : url
         * channelVivo : url
         * channel360 : url
         */

        private String channelYingyongbao;
        private String channelOppo;
        private String channelVivo;
        private String channel360;

        public String getChannelYingyongbao() {
            return channelYingyongbao;
        }

        public void setChannelYingyongbao(String channelYingyongbao) {
            this.channelYingyongbao = channelYingyongbao;
        }

        public String getChannelOppo() {
            return channelOppo;
        }

        public void setChannelOppo(String channelOppo) {
            this.channelOppo = channelOppo;
        }

        public String getChannelVivo() {
            return channelVivo;
        }

        public void setChannelVivo(String channelVivo) {
            this.channelVivo = channelVivo;
        }

        public String getChannel360() {
            return channel360;
        }

        public void setChannel360(String channel360) {
            this.channel360 = channel360;
        }
    }
}
