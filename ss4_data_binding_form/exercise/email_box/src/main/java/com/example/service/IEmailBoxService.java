package com.example.service;

import com.example.model.EmailBox;

public interface IEmailBoxService {
    EmailBox getEmailBoxInfo();
    void updateEmailInfo(EmailBox emailBox1);
}
