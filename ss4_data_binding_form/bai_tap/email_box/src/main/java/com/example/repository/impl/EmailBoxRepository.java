package com.example.repository.impl;

import com.example.model.EmailBox;
import com.example.repository.IEmailBoxRepository;
import org.springframework.stereotype.Repository;

@Repository
public class EmailBoxRepository implements IEmailBoxRepository {
    public static EmailBox emailBox;
    {
       emailBox  = new EmailBox("English", "25", false, "Thor, King, Asgard");
    }

    @Override
    public EmailBox getEmailBoxInfo() {
        return emailBox;
    }

    @Override
    public void updateEmailInfo(EmailBox emailBox1) {
        emailBox.setLanguages(emailBox1.getLanguages());
        emailBox.setPageSize(emailBox1.getPageSize());
        emailBox.setSpamFilter(emailBox1.isSpamFilter());
        emailBox.setSignature(emailBox1.getSignature());
    }
}
