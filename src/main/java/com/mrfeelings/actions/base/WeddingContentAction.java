package com.mrfeelings.actions.base;

import com.mrfeelings.db.ContentRetriever;
import com.mrfeelings.db.enums.ContentType;

public abstract class WeddingContentAction extends WeddingAction {

  private static final long serialVersionUID = 1L;

  protected abstract ContentType getContentType();
  
  private String _data;
  
  @Override
  protected String doWork() throws Exception {
    _data = new ContentRetriever().getContentData(getContentType());
    return SUCCESS;
  }
  
  public String getTitle() {
    return getContentType().getTitle();
  }
  
  public String getData() {
    return convertToHtml(_data);
  }
}
