package com.hxj.page;

import java.util.HashMap;
import java.util.List;

/**
 * @ author 黑潇君
 * 东软睿道西安TTC
 */
public class PageBean<T>{

    private int pageNow = 1;  //防止前台不传数据
    private int pageCount = 10;//防止前台不传数据
    private int totalRows;
    private int totalPages;
    private List<T> data;

    //条件查询中的  各个条件  放在这个map中   前台不一定有条件  没有条件的时候map就会为null  初始创建出来
    private HashMap condition = new HashMap();

    public PageBean() {
    }

    public PageBean(int pageNow, int pageCount) {
        this.pageNow = pageNow;
        this.pageCount = pageCount;
    }

    public int getPageNow() {
        return pageNow;
    }

    public void setPageNow(int pageNow) {
        this.pageNow = pageNow;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public int getTotalRows() {
        return totalRows;
    }

    public void setTotalRows(int totalRows) {
        this.totalRows = totalRows;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public HashMap getCondition() {
        return condition;
    }

    public void setCondition(HashMap condition) {
        this.condition = condition;
    }

    @Override
    public String toString() {
        return "PageBean{" +
                "pageNow=" + pageNow +
                ", pageCount=" + pageCount +
                ", totalRows=" + totalRows +
                ", totalPages=" + totalPages +
                ", data=" + data +
                ", condition=" + condition +
                '}';
    }
}
