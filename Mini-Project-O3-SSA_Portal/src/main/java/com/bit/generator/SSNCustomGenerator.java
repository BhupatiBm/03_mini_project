package com.bit.generator;


import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

public class SSNCustomGenerator implements IdentifierGenerator
{
	private static final String sql="SELECT SSN_SUFIX.NEXTVAL FROM DUAL";
	@Override
	public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
		String prefix="101";
		String sufix="";
		try {
			Connection con=session.connection();
			Statement stn=con.createStatement();
			ResultSet rs=stn.executeQuery(sql);
			if(rs.next()) {
				sufix=String.valueOf(rs.getInt(1));
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return Long.valueOf(prefix+sufix);
	}

}
