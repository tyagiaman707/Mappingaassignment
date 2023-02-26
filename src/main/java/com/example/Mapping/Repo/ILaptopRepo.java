package com.example.Mapping.Repo;

import com.example.Mapping.Model.Laptop;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ILaptopRepo extends JpaRepository<Laptop,Integer> {
}
