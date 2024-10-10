//package com.truphone.lpap.card;
//
//import org.junit.*;
//
//import java.nio.charset.StandardCharsets;
//import java.util.Arrays;
//import java.util.LinkedList;
//import java.util.List;
//import java.util.logging.Logger;
//import javax.smartcardio.Card;
//import javax.smartcardio.CardChannel;
//import javax.smartcardio.CardException;
//import javax.smartcardio.CardTerminal;
//import javax.smartcardio.CardTerminals;
//import javax.smartcardio.CommandAPDU;
//import javax.smartcardio.ResponseAPDU;
//import javax.smartcardio.TerminalFactory;
//
//public class CardTerminalHandlerTest {
//
//	@Test
//	public void getCardTerminalNames() throws CardException {
//		// show the list of available terminals
//		TerminalFactory factory = TerminalFactory.getDefault();
//		List<CardTerminal> terminals = factory.terminals().list();
//		System.out.println("Terminals: " + terminals);
//		// get the first terminal
//		CardTerminal terminal = terminals.get(1);
//		// establish a connection with the card
//		Card card = terminal.connect("T=1");
//		System.out.println("card: " + card);
//		CardChannel channel = card.getBasicChannel();
//		ResponseAPDU r = channel.transmit(new CommandAPDU("c1".getBytes(StandardCharsets.UTF_8)));
//		System.out.println("response: " + (Arrays.toString(r.getBytes())));
//		// disconnect
//		card.disconnect(false);
//	}
//}