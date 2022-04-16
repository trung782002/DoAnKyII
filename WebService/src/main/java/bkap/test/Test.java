package bkap.test;

import bkap.dao.impl.ConfigDAOImpl;

public class Test {
	public static void main(String[] args) {
		ConfigDAOImpl config = new ConfigDAOImpl();
		System.out.println(config.getList());
	}
}
