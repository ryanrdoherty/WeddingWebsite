package com.mrfeelings.actions;

import com.mrfeelings.actions.base.WeddingAction;
import com.mrfeelings.db.enums.Page;

public class ThanksAction extends WeddingAction {

  private static final long serialVersionUID = 1L;

  @Override
  protected String doWork() throws Exception {
    return SUCCESS;
  }

  @Override
  protected Page getPage() {
    return Page.THANKS;
  }

}
