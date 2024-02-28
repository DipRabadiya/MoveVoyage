package com.movevoyage.service;

import com.movevoyage.model.MailStructure;

public interface MailService {
    public void welcome(String mail, MailStructure mailStructure);
}
