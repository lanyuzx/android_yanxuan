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
    private List<HomeHotStyleListBean> hotStyleList;
    private  Map timePurchaseItems;
    private Map thresholdGoodList;
    private  List focus;
    private List kingKongAreaV5;

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



}

