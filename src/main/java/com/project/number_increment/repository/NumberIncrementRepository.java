package com.project.number_increment.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.project.number_increment.model.NumberIncrement;

@Repository
public interface NumberIncrementRepository extends CrudRepository<NumberIncrement, String>
{

}
