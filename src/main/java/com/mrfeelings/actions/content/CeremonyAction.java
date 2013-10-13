package com.mrfeelings.actions.content;

import com.mrfeelings.actions.base.WeddingContentAction;
import com.mrfeelings.db.enums.ContentType;
import com.mrfeelings.db.enums.Page;

public class CeremonyAction extends WeddingContentAction {

  private static final long serialVersionUID = 1L;

  @Override
  protected Page getPage() {
    return Page.CEREMONY;
  }

  @Override
  protected ContentType getContentType() {
    return ContentType.CEREMONY;
  }
  

}
