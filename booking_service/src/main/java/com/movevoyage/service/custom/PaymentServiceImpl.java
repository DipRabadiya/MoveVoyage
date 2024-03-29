package com.movevoyage.service.custom;

import com.movevoyage.dto.PaymentDto;
import com.movevoyage.entity.Booking;
import com.movevoyage.entity.Payment;
import com.movevoyage.repository.BookingRepository;
import com.movevoyage.repository.PaymentRepository;
import com.movevoyage.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {
    private final PaymentRepository paymentRepository;
    private final BookingRepository bookingRepository;
    private final ModelMapper mapper;

    @Override
    public String getOngoingPaymentId() {
        List<Payment> lastPayment = paymentRepository.getLastPayment();
        return lastPayment.isEmpty() ? "PAY0000001" : String.format("PAY%07d", Integer.parseInt(lastPayment.get(0).getId().substring(3)) + 1);

    }

    @Override
    public boolean existsByPaymentId(String id) {
        boolean exists = paymentRepository.existsById(id);
        System.out.println("payment exists -> " +exists);
        return exists;
    }

    @Override
    public boolean save(PaymentDto paymentDto) {
        Payment payment = mapper.map(paymentDto, Payment.class);
        if( paymentRepository.save(payment) != null){
            System.out.println("payment saved!");
            Booking booking = bookingRepository.getBookingById(paymentDto.getBooking_id());
            if(booking.getTotal_price()==paymentRepository.calculateTotalPriceByBookingId(paymentDto.getBooking_id())){
                booking.setStatus("completed");
                bookingRepository.save(booking);
                System.out.println("booking updated!");
            }
            return true;
        };
        return false;
    }
}
