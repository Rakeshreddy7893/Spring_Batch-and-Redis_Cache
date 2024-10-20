package com.file.recykal.dao;

import com.file.recykal.entity.File;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface FileRepository extends CrudRepository<File,String> {

    @Override
    ArrayList<File> findAll();
}
