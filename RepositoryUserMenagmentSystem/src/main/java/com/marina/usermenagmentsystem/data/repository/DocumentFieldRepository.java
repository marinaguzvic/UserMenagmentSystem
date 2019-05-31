/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.marina.usermenagmentsystem.data.repository;

import com.marina.usermenagmentsystem.data.model.DocumentField;
import com.marina.usermenagmentsystem.data.model.DocumentFieldPK;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author MARINA
 */
@Repository
public interface DocumentFieldRepository extends JpaRepository<DocumentField, DocumentFieldPK> {
    List<DocumentField> findByDocumentFieldPKDocumentIdFk(Long documentId);
    
}
