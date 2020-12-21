package com.boggle.wall.utils;

import com.boggle.wall.entity.TitleEntity;

import java.util.ArrayList;
import java.util.List;

public class RequestUtils {

    private static volatile RequestUtils requestUtils = null;

    private int titlePosition = 0;
    private int bottomPosition = 0;

    public static RequestUtils getInstance() {
        if (requestUtils == null) {
            synchronized (RequestUtils.class) {
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

    private final String[] mCategoryCn = {"背景", "ファッション", "自然", "科学", "教育", "感情", "健康です", "人",
            "宗教", "場所", "動物", "工業", "コンピュータ", "食料品", "スポーツ", "世界", "旅行する", "建物", "商業", "音楽"};

    private final String[] mCategoryDes = {"我们也会成为别人的背景", "ファッションは輪廻です。", "自然は時に不自然である。", "科学も宗教です。", "多情ホルモン",
            "子供は教えないで、父の過ち。", "あなただけの資本", "あくせくして茫々としている", "信仰の力", "-> location", "万物は霊験あらたかである", "暗い世界", "あなたが見えない0と1",
            "命を維持する意味のないもの", "感情を発散するもの", "バーチャルかもしれません", "他の人が嫌いな都市に行きます。", "魂のない泥", "魅力的な散財主義", "あなたを喜ばせるかもしれないもの。"};

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

    public String getBottomCategory() {
        return mCategory[bottomPosition];
    }

    public List<TitleEntity> getHeadTitles() {
        titlePosition = (int) (Math.random() * mCategory.length);
        List<TitleEntity> temp = new ArrayList<>();
        temp.add(new TitleEntity(mCategoryCn[titlePosition], mCategoryDes[titlePosition]));
        return temp;
    }

    public List<TitleEntity> getBottomTitle() {
        bottomPosition = (int) (Math.random() * mCategory.length);
        List<TitleEntity> temp = new ArrayList<>();
        temp.add(new TitleEntity(mCategoryCn[bottomPosition], mCategoryDes[bottomPosition]));
        return temp;
    }

    public int getRandom() {
        return (int) (Math.random() * 3 + 1);
    }

    public int getBannerRandom() {
        return (int) (Math.random() * 3 + 1);
    }

    public String getTitleKey() {
        return mCategory[titlePosition];
    }
}
