package com.xcty.resolve.service;

import com.xcty.resolve.constants.Constants;
import com.xcty.resolve.dao.TimeoutDao;
import com.xcty.resolve.dao.entity.TimeoutWithBlobs;
import com.xcty.resolve.utils.LoggerUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.List;

@Service
public class ResolveService {
    @Autowired
    TimeoutDao timeoutDao;

    public void readFileByLines(String fileName, String name) {
        String regStr = "\\[/|]\\*执行时长:\\*\\[|]毫秒\\*参数\\*\\|\\|\\||\\|\\|\\|结果\\|\\|\\||\\n";
        String regStr2 = "\\[|]\\*执行时长:\\*\\[|]毫秒|\\n";
        String date = StringUtils.split(name, "_")[0];

        File file = new File(fileName);
        BufferedReader reader = null;
        try {
            InputStreamReader isr = new InputStreamReader(new FileInputStream(file), "UTF-8");
            reader = new BufferedReader(isr);
            String tempString = null;
            while ((tempString = reader.readLine()) != null) {
                TimeoutWithBlobs TimeoutWithBlobs = new TimeoutWithBlobs();
                String[] strArr = null;
                if (StringUtils.contains(tempString, "参数")) {
                    strArr = tempString.split(regStr);
                    TimeoutWithBlobs.setParam(strArr[3]);
                    TimeoutWithBlobs.setResult(strArr[4]);
                    TimeoutWithBlobs.setUrl("/" + strArr[1]);
                } else {
                    strArr =  tempString.split(regStr2);
                    TimeoutWithBlobs.setUrl(strArr[1]);
                }
                TimeoutWithBlobs.setTime(strArr[0]);
                TimeoutWithBlobs.setPasstime(Integer.parseInt(strArr[2]));
                TimeoutWithBlobs.setDate(date);

                Constants.list.add(TimeoutWithBlobs);
            }
            reader.close();
        } catch (FileNotFoundException e) {
            LoggerUtils.getLogger().error(e.getMessage(), e);
        } catch (UnsupportedEncodingException e) {
            LoggerUtils.getLogger().error(e.getMessage(), e);
        } catch (IOException e) {
            LoggerUtils.getLogger().error(e.getMessage(), e);
        }

    }

    public int insertTimeoutWithBlobsBatch(List<TimeoutWithBlobs > TimeoutWithBlobs) {
        try {
            return timeoutDao.insertTimeoutWithBlobsBatch(TimeoutWithBlobs);
        } catch (Exception e) {
            System.out.println(e);
            return 0;
        }
    }

    public int insert(TimeoutWithBlobs record) {
        try {
            return timeoutDao.insert(record);
        } catch (Exception e) {
            LoggerUtils.getLogger().error(e.getMessage(), e);
            return 0;
        }
    }
}
