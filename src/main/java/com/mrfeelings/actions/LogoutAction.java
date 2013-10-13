package com.mrfeelings.actions;

import java.util.Map;

import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class LogoutAction extends ActionSupport implements SessionAware {

  private static final long serialVersionUID = 1L;

  private SessionMap<String, Object> _session;
  
  @Override
  public String execute() throws Exception {
    _session.invalidate();
    return SUCCESS;
  }
  
  @Override
  public void setSession(Map<String, Object> session) {
    if (session instanceof SessionMap) {
      _session = (SessionMap<String, Object>)session;
    }
  }
}
