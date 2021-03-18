package com.example.demo.controller;

import com.example.demo.entity.Attachment;
import com.example.demo.payload.Result;
import com.example.demo.servise.AttachmentService;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartHttpServletRequest;

@RestController
@RequestMapping("/attachment")
public class AttachmentController {
    AttachmentService attachmentService;
    @PostMapping("/upload")
    public Result upload(MultipartHttpServletRequest request){
        return attachmentService.uploadFile(request);
    }
    @GetMapping("/get")
    public Page<Attachment> getAttachmentList(@RequestParam Integer page){

        Page<Attachment> attachmentList = attachmentService.getAttachmentList(page);
        return attachmentList;
    }

    @GetMapping(value = "/get/{attachmentId}")
    public Attachment getOneAttachment(@PathVariable Integer attachmentId){

        Attachment oneAttachment = attachmentService.getOneAttachment(attachmentId);
        return oneAttachment;
    }

    @PutMapping(value = "/edit/{attachmentId}")
    public Result editAttachment(@PathVariable Integer attachmentId, MultipartHttpServletRequest request){

        Result result = attachmentService.editAttachment(attachmentId, request);
        return result;
    }

    @DeleteMapping(value = "/delete/{attachmentId}")
    public Result deleteAttachment(@PathVariable Integer attachmentId){

        Result result = attachmentService.deleteAttachment(attachmentId);
        return result;
    }
}
