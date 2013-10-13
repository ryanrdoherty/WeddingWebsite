package com.mrfeelings.actions;

import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.struts2.interceptor.SessionAware;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mrfeelings.actions.base.WeddingAction;
import com.mrfeelings.db.ContentRetriever;
import com.mrfeelings.db.WeddingDbWorker;
import com.mrfeelings.db.entities.User;
import com.mrfeelings.db.enums.Page;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport implements SessionAware {
  
  private static final long serialVersionUID = 1L;

  private static final Logger LOG = LoggerFactory.getLogger(LoginAction.class.getName());
  
  public static final String USER_ID_KEY = "uidKey";
  public static final String REDIRECT = "redirect";
  
  private String _passcode;
  private String _redirectUrl;
  private String _message;
  private Map<String, Object> _session;

  @Override
  public String execute() throws Exception {
    User user = null;
    try {
      if (StringUtils.isEmpty(_passcode) || (user = new ContentRetriever().getUserByPasscode(_passcode)) == null) {
        LOG.info("Empty or invalid passcode submitted.");
        _message = "Incorrect.  Please try again.";
        return WeddingAction.AUTHENTICATE;
      }
    }
    catch (Exception e) {
      LOG.warn("Could not validate passcode: " + _passcode, e);
      _message = "Error: Could not validate passcode (" + e.toString() + ").";
      return WeddingAction.AUTHENTICATE;
    }
    _message = null;
    _session.put(USER_ID_KEY, user.getId());
    WeddingDbWorker.addPageView(Page.LOGIN, user);
    if (StringUtils.isEmpty(_redirectUrl)) {
      LOG.info("Found empty redirect URL, returning 'success'.");
      return SUCCESS;
    }
    LOG.info("Authentication successful; redirecting to " + _redirectUrl);
    return REDIRECT;
  }

  public String getMessage(String message) {
    LOG.info("Page requested message; returning <" + _message + ">.");
    return _message;
  }
  
  public void setPasscode(String passcode) {
    _passcode = passcode;
  }
  
  @Override
  public void setSession(Map<String, Object> session) {
    _session = session;
  }
  
  public void setRequestUrl(String url) {
    _redirectUrl = url;
  }
  
  public String getRequestUrl() {
    return _redirectUrl;
  }
  
}
