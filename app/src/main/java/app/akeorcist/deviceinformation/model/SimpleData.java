package app.akeorcist.deviceinformation.model;

/**
 * Created by Akexorcist on 2/26/15 AD.
 */
public class SimpleData {
    public static final int DATA_ANDROID = 0;
    public static final int DATA_BUILD = 1;
    public static final int DATA_COMMUNICATION = 2;
    public static final int DATA_CPU = 3;
    public static final int DATA_GPU = 4;
    public static final int DATA_MEMORY = 5;
    public static final int DATA_STORAGE = 6;

    public static final String TITLE_ANDROID = "Android Infomation";
    public static final String TITLE_BUILD = "Build Infomation";
    public static final String TITLE_COMMUNICATION = "Communication Infomation";
    public static final String TITLE_CPU = "CPU Infomation";
    public static final String TITLE_GPU = "GPU Infomation";
    public static final String TITLE_MEMORY = "Memory Infomation";
    public static final String TITLE_STORAGE = "Storage Infomation";

    private String title;
    private String detail;

    public SimpleData(String title, String detail) {
        this.title = title;
        this.detail = detail;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }
}
