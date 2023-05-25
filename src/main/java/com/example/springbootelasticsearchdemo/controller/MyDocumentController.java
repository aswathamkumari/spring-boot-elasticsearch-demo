package com.example.springbootelasticsearchdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.springbootelasticsearchdemo.entity.MyDocument;
import com.example.springbootelasticsearchdemo.service.MyDocumentService;

@RestController
@RequestMapping("/documents")
public class MyDocumentController {
	private final MyDocumentService documentService;

	@Autowired
	public MyDocumentController(MyDocumentService documentService) {
		this.documentService = documentService;
	}

	@PostMapping
	public void saveDocument(@RequestBody MyDocument document) {
		documentService.save(document);
	}

	@GetMapping("/search")
	public List<MyDocument> searchDocuments(@RequestParam("q") String searchTerm) {
		return documentService.search(searchTerm);
	}
}
