package com.vtest.angular2.pojo;

import com.vtest.angular2.util.Utils;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;
import lombok.Data;

@Data
@Entity
public class PersonalData {
    
    private @Id @GeneratedValue Long id;
    
    private String firstName;
    
    private String lastName;
    
    private String description;
    
    @Transient
    private List<Integer> values = Utils.getRandomList(5, 100);
    
    
}
