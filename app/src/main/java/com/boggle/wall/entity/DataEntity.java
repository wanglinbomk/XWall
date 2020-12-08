package com.boggle.wall.entity;

import java.util.List;

public class DataEntity {

    /**
     * total : 4
     * totalHits : 4
     * hits : [{"id":5657153,"pageURL":"https://pixabay.com/photos/tower-building-monument-tree-5657153/","type":"photo","tags":"tower, building, monument","previewURL":"https://cdn.pixabay.com/photo/2020/10/15/15/56/tower-5657153_150.jpg","previewWidth":100,"previewHeight":150,"webformatURL":"https://pixabay.com/get/53e6d0444b57af14f1dc846096293e7d113adaed554c704f75287fd59248c75d_640.jpg","webformatWidth":427,"webformatHeight":640,"largeImageURL":"https://pixabay.com/get/53e6d0444b57af14f6da8c7dda793677163bdbe15b576c48732f7cd09648c05abd_1280.jpg","imageWidth":2624,"imageHeight":3936,"imageSize":1832791,"views":173,"downloads":160,"favorites":1,"likes":1,"comments":0,"user_id":18721614,"user":"iwanwasyl9","userImageURL":"https://cdn.pixabay.com/user/2020/10/15/15-45-50-302_250x250.jpg"},{"id":4832506,"pageURL":"https://pixabay.com/illustrations/city-skyline-sunset-cityscape-4832506/","type":"illustration","tags":"city, skyline, sunset","previewURL":"https://cdn.pixabay.com/photo/2020/02/09/09/43/city-4832506_150.png","previewWidth":93,"previewHeight":150,"webformatURL":"https://pixabay.com/get/52e8d6414f52aa14f1dc846096293e7d113adaed554c704f75287fd59248c75d_640.png","webformatWidth":397,"webformatHeight":640,"largeImageURL":"https://pixabay.com/get/52e8d6414f52aa14f6da8c7dda793677163bdbe15b576c48732f7cd09648c05abd_1280.png","imageWidth":4054,"imageHeight":6530,"imageSize":523448,"views":430,"downloads":253,"favorites":15,"likes":7,"comments":2,"user_id":15107399,"user":"Chakkree_Chantakad","userImageURL":"https://cdn.pixabay.com/user/2020/02/01/15-08-51-697_250x250.jpg"},{"id":4140109,"pageURL":"https://pixabay.com/photos/moon-two-color-neon-astronaut-4140109/","type":"photo","tags":"moon, two color, neon","previewURL":"https://cdn.pixabay.com/photo/2019/04/19/18/46/moon-4140109_150.jpg","previewWidth":82,"previewHeight":150,"webformatURL":"https://pixabay.com/get/52e1d1434b52a514f1dc846096293e7d113adaed554c704f75287fd59248c75d_640.jpg","webformatWidth":351,"webformatHeight":640,"largeImageURL":"https://pixabay.com/get/52e1d1434b52a514f6da8c7dda793677163bdbe15b576c48732f7cd09648c05abd_1280.jpg","imageWidth":3000,"imageHeight":5465,"imageSize":1827764,"views":4916,"downloads":3286,"favorites":38,"likes":32,"comments":0,"user_id":12044322,"user":"pizar_kestrap","userImageURL":""},{"id":3083398,"pageURL":"https://pixabay.com/photos/woman-grown-up-portrait-people-3083398/","type":"photo","tags":"woman, grown up, portrait","previewURL":"https://cdn.pixabay.com/photo/2018/01/15/07/52/woman-3083398_150.jpg","previewWidth":100,"previewHeight":150,"webformatURL":"https://pixabay.com/get/55e0dd40495ba414f1dc846096293e7d113adaed554c704f75287fd59248c75d_640.jpg","webformatWidth":426,"webformatHeight":640,"largeImageURL":"https://pixabay.com/get/55e0dd40495ba414f6da8c7dda793677163bdbe15b576c48732f7cd09648c05abd_1280.jpg","imageWidth":3286,"imageHeight":4930,"imageSize":2445766,"views":4612,"downloads":2542,"favorites":84,"likes":67,"comments":4,"user_id":3773230,"user":"nastya_gepp","userImageURL":"https://cdn.pixabay.com/user/2018/09/30/11-48-14-744_250x250.jpg"}]
     */

    private int total;
    private int totalHits;
    private List<HitsBean> hits;

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getTotalHits() {
        return totalHits;
    }

    public void setTotalHits(int totalHits) {
        this.totalHits = totalHits;
    }

    public List<HitsBean> getHits() {
        return hits;
    }

    public void setHits(List<HitsBean> hits) {
        this.hits = hits;
    }

    public static class HitsBean {
        /**
         * id : 5657153
         * pageURL : https://pixabay.com/photos/tower-building-monument-tree-5657153/
         * type : photo
         * tags : tower, building, monument
         * previewURL : https://cdn.pixabay.com/photo/2020/10/15/15/56/tower-5657153_150.jpg
         * previewWidth : 100
         * previewHeight : 150
         * webformatURL : https://pixabay.com/get/53e6d0444b57af14f1dc846096293e7d113adaed554c704f75287fd59248c75d_640.jpg
         * webformatWidth : 427
         * webformatHeight : 640
         * largeImageURL : https://pixabay.com/get/53e6d0444b57af14f6da8c7dda793677163bdbe15b576c48732f7cd09648c05abd_1280.jpg
         * imageWidth : 2624
         * imageHeight : 3936
         * imageSize : 1832791
         * views : 173
         * downloads : 160
         * favorites : 1
         * likes : 1
         * comments : 0
         * user_id : 18721614
         * user : iwanwasyl9
         * userImageURL : https://cdn.pixabay.com/user/2020/10/15/15-45-50-302_250x250.jpg
         */

        private int id;
        private String pageURL;
        private String type;
        private String tags;
        private String previewURL;
        private int previewWidth;
        private int previewHeight;
        private String webformatURL;
        private int webformatWidth;
        private int webformatHeight;
        private String largeImageURL;
        private int imageWidth;
        private int imageHeight;
        private int imageSize;
        private int views;
        private int downloads;
        private int favorites;
        private int likes;
        private int comments;
        private int user_id;
        private String user;
        private String userImageURL;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getPageURL() {
            return pageURL;
        }

        public void setPageURL(String pageURL) {
            this.pageURL = pageURL;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getTags() {
            return tags;
        }

        public void setTags(String tags) {
            this.tags = tags;
        }

        public String getPreviewURL() {
            return previewURL;
        }

        public void setPreviewURL(String previewURL) {
            this.previewURL = previewURL;
        }

        public int getPreviewWidth() {
            return previewWidth;
        }

        public void setPreviewWidth(int previewWidth) {
            this.previewWidth = previewWidth;
        }

        public int getPreviewHeight() {
            return previewHeight;
        }

        public void setPreviewHeight(int previewHeight) {
            this.previewHeight = previewHeight;
        }

        public String getWebformatURL() {
            return webformatURL;
        }

        public void setWebformatURL(String webformatURL) {
            this.webformatURL = webformatURL;
        }

        public int getWebformatWidth() {
            return webformatWidth;
        }

        public void setWebformatWidth(int webformatWidth) {
            this.webformatWidth = webformatWidth;
        }

        public int getWebformatHeight() {
            return webformatHeight;
        }

        public void setWebformatHeight(int webformatHeight) {
            this.webformatHeight = webformatHeight;
        }

        public String getLargeImageURL() {
            return largeImageURL;
        }

        public void setLargeImageURL(String largeImageURL) {
            this.largeImageURL = largeImageURL;
        }

        public int getImageWidth() {
            return imageWidth;
        }

        public void setImageWidth(int imageWidth) {
            this.imageWidth = imageWidth;
        }

        public int getImageHeight() {
            return imageHeight;
        }

        public void setImageHeight(int imageHeight) {
            this.imageHeight = imageHeight;
        }

        public int getImageSize() {
            return imageSize;
        }

        public void setImageSize(int imageSize) {
            this.imageSize = imageSize;
        }

        public int getViews() {
            return views;
        }

        public void setViews(int views) {
            this.views = views;
        }

        public int getDownloads() {
            return downloads;
        }

        public void setDownloads(int downloads) {
            this.downloads = downloads;
        }

        public int getFavorites() {
            return favorites;
        }

        public void setFavorites(int favorites) {
            this.favorites = favorites;
        }

        public int getLikes() {
            return likes;
        }

        public void setLikes(int likes) {
            this.likes = likes;
        }

        public int getComments() {
            return comments;
        }

        public void setComments(int comments) {
            this.comments = comments;
        }

        public int getUser_id() {
            return user_id;
        }

        public void setUser_id(int user_id) {
            this.user_id = user_id;
        }

        public String getUser() {
            return user;
        }

        public void setUser(String user) {
            this.user = user;
        }

        public String getUserImageURL() {
            return userImageURL;
        }

        public void setUserImageURL(String userImageURL) {
            this.userImageURL = userImageURL;
        }
    }
}
