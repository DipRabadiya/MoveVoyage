package com.movevoyage.repository;

import com.movevoyage.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, String> {
    @Query(value = "SELECT * FROM payment ORDER BY payment_date DESC LIMIT 1", nativeQuery = true)
    List<Payment> getLastPayment();

//    @Aggregation(pipeline = {
//            "{ $match: { booking_id: ?0 } }",
//            "{ $group: { _id: null, totalPrice: { $sum: '$amount' } } }"
//    })

    @Query("SELECT SUM(p.amount) FROM Payment p WHERE p.booking_id = :bookingId")
    Double calculateTotalPriceByBookingId(String bookingId);


    boolean existsById(String id);
}
