package org.jim.server.beans;

import org.jim.common.packets.Command;
import org.jim.common.packets.Message;

public class CsLoginReqBody extends Message {

    private static final long serialVersionUID = -10113316720288444L;
    private String userId;
    private String userType;
    private String token;

    public CsLoginReqBody() {
    }

    public CsLoginReqBody(String token) {
        this.token = token;
        this.cmd = Command.COMMAND_LOGIN_REQ.getNumber();
    }

    public CsLoginReqBody(String userId, String userType) {
        this.userId = userId;
        this.userType = userType;
        this.cmd = Command.COMMAND_LOGIN_REQ.getNumber();
    }

    public CsLoginReqBody(String loginname, String password, String token) {
        this(loginname, password);
        this.token = token;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getToken() {
        return this.token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
