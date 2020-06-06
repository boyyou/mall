package com.hjht.mall.three.api.sms;

import com.alibaba.fastjson.JSONObject;
import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import com.hjht.mall.three.api.constant.ThreeCodeConstant;

/**
 * 短信验证码工具类
 * @Date 2020/5/29 15:12
 * @Created by ycl
 */
public class SendSmsUtil {

    /**
     * 发送短信验证码
     * @param phone 手机号
     * @param code 验证码
     * @return
     */
    public static Object sendSms(String phone,String code){
        DefaultProfile profile = DefaultProfile.getProfile("cn-hangzhou", ThreeCodeConstant.ACCESS_KEY_ID, ThreeCodeConstant.ACCESS_KEY_SECRET);
        IAcsClient client = new DefaultAcsClient(profile);

        CommonRequest request = new CommonRequest();
        request.setSysMethod(MethodType.POST);
        request.setSysDomain("dysmsapi.aliyuncs.com");
        request.setSysVersion("2017-05-25");
        request.setSysAction("SendSms");
        request.putQueryParameter("RegionId", "cn-hangzhou");
        request.putQueryParameter("PhoneNumbers", phone);
        request.putQueryParameter("SignName", ThreeCodeConstant.SIGN_NAME);
        request.putQueryParameter("TemplateCode", ThreeCodeConstant.TEMPLATE_CODE);
        request.putQueryParameter("TemplateParam", "{\"code\":\""+code+"\"}");
        try {
            CommonResponse response = client.getCommonResponse(request);
            String data = response.getData();
            JSONObject jsonObject = JSONObject.parseObject(data);
            if ("OK".equals(jsonObject.get("Code")) && "OK".equals(jsonObject.get("Message"))){
                return Boolean.TRUE;
            }else {
                return jsonObject.get("Message");
            }
        } catch (ServerException e) {
            e.printStackTrace();
        } catch (ClientException e) {
            e.printStackTrace();
        }
        return Boolean.FALSE;
    }
}
