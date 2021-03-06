package com.accenture.gqldemo.resolver.query;

import com.accenture.gqldemo.dao.EggDAO;
import com.accenture.gqldemo.model.Egg;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class EggQueryResolver implements GraphQLQueryResolver {

    @Autowired
    private EggDAO repository;

    public Egg eggById(Integer id) {
        log.info("fetching egg by id: {}", id);
        return repository.findById(id).orElse(null);
    }
}
