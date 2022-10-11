package com.group28.laptrinhhuongdoituong.controller;

import com.group28.laptrinhhuongdoituong.entity.ImportEntity;
import com.group28.laptrinhhuongdoituong.service.implement.ImportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class ImportController {
    @Autowired
    private ImportService importService;

    @RequestMapping(value = "/import/", method = RequestMethod.GET)
    public ResponseEntity<List<ImportEntity>> listAllImport(){
        List<ImportEntity> listImport= (List<ImportEntity>) importService.findAll();
        if(listImport.isEmpty()) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<ImportEntity>>(listImport, HttpStatus.OK);
    }

    @RequestMapping(value = "/import/{id}", method = RequestMethod.GET)
    public ResponseEntity<Optional<ImportEntity>> findImport(@PathVariable("id") long id) {
        Optional<ImportEntity> imports = importService.findOneById(id);
        if(imports.isEmpty()) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<Optional<ImportEntity>>(imports, HttpStatus.OK);
    }

    @RequestMapping(value = "/import/", method = RequestMethod.POST)
    public ImportEntity saveImport(ImportEntity imports) {

        return importService.create(imports);
    }

    @RequestMapping(value = "/import/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteImport(@PathVariable("id") long id) {
        try {
            importService.remove(id);
            return ResponseEntity.ok("Success");
        }catch(Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
