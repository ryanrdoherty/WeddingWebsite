package com.mrfeelings.actions.admin;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.conical.common.bbl.enums.State;

import com.mrfeelings.Config;
import com.mrfeelings.Config.PropKey;
import com.mrfeelings.actions.base.WeddingAdminAction;
import com.mrfeelings.db.WeddingDataManager;
import com.mrfeelings.db.WeddingDbWorker;
import com.mrfeelings.db.entities.User;
import com.mrfeelings.db.enums.Page;

public class UploadUsersAction extends WeddingAdminAction {

  private static final long serialVersionUID = 1L;
  
  private List<String> _errors = new ArrayList<String>();
  
  private User _user;
  
  @Override
  protected String doWork() throws Exception {
    try (BufferedReader br = new BufferedReader(new FileReader(Config.getValue(PropKey.userDataFile)))) {
      if (br.ready()) br.readLine(); // header
      while (br.ready()) {
        String line = br.readLine();
        String[] tokens = line.split("\t");
        if (tokens.length != 11) {
          _errors.add("Wrong # of tokens (" + tokens.length + "): " + line);
          continue;
        }
        _user = new User();
        _user.setName(tokens[0]);
        _user.setAddress(tokens[5]);
        _user.setCity(tokens[6]);
        _user.setState((StringUtils.isEmpty(tokens[7]) ? null : State.valueOf(tokens[7])));
        _user.setZip(tokens[8]);
        _user.setEmail(tokens[9]);
        _user.setPassCode(tokens[10]);
        
        new WeddingDbWorker() {
          @Override public void doDbTasks(WeddingDataManager dataMgr) {
            dataMgr.saveObject(_user);
          }
        }.doWork();
      }
      return SUCCESS;
    }
  }

  @Override
  protected Page getPage() {
    return Page.UPLOAD_USERS;
  }  
}
