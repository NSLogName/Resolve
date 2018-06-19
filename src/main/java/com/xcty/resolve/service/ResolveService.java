package com.xcty.resolve.service;

import com.xcty.resolve.constants.Constants;
import com.xcty.resolve.dao.ResolveLogDao;
import com.xcty.resolve.dao.entity.ResolveLog;
import com.xcty.resolve.dao.entity.ResolveLogWithBLOBs;
import com.xcty.resolve.utils.LoggerUtils;
import com.xcty.utils.DatetimeUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.List;

@Service
public class ResolveService {
    @Autowired
    private ResolveLogDao resolveLogDao;

    public void readFileByLines(String fileName, String name) {
        String regStr = "\\[/|]\\*执行时长:\\*\\[|]毫秒\\*参数\\*\\|\\|\\||\\|\\|\\|结果\\|\\|\\||\\n";
        String regStr2 = "\\[|]\\*执行时长:\\*\\[|]毫秒|\\n";
        String date = StringUtils.split(name, "_")[0];

        File file = new File(fileName);
        BufferedReader reader;
        try {
            InputStreamReader isr = new InputStreamReader(new FileInputStream(file), "UTF-8");
            reader = new BufferedReader(isr);
            String tempString;
            while ((tempString = reader.readLine()) != null) {
                ResolveLogWithBLOBs resolveLogWithBLOBs = new ResolveLogWithBLOBs();
                String[] strArr;
                if (StringUtils.contains(tempString, "参数")) {
                    strArr = tempString.split(regStr);
//                    resolveLogWithBLOBs.setInvokeParam(strArr[3]);
//                    resolveLogWithBLOBs.setInvokeResult(strArr[4]);
                    resolveLogWithBLOBs.setInvokeUrl("/" + strArr[1]);
                } else {
                    strArr =  tempString.split(regStr2);
                    resolveLogWithBLOBs.setInvokeUrl(strArr[1]);
                }
                resolveLogWithBLOBs.setInvokeTime(date + " " + strArr[0]);
                resolveLogWithBLOBs.setInvokePasstime(Integer.parseInt(strArr[2]));
                resolveLogWithBLOBs.setCreateTime(DatetimeUtil.getNowStr());

                Constants.list.add(resolveLogWithBLOBs);
            }
            reader.close();
        } catch (IOException e) {
            LoggerUtils.getLogger().error(e.getMessage(), e);
        }

    }

    public int insertTimeoutWithBlobsBatch(List<ResolveLogWithBLOBs> resolveLogWithBLOBsList) {
        try {
            return resolveLogDao.insertResolveLogWithBLOBsBatch(resolveLogWithBLOBsList);
        } catch (Exception e) {
            System.out.println(e);
            return 0;
        }
    }
}
