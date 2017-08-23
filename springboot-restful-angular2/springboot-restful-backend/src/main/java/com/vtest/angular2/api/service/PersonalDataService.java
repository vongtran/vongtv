package com.vtest.angular2.api.service;

import com.vtest.angular2.pojo.PersonalData;
import com.vtest.angular2.repository.PersonalDataRepository;
import java.util.ArrayList;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class PersonalDataService {
    
    @Autowired
    private PersonalDataRepository repository;
    
    public PersonalData getPersonalData(Long id) {
        return repository.findOne(id);
    }
    
    public PersonalData createPersonalData(PersonalData personalData) {
        return repository.save(personalData);
    }
    
    public PersonalData updatePersonalData(PersonalData personalData) {
        personalData = repository.save(personalData);
        return personalData;
    }
    
    public void deletePersonalData(Long id) {
        repository.delete(id);
    }
    
    public List<PersonalData> findAll() {
        List<PersonalData> result = new ArrayList<>();
        repository.findAll().forEach(personalData -> result.add(personalData));
        return result;
    }
}
