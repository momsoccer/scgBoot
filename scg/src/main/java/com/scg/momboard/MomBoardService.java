package com.scg.momboard;

import com.scg.model.MomBoard;
import com.scg.model.MomBoardFile;
import com.scg.persistence.MomBoardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by sungbo on 2016-09-08.
 */

@Service
public class MomBoardService {

    @Autowired
    private MomBoardMapper momBoardMapper;

    public MomBoard getBoardHeader(MomBoard momBoard){
        return momBoardMapper.getBoardHeader(momBoard);
    };

    public void updateBoardHeader(MomBoard momBoard){
        momBoardMapper.updateBoardHeader(momBoard);
    };

    public List<MomBoard> getBoardHeaderList(MomBoard momBoard){
        return momBoardMapper.getBoardHeaderList(momBoard);
    };


    public void saveBoardheader(MomBoard momBoard){
        momBoardMapper.saveBoardheader(momBoard);
    };


    public void deleteBoardheader(MomBoard momBoard){
        momBoardMapper.deleteBoardheader(momBoard);
    };

    public List<MomBoard> getBoardLineList(MomBoard momBoard){
        return momBoardMapper.getBoardLineList(momBoard);
    };
    public int getBoardLineCount(MomBoard momBoard){
        return momBoardMapper.getBoardLineCount(momBoard);
    };

    public void saveBoardLine(MomBoard momBoard){
        momBoardMapper.saveBoardLine(momBoard);
    };
    public void deleteBoardLine(MomBoard momBoard){
        momBoardMapper.deleteBoardLine(momBoard);
    };


    public void saveBoardLike(MomBoard momBoard){
        momBoardMapper.saveBoardLike(momBoard);
    };
    public void deleteBoardLike(MomBoard momBoard){
        momBoardMapper.deleteBoardLike(momBoard);
    };

    public int getBoardLikeCount(MomBoard momBoard){
        return momBoardMapper.getBoardLikeCount(momBoard);
    };

    public void saveBoardFile(MomBoardFile momBoardFile){
        momBoardMapper.saveBoardFile(momBoardFile);
    };

    public List<MomBoardFile> getBoardFileList(int boardid){
        return momBoardMapper.getBoardFileList(boardid);
    };

    public void deleteBoardFile(MomBoardFile momBoardFile){
        momBoardMapper.deleteBoardFile(momBoardFile);
    };


    public List<MomBoard> getAllBoardLineList(MomBoard momBoard){
        return momBoardMapper.getAllBoardLineList(momBoard);
    };

}
