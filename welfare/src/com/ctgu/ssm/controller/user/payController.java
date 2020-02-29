package com.ctgu.ssm.controller.user;

import java.io.IOException;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.internal.util.AlipaySignature;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.alipay.api.request.AlipayTradeQueryRequest;
import com.ctgu.ssm.entity.Item;
import com.ctgu.ssm.entity.Support;
import com.ctgu.ssm.entity.User;
import com.ctgu.ssm.service.ActinfoService;
import com.ctgu.ssm.service.AdminService;
import com.ctgu.ssm.service.ApplyService;
import com.ctgu.ssm.service.ItemService;
import com.ctgu.ssm.service.ItemTypeService;
import com.ctgu.ssm.service.OffinfoService;
import com.ctgu.ssm.service.SupportService;
import com.ctgu.ssm.service.UserService;
import com.ctgu.ssm.utils.AlipayConfig;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;


@Controller
public class payController{
	@Autowired
	@Qualifier("adminService")
	private AdminService adminService;

	@Autowired
	@Qualifier("userService")
	private UserService userService;
	
	@Autowired
	@Qualifier("applyService")
	private ApplyService applyService;
	
	@Autowired
	@Qualifier("itemService")
	private ItemService itemService;

	@Autowired
	@Qualifier("itemTypeService")
	private ItemTypeService itemTypeService;

	@Autowired
	@Qualifier("offinfoService")
	private OffinfoService offinfoService;

	@Autowired
	@Qualifier("actinfoService")
	private ActinfoService actinfoService;
	
	@Autowired
	@Qualifier("supportService")
	private SupportService supportService;

	@Autowired
	private HttpSession session;

	// 测试接口
	@ResponseBody
	@RequestMapping("/alipay/testpay")
	public String gettest() {

		System.out.println( "testUser333" );

		return "hello";
	}
	
	/**
	 * 活动捐赠
	 * 支付宝支付
	 * @throws IOException 
	 * 
	 * */
	@ResponseBody
	@RequestMapping(value = "/user/alipay2")
	public String alipay(
			HttpServletRequest request,
			@RequestParam("money") String money,
			@RequestParam("id") String id
			) throws AlipayApiException, IOException {
		User user = (User) session.getAttribute("user");
		System.out.println("-------------------/goods/alipay2-----------------------");
		//获得初始化的AlipayClient
		AlipayClient alipayClient = new DefaultAlipayClient(AlipayConfig.gatewayUrl, AlipayConfig.app_id, AlipayConfig.merchant_private_key, "json", AlipayConfig.charset, AlipayConfig.alipay_public_key, AlipayConfig.sign_type);

		//设置请求参数
		AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();
		alipayRequest.setReturnUrl(AlipayConfig.return_url);
		alipayRequest.setNotifyUrl(AlipayConfig.notify_url);

		//商户订单号，商户网站订单系统中唯一订单号，必填
		String dingdanid = String.valueOf(Calendar.getInstance().getTimeInMillis()) ;
		String out_trade_no = dingdanid;
		//付款金额，必填
		String total_amount = money;
		//订单名称，必填
		String s ="welfare";
		String subject = new String(s.getBytes("ISO-8859-1"),"UTF-8"); ;
		//商品描述，可空
		String body = id + ",";
		if(user == null) {
			System.out.println("您没有登入！-----");
			body += "0"; // 对象为空为匿名捐赠
		}
		else {
			body += "" + user.getId(); // 插入捐赠者id
		}
		
		// 插入物品
		Item item = new Item();
		item.setItemname("爱心捐款");
		item.setItemimg("img\\\\金币.jpg");
		item.setItemcount(0);
		item.setIntroduce("捐赠失败");
		item.setUserid(user.getId());
		item.setTypeid(3);
		item.setAuditid(3);  // 默认失败
		
		itemService.addItem(item);
		
//		item.setItemimg(null);
//		List<Item> item2 = itemService.findItemBySome(item);
//		item = item2.get(0);
		
		// 添加捐赠记录
		Support sup = new Support();
		sup.setDonorid(user.getId());
		sup.setReceiveid(Integer.valueOf(id));
		sup.setItemid(item.getId());
		sup.setItemnum(1);
//		sup.setRemarks("活动捐赠");
		sup.setRemarks(dingdanid);
		sup.setDistin(3);  // 活动捐赠失败
		supportService.addSupport(sup);
		
		alipayRequest.setBizContent("{\"out_trade_no\":\""+ out_trade_no +"\"," 
				+ "\"total_amount\":\""+ total_amount +"\"," 
				+ "\"subject\":\""+ subject +"\"," 
				+ "\"body\":\""+ body +"\"," 
				+ "\"product_code\":\"FAST_INSTANT_TRADE_PAY\"}");

		//请求
		String result = alipayClient.pageExecute(alipayRequest).getBody();

		//输出
		System.out.print("请求 trade.page:----" + result);
		return result;
	}
	/* *
	 * 功能：支付宝服务器同步通知页面
	 * 日期：2019-04-29
	 * 说明：
	 * 以下代码只是为了方便商户测试而提供的样例代码，商户可以根据自己网站的需要，按照技术文档编写,并非一定要使用该代码。
	 * 该代码仅供学习和研究支付宝接口使用，只是提供一个参考。

	 *************************页面功能说明*************************
	 * 该页面仅做页面展示，业务逻辑处理请勿在该页面执行
	 */
	@RequestMapping(value = "/alipay/alipayReturnNotice")
	public ModelAndView alipayReturnNotice(
			HttpServletRequest request,
			HttpServletRequest response) 
					throws Exception { 
		System.out.println("-------------------alipayReturnNotice-----支付宝服务器同步通知页面---------------------");

		//获取支付宝GET过来反馈信息
		Map<String,String> params = new HashMap<String,String>();
		Map<String,String[]> requestParams = request.getParameterMap();
		for (Iterator<String> iter = requestParams.keySet().iterator(); iter.hasNext();) {
			String name = (String) iter.next();
			String[] values = (String[]) requestParams.get(name);
			String valueStr = "";
			for (int i = 0; i < values.length; i++) {
				valueStr = (i == values.length - 1) ? valueStr + values[i]
						: valueStr + values[i] + ",";
			}
			//乱码解决，这段代码在出现乱码时使用
			valueStr = new String(valueStr.getBytes("ISO-8859-1"), "utf-8");
			params.put(name, valueStr);
		}

		boolean signVerified = AlipaySignature.rsaCheckV1(params, AlipayConfig.alipay_public_key, AlipayConfig.charset, AlipayConfig.sign_type); //调用SDK验证签名

//		ModelAndView mv = new ModelAndView("/user/pay/alipaySuccess");
		//——请在这里编写您的程序（以下代码仅作参考）——
		int flag = 1;
		if(signVerified) {
			//商户订单号
			String out_trade_no = new String(request.getParameter("out_trade_no").getBytes("ISO-8859-1"),"UTF-8");

			//支付宝交易号
			String trade_no = new String(request.getParameter("trade_no").getBytes("ISO-8859-1"),"UTF-8");

			//付款金额
			String total_amount = new String(request.getParameter("total_amount").getBytes("ISO-8859-1"),"UTF-8");
			
			//得到活动id 和 用户id
//			String body = new String(request.getParameter("body").getBytes("ISO-8859-1"),"UTF-8");
//			System.out.println("得到活动id 和 用户id: " + body);

//			mv.addObject("out_trade_no", out_trade_no);
//			mv.addObject("trade_no", trade_no);
//			mv.addObject("total_amount", total_amount);
			
			System.out.println("验签成功");
			System.out.println("trade_no:" + trade_no + "  out_trade_no:" +out_trade_no+ "  total_amount:" + total_amount);

			//查询订单是否支付成功：
			Thread.sleep(1000);  //1000毫秒就是1秒
//			String rt = TradeQuery(out_trade_no, null);
			String rt = TradeQuery(null, trade_no);
			
			if(rt == "1") {
				Support sup = supportService.findByRemarks(out_trade_no);
				sup.setDistin(1);   // 官方活动捐赠成功
				supportService.updateSupport(sup);
				Item item = itemService.findById(sup.getItemid());
				item.setAuditid(2); // 审核成功
				flag = sup.getReceiveid();
				item.setIntroduce("爱心捐助成功");
				itemService.updateItem(item);
				System.out.println("------------支付成功！");
			}
			else {
				flag = 0;
				System.out.println("------------支付失败！");
			}
		}
		//——请在这里编写您的程序（以上代码仅作参考）——
		ModelAndView mv;
		System.out.println("编号：" + flag);
		if(flag != -1 && flag != 0) {
			mv = new ModelAndView("redirect:/user/actinfoDetail?id="+flag);
		}
		else {
			mv = new ModelAndView("redirect:/user/activity");
		}
		return mv;
	}
	
	/**
	 *
	 * @Title: AlipayController.java
	 * @Package com.sihai.controller
	 * @Description: 支付宝异步 通知页面
	 * @author sihai
	 * @date 2019-04-29 
	 * @version V1.0
	 */
	@RequestMapping(value = "/alipay/alipayNotifyNotice")
	@ResponseBody
	public String alipayNotifyNotice(
			HttpServletRequest request,
			HttpServletRequest response) 
					throws Exception {

		/*************************页面功能说明*************************
		 * 创建该页面文件时，请留心该页面文件中无任何HTML代码及空格。
		 * 该页面不能在本机电脑测试，请到服务器上做测试。请确保外部可以访问该页面。
		 * 如果没有收到该页面返回的 success 
		 * 建议该页面只做支付成功的业务逻辑处理，退款的处理请以调用退款查询接口的结果为准。
		 */
		
		System.out.println("-----------------alipayNotifyNotice-测试-------------------------");
		//获取支付宝POST过来反馈信息
		Map<String,String> params = new HashMap<String,String>();
		Map<String,String[]> requestParams = request.getParameterMap();
		for (Iterator<String> iter = requestParams.keySet().iterator(); iter.hasNext();) {
			String name = (String) iter.next();
			String[] values = (String[]) requestParams.get(name);
			String valueStr = "";
			for (int i = 0; i < values.length; i++) {
				valueStr = (i == values.length - 1) ? valueStr + values[i]
						: valueStr + values[i] + ",";
			}
			//乱码解决，这段代码在出现乱码时使用
			valueStr = new String(valueStr.getBytes("ISO-8859-1"), "utf-8");
			params.put(name, valueStr);
		}

		boolean signVerified = AlipaySignature.rsaCheckV1(params, AlipayConfig.alipay_public_key, AlipayConfig.charset, AlipayConfig.sign_type); //调用SDK验证签名

		//——请在这里编写您的程序（以下代码仅作参考）——

		/* 实际验证过程建议商户务必添加以下校验：
			1、需要验证该通知数据中的out_trade_no是否为商户系统中创建的订单号，
			2、判断total_amount是否确实为该订单的实际金额（即商户订单创建时的金额），
			3、校验通知中的seller_id（或者seller_email) 是否为out_trade_no这笔单据的对应的操作方（有的时候，一个商户可能有多个seller_id/seller_email）
			4、验证app_id是否为该商户本身。
		 */
		if(signVerified) {//验证成功
			//商户订单号
			String out_trade_no = new String(request.getParameter("out_trade_no").getBytes("ISO-8859-1"),"UTF-8");

			//支付宝交易号
			String trade_no = new String(request.getParameter("trade_no").getBytes("ISO-8859-1"),"UTF-8");

			//交易状态
			String trade_status = new String(request.getParameter("trade_status").getBytes("ISO-8859-1"),"UTF-8");

			if(trade_status.equals("TRADE_FINISHED")){
				//判断该笔订单是否在商户网站中已经做过处理
				//如果没有做过处理，根据订单号（out_trade_no）在商户网站的订单系统中查到该笔订单的详细，并执行商户的业务程序
				//如果有做过处理，不执行商户的业务程序

				//注意：
				//退款日期超过可退款期限后（如三个月可退款），支付宝系统发送该交易状态通知
			}else if (trade_status.equals("TRADE_SUCCESS")){
				//判断该笔订单是否在商户网站中已经做过处理
				//如果没有做过处理，根据订单号（out_trade_no）在商户网站的订单系统中查到该笔订单的详细，并执行商户的业务程序
				//如果有做过处理，不执行商户的业务程序

				//注意：
				//付款完成后，支付宝系统发送该交易状态通知
			}

			System.out.println("success");

		}else {//验证失败
			System.out.println("fail");

			//调试用，写文本函数记录程序运行情况是否正常
			//String sWord = AlipaySignature.getSignCheckContentV1(params);
			//AlipayConfig.logResult(sWord);
		}

		//——请在这里编写您的程序（以上代码仅作参考）——

		return "success";
	}
		
	/**
	 * 查询支付宝结果
	 * 参数：订单号或支付宝订单号，二选一
	 * 返回状态
	 * **/
	public String TradeQuery(String WIDTQout_trade_no, String WIDTQtrade_no) {
		
		//获得初始化的AlipayClient
		AlipayClient alipayClient = new DefaultAlipayClient(AlipayConfig.gatewayUrl, AlipayConfig.app_id, AlipayConfig.merchant_private_key, "json", AlipayConfig.charset, AlipayConfig.alipay_public_key, AlipayConfig.sign_type);
		
		//设置请求参数
		AlipayTradeQueryRequest alipayRequest = new AlipayTradeQueryRequest();
		
		//商户订单号，商户网站订单系统中唯一订单号
		String out_trade_no = WIDTQout_trade_no ;
		//支付宝交易号
		String trade_no = WIDTQtrade_no;
		//请二选一设置
		
		alipayRequest.setBizContent("{\"out_trade_no\":\""+ out_trade_no +"\","+"\"trade_no\":\""+ trade_no +"\"}");
		
		//请求
		String result;
		try {
			result = alipayClient.execute(alipayRequest).getBody();
			
			JsonObject returnData = new JsonParser().parse(result).getAsJsonObject(); 
			
			System.out.println("--------------支付结果查询-----------------------------");
			System.out.println(returnData);
			System.out.println(returnData.get("alipay_trade_query_response"));
			JsonObject returnData2 = new JsonParser().parse(returnData.get("alipay_trade_query_response").toString()).getAsJsonObject();
			String isSu = returnData2.get("msg").toString();
			System.out.println("返回信息： " + isSu);
			if("\"Success\"".equals(isSu)) {
				return "1"; 
			}
		} catch (AlipayApiException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "0"; //查询成功
	}
	 
	/**
	 * 个人求助捐赠
	 * 支付宝支付
	 * @throws IOException 
	 * 
	 * */
	@ResponseBody
	@RequestMapping(value = "/user/alipay3")
	public String alipay3(
			HttpServletRequest request,
			@RequestParam("money") String money,
			@RequestParam("id") String id
			) throws AlipayApiException, IOException {
		User user = (User) session.getAttribute("user");
		System.out.println("-------------------/goods/alipay3333-----------------------");
		//获得初始化的AlipayClient
		AlipayClient alipayClient = new DefaultAlipayClient(AlipayConfig.gatewayUrl, AlipayConfig.app_id, AlipayConfig.merchant_private_key, "json", AlipayConfig.charset, AlipayConfig.alipay_public_key, AlipayConfig.sign_type);

		//设置请求参数
		AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();
		alipayRequest.setReturnUrl(AlipayConfig.return_url2);
		alipayRequest.setNotifyUrl(AlipayConfig.notify_url2);

		//商户订单号，商户网站订单系统中唯一订单号，必填
		String dingdanid = String.valueOf(Calendar.getInstance().getTimeInMillis()) ;
		String out_trade_no = dingdanid;
		//付款金额，必填
		String total_amount = money;
		//订单名称，必填
		String s ="welfare2";
		String subject = new String(s.getBytes("ISO-8859-1"),"UTF-8"); ;
		//商品描述，可空
		String body = id + ",";
		if(user == null) {
			System.out.println("您没有登入！-----");
			body += "0"; // 对象为空为匿名捐赠
		}
		else {
			body += "" + user.getId(); // 插入捐赠者id
		}
		
		// 插入物品
		Item item = new Item();
		item.setItemname("爱心捐款");
		item.setItemimg("img\\\\金币.jpg");
		item.setItemcount(0);
		item.setIntroduce("捐赠失败");
		item.setUserid(user.getId());
		item.setTypeid(3);   
		item.setAuditid(3);  // 默认失败
		
		System.out.println("添加对象");
		itemService.addItem(item);
		System.out.println("对象：" + item);
//		int ys = item.getId();
//		System.out.println("返回的主键：" + ys);
//		item.setItemimg(null);
//		List<Item> item2 = itemService.findItemBySome(item);
//		item = item2.get(0);
		
		// 添加捐赠记录
		Support sup = new Support();
		sup.setDonorid(user.getId());
		sup.setReceiveid(Integer.valueOf(id));
		sup.setItemid(item.getId());
		sup.setItemnum(1);
//		sup.setRemarks("活动捐赠");
		sup.setRemarks(dingdanid);
		sup.setDistin(3);  // 活动捐赠失败
		supportService.addSupport(sup);
		
		alipayRequest.setBizContent("{\"out_trade_no\":\""+ out_trade_no +"\"," 
				+ "\"total_amount\":\""+ total_amount +"\"," 
				+ "\"subject\":\""+ subject +"\"," 
				+ "\"body\":\""+ body +"\"," 
				+ "\"product_code\":\"FAST_INSTANT_TRADE_PAY\"}");

		//请求
		String result = alipayClient.pageExecute(alipayRequest).getBody();

		//输出
		System.out.print("个人求助捐赠---请求 trade.page:----" + result);
		return result;
	}
	/* *
	 * 功能：支付宝服务器同步通知页面
	 * 日期：2019-04-29
	 * 说明：
	 * 以下代码只是为了方便商户测试而提供的样例代码，商户可以根据自己网站的需要，按照技术文档编写,并非一定要使用该代码。
	 * 该代码仅供学习和研究支付宝接口使用，只是提供一个参考。

	 *************************页面功能说明*************************
	 * 该页面仅做页面展示，业务逻辑处理请勿在该页面执行
	 */
	@RequestMapping(value = "/alipay/alipayReturnNotice2")
	public ModelAndView alipayReturnNotice2(
			HttpServletRequest request,
			HttpServletRequest response) 
					throws Exception { 
		System.out.println("-------------------alipayReturnNotice-----支付宝服务器同步通知页面---------------------");

		//获取支付宝GET过来反馈信息
		Map<String,String> params = new HashMap<String,String>();
		Map<String,String[]> requestParams = request.getParameterMap();
		for (Iterator<String> iter = requestParams.keySet().iterator(); iter.hasNext();) {
			String name = (String) iter.next();
			String[] values = (String[]) requestParams.get(name);
			String valueStr = "";
			for (int i = 0; i < values.length; i++) {
				valueStr = (i == values.length - 1) ? valueStr + values[i]
						: valueStr + values[i] + ",";
			}
			//乱码解决，这段代码在出现乱码时使用
			valueStr = new String(valueStr.getBytes("ISO-8859-1"), "utf-8");
			params.put(name, valueStr);
		}

		boolean signVerified = AlipaySignature.rsaCheckV1(params, AlipayConfig.alipay_public_key, AlipayConfig.charset, AlipayConfig.sign_type); //调用SDK验证签名

		
		//——请在这里编写您的程序（以下代码仅作参考）——
		int flag = -1;
		if(signVerified) {
			//商户订单号
			String out_trade_no = new String(request.getParameter("out_trade_no").getBytes("ISO-8859-1"),"UTF-8");

			//支付宝交易号
			String trade_no = new String(request.getParameter("trade_no").getBytes("ISO-8859-1"),"UTF-8");

			//付款金额
			String total_amount = new String(request.getParameter("total_amount").getBytes("ISO-8859-1"),"UTF-8");
			
			//得到活动id 和 用户id
//			String body = new String(request.getParameter("body").getBytes("ISO-8859-1"),"UTF-8");
//			System.out.println("得到活动id 和 用户id: " + body);

//			mv.addObject("out_trade_no", out_trade_no);
//			mv.addObject("trade_no", trade_no);
//			mv.addObject("total_amount", total_amount);
			
			System.out.println("验签成功");
			System.out.println("trade_no:" + trade_no + "  out_trade_no:" +out_trade_no+ "  total_amount:" + total_amount);

			//查询订单是否支付成功：
			Thread.sleep(1000);  //1000毫秒就是1秒
//			String rt = TradeQuery(out_trade_no, null);
			String rt = TradeQuery(null, trade_no);
			
			if(rt == "1") {  // 如果付款成功
				Support sup = supportService.findByRemarks(out_trade_no);
				sup.setDistin(4);   // 个人活动捐赠成功
				supportService.updateSupport(sup);
				Item item = itemService.findById(sup.getItemid());
				item.setAuditid(2); // 审核成功
				item.setIntroduce("爱心捐助成功");
				itemService.updateItem(item);
				flag = sup.getReceiveid();
				System.out.println("------------支付成功！");
			}
			else {
				flag = 0;
				System.out.println("------------支付失败！");
			}
		}
		//——请在这里编写您的程序（以上代码仅作参考）——
		System.out.println("编号：" + flag);
		ModelAndView mv;
		if(flag != -1 && flag != 0) {
			mv = new ModelAndView("redirect:/user/helpDetial?id="+flag);
		}
		else {
			mv = new ModelAndView("redirect:/user/helps");
		}
		return mv;
	}
	
	
}
