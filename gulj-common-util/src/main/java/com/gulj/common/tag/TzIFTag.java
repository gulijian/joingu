package com.gulj.common.tag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

/**
 * 
 * TzIFTag
 * 创建人:gulj 
 * 时间：2015年9月19日-下午11:28:46 
 * @version 1.0.0
 * 
 */
public class TzIFTag extends TagSupport{
	
	private Boolean test;

	public Boolean getTest() {
		return test;
	}

	public void setTest(Boolean test) {
		this.test = test;
	}

	@Override
	public int doStartTag() throws JspException {
		return EVAL_BODY_INCLUDE;//继续去执行标签提的内容
		//SKIP_BODY====默认值就是skip_body---忽略标签提直接进入doEndTag()
	}
	
}
