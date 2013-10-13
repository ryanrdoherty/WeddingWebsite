package com.mrfeelings.actions.edit;

import com.mrfeelings.MailUtil;
import com.mrfeelings.actions.base.WeddingAction;
import com.mrfeelings.db.enums.Page;

public class ContactUpdateAction extends WeddingAction {

  private static final long serialVersionUID = 1L;

  private String _subject;
  private String _message;
  
  @Override
  protected String doWork() throws Exception {
    MailUtil.sendMail(getCurrentUser(), _subject, _message);
    return SUCCESS;
  }

  @Override
  protected Page getPage() {
    return Page.CONTACT_UPDATE;
  }

  @Override
  protected boolean requiresLogin() {
    return true;
  }

  public void setSubject(String subject) {
    _subject = subject;
  }
  
  public void setMessage(String message) {
    _message = message;
  }  
}
