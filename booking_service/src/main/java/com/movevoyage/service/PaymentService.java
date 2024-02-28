package com.movevoyage.service;

import com.movevoyage.dto.PaymentDto;

public interface PaymentService {
    String getOngoingPaymentId();
    boolean existsByPaymentId(String id);
    boolean save(PaymentDto paymentDto);

}
