package app;

import app.objects.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Start {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("app-context.xml");
        FileManager fileUtil = (FileManager) context.getBean("fileManager");
        fileUtil.getExtensionCount("c:\\Windows\\System32");
        fileUtil.getExtensionCount("c:\\Windows\\");
    }
} // class Start
