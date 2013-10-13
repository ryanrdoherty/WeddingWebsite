package com.mrfeelings.actions.admin;

import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.mrfeelings.actions.base.WeddingAdminAction;
import com.mrfeelings.db.ContentRetriever;
import com.mrfeelings.db.entities.User;
import com.mrfeelings.db.enums.Page;

public class ExportUsersAction extends WeddingAdminAction {

  private static final long serialVersionUID = 1L;

  private static final String FILENAME = "users.xls";
  
  private InputStream _excelStream;
  
  @Override
  protected String doWork() throws Exception {
    List<User> users = new ContentRetriever().getAllUsers();
    _excelStream = new UsersInputStream(users);
    return SUCCESS;
  }

  @Override
  protected Page getPage() {
    return Page.EXCEL_EXPORT;
  }

  public String getFilename() {
    return FILENAME;
  }
  
  public InputStream getExcelStream() {
    return _excelStream;
  }
  
  private static class UsersInputStream extends InputStream {

    private static final String DELIM = "\t";
    private static final String NL = System.getProperty("line.separator");
    private static final String[] HEADER = new String[] {
      "ID", "NAME", "DISPLAY_NAME", "PASSCODE", "ADMIN", "ATTENDING",
      "MAX_ADULTS", "NUM_ADULTS", "MAX_KIDS", "NUM_KIDS", "EMAIL", "ADDRESS",
      "CITY", "STATE", "ZIP", "GIFT", "THANKYOU", "COMMENT"
    };
    
    private StringReader _reader;
    
    public UsersInputStream(List<User> users) {
      StringBuilder sb = new StringBuilder().append(StringUtils.join(HEADER, DELIM)).append(NL);
      String[] fields;
      for (User user : users) {
        fields = new String[] {
            String.valueOf(user.getId()),
            user.getName(),
            user.getDisplayName(),
            user.getPassCode(),
            String.valueOf(user.getWriteAccess()),
            user.getAttending().getName(),
            String.valueOf(user.getMaxAdults()),
            String.valueOf(user.getNumAdults()),
            String.valueOf(user.getMaxKids()),
            String.valueOf(user.getNumKids()),
            user.getEmail(),
            user.getAddress(),
            user.getCity(),
            (user.getState() == null ? "" : user.getState().name()),
            user.getZip(),
            user.getGift(),
            String.valueOf(user.getThankyou()),
            user.getRsvpComment().replace("\t", " ")
        };
        sb.append(StringUtils.join(fields, DELIM)).append(NL);
      }
      _reader = new StringReader(sb.toString());
    }
    
    @Override
    public int read() throws IOException {
      return _reader.read();
    }
    
  }
}
