package com.vtest.angular2.api;

import com.vtest.angular2.api.service.PersonalDataService;
import com.vtest.angular2.pojo.PersonalData;
import io.swagger.annotations.Api;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Api("QASSalesRepApi")
@RestController
@RequestMapping("/api/salesreps")
public class PersonalDataApi {
    
    @Autowired
    private PersonalDataService service;
    
    @RequestMapping(value = "")
    public List<PersonalData> findAll() {
        return service.findAll();
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public PersonalData getPersonalData(@PathVariable("id") Long id) {
        return service.getPersonalData(id);
    }
    
    @RequestMapping(value = "", method = RequestMethod.POST)
    public PersonalData createPersonalData(@RequestBody PersonalData personalData) {
        return service.createPersonalData(personalData);
    }
}
