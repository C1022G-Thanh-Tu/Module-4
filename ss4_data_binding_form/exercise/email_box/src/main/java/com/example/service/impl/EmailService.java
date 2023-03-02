package com.example.service.impl;

import com.example.model.EmailBox;
import com.example.repository.IEmailBoxRepository;
import com.example.service.IEmailBoxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmailService implements IEmailBoxService {
    @Autowired
    IEmailBoxRepository emailBoxRepository;
    @Override
    public EmailBox getEmailBoxInfo() {
        return emailBoxRepository.getEmailBoxInfo();
    }

    @Override
    public void updateEmailInfo(EmailBox emailBox1) {
        emailBoxRepository.updateEmailInfo(emailBox1);
    }
}
