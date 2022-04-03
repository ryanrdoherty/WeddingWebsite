package com.mrfeelings.db.enums;

import org.conical.common.bbl.enums.ifc.Described;
import org.conical.common.bbl.enums.ifc.Named;

public enum RsvpType implements Named, Described {
  UNKNOWN ("Undecided"),
  YES ("Yes!"),
  NO ("No");

  private String _description;
  
  private RsvpType(String description) {
    _description = description;
  }
  
  public boolean getIsYes() { return this.equals(RsvpType.YES); }
  public boolean getIsNo() { return this.equals(RsvpType.NO); }
  
  @Override
  public String getDescription() {
    return _description;
  }

  @Override
  public String getName() {
    return name();
  }
}
