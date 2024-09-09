package com.king.app.updater.http;

import java.io.File;
import java.io.Serializable;

/**
 * @author Jenly <a href="mailto:jenly1314@gmail.com">Jenly</a>
 */
public interface IHttpManager {


    /**
     * download
     * @param url
     * @param path
     * @param filename
     * @param callback
     */
    void download(String url,String path,String filename,DownloadCallback callback);


    interface DownloadCallback extends Serializable{
        /**
         * start
         * @param url
         */
        void onStart(String url);

        /**
         * Loading progress…
         * @param progress
         * @param total
         */
        void onProgress(int progress,int total);

        /**
         * Finish
         * @param file
         */
        void onFinish(File file);

        /**
         * error
         * @param e
         */
        void onError(Exception e);


        /**
         * Cancel
         */
        void onCancel();
    }
}
