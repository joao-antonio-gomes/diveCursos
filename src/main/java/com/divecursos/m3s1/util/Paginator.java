package com.divecursos.m3s1.util;

import java.util.ArrayList;
import java.util.List;

public class Paginator<T> {
    private List<T> registers;
    private int pageSize;
    private int pageQuantity;

    public Paginator(List<T> registers, int pageSize) {
        this.registers = registers;
        this.pageSize = pageSize;
        this.pageQuantity = (int) Math.ceil((double) registers.size() / pageSize);
    }

    public List<T> getPage(int pageNumber) {
        if (pageNumber > pageQuantity) {
            return new ArrayList<>();
        }
        int start = (pageSize * (pageNumber - 1));
        boolean isLastPage = pageQuantity == pageNumber;
        int registersRemaining = registers.size() % pageQuantity;
        int end;
        if (!isLastPage || registersRemaining > 0) {
            end = start + pageSize;
        } else {
            end = start + registersRemaining;
        }
        return new ArrayList<>(registers.subList(start, end));
    }

    public int getPageQuantity() {
        return pageQuantity;
    }
}
