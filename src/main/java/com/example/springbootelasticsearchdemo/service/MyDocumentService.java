package com.example.springbootelasticsearchdemo.service;


import java.util.List;
import java.util.stream.Collectors;

import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.SearchHit;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.data.elasticsearch.core.mapping.IndexCoordinates;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.stereotype.Service;

import com.example.springbootelasticsearchdemo.entity.MyDocument;
import com.example.springbootelasticsearchdemo.repository.MyDocumentRepository;

@Service
public class MyDocumentService {
    private final MyDocumentRepository documentRepository;
    private final ElasticsearchOperations elasticsearchOperations;

    @Autowired
    public MyDocumentService(MyDocumentRepository documentRepository,
                             ElasticsearchOperations elasticsearchOperations) {
        this.documentRepository = documentRepository;
        this.elasticsearchOperations = elasticsearchOperations;
    }

    public void save(MyDocument document) {
        documentRepository.save(document);
    }

    public List<MyDocument> search(String searchTerm) {
        NativeSearchQuery searchQuery = new NativeSearchQueryBuilder()
                .withQuery(QueryBuilders.matchQuery("content", searchTerm))
                .withHighlightFields(new HighlightBuilder.Field("content"))
                .build();

        SearchHits<MyDocument> searchHits = elasticsearchOperations.search(searchQuery, MyDocument.class,
                IndexCoordinates.of("documents"));

        return searchHits.get().map(SearchHit::getContent).collect(Collectors.toList());
    }
}

