package com.lingyun.yanxuan.classes.home.bean;

import java.util.List;
import java.util.Map;

import lombok.Data;
import lombok.ToString;

@Data
public class HomeBean {

    private Map commonConfigModule;
    private List<HomeKingKongAreaV4Bean> kingKongAreaV4;
    private List<HomeOperationCfgBean> operationCfg;
    private HomeHotStyleListBean hotStyleList;
    private  HomeTimePurchaseItemsBean timePurchaseItems;
    private HomeThresholdGoodListBean thresholdGoodList;
    private  List<HomeFocusBean> focus;
    private List<HomeKingKongAreaV5Bean> kingKongAreaV5;

    @Data
    public class HomeKingKongAreaV4Bean {

     private String targetJump;
     private Map payload;
     private List<String> picUrls;
     private String title;
     private String desc;

    }

    @Data
    public  class  HomeOperationCfgBean {
        private  String targetJump;
        private Map payload;
        private List<String> picUrls;
        private String title;
    }

    @Data
    @ToString
    public class  HomeHotStyleListBean {
        private String bgColorTwo;
        private String titlePic;
        private String bgColorOne;
        private  List<HomeHotStyleItemListBean> hotStyleItemList;

        @Data
        @ToString
        public class   HomeHotStyleItemListBean {
            private List itemTagList;
            private long itemId;
            private String picUrl;
            private float activityPrice;
            private  String evaluatorAvatar;
            private String name;
            private  int rank;
            private String itemDesc;
            private  float retailPrice;
            private  String evaluatorComment;

        }
    }

    @Data
    public class  HomeThresholdGoodListBean {
        private String bgColorTwo;
        private String titlePic;
        private String bgColorOne;
        private List<HomeThresholdGoodItemListBean> thresholdGoodItemList;

        @Data
        public class  HomeThresholdGoodItemListBean {

            private List itemTagList;
            private long itemId;
            private String picUrl;
            private float activityPrice;
            private  HomeThresholdGoodPromBannerBean promBanner;
            private Map promLogo;
            private String name;
            private String itemDesc;
            private float retailPrice;

            @Data
            public class   HomeThresholdGoodPromBannerBean {
                private boolean valid;
                private int styleType;
                private int bannerType;
                private String bannerContentUrl;
                private String promoTitle;
                private String promoSubTitle;
                private int timeType;
                private String bannerTitleUrl;
                private String content;
            }
        }
    }

    @Data
    public  class HomeTimePurchaseItemsBean {

        private long currentTime;
        private long screenId;
        private long flashSaleId;
        private long leftTime;
        private  List<HomeTimePurchaseItemListBean> itemList;

        @Data
        public  class  HomeTimePurchaseItemListBean {

            private  String listPicUrl;
            private  float actualPrice;
            private  String primaryPicUrl;
            private  String simpleDesc;
            private  int type;
            private  int totalSellVolume;
            private  boolean valid;
            private  int itemId;
            private  String itemName;
            private  float differencePrice;
            private float  validEndTime;
            private float retailPrice;
            private  float currentSellVolume;

        }
    }

    @Data
    public class  HomeFocusBean {
        private String backgroundColor;
        private String img;
        private  int rank;
        private  int type;
        private  String content;
    }

    @Data
    public class  HomeKingKongAreaV5Bean {
        private String targetJump;
        private Map payload;
        private  List<String> picUrls;
        private  String title;
        private  String desc;
    }

}

