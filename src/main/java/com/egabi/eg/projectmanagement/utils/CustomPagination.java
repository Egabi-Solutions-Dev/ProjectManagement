package com.egabi.eg.projectmanagement.utils;


import com.egabi.eg.projectmanagement.response.PageInfoApiModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

public class CustomPagination {

    Pageable pageable = null;

    public static final Integer DEFAULT_PAGE_SIZE=10;
    public static final Integer DEFAULT_CURRENT_PAGE=0;

    public Pageable getPageable() {
        return pageable;
    }

    /**
     * Creates a new {@link PageRequest} with sort parameters applied.
     *
     * @param page zero-based page index, must not be negative.
     * @param size the size of the page to be returned, must be greater than 0.
     * @param sort must not be {@literal null}, use {@link Sort#unsorted()} instead.
     */
    public CustomPagination(int page, int size, Sort sort) {

        if(page<0){
            page = DEFAULT_CURRENT_PAGE;
        }

        if(size<1){
            size = DEFAULT_PAGE_SIZE;
        }
        this.pageable =  PageRequest.of(page, size, sort);
    }

    public CustomPagination(Integer page, Integer size, Sort sort) {
        if(page==null ||page<0){
            page = DEFAULT_CURRENT_PAGE;
        }

        if(size==null ||size<1){
            size = DEFAULT_PAGE_SIZE;
        }

        this.pageable =  PageRequest.of(page, size, sort);
    }


    public CustomPagination(int page, int size) {

        if(page<0){
            page = DEFAULT_CURRENT_PAGE;
        }

        if(size<1){
            size = DEFAULT_PAGE_SIZE;
        }
        this.pageable =  PageRequest.of(page, size);
    }

    public CustomPagination(Integer page, Integer size) {
        if(page==null ||page<0){
            page = DEFAULT_CURRENT_PAGE;
        }

        if(size==null ||size<1){
            size = DEFAULT_PAGE_SIZE;
        }

        this.pageable =  PageRequest.of(page, size);
    }

    public PageInfoApiModel getPageInfoApiModel(Page page){
        if(page==null){
            return null;
        }

        return new PageInfoApiModel(page.getNumber(),page.getSize(),page.getTotalElements());

    }


}
