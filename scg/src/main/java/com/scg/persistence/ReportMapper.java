package com.scg.persistence;

import com.scg.model.Report;

import java.util.List;

/**
 * Created by sungbo on 2016-09-11.
 */
public interface ReportMapper {

    public void saveReport(Report report);

    public List<Report> getReportList(Report report);

    public void pointUpdateReport(Report report);

}
