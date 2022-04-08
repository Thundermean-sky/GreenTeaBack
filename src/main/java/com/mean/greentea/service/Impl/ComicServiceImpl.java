package com.mean.greentea.service.Impl;

import cn.hutool.json.JSONException;
import cn.hutool.json.JSONObject;
import com.mean.greentea.dao.ComicMapper;
import com.mean.greentea.entity.Comic;
import com.mean.greentea.service.ComicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComicServiceImpl implements ComicService {

    @Autowired
    private ComicMapper comicMapper;

    @Override
    public int getComicListByTypeAndProcess(String type, String process, JSONObject result) {
        List<Comic>comicList = null;
        try{
            comicList = comicMapper.getComicListByTypeAndProcess(type, process);
            System.out.println(comicList);
        }catch (JSONException e)
        {
            result.set("msg","服务器错误");
            return 2;
        }
        result.set("data",comicList);
        result.set("msg","success");
        return 1;
    }

    @Override
    public int getComicData(String CID, JSONObject result) {
        Comic comic = new Comic();
        try{
            comic = comicMapper.getComicData(CID);
        } catch (JSONException e)
        {
            result.set("msg", "服务器错误");
            return 2;
        }
        result.set("data",comic);
        result.set("msg","success");
        return 1;
    }

}
