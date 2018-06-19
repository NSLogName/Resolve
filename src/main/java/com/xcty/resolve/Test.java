package com.xcty.resolve;

import com.xcty.resolve.constants.Constants;
import com.xcty.resolve.dao.entity.ResolveLogWithBLOBs;
import com.xcty.resolve.service.ResolveService;
import com.xcty.resolve.utils.FileUtil;
import com.xcty.resolve.utils.LoggerUtils;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

/*******************************
 * @Title: Test.java
 * @package com.xcty.eventcenter
 * @Description:TODO
 *
 * @author XCTY
 * @date 2017年8月15日 下午1:50:33
 * @version
 ********************************/

public class Test {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                new String[]{"applicationContext.xml"});
        context.start();
        ResolveService resolveService = context.getBean(ResolveService.class);
        try {
            List<String> fileNameArr = new ArrayList<String>();
            fileNameArr = FileUtil.findFile(Constants.winFilePath, ".log");

            long startTime = System.currentTimeMillis();
            for (String fileName : fileNameArr) {
                String filePath = Constants.winFilePath + fileName;
                resolveService.readFileByLines(filePath, fileName);
                FileUtil.renameFile(filePath, filePath + "_wasResolve");
            }
            long endTime = System.currentTimeMillis();
            long execTime = endTime - startTime;
            LoggerUtils.getLogger().info("======================== 解析文件累计耗时：" + execTime + "毫秒" + "  " + "数据总量为：" + Constants.list.size() + " ========================");

            LoggerUtils.getLogger().info("###################开始入库！###################");
            long saveStartTime = System.currentTimeMillis();
            List<ResolveLogWithBLOBs> list = new ArrayList<ResolveLogWithBLOBs>();
            for (ResolveLogWithBLOBs record : Constants.list) {
                list.add(record);
                if (list.size() == 5000) {
                    if (resolveService.insertTimeoutWithBlobsBatch(list) > 0) {
                        list.clear();
                    } else {
                        LoggerUtils.getLogger().error("###################入库出错！###################");
                        break;
                    }
                }
            }
            if (list.size() > 0) {
                if (resolveService.insertTimeoutWithBlobsBatch(list) > 0) {
                    list.clear();
                } else {
                    LoggerUtils.getLogger().error("###################入库出错！###################");
                }
            }
            long saveEndTime = System.currentTimeMillis();
            long saveExecTime = saveEndTime - saveStartTime;
            LoggerUtils.getLogger().info("###################入库结束！###################");
            LoggerUtils.getLogger().info("======================== 入库累计耗时：" + saveExecTime + "毫秒 ========================");
        } catch (Exception e) {
            LoggerUtils.getLogger().error(e.getMessage(), e);
        }
    }
}
