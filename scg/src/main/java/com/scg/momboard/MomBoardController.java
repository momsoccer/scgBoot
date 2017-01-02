package com.scg.momboard;


import com.scg.api.common.UploadFunction;
import com.scg.api.googlefcm.Push;
import com.scg.api.googlefcm.PushService;
import com.scg.model.Common.ServerResult;
import com.scg.model.Message;
import com.scg.model.MomBoard;
import com.scg.model.MomBoardFile;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/*****
 *
 * 팀, 클럽 게시판
 *
 */

@RestController
@RequestMapping("/momboard/")
public class MomBoardController {

    private static final Logger logger = LoggerFactory.getLogger(MomBoardController.class);

    @Autowired
    private  MomBoardService momBoardService;

    @Autowired
    private PushService pushService;

    @RequestMapping(value = "getBoardHeader", method = RequestMethod.POST)
    public MomBoard getBoardHeader(@RequestBody MomBoard momBoard){

        MomBoard resultBoard = new MomBoard();

        resultBoard = momBoardService.getBoardHeader(momBoard);

        if(resultBoard.getFilecount()!=0){
            List<MomBoardFile> momBoardFiles = momBoardService.getBoardFileList(resultBoard.getBoardid());
            resultBoard.setBoardFiles(momBoardFiles);
        }

        return resultBoard;
    };

    //수정
    @RequestMapping(value = "updateBoardHeader", method = RequestMethod.POST)
    public ServerResult updateBoardHeader(@RequestBody MomBoard momBoard){
        momBoardService.updateBoardHeader(momBoard);
        return new ServerResult(1,"S");
    };

    @RequestMapping(value = "getBoardHeaderList", method = RequestMethod.POST)
    public List<MomBoard> getBoardHeaderList(@RequestBody MomBoard momBoard){


        List<MomBoard> momBoards = new ArrayList<MomBoard>();

        if(momBoard.getBoardtypeid()==0){
            return momBoards;
        }else{
            momBoards = momBoardService.getBoardHeaderList(momBoard);

            for(int i =0; i < momBoards.size() ; i++){
                if(momBoards.get(i).getFilecount()!=0){
                    momBoards.get(i).setBoardFiles(momBoardService.getBoardFileList(momBoards.get(i).getBoardid()));
                }
            }

        }

        return momBoards;
    };

    @RequestMapping(value = "getAllBoardHeaderList", method = RequestMethod.POST)
    public List<MomBoard> getAllBoardHeaderList(@RequestBody MomBoard momBoard){


        List<MomBoard> momBoards = new ArrayList<MomBoard>();

            momBoards = momBoardService.getAllBoardLineList(momBoard);

            for(int i =0; i < momBoards.size() ; i++){
                if(momBoards.get(i).getFilecount()!=0){
                    momBoards.get(i).setBoardFiles(momBoardService.getBoardFileList(momBoards.get(i).getBoardid()));
                }
            }

        return momBoards;
    };


    @RequestMapping(value = "saveBoardheader", method = RequestMethod.POST)
    public ServerResult saveBoardheader(@RequestBody MomBoard momBoard){

        momBoardService.saveBoardheader(momBoard);

        //푸쉬
        if(momBoard.getBoardtype().equals("team")){
            Message message = new Message(Push.PUSH_TITLE_BOARD_TEAM,momBoard.getUsername(),momBoard.getContent());
            pushService.pushExecute(Push.PUSHTYPE_TEAM, 0, 0, momBoard.getBoardtypeid(), message);
        }

        return new ServerResult(momBoard.getBoardid(),"S");
    };

    @RequestMapping(value = "deleteBoardheader", method = RequestMethod.POST)
    public ServerResult deleteBoardheader(HttpServletRequest request,@RequestBody MomBoard momBoard){
        momBoardService.deleteBoardLine(momBoard);
        momBoardService.deleteBoardheader(momBoard);

        //file이 있다면 파일도 삭제
        List<MomBoardFile> momBoardFiles = new ArrayList<MomBoardFile>();
        momBoardFiles = momBoardService.getBoardFileList(momBoard.getBoardid());

        if(momBoardFiles.size()!=0){
            UploadFunction uploadFunction = new UploadFunction();
            for(int i = 0;i < momBoardFiles.size();i++){
                logger.info("파일 지우기  : " + i);
                uploadFunction.boardDeleteFile(request, momBoardFiles.get(i).getFilename());
            }
            logger.info("파일 지우기  : 컬....");
            MomBoardFile momBoardFile = new MomBoardFile();
            momBoardFile.setBoardid(momBoard.getBoardid());
            momBoardService.deleteBoardFile(momBoardFile);

        }


        return new ServerResult(1,"S");
    };

    //라인글쓰기
    @RequestMapping(value = "saveBoardLine", method = RequestMethod.POST)
    public ServerResult saveBoardLine(@RequestBody MomBoard momBoard){
        momBoardService.saveBoardLine(momBoard);
        //원게시자에게 메세지 발송

        MomBoard board = new MomBoard();
        board.setBoardid(momBoard.getBoardid());
        board = momBoardService.getBoardHeader(board);

        Message message = new Message(Push.PUSH_TITLE_BOARD_COMMNET,momBoard.getUsername(),momBoard.getContent());
        pushService.pushExecute(Push.PUSHTYPE_COMMENT_USER, 0, board.getUid(), momBoard.getBoardtypeid(), message);
        return new ServerResult(1,"S");
    };

    //라인만 삭제
    @RequestMapping(value = "deleteBoardLine", method = RequestMethod.POST)
    public ServerResult deleteBoardLine(@RequestBody MomBoard momBoard){
        momBoardService.deleteBoardLine(momBoard);
        return new ServerResult(1,"S");
    };

    @RequestMapping(value = "getBoardLineList", method = RequestMethod.POST)
    public List<MomBoard> getBoardLineList(@RequestBody MomBoard momBoard){

        return momBoardService.getBoardLineList(momBoard);
    };


    //게시글 파일 첨부
    @RequestMapping(value = "fileupload", method = RequestMethod.POST, headers = "Content-Type=multipart/form-data")
    public ServerResult fileupLoad(HttpServletRequest request,
                                   @RequestParam("boardid") String boardid,
                                   @RequestParam("filename") String filename,
                                   @RequestParam("profileimgurl") String profileimgurl,
                                   @RequestParam("file") MultipartFile file){

        int dbBoardid = Integer.parseInt(boardid);
        if (!file.isEmpty()) {
            String picture = filename;

            String rootPath = request.getSession().getServletContext().getRealPath("/") + "/" + "resources/board/";
            UploadFunction uploadFunction = new UploadFunction();
            uploadFunction.writeFile(file, picture, request, rootPath);
        }

        MomBoardFile momBoardFile = new MomBoardFile();
        momBoardFile.setBoardid(dbBoardid);
        momBoardFile.setFilename(filename);
        momBoardFile.setFileaddr(profileimgurl);

        momBoardService.saveBoardFile(momBoardFile);

        return new ServerResult(1,"S");
    }

    @RequestMapping(value = "getBoardFileList")
    public List<MomBoardFile> getBoardFileList(@RequestParam("boardid") int boardid){
        return momBoardService.getBoardFileList(boardid);
    };


    @RequestMapping(value = "getTest")
    public List<MomBoard> getBoardHeaderListTest(){
        MomBoard momBoard = new MomBoard();

        momBoard.setLimit(10);
        List<MomBoard> momBoards = new ArrayList<MomBoard>();


        momBoards = momBoardService.getBoardHeaderList(momBoard);
        for(int i =0; i < momBoards.size() ; i++){
            if(momBoards.get(i).getFilecount()!=0){
                momBoards.get(i).setBoardFiles(momBoardService.getBoardFileList(momBoards.get(i).getBoardid()));
            }
        }
        return momBoards;
    };



    @RequestMapping(value = "deleteBoardFile",method = RequestMethod.POST)
    public ServerResult deleteBoardFile(HttpServletRequest request,@RequestBody MomBoardFile momBoardFile
    ){

        List<MomBoardFile> momBoardFiles = new ArrayList<MomBoardFile>();
        momBoardFiles = momBoardService.getBoardFileList(momBoardFile.getBoardid());

        if(momBoardFiles.size()!=0){
            UploadFunction uploadFunction = new UploadFunction();
            for(int i = 0;i < momBoardFiles.size();i++){
                uploadFunction.boardDeleteFile(request, momBoardFiles.get(i).getFilename());
            }
            momBoardFile.setBoardid(momBoardFile.getBoardid());
            momBoardService.deleteBoardFile(momBoardFile);

        }
        return new ServerResult(1,"S");
    }

    @RequestMapping(value = "deleteBoardFileList",method = RequestMethod.POST)
    public ServerResult deleteBoardFileList(HttpServletRequest request,@RequestBody List<MomBoardFile> momBoardFile){

        UploadFunction uploadFunction = new UploadFunction();
        for(int i = 0;i < momBoardFile.size();i++){
            uploadFunction.boardDeleteFile(request, momBoardFile.get(i).getFilename());

            MomBoardFile query = new MomBoardFile();
            query.setFileid(momBoardFile.get(i).getFileid());

            momBoardService.deleteBoardFile(query);
        }

        return new ServerResult(1,"S");
    }
}
