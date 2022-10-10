package com.group28.laptrinhhuongdoituong.service;

import com.group28.laptrinhhuongdoituong.model.Customer;
import com.group28.laptrinhhuongdoituong.model.Import;
import com.group28.laptrinhhuongdoituong.repository.CustomerRepository;
import com.group28.laptrinhhuongdoituong.repository.ImportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ImportService {
    @Autowired
    private ImportRepository importRepository;

    public Import create(Import imports) {
        return importRepository.save(imports);
    }

    public void remove(Long id){
        importRepository.deleteById(id);
    }

    public Iterable<Import> findAll(){
        return importRepository.findAll();
    }

    public Optional<Import> findOneById(long id){
        return importRepository.findById(id);
    }
}
