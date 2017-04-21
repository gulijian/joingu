package com.gulj.common.util;

import java.io.UnsupportedEncodingException;

public enum FeijianCode {
	
	
		SAVE_SUCCESS("0001","保存成功"),
	    SAVE_ERROR("0002","保存失败"),
	    UPDATE_SUCCESS("0003","修改成功"),
	    UPDATE_ERROR("0004","修改失败"),
	    DELETE_SUCCESS("0005","删除成功"),
	    DELETE_ERROR("0006","删除失败"),
		USERORPWD_ERROR("0007","用户名或者密码不正确"),
		USEROR_ERROR("0008","账号不存在"),
		USER_FIBINDDEN_ERROR("0009","账号被禁止"),
		CODE_ERROR("0010","验证码不正确"),
	    USER_EXIST_ERROR("0011","帐号已存在"),
		USEROR_LOGIN_SUCCESS("0012","登录成功"),
		USEROR_NONE_TOP_MENU("0013","无顶级菜单，请联系系统管理员进行权限分配"),
	    USEROR_NONE_CHILD_MENU("0014","无子级菜单，请联系系统管理员进行权限分配"),
	    SYS_EXCEPTION("1100","系统异常"),;

	    /** 错误码 */
	    private final String code;
	    /** 错误吗对应描述信息 */
	    private final String info;

	    FeijianCode(String code, String info) {
	        this.code = code;
	        this.info = info;
	    }

	    public String getCode() {
	        return code;
	    }

	    public String getInfo() {
	        return info;
	    }
	    
	    
		@SuppressWarnings("finally")
		@Override
	    public String toString() {
			String result = "{\"code\":"+"\""+this.code+"\""+",\"message\":"+"\""+this.info+"\""+"}";
	        try {
	        	result = new String(result.getBytes("utf-8"), "utf-8");
			} catch (UnsupportedEncodingException e) {
				result = e.getMessage();
				e.printStackTrace();
			}
	        finally{
	        	return result;
	        }
	    }

}
