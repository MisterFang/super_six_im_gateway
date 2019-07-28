package org.jim.server.command;

import org.jim.common.ImAio;
import org.jim.common.ImPacket;
import org.jim.common.http.HttpConst;
import org.jim.common.http.HttpRequest;
import org.jim.common.packets.Command;
import org.jim.common.utils.JsonKit;
import org.jim.server.beans.CsLoginReqBody;
import org.jim.server.command.handler.LoginReqHandler;
import org.jim.server.command.handler.processor.handshake.WsHandshakeProcessor;
import org.tio.core.ChannelContext;

public class DemoWsHandshakeProcessor extends WsHandshakeProcessor {

	@Override
	public void onAfterHandshaked(ImPacket packet, ChannelContext channelContext) throws Exception {
		LoginReqHandler loginHandler = (LoginReqHandler)CommandManager.getCommand(Command.COMMAND_LOGIN_REQ);
		HttpRequest request = (HttpRequest)packet;
		String userId = request.getParams().get("userId") == null ? null : (String)request.getParams().get("userId")[0];
		String userType = request.getParams().get("userType") == null ? null : (String)request.getParams().get("userType")[0];
		String token = request.getParams().get("token") == null ? null : (String)request.getParams().get("token")[0];
		//LoginReqBody loginBody = new LoginReqBody(username,password,token);
		CsLoginReqBody csLoginReqBody = new CsLoginReqBody(userId,userType,token);
		byte[] loginBytes = JsonKit.toJsonBytes(csLoginReqBody);
		request.setBody(loginBytes);
		request.setBodyString(new String(loginBytes,HttpConst.CHARSET_NAME));
		ImPacket loginRespPacket = loginHandler.handler(request, channelContext);
		if(loginRespPacket != null){
			ImAio.send(channelContext, loginRespPacket);
		}
	}
}
