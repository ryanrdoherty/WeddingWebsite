package com.mrfeelings.db;

import java.util.Arrays;

import com.mrfeelings.db.entities.GuestbookEntry;
import com.mrfeelings.db.entities.PageStat;
import com.mrfeelings.db.entities.PageView;
import com.mrfeelings.db.entities.User;

import edu.upenn.bbl.common.jpa.DdlScriptCreator;

/**
 * SQL Creator for Tables according to JPA/Hibernate annotations.
 */
public class ScriptCreator {

    private static final Class<?>[] ENTITIES = new Class<?>[] {
    	GuestbookEntry.class, PageView.class, User.class, PageStat.class
    };
    
    public static void main(String[] args) {
        DdlScriptCreator scripter = new DdlScriptCreator(Arrays.asList(ENTITIES));
        System.out.println(scripter.createTablesScript());
    }
}

