package com.example.apijavaspringboot.repository;

import com.example.apijavaspringboot.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long>{

}
