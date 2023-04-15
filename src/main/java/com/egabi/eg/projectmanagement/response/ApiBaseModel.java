package com.egabi.eg.projectmanagement.response;

import java.util.HashSet;
import java.util.Set;

//@Getter @Setter
public class ApiBaseModel<T> {
    private Boolean status;
    private Set<Integer> msgCodes = new HashSet<>();
    private  T result = null;
    private PageInfoApiModel pageInfo =null;

    public ApiBaseModel(Boolean status, Set<Integer> msgCodes,T result,PageInfoApiModel pageInfo) {
        this.status = status;
        this.msgCodes = msgCodes;
        this.pageInfo = pageInfo;
        this.result = result;

    }


    public ApiBaseModel(Boolean status, T result,PageInfoApiModel pageInfo) {
        this.status = status;
        this.pageInfo = pageInfo;
        this.result = result;

    }

    public ApiBaseModel(Boolean status, T result) {
        this.status = status;
        this.result = result;

    }
    public ApiBaseModel(Boolean status,  Set<Integer>  msgCodes) {
        this.status = status;
        this.msgCodes = msgCodes;
    }

    public ApiBaseModel(Boolean status,  Set<Integer>  msgCodes,PageInfoApiModel pageInfo) {
        this.status = status;
        this.msgCodes = msgCodes;
        this.pageInfo = pageInfo;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public  Set<Integer>  getMsgCodes() {
        return msgCodes;
    }

    public void setMsgCodes( Set<Integer>  msgCodes) {
        this.msgCodes = msgCodes;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }

    public PageInfoApiModel getPageInfo() {
        return pageInfo;
    }

    public void setPageInfo(PageInfoApiModel pageInfo) {
        this.pageInfo = pageInfo;
    }
}
