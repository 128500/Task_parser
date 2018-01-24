package com.kudin.alex.common.services;

import com.kudin.alex.common.repositories.SpringJDBCTemplateStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by KUDIN ALEKSANDR on 25.01.2018.
 */
@Service("parserService")
public class ParserService {

    public final Parser parser;
    public final SpringJDBCTemplateStorage storage;

    @Autowired
    public ParserService(final Parser parser, final SpringJDBCTemplateStorage storage){
        this.parser = parser;
        this.storage  = storage;
    }
}
