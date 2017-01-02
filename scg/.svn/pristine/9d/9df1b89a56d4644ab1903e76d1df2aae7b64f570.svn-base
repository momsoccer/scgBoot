package com.scg.persistence;

import com.scg.model.MomBoard;
import com.scg.model.MomBoardFile;

import java.util.List;

/**
 * Created by sungbo on 2016-09-08.
 */
public interface MomBoardMapper {

    public MomBoard getBoardHeader(MomBoard momBoard);
    public void updateBoardHeader(MomBoard momBoard);

    public List<MomBoard> getBoardHeaderList(MomBoard momBoard);
    public void saveBoardheader(MomBoard momBoard);
    public void deleteBoardheader(MomBoard momBoard);

    public List<MomBoard> getBoardLineList(MomBoard momBoard);
    public int getBoardLineCount(MomBoard momBoard);
    public void saveBoardLine(MomBoard momBoard);
    public void deleteBoardLine(MomBoard momBoard);

    public int getBoardLikeCount(MomBoard momBoard);
    public void saveBoardLike(MomBoard momBoard);
    public void deleteBoardLike(MomBoard momBoard);

    //file
    public void saveBoardFile(MomBoardFile momBoardFile);
    public void deleteBoardFile(MomBoardFile momBoardFile);
    public List<MomBoardFile> getBoardFileList(int boardid);


    public List<MomBoard> getAllBoardLineList(MomBoard momBoard);



}
