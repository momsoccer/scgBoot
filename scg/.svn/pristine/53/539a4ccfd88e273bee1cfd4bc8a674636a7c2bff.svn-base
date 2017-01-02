package com.scg.api.board;

import com.scg.api.googlefcm.Push;
import com.scg.api.googlefcm.PushService;
import com.scg.model.Board;
import com.scg.model.Common.ServerResult;
import com.scg.model.Message;
import com.scg.persistence.BoardMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by sungbo on 2016-08-01.
 */

@RestController
@RequestMapping("/api/mission/board/")
public class BoardController {

    private static final Logger logger = LoggerFactory.getLogger(BoardController.class);

    @Autowired
    private BoardMapper boardMapper;

    @Autowired
    private PushService pushService;

    @RequestMapping(value = "saveboard",method = RequestMethod.POST)
    public ServerResult saveBoard(@RequestBody Board board){

        boardMapper.saveBoard(board);

        //push noti
        Message message = new Message(Push.PUSH_TITLE_MISSION_COMMENT,board.getUsername(),board.getComment());
        pushService.pushExecute(Push.PUSHTYPE_MISSION_COMMENT, 0, board.getUid(), 0, message);

        return new ServerResult(1,"S");
    }

    @RequestMapping(value = "getboardlist",method = RequestMethod.POST)
    public List<Board> getBoardList(@RequestBody Board board){
        return boardMapper.getBoardList(board);
    }

    @RequestMapping(value = "deleteBoard")
    public ServerResult deleteBoard(@RequestParam("boardid") int boardid){
        boardMapper.deleteBoard(boardid);
        return new ServerResult(1,"S");
    }



}
