package org.jim.server.command;

import org.jim.common.cache.redis.JedisTemplate;
import org.jim.common.packets.LoginReqBody;
import org.jim.common.packets.LoginRespBody;
import org.jim.server.beans.CsLoginReqBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.tio.core.ChannelContext;

/**
 * 客服系统登陆业务处理
 */
@Component
public class CsLoginServiceProcessor implements CsLoginCmdProcessor {

    @Override
    public LoginRespBody doLogin(CsLoginReqBody loginReqBody, ChannelContext channelContext) {
        String token = loginReqBody.getToken();
        String userId = loginReqBody.getUserId();
        String userType = loginReqBody.getUserType();

       // String userType = loginReqBody.getExtras().getString(Constant.USER_FIELD_USERID);

        return null;
    }

    @Override
    public void onSuccess(ChannelContext channelContext) {

    }

    @Override
    public boolean isProtocol(ChannelContext channelContext) {
        return false;
    }

    @Override
    public String name() {
        return null;
    }
}
