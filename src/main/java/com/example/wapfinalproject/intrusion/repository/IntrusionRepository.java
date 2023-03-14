package com.example.wapfinalproject.intrusion.repository;

import com.example.wapfinalproject.intrusion.entity.Intrusion;
import org.springframework.data.repository.CrudRepository;

public interface IntrusionRepository extends CrudRepository<Intrusion, String> {

    public Intrusion findFirstByOrderByDateDesc();

}
