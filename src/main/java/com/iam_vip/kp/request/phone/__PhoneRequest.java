/**
 * 
 */
package com.iam_vip.kp.request.phone;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;

import com.iam_vip.kp.logic.iapi.IFuJianService;
import com.iam_vip.kp.logic.iapi.IHeTongService;
import com.iam_vip.kp.request.__Request;

/**
 * @author Colin
 */
public class __PhoneRequest extends __Request {
	
	@Autowired
	protected IFuJianService fuJianService;
	@Autowired
	protected IHeTongService heTongService;

	/**
	 * 
	 */
	public __PhoneRequest() {
	}

	/**
	 * 非空检测
	 * 
	 * @param map
	 *            验证失败返回内容 {"sign":0,"message":"参数有空值!"}
	 * @param param
	 *            任意长度字符串参数
	 * @return true:所有参数均有值 false:部分或全部参数为空
	 */
	protected boolean notEmpty(HttpServletRequest request, Map<String, Object> map, String... param) {

		boolean b = true; /// 默认所有参数非空 ///

		// for (String p : param) {
		//
		// if (b)
		// b = EmptyUtil.notEmpty(p);
		//
		// if (b == false) { /// 如果上一步检测到空参数,则直接break ///
		//
		// map.put(JSON_KEY, 2);
		//
		// /// 国际化消息 ///
		// RequestContext reqCtx = new RequestContext(request);
		// String content = reqCtx.getMessage("parameter_include_null");
		// map.put(JSON_MSG, content);
		// break;
		// }
		// }

		return b;
	}

	/**
	 * 唯一在线验证
	 * 
	 * @param uniqueCode
	 *            唯一登录码
	 * @param phoneUID
	 *            手机用户ID
	 * @param map
	 *            验证失败返回内容 {"sign":4,"message":"检测到您的帐号在其它地方登录,若需继续使用,请重新登录"}
	 * @return 4:其它地方登录 1:正常
	 */
	protected int onlineCheck(HttpServletRequest request, String uniqueCode, int phoneUID, Map<String, Object> map) {
		return this.onlineCheck(request, uniqueCode, phoneUID, map, false);
	}

	protected int onlineCheck(HttpServletRequest request, String uniqueCode, int phoneUID, Map<String, Object> map,
			boolean onlineCanGo) {

		if (onlineCanGo && "009900".equals(uniqueCode) && phoneUID == 0) {
			return 1; /// 非登录请求 ///
		}

		// /// 登录超时,需要重新登录 ///
		// Calendar c = new GregorianCalendar();
		// c.add(Calendar.DATE, 0 - ConstUtil.getMobileAuthorization());
		// String timeline = DTUtil.formatDT(DTUtil.FMT_DEFAULT, new
		// Date(c.getTimeInMillis()));
		// if (one.getTimeline().compareTo(timeline) <= 0) {
		// // System.out.println(one.getTimeline() + " --- " + timeline);
		// map.put(JSON_KEY, 4);
		//
		// /// 国际化消息 ///
		// RequestContext reqCtx = new RequestContext(request);
		// String content = reqCtx.getMessage("login_timeout");
		// map.put(JSON_MSG, content);
		// return 4;
		//
		// }

		return 1;

	}

}
