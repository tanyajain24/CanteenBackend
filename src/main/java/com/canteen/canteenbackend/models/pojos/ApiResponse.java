package com.canteen.canteenbackend.models.pojos;

public class ApiResponse {
    private String msg;
    private boolean status;
    private Object body;


    public ApiResponse(String msg, boolean status, Object body) {
        this.msg = msg;
        this.status = status;
        this.body = body;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public boolean isstatus() {
        return status;
    }

    public void setstatus(boolean status) {
        this.status = status;
    }

    public Object getBody() {
        return body;
    }

    public void setBody(Object body) {
        this.body = body;
    }
}
