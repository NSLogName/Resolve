package com.xcty.resolve.utils;

import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*******************************
 * @Title: FileUtil
 * @package com.xcty.resolve.utils
 * @Description:TODO
 *
 * @author XCTY
 * @date 2017/10/13 14:34
 * @version
 ********************************/
public class FileUtil {
    public static List<String> findFile(String filePath, String suffixName) {
        List<String> filePaths = new ArrayList<String>();
        try {
            File f = new File(filePath);
            if (!f.exists()) {
                LoggerUtils.getLogger().info("文件不存在！");
            }
            if (f.isDirectory()) {
                File[] list = f.listFiles(getFileExtensionFilter(suffixName));
                for (int i = 0; i < list.length; i++) {
                    filePaths.add(list[i].getName());
                }

                list = f.listFiles(getNotDirFileFilter());
                for (int i = 0; i < list.length; i++) {
                    if (list[i].isDirectory()) {
                        findFile(list[i].toString(), suffixName);
                    }
                }
            }
        } catch (Exception e) {
            LoggerUtils.getLogger().error(e.getMessage(), e);
        }
        Collections.sort(filePaths);
        return filePaths;
    }


    private static FilenameFilter getFileExtensionFilter(String extension) {// 指定扩展名过滤
        final String tempExtension = extension;
        return new FilenameFilter() {
            @Override
            public boolean accept(File file, String name) {
                boolean ret = name.endsWith(tempExtension);
                return ret;
            }
        };
    }


    private static FileFilter getNotDirFileFilter() { // 文件还是目录过滤
        return new FileFilter() {
            @Override
            public boolean accept(File file) {
                //关键判断点
                return file.isDirectory();
            }
        };
    }

    public static void renameFile(String oldFilePath, String newFilePath) {
        File file = new File(oldFilePath);
        if (file.renameTo(new File(newFilePath))) {
            LoggerUtils.getLogger().info("文件：" + oldFilePath + "重命名成功！重命名后的文件名为：" + newFilePath);
        } else {
            LoggerUtils.getLogger().info("文件：" + oldFilePath + "重命名失败！");
        }
    }
}
