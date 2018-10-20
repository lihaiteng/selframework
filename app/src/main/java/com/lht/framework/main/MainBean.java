package com.lht.framework.main;

/**
 * @date 2018/10/16 0016
 */
public class MainBean {
    private String showText;
    private String targetActivity;

    public MainBean(String showText, String targetActivity) {
        this.showText = showText;
        this.targetActivity = targetActivity;
    }

    public String getShowText() {
        return showText;
    }

    public void setShowText(String showText) {
        this.showText = showText;
    }

    public String getTargetActivity() {
        return targetActivity;
    }

    public void setTargetActivity(String targetActivity) {
        this.targetActivity = targetActivity;
    }
}
