package com.kudin.alex.common;

import com.kudin.alex.common.entities.Tire;
import com.kudin.alex.common.services.ParserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * Created by KUDIN ALEKSANDR on 25.01.2018.
 */

public class SpringEntryPoint {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-context.xml");

        ParserService service = (ParserService)context.getBean("parserService");

        List<Tire>  tires = service.parser.parseFile("C:\\Users\\homeuser.1-HP\\Desktop\\Прайс шины.xls");

        for(Tire t : tires){
            service.storage.saveEntity(t);
        }
    }
}
