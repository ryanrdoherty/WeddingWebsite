package com.mrfeelings.actions.admin;

import com.mrfeelings.actions.base.WeddingAdminAction;
import com.mrfeelings.db.ContentRetriever;
import com.mrfeelings.db.entities.User;
import com.mrfeelings.db.enums.Page;

public class UpdateUserAction extends WeddingAdminAction {

  private static final long serialVersionUID = 1L;

  private User _user = null;
  
  @Override
  protected String doWork() throws Exception {
    _user = new ContentRetriever().updateUser(_user);
    _user = new ContentRetriever().getUserById(_user.getId());
    return SUCCESS;
  }

  @Override
  protected Page getPage() {
    return Page.UPDATE_USER;
  }
  
  public User getUser() {
    if (_user == null) {
      _user = new User();
    }
    return _user;
  }

}
