/** 
 * <pre>项目名称:easyui-1-pm 
 * 文件名称:Log.java 
 * 包名:com.tf.color.model 
 * 创建日期:2018年1月31日下午6:39:36 
 * Copyright (c) 2018, yuxy123@gmail.com All Rights Reserved.</pre> 
 */  
package com.jk.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.Date;

/** 
 * <pre>项目名称：easyui-1-pm    
 * 类名称：Log    
 * 类描述：    
 * 创建人：小飞飞  
 * 创建时间：2018年1月31日 下午6:39:36    
 * 修改人：小飞飞
 * 修改时间：2018年1月31日 下午6:39:36    
 * 修改备注：       
 * @version </pre>    
 */
@Document(collection="shop_logInfo")
public class Log implements Serializable{
	private static final long serialVersionUID = 6534822145330191393L;
	@Id
	private String logid;
	private String url;
	private String httpmethod;
	private String ip;
	private String classmethod;
	private String args;
	private String acttime;

	public String getLogid() {
		return logid;
	}

	public void setLogid(String logid) {
		this.logid = logid;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getHttpmethod() {
		return httpmethod;
	}

	public void setHttpmethod(String httpmethod) {
		this.httpmethod = httpmethod;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getClassmethod() {
		return classmethod;
	}

	public void setClassmethod(String classmethod) {
		this.classmethod = classmethod;
	}

	public String getArgs() {
		return args;
	}

	public void setArgs(String args) {
		this.args = args;
	}

	public String getActtime() {
		return acttime;
	}

	public void setActtime(String acttime) {
		this.acttime = acttime;
	}

	public Log() {
	}

	public Log(String logid, String url, String httpmethod, String ip, String classmethod, String args, String acttime) {
		this.logid = logid;
		this.url = url;
		this.httpmethod = httpmethod;
		this.ip = ip;
		this.classmethod = classmethod;
		this.args = args;
		this.acttime = acttime;
	}

	@Override
	public String toString() {
		return "Log{" +
				"logid='" + logid + '\'' +
				", url='" + url + '\'' +
				", httpmethod='" + httpmethod + '\'' +
				", ip='" + ip + '\'' +
				", classmethod='" + classmethod + '\'' +
				", args='" + args + '\'' +
				", acttime='" + acttime + '\'' +
				'}';
	}
}
