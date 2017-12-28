package com.my.smnb20_2;


import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.my.smnb20_2.service.BoardDAO_ano_Son;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={
"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml",
"file:src/main/webapp/WEB-INF/spring/root-context.xml"}
)
public class BoardDAO_ano_Son_Test {

	@Inject
	private BoardDAO_ano_Son bdas;
	
	@Test
	public void testDate() throws Exception{
		
		System.out.println(bdas.CreateyyMMdd() );
	}
	
	@Test
	public void testList() throws Exception{
		
		System.out.println("\n\nbdas.getContent() = \n\n");
		System.out.println("\n\nbdas.getContent() = " + bdas.getContent(1) + "\n\n");
	}
	
}
