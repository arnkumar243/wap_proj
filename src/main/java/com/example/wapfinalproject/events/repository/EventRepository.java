package com.example.wapfinalproject.events.repository;

import com.example.wapfinalproject.events.entity.Device;
import org.springframework.data.repository.CrudRepository;

public interface EventRepository extends CrudRepository<Device, Long> {

}
