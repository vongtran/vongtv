package com.vtest.angular2.repository;

import com.vtest.angular2.pojo.PersonalData;
import org.springframework.data.repository.CrudRepository;

public interface PersonalDataRepository extends CrudRepository<PersonalData, Long>{
    
}
