package com.cskaoyan.utils;

import java.util.List;

public class Page<T> {

    public final static int DEFAULT_IETMS = 10;

    //总页数
    private int totalPage;
    //当前页
    private int currentPage;
    //数据集合
    private List<T> result;

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public List<T> getResult() {
        return result;
    }

    public void setResult(List<T> result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "Page{" +
                "totalPage=" + totalPage +
                ", currentPage=" + currentPage +
                ", result=" + result +
                '}';
    }
}
