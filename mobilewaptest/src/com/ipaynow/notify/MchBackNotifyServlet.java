package com.ipaynow.notify;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipaynow.utils.FormDateReportConvertor;
import com.ipaynow.utils.MD5Facade;

/**
 * 服务器端异步通知商户Servlet
 * @author christ
 *
 */
public class MchBackNotifyServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2358940163943334363L;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//获取通知数据需要从body中流式读取
		BufferedReader reader = req.getReader();
		StringBuilder reportBuilder = new StringBuilder();
		String tempStr = "";
		while((tempStr = reader.readLine()) != null){
			reportBuilder.append(tempStr);
		}		
		String reportContent = reportBuilder.toString();		
		Map<String,String> dataMap = FormDateReportConvertor.parseFormDataPatternReportWithDecode(reportContent, "UTF-8", "UTF-8");
		
		//去除签名类型和签名值
        dataMap.remove("signType");
        String signature = dataMap.remove("signature");

        //拿到自己应用的md5Key
        InputStream propertiesInput = Thread.currentThread().getContextClassLoader().getResourceAsStream("config.properties");
        Properties properties = new Properties();
        properties.load(propertiesInput);
        String md5Key = (String) properties.get("md5Key");
        //验证签名
        boolean isValidSignature = MD5Facade.validateFormDataParamMD5(dataMap,md5Key,signature);

        System.out.println("验签结果："+isValidSignature);

        //一定要返回
        if(isValidSignature)
            resp.getOutputStream().write("success=Y".getBytes());
        else
        	resp.getOutputStream().write("success=N".getBytes());
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

}