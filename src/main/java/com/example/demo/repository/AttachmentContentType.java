package com.example.demo.repository;

import com.example.demo.entity.AttachmentContent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AttachmentContentType extends JpaRepository<AttachmentContent,Integer> {
}
