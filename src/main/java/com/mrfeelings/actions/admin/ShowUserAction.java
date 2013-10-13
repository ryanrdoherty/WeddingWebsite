package com.mrfeelings.actions.admin;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mrfeelings.actions.base.WeddingAdminAction;
import com.mrfeelings.db.ContentRetriever;
import com.mrfeelings.db.entities.User;
import com.mrfeelings.db.enums.Page;

public class ShowUserAction extends WeddingAdminAction {

  private static final long serialVersionUID = 1L;

  private static final Logger LOG = LoggerFactory.getLogger(ShowUserAction.class.getName());
  
  private Long _id;
  private User _user;
  
  @Override
  protected String doWork() throws Exception {
    if (_id == null || (_user = new ContentRetriever().getUserById(_id)) == null) {
      _user = new User();
    }
    return SUCCESS;
  }

  @Override
  protected Page getPage() {
    return Page.VIEW_USER;
  }
  
  public void setUserId(String id) {
    try {
      _id = Long.parseLong(id);
    }
    catch (NumberFormatException pe) {
      LOG.error("Unable to convert id to long: " + id, pe);
    }
  }

  public User getUser() {
    return _user;
  }
}
