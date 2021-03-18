package com.example.demo.servise;

import com.example.demo.entity.Attachment;
import com.example.demo.entity.AttachmentContent;
import com.example.demo.payload.Result;
import com.example.demo.repository.AttachmentContentType;
import com.example.demo.repository.AttachmentRepository;
import lombok.SneakyThrows;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.io.IOException;
import java.util.Iterator;
import java.util.Optional;

@Service
public class AttachmentService {

 final    AttachmentRepository attachmentRepository;
 final AttachmentContentType attachmentContentTypeRepository;


    public AttachmentService(AttachmentRepository attachmentRepository, AttachmentContentType attachmentContentType, AttachmentContentType attachmentContentTypeRepository) {
        this.attachmentRepository = attachmentRepository;
        this.attachmentContentTypeRepository = attachmentContentTypeRepository;
    }

    @SneakyThrows
    public Result uploadFile(MultipartHttpServletRequest request) {
        Iterator<String>fileNames= request.getFileNames();
        MultipartFile file = request.getFile(fileNames.next());
        Attachment attachment=new Attachment();
        attachment.setName(file.getOriginalFilename());
        attachment.setSize(file.getSize());
        attachment.setContentType(file.getContentType());

        Attachment saveAttachment = attachmentRepository.save(attachment);

        AttachmentContent attachmentContent=new AttachmentContent();
        attachmentContent.setBytes(file.getBytes());
        attachmentContent.setAttachment(saveAttachment);
attachmentContentTypeRepository.save(attachmentContent);
return new Result("File Saqlandi",true,saveAttachment.getId());
    }
    public Page<Attachment> getAttachmentList(Integer page) {

        Pageable pageable = PageRequest.of(page, 15);
        Page<Attachment> attachmentPage = attachmentRepository.findAll(pageable);
        return attachmentPage;
    }

    public Attachment getOneAttachment(Integer attachmentId) {

        Optional<Attachment> optionalAttachment = attachmentRepository.findById(attachmentId);
        if (!optionalAttachment.isPresent())
            return new Attachment();
        return optionalAttachment.get();
    }

    @SneakyThrows
    public Result editAttachment(Integer attachmentId, MultipartHttpServletRequest request) {

        Optional<Attachment> optionalAttachment = attachmentRepository.findById(attachmentId);

        if (!optionalAttachment.isPresent())
            return new Result("Invalid attachment ID", false);

        Iterator<String> fileNames = request.getFileNames();
        MultipartFile file = request.getFile(fileNames.next());

        Attachment editedAttachment = optionalAttachment.get();

        assert file != null;
        editedAttachment.setContentType(file.getContentType());
        editedAttachment.setName(file.getOriginalFilename());
        editedAttachment.setSize(file.getSize());

        Attachment savedAttachment = attachmentRepository.save(editedAttachment);

        AttachmentContent attachmentContent = new AttachmentContent();
        attachmentContent.setBytes(file.getBytes());
        attachmentContent.setAttachment(savedAttachment);
        attachmentContentTypeRepository.save(attachmentContent);

        return new Result("Attachment edited", true, savedAttachment.getId());
    }

    public Result deleteAttachment(Integer attachmentId) {

        Optional<Attachment> optionalAttachment = attachmentRepository.findById(attachmentId);
        if (!optionalAttachment.isPresent())
            return new Result("Invalid Attachment Id", false);

        attachmentRepository.deleteById(attachmentId);
        return new Result("Attachment deleted", true);

    }
}
