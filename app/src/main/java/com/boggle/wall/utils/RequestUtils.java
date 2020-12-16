package com.boggle.wall.utils;

import java.util.ArrayList;
import java.util.List;

public class RequestUtils {

    private static volatile RequestUtils requestUtils = null;

    public static RequestUtils getInstance(){
        if (requestUtils == null){
            synchronized (RequestUtils.class){
                requestUtils = new RequestUtils();
            }
        }
        return requestUtils;
    }

    /**
     * category
     * 按类别过滤结果。
     * 接受的值：背景，时尚，自然，科学，教育，感情，健康，人，宗教，地方，动物，工业，计算机，食品，体育，运输，旅行，建筑物，商业，音乐
     */
    private final String[] mCategory = {"backgrounds", "fashion", "nature", "science", "education", "feelings", "health",
            "people", "religion", "places", "animals", "industry", "computer", "food", "sports", "transportation",
            "travel", "buildings", "business", "music"};

    private final String[] mCategoryCn ={"背景","时尚","自然","科学","教育","感情","健康","人",
            "宗教","地方","动物","工业","计算机","食品","体育","世界","旅行","建筑物","商业","音乐"};

    /**
     * 类型对应的HasMap
     */

    /**
     * colors
     */
    private String[] mColors = {"grayscale", "transparent", "red", "orange",
            "yellow", "green", "turquoise", "blue", "lilac",
            "pink", "white", "gray", "black", "brown"};

    public String getRandomCategory() {
        int position = (int) (Math.random() * mCategory.length);
        return mCategory[position];
    }

    public List<String> getHeadTitles(){
        int position = (int) (Math.random() * mCategory.length);
        List<String> temp = new ArrayList<>();
        temp.add(mCategoryCn[position]);
        return temp;
    }

    public int getRandom(){
        return (int) (Math.random() * 10+1);
    }
}
