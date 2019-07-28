package org.jim.server.command;

import org.jim.common.packets.LoginRespBody;
import org.jim.server.beans.CsLoginReqBody;
import org.jim.server.command.handler.processor.CmdProcessor;
import org.tio.core.ChannelContext;

public interface CsLoginCmdProcessor extends CmdProcessor {

    LoginRespBody doLogin(CsLoginReqBody csLoginReqBody, ChannelContext channelContext);

    void onSuccess(ChannelContext channelContext);
}
