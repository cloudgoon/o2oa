package o2.collect.assemble.jaxrs.collect;

import javax.servlet.http.HttpServletRequest;

import com.google.gson.JsonElement;
import com.x.base.core.project.http.ActionResult;
import com.x.base.core.project.http.EffectivePerson;
import com.x.base.core.project.jaxrs.WrapBoolean;
import com.x.base.core.project.logger.Logger;
import com.x.base.core.project.logger.LoggerFactory;

import o2.collect.assemble.ThisServletContextListener;

class ActionUnexpectedErrorLogReceive extends BaseAction {

	private static Logger logger = LoggerFactory.getLogger(ActionUnexpectedErrorLogReceive.class);

	ActionResult<Wo> execute(HttpServletRequest request, EffectivePerson effectivePerson, JsonElement jsonElement)
			throws Exception {
		Wi wi = this.convertToWrapIn(jsonElement, Wi.class);
		wi.setAddress(request.getRemoteAddr());
		logger.print("接收到源地址:{}, 名称:{}, 发送的意外错误日志.", wi.getAddress(), wi.getName());
		ThisServletContextListener.queueUnexpectedErrorLogReceive.send(wi);
		ActionResult<Wo> result = new ActionResult<>();
		Wo wo = new Wo();
		wo.setValue(true);
		result.setData(wo);
		return result;
	}

	public static class Wi extends QueueUnexpectedErrorLogReceive.WiUnexpectedErrorLogReceive {
	}

	public static class Wo extends WrapBoolean {

	}
}
