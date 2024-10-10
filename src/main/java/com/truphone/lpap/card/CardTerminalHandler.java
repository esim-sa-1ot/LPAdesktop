/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.truphone.lpap.card;

import java.security.NoSuchAlgorithmException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Logger;
import javax.smartcardio.CardException;
import javax.smartcardio.CardTerminal;
import javax.smartcardio.CardTerminals;
import javax.smartcardio.TerminalFactory;

/**
 *
 * @author frederico.palma
 */
public class CardTerminalHandler {
    
    private static final java.util.logging.Logger LOG = Logger.getLogger(CardTerminalHandler.class.getName());
    
    private static final List<String> cardTerminalNames = new LinkedList<>();
    
    private static CardTerminals cardTerminals = null;
    
    private CardTerminalHandler() {}

    public static List<String> getCardTerminalNames(final boolean forceRefresh) throws CardException {
        if (forceRefresh || cardTerminals == null) {
            refreshList();
        }
        return cardTerminalNames;
    }    
    
    private static void refreshList() throws CardException {
        cardTerminalNames.clear();

	    try {
		    System.setProperty("sun.security.smartcardio.library", "/lib/x86_64-linux-gnu/libpcsclite.so.1.0.0");
//		    TerminalFactory terminalFactory = TerminalFactory.getDefault();
		    TerminalFactory terminalFactory = TerminalFactory.getInstance("PC/SC", null);

		    cardTerminals = terminalFactory.terminals();

		    for (CardTerminal terminal : cardTerminals.list()) {
			    cardTerminalNames.add(terminal.getName());
		    }
	    } catch (Exception e) {
		    throw new RuntimeException(e);
	    }
    }
    
    public static CardTerminal getCardTerminalByName(final String name) throws CardException {
        if (cardTerminals == null) {
            
            refreshList();
        }
        return cardTerminals.getTerminal(name);
    }
}
