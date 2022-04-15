package com.mean.greentea.service;

import cn.hutool.json.JSONObject;
import com.mean.greentea.entity.Comic;

public interface ComicService {

    // 漫画界面按照类型查询数据列表
    int getComicListByTypeAndProcess(String type, String process, JSONObject result);

    // 获取单个漫画的详细信息
    int getComicData(String CID, JSONObject result);

    // 首页的更新列表
    int getComicListByRec(JSONObject result);

    // 更新漫画信息
    int putComicData(Comic comic, JSONObject result);

    // 查找漫画信息
    int searchComicData(String searchName, JSONObject result);

}
