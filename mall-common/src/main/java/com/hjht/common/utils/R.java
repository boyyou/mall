/**
 * Copyright (c) 2016-2019 人人开源 All rights reserved.
 *
 * https://www.renren.io
 *
 * 版权所有，侵权必究！
 */

package com.hjht.common.utils;

import com.hjht.common.constant.CodeConstant;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * 返回数据
 *
 * @author ycl
 */
public class R<T> implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 返回编码
	 */
	@Getter
	@Setter
	@ApiModelProperty("应答状态码0-成功1-失败")
	private int code;

	/**
	 * 返回消息
	 */
	@Getter
	@Setter
	@ApiModelProperty("应答消息")
	private String message;

	/**
	 * 返回数据
	 */
	@Getter
	@Setter
	@ApiModelProperty("数据")
	private T data;

	
	public static R ok() {
		return setResult(CodeConstant.SUCCESS,CodeConstant.OK_MSG,null);
	}


	public static <T> R ok(String msg,T data) {
		return setResult(CodeConstant.SUCCESS,msg,data);
	}

	public static <T> R ok(T data) {
		return setResult(CodeConstant.SUCCESS,CodeConstant.OK_MSG,data);
	}

	public static <T> R ok(int code,String message,T data) {
		return setResult(code,message,data);
	}

	public static R ok(int code,String message) {
		return setResult(code,message,null);
	}

	public static R fail() {
		return setResult(CodeConstant.FAIL,CodeConstant.FAIL_MSG,null);
	}

	public static R fail(String message) {
		return setResult(CodeConstant.FAIL,message,null);
	}


	public static <T> R fail(String msg,T data) {
		return setResult(CodeConstant.FAIL,msg,data);
	}

	public static <T> R fail(T data) {
		return setResult(CodeConstant.FAIL,CodeConstant.FAIL_MSG,data);
	}

	public static <T> R fail(int code,String message,T data) {
		return setResult(code,message,data);
	}

	public static R fail(int code,String message) {
		return setResult(code,message,null);
	}



	private static <T> R<T> setResult(int code,String message,T data){
		R<T> result = new R();
		result.setCode(code);
		result.setMessage(message);
		result.setData(data);
		return result;
	}
}
