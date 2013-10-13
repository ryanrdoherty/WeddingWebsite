package com.mrfeelings.actions.content;

import com.mrfeelings.actions.base.WeddingContentAction;
import com.mrfeelings.db.enums.ContentType;
import com.mrfeelings.db.enums.Page;

public class HotelsAction extends WeddingContentAction {

  private static final long serialVersionUID = 1L;

  @Override
  protected Page getPage() {
    return Page.ACCOMMODATIONS;
  }

  @Override
  protected ContentType getContentType() {
    return ContentType.ACCOMMODATIONS;
  }

}
