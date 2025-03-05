package com.microservice.examtest.repository;

import com.microservice.examtest.document.FullTest;
import com.microservice.sharedmodel.editingdocument.repository.EditableDocumentRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FullTestRepository extends EditableDocumentRepository<FullTest> {
}
