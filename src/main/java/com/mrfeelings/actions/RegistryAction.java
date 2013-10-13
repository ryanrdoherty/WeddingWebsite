package com.mrfeelings.actions;

import com.mrfeelings.Config;
import com.mrfeelings.Config.PropKey;
import com.mrfeelings.actions.base.WeddingAction;
import com.mrfeelings.db.enums.Page;

public class RegistryAction extends WeddingAction {

  private static final long serialVersionUID = 1L;
  
  @Override
  protected String doWork() throws Exception {
    return SUCCESS;
  }

  @Override
  protected Page getPage() {
    return Page.REGISTRY;
  }
  
  @Override
  public String getRequestUrl() {
    return Config.getValue(PropKey.registryUrl);
  }
}
