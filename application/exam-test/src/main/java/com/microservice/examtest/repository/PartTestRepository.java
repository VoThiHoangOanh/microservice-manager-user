package com.microservice.examtest.repository;

import com.microservice.examtest.document.Part;
import com.microservice.sharedmodel.editingdocument.repository.EditableDocumentRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PartTestRepository extends EditableDocumentRepository<Part> {
}
