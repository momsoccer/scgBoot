package com.scg.api.android;

import com.scg.model.Board;
import com.scg.persistence.BoardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/main/")
public class AndroidController {

    @Autowired
    private BoardMapper boardMapper;

    @RequestMapping("test")
    public List<Board> getTest(){



        return boardMapper.getTestBoardList();
    }





}
