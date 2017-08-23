package com.vtest.angular2.repository;

import com.vtest.angular2.pojo.PersonalData;
import java.util.ArrayList;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 *
 * @author vongtran
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Slf4j
public class PersonalDataRepositoryTest {
    
    @Autowired
    private PersonalDataRepository repository;
    
    public PersonalDataRepositoryTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testCreatePersonalData() {
        PersonalData data = new PersonalData();
        String firstName = "Vong";
        String lastName = "Tran";
        List<Integer> values = new ArrayList<>();
        values.add(1);
        values.add(2);
        data.setFirstName(firstName);
        data.setLastName(lastName);
        data.setValues(values);
        data = repository.save(data);
        assertNotNull(data);
        
        Long id = data.getId();
        log.info("Personal data created with id: " + id);
        data = repository.findOne(id);
        assertNotNull(data);
        
        repository.delete(id);
        data = repository.findOne(id);
        assertNull(data);
    }
}
