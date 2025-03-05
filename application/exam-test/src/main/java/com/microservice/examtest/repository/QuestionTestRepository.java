package com.microservice.examtest.repository;
import com.microservice.examtest.document.Question;
import com.microservice.sharedmodel.editingdocument.repository.EditableDocumentRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionTestRepository extends EditableDocumentRepository<Question> {
}
