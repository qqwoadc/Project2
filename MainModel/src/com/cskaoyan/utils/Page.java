package com.cskaoyan.utils;

import java.util.List;

public class Page<T> {

    public final static int DEFAULT_IETMS = 10;


    private int totalPage;
    private int currentPage;

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
}
