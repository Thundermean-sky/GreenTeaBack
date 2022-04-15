package com.mean.greentea.controller;


import cn.hutool.json.JSONObject;
import com.mean.greentea.entity.Comic;
import com.mean.greentea.service.ComicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@CrossOrigin
@RestController
@RequestMapping("/comics")
public class ComicController {

    @Autowired
    private ComicService comicService;

    /*
    *   通过类型和进度返回列表
    * */
    @GetMapping("/{type}/{process}")
    public ResponseEntity<JSONObject> getComicsByTypeAndProcess(@PathVariable String type, @PathVariable String process)
    {
        JSONObject result = new JSONObject();
        int res = comicService.getComicListByTypeAndProcess(type, process, result);
        if(res != 1)
        {
            return new ResponseEntity<>(result, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    /*
    *   通过CID返回详细信息
    * */
    @GetMapping("/{CID}")
    public ResponseEntity<JSONObject> getComicData(@PathVariable String CID)
    {
        JSONObject result = new JSONObject();
        int res = comicService.getComicData(CID, result);
        if(res != 1)
        {
            return new ResponseEntity<>(result, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    /*
    *   首页推荐列表，待改进
    * */
    @GetMapping
    public ResponseEntity<JSONObject> getComicListByRec()
    {
        JSONObject result = new JSONObject();
        int res = comicService.getComicListByRec(result);
        if(res != 1)
        {
            return new ResponseEntity<>(result, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    /**
     * 搜索功能实现
     * @param searchName
     * @return 列表
     */
    @GetMapping("/rec/{searchName}")
    public ResponseEntity<JSONObject> getComicBySearch(@PathVariable String searchName)
    {
        JSONObject result = new JSONObject();
        int res = comicService.searchComicData(searchName, result);
        if(res != 1)
        {
            return new ResponseEntity<>(result, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(result, HttpStatus.OK);
    }



    /*
    *   更新详细信息
    * */
    @PutMapping
    public ResponseEntity<JSONObject> putComicData(@RequestBody Comic comic)
    {
        JSONObject result = new JSONObject();
        int res = comicService.putComicData(comic, result);
        if(res == 2)
        {
            return new ResponseEntity<>(result, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(result, HttpStatus.OK);
    }


}
