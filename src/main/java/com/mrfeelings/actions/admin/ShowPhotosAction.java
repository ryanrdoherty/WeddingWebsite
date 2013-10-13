package com.mrfeelings.actions.admin;

import java.util.List;

import com.mrfeelings.PhotoManager;
import com.mrfeelings.actions.base.WeddingAdminAction;
import com.mrfeelings.db.enums.Page;

public class ShowPhotosAction extends WeddingAdminAction {

  private static final long serialVersionUID = 1L;

  private List<String> _photos;
  
  @Override
  protected String doWork() throws Exception {
    _photos = PhotoManager.getImageNames();
    return SUCCESS;
  }

  @Override
  protected Page getPage() {
    return Page.SHOW_PHOTOS;
  }

  public List<String> getPhotos() {
    return _photos;
  }
}
