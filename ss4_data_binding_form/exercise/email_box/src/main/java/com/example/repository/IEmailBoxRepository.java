package com.example.repository;

import com.example.model.EmailBox;

public interface IEmailBoxRepository {
    EmailBox getEmailBoxInfo();
    void updateEmailInfo(EmailBox emailBox1);
}
