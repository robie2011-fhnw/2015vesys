/*
 * Copyright (c) 2000-2015 Fachhochschule Nordwestschweiz (FHNW)
 * All Rights Reserved. 
 */

package bank.gui.tests;

import javax.swing.JFrame;

import bank.IBank;

public interface BankTest {
	String getName();
	boolean isEnabled(int size);
	void runTests(JFrame context, IBank bank, String currentAccountNumber) throws Exception;
}
