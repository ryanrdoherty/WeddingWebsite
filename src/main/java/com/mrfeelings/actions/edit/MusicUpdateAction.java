package com.mrfeelings.actions.edit;

import com.mrfeelings.actions.base.WeddingAction;
import com.mrfeelings.db.enums.Page;

public class MusicUpdateAction extends WeddingAction {

  private static final long serialVersionUID = 1L;

  @Override
  protected String doWork() throws Exception {
    return SUCCESS;
  }

  @Override
  protected boolean requiresLogin() {
    return true;
  }

  @Override
  protected Page getPage() {
    return Page.MUSIC_UPDATE;
  }

}
