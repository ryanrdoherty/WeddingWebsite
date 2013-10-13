package com.mrfeelings.actions.admin;

import java.io.File;

import com.mrfeelings.PhotoManager;
import com.mrfeelings.actions.base.WeddingAdminAction;
import com.mrfeelings.db.enums.Page;

public class UploadPhotoAction extends WeddingAdminAction {

  private static final long serialVersionUID = 1L;

  private File _file;
  private String _filename;
  
  @Override
  protected String doWork() throws Exception {
    if (_file == null || !_file.isFile() || !isImageFile(_filename)) {
      return SUCCESS;
    }
    PhotoManager.saveImage(_file, _filename);
    return SUCCESS;
  }

  private boolean isImageFile(String filename) {
    String lower = filename.toLowerCase();
    return (lower.endsWith(".jpg") || lower.endsWith(".gif") || lower.endsWith(".png"));
  }

  @Override
  protected Page getPage() {
    return Page.UPLOAD_PHOTO;
  }
  
  public void setPhoto(File file) {
    _file = file;
  }
  
  public void setPhotoFileName(String filename) {
    _filename = filename;
  }

}
