package com.example.springbootelasticsearchdemo.repository;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import com.example.springbootelasticsearchdemo.entity.MyDocument;

@Repository
public interface MyDocumentRepository extends ElasticsearchRepository<MyDocument, String> {
	// Additional methods if needed
}
