package com.example.tmbluemoon;

public class TMGridInfoItem {
    private static TMGridInfoItem instance;

    private int infoId;
    private String infoTitle;
    private String infoMessage;

    //Initialize
    private TMGridInfoItem () {
        this.infoId = 0;
        this.infoTitle = "";
        this.infoMessage = "";
    }

    private static class TMInnerGridInfoItem {
        private static final TMGridInfoItem instance = new TMGridInfoItem();
    }

    public static TMGridInfoItem getInstance() {
//        if (instance == null) {
//            instance = new TMGridInfoItem();
//        }

        return TMInnerGridInfoItem.instance;
    }

    public TMGridInfoItem (int infoId, String infoTitle, String infoMessage) {
        this.infoId = infoId;
        this.infoTitle = infoTitle;
        this.infoMessage = infoMessage;
    }

    //Getter
    public String getInfoTitle() {
        if (this.infoTitle != null) {
            return this.infoTitle;
        }

        return "";
    }

    public String getInfoMessage() {
        if (this.infoMessage != null) {
            return this.infoMessage;
        }

        return "";
    }

    //Setter
    public void setInfoTitle(String infoTitle) {
        if (infoTitle != null) {
            this.infoTitle = infoTitle;
        }
    }

    public void setInfoMessage(String infoMessage) {
        if (infoMessage != null) {
            this.infoMessage = infoMessage;
        }
    }
}
