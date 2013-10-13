package com.mrfeelings;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mrfeelings.Config.PropKey;
import com.mrfeelings.db.DataException;

public class PhotoManager {

  private static final Logger LOG = LoggerFactory.getLogger(PhotoManager.class.getName());
  
  public static synchronized List<String> getImageNames() throws DataException {
    String imagesDir = Config.getValue(PropKey.imagesDir);
    LOG.debug("Found configured value of " + imagesDir + " to look up images.");
    File f = new File(imagesDir);
    String[] files = f.list();
    LOG.debug("Looked in " + f.getAbsolutePath() + " and found " + files.length + " uploaded files.");
    return Arrays.asList(files);
  }

  public static synchronized void saveImage(File file, String filename) throws DataException {
    try {
      LOG.info("Will save " + file.getAbsolutePath() + " as " + filename);
      File destFile = new File(Config.getValue(PropKey.imagesDir) + "/" + filename);
      FileUtils.copyFile(file, destFile);
    }
    catch(IOException ioe) {
      throw new DataException(ioe);
    }
  }

}
