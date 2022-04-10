package com.mean.greentea.controller;


import cn.hutool.json.JSONObject;
import com.mean.greentea.entity.Comic;
import com.mean.greentea.service.ComicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/comics")
public class ComicController {

    @Autowired
    private ComicService comicService;

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

    @PutMapping
    public ResponseEntity<JSONObject> putComicData(@RequestBody Comic comic)
    {
        JSONObject result = new JSONObject();
        System.out.println(comic);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }


}
