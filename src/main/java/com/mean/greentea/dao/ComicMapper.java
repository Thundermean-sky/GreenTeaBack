package com.mean.greentea.dao;

import com.mean.greentea.entity.Comic;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ComicMapper {

    List<Comic> getComicListByTypeAndProcess(@Param("type") String type, @Param("process") String process);

    Comic getComicData(@Param("CID") String CID);
}
