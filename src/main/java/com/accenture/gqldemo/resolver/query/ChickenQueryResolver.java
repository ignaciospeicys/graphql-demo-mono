package com.accenture.gqldemo.resolver.query;

import com.accenture.gqldemo.dao.ChickenDAO;
import com.accenture.gqldemo.enums.BreedEnum;
import com.accenture.gqldemo.model.Chicken;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * provides a high level mechanism for routing queries
 * REST equivalent of a controller
 * method names should match with the defined queries in the *.graphqls file
 * see also {@link graphql.schema.DataFetcher} for a lower level implementation
 */
@Slf4j
@Component
public class ChickenQueryResolver implements GraphQLQueryResolver {

    @Autowired
    private ChickenDAO repository;

    public List<Chicken> chickens() {
        log.info("fetching all chickens");
        return repository.findAll();
    }

    public Chicken chickenById(Integer id) {
        log.info("fetching chicken by id: {}", id);
        return repository.findById(id).orElse(null);
    }

    public Chicken chickenByName(String name) {
        log.info("fetching chicken by name: {}", name);
        return repository.findByName(name);
    }

    public List<Chicken> chickensByBreed(String breed) {
        BreedEnum breedEnum = BreedEnum.findByName(breed);
        log.info("fetching chickens by breed: {}", breedEnum.name());
        return repository.findAllByBreed(breedEnum);
    }

}