package com.quickstart.baselib.net;

import android.util.Log;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;

/**
 * 文件工具类    LogFileHelper.writeTxtToFile(idPASideBase64, "/sdcard/Gyt/", "idPASide.txt");
 *              String idPASideBase64 = LogFileHelper.getFileContent(new File("/sdcard/Gyt/idPASide.txt"));
 */
public class LogFileHelper {
    private static final String TAG = "LogFileHelper";

    // 将字符串写入到文本文件中
    public static void writeTxtToFile(String strContent) {
        writeTxtToFile(strContent, "/sdcard/memory/", "network_log.txt");
    }

    // 将字符串写入到文本文件中
    public static void writeTxtToFile(String strContent, String filePath, String fileName) {
        //生成文件夹之后，再生成文件，不然会出错
        makeFilePath(filePath, fileName);
        String strFilePath = filePath + fileName;
        // 每次写入时，都换行写
        String content = strContent + "\r\n";
        try {
            File file = new File(strFilePath);
            if (!file.exists()) {
                file.getParentFile().mkdirs();
                file.createNewFile();
            }
            RandomAccessFile raf = new RandomAccessFile(file, "rwd");
            raf.seek(file.length());
            raf.write(content.getBytes());
            raf.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //生成文件
    public static File makeFilePath(String filePath, String fileName) {
        File file = null;
        makeRootDirectory(filePath);
        try {
            file = new File(filePath + fileName);
            if (!file.exists()) {
                file.createNewFile();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return file;
    }

    //生成文件夹
    public static void makeRootDirectory(String filePath) {
        File file = null;
        try {
            file = new File(filePath);
            if (!file.exists()) {
                file.mkdir();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //读取指定目录下的所有TXT文件的文件内容
    public static String getFileContent(File file) {
        String content = "";
        if (!file.isDirectory()) { //检查此路径名的文件是否是一个目录(文件夹)
            if (file.getName().endsWith("txt")) {//文件格式为""文件
                try {
                    InputStream instream = new FileInputStream(file);
                    if (instream != null) {
                        InputStreamReader inputReader
                                = new InputStreamReader(instream, "UTF-8");
                        BufferedReader buffReader = new BufferedReader(inputReader);
                        String line = "";
                        //分行读取
                        while ((line = buffReader.readLine()) != null) {
                            content += line + "\n";
                        }
                        instream.close();//关闭输入流
                    }
                } catch (java.io.FileNotFoundException e) {
                    Log.e(TAG, "The File doesn't not exist.");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return content;
    }

}
