package com.mean.greentea.service;

import org.json.JSONObject;

public interface ComicService {
    int getComicListByTypeAndProcess(String type, String process, JSONObject result);
}
