package com.group28.laptrinhhuongdoituong.service.implement;

import com.group28.laptrinhhuongdoituong.entity.ImportEntity;
import com.group28.laptrinhhuongdoituong.repository.ImportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ImportService {
    @Autowired
    private ImportRepository importRepository;

    public ImportEntity create(ImportEntity imports) {
        return importRepository.save(imports);
    }

    public void remove(Long id){
        importRepository.deleteById(id);
    }

    public Iterable<ImportEntity> findAll(){
        return importRepository.findAll();
    }

    public Optional<ImportEntity> findOneById(long id){
        return importRepository.findById(id);
    }
}
