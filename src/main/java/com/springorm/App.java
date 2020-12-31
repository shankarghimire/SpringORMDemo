package com.springorm;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.springorm.dao.StudentDao;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        //System.out.println( "Hello World!" );

    	ApplicationContext applicationContext = new ClassPathXmlApplicationContext("config.xml");
    	StudentDao studentDao = applicationContext.getBean("studentDao", StudentDao.class);
    	
    	System.out.println("Testing: Context Loaded...");
    }
}
