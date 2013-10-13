package com.mrfeelings.actions.base;

public abstract class WeddingAdminAction extends WeddingAction {

  private static final long serialVersionUID = 1L;

  @Override
  protected boolean requiresWriteAccess() {
    return true;
  }
  
  @Override
  protected boolean requiresLogin() {
    return true;
  }
}
