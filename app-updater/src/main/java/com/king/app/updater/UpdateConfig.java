package com.king.app.updater;


import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.DrawableRes;

import com.king.app.updater.constant.Constants;

/**
 * @author Jenly <a href="mailto:jenly1314@gmail.com">Jenly</a>
 */
public class UpdateConfig implements Parcelable {


    private String mUrl;
    /**
     * Save Path
     */
    private String mPath;
    /**
     * Save file name
     */
    private String mFilename;

    /**
     * Whether to display the notification bar
     */
    private boolean isShowNotification = true;
    /**
     * Whether to automatically pop up the installation after downloading is complete
     */
    private boolean isInstallApk = true;
    /**
     *Notification bar icon: default app icon
     */
    private int mNotificationIcon;

    /**
     * Notification bar ID
     */
    private int mNotificationId = Constants.DEFAULT_NOTIFICATION_ID;

    /**
     * Notification channel ID
     */
    private String mChannelId;
    /**
     * Notification channel name
     */
    private String mChannelName;
    /**
     * default{@link Context#getPackageName() + ".fileProvider"}
     */
    private String mAuthority;
    /**
     * If the download fails, can you click the notification bar to download again?
     */
    private boolean isReDownload = true;
    /**
     * Whether to display percentage
     */
    private boolean isShowPercentage = true;


    public UpdateConfig() {

    }

    public String getUrl() {
        return mUrl;
    }

    public void setUrl(String url) {
        this.mUrl = url;
    }

    public String getPath() {
        return mPath;
    }

    public void setPath(String path) {
        this.mPath = path;
    }

    public String getFilename() {
        return mFilename;
    }

    public void setFilename(String filename) {
        this.mFilename = filename;
    }

    public boolean isShowNotification() {
        return isShowNotification;
    }

    public void setShowNotification(boolean isShowNotification) {
        this.isShowNotification = isShowNotification;
    }

    public String getChannelId() {
        return mChannelId;
    }

    public void setChannelId(String channelId) {
        this.mChannelId = channelId;
    }

    public String getChannelName() {
        return mChannelName;
    }

    public void setChannelName(String channelName) {
        this.mChannelName = channelName;
    }

    public void setNotificationId(int notificationId) {
        this.mNotificationId = notificationId;
    }

    public int getNotificationId() {
        return this.mNotificationId;
    }

    public void setNotificationIcon(@DrawableRes int icon) {
        this.mNotificationIcon = icon;
    }

    public int getNotificationIcon() {
        return this.mNotificationIcon;
    }

    public boolean isInstallApk() {
        return isInstallApk;
    }

    public void setInstallApk(boolean isInstallApk) {
        this.isInstallApk = isInstallApk;
    }

    public String getAuthority() {
        return mAuthority;
    }

    public void setAuthority(String authority) {
        this.mAuthority = authority;
    }

    public boolean isShowPercentage() {
        return isShowPercentage;
    }

    public void setShowPercentage(boolean showPercentage) {
        isShowPercentage = showPercentage;
    }

    public boolean isReDownload() {
        return isReDownload;
    }

    public void setReDownload(boolean reDownload) {
        isReDownload = reDownload;
    }

    @Override
    public String toString() {
        return "UpdateConfig{" +
                "mUrl='" + mUrl + '\'' +
                ", mPath='" + mPath + '\'' +
                ", mFilename='" + mFilename + '\'' +
                ", isShowNotification=" + isShowNotification +
                ", isInstallApk=" + isInstallApk +
                ", mNotificationIcon=" + mNotificationIcon +
                ", mNotificationId=" + mNotificationId +
                ", mChannelId='" + mChannelId + '\'' +
                ", mChannelName='" + mChannelName + '\'' +
                ", mAuthority='" + mAuthority + '\'' +
                ", isShowPercentage=" + isShowPercentage +
                ", isReDownload=" + isReDownload +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.mUrl);
        dest.writeString(this.mPath);
        dest.writeString(this.mFilename);
        dest.writeByte(this.isShowNotification ? (byte) 1 : (byte) 0);
        dest.writeByte(this.isInstallApk ? (byte) 1 : (byte) 0);
        dest.writeInt(this.mNotificationIcon);
        dest.writeInt(this.mNotificationId);
        dest.writeString(this.mChannelId);
        dest.writeString(this.mChannelName);
        dest.writeString(this.mAuthority);
        dest.writeByte(this.isReDownload ? (byte) 1 : (byte) 0);
        dest.writeByte(this.isShowPercentage ? (byte) 1 : (byte) 0);
    }


    protected UpdateConfig(Parcel in) {
        this.mUrl = in.readString();
        this.mPath = in.readString();
        this.mFilename = in.readString();
        this.isShowNotification = in.readByte() != 0;
        this.isInstallApk = in.readByte() != 0;
        this.mNotificationIcon = in.readInt();
        this.mNotificationId = in.readInt();
        this.mChannelId = in.readString();
        this.mChannelName = in.readString();
        this.mAuthority = in.readString();
        this.isReDownload = in.readByte() != 0;
        this.isShowPercentage = in.readByte() != 0;
    }

    public static final Creator<UpdateConfig> CREATOR = new Creator<UpdateConfig>() {
        @Override
        public UpdateConfig createFromParcel(Parcel source) {
            return new UpdateConfig(source);
        }

        @Override
        public UpdateConfig[] newArray(int size) {
            return new UpdateConfig[size];
        }
    };
}
