package app.akeorcist.deviceinformation.model;

/**
 * Created by Ake on 2/28/2015.
 */
public class CameraData {
    private String name;
    private String packageName;
    private int minSdk;
    private int detail;

    public CameraData(String name, String packageName, int minSdk, int detail) {
        this.name = name;
        this.packageName = packageName;
        this.minSdk = minSdk;
        this.detail = detail;
    }

    public String getName() {
        return name;
    }

    public String getPackage() {
        return packageName;
    }

    public int getMinSdk() {
        return minSdk;
    }

    public int getDetail() {
        return detail;
    }
}
