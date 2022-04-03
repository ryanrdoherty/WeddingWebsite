package com.mrfeelings.actions.base;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.mrfeelings.actions.LoginAction;
import com.mrfeelings.db.WeddingDataManager;
import com.mrfeelings.db.WeddingDbWorker;
import com.mrfeelings.db.entities.User;
import com.mrfeelings.db.enums.Page;
import com.mrfeelings.db.enums.RsvpType;
import com.opensymphony.xwork2.ActionSupport;

import org.conical.common.bbl.enums.State;

public abstract class WeddingAction extends ActionSupport implements SessionAware, ServletRequestAware {

  private static final Logger LOG = LogManager.getLogger(WeddingAction.class);

  private static final long serialVersionUID = 1L;

  public static final String AUTHENTICATE = "authenticate";
  public static final String PERMISSION_DENIED = "permissionDenied";
  public static final String REDIRECT = "redirect";

  private String _originalRequestUrl;
  private User _currentUser;
  private Exception _exception;
  
  protected abstract String doWork() throws Exception;
  protected abstract Page getPage();
  
  @Override
  public String execute() throws Exception {
    if (_exception != null) throw new Exception(_exception);
    if (requiresLogin() && _currentUser == null) {
      return AUTHENTICATE;
    }
    WeddingDbWorker.addPageView(getPage(), _currentUser);
    if (requiresWriteAccess() && (_currentUser == null || !_currentUser.getWriteAccess())) {
      return PERMISSION_DENIED;
    }
    return doWork();
  }

  protected boolean requiresLogin() {
    return false;
  }

  protected boolean requiresWriteAccess() {
    return false;
  }

  public User getCurrentUser() {
    return _currentUser;
  }
  
  @Override
  public void setSession(Map<String, Object> session) {
    final Long userId = (Long)session.get(LoginAction.USER_ID_KEY);
    if (userId != null) {
      try {
        new WeddingDbWorker() { @Override public void doDbTasks(WeddingDataManager dataMgr) {
          _currentUser = dataMgr.findById(User.class, userId);
        }}.doWork();
      } catch (Exception e) {
        _exception = e;
      }
    }
  }
  
  @Override
  public void setServletRequest(HttpServletRequest request) {
    _originalRequestUrl = request.getRequestURL().toString();
    if (request.getQueryString() != null) {
            _originalRequestUrl += "?" + request.getQueryString();
    }
    LOG.debug("Have set request url to: " + _originalRequestUrl);
  }
  
  public String getRequestUrl() {
    return _originalRequestUrl;
  }
  
  public boolean getIsAdmin() {
    return (_currentUser != null && _currentUser.getWriteAccess());
  }
  
  public boolean getLoggedIn() {
    return (_currentUser != null);
  }
  
  protected String convertToHtml(String str) {
    return str;
  }
  
  public List<State> getStates() {
    return Arrays.asList(State.values());
  }
  
  public List<RsvpType> getRsvpTypes() {
    return Arrays.asList(RsvpType.values());
  }
}
