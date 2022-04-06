package com.mean.greentea.controller;


import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/comics")
public class ComicController {

    @GetMapping("/{type}/{process}")
    public ResponseEntity<JSONObject> getComicsByTypeAndProcess(@PathVariable String type, @PathVariable String process)
    {
        JSONObject result = new JSONObject();
        return new ResponseEntity<>(result, HttpStatus.ACCEPTED);
    }


}
