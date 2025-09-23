package com.Bite_resturant.service;

import com.Bite_resturant.dto.request.ReservationDto;
import com.Bite_resturant.dto.request.ReservationTableDto;
import com.Bite_resturant.dto.response.ReservationResponseDto;
import com.Bite_resturant.entity.Reservation;
import com.Bite_resturant.entity.ReserveTable;
import com.Bite_resturant.repo.ReservationRepo;
import com.Bite_resturant.repo.ReserveTableRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ReservationService {
    @Autowired
    private ReservationRepo reservationRepo;



    @Autowired
    private ReserveTableRepo reserveTableRepo;

    public String saveReservation(ReservationDto reservationDto) {
        try {
            // ✅ Save Reservation first
            Reservation reservation = new Reservation(
                    reservationDto.getId(),
                    reservationDto.getUser(),
                    reservationDto.getUser().getFirstName(),
                    reservationDto.getUser().getLastName(),
                    reservationDto.getUser().getNumber(),
                    reservationDto.getReserveDate(),
                    reservationDto.getReserveTime(),
                    reservationDto.getNumberOfPerson()
            );

            Reservation savedReservation = reservationRepo.save(reservation);

            // ✅ Save each reserved table separately
            List<ReserveTable> savedTables = new ArrayList<>();
            for (ReservationTableDto tableDto : reservationDto.getTableDtoList()) {
                ReserveTable reserveTable = new ReserveTable(
                        0, // auto-generated ID
                        savedReservation,// foreign key to Reservation
                        tableDto.getTableNumber()
                );
                savedTables.add(reserveTableRepo.save(reserveTable));
            }

            return "Reservation saved successfully with ID: "
                    + savedReservation.getId()
                    + " and " + savedTables.size() + " tables reserved.";
        } catch (Exception e) {
            e.printStackTrace();
            return "Failed to save reservation: " + e.getMessage();
        }
    }





    public List<ReservationResponseDto> getAllReservations() {
        try {
            List<ReservationResponseDto> reservationResponseDtos = new ArrayList<>();
            List<Reservation> reservations = reservationRepo.findAll();

            for (Reservation reservation : reservations) {

                // Map ReserveTable -> ReservationTableDto
                Set<ReservationTableDto> tableDtos = reservation.getReserveTable().stream()
                        .map(table -> new ReservationTableDto(
                                table.getId(),
                                table.getTableNumber()
                        ))
                        .collect(Collectors.toSet());

                // Build ReservationResponseDto
                ReservationResponseDto reservationResponseDto = new ReservationResponseDto(
                        reservation.getId(),
                        reservation.getUser().getEmail(),
                        reservation.getUserFirstName(),
                        reservation.getUserLastName(),
                        reservation.getContactNumber(),
                        reservation.getReserveDate(),
                        reservation.getReserveTime(),
                        reservation.getNumberOfPerson(),
                        tableDtos
                );

                reservationResponseDtos.add(reservationResponseDto);
            }

            return reservationResponseDtos;

        } catch (Exception e) {
            System.out.println("Error while fetching reservations: " + e.getMessage());
            return new ArrayList<>();
        }
    }




    public List<ReservationResponseDto> getAllReservationByEmail(String email) {
        try {
            List<ReservationResponseDto> reservationResponseDtos = new ArrayList<>();
            List<Reservation> reservations = reservationRepo.findAllByUserEmail(email);

            for (Reservation reservation : reservations) {

                // Map ReserveTable -> ReservationTableDto
                Set<ReservationTableDto> tableDtos = reservation.getReserveTable().stream()
                        .map(table -> new ReservationTableDto(
                                table.getId(),
                                table.getTableNumber()
                        ))
                        .collect(Collectors.toSet());

                // Build ReservationResponseDto
                ReservationResponseDto reservationResponseDto = new ReservationResponseDto(
                        reservation.getId(),
                        reservation.getUser().getEmail(),
                        reservation.getUserFirstName(),
                        reservation.getUserLastName(),
                        reservation.getContactNumber(),
                        reservation.getReserveDate(),
                        reservation.getReserveTime(),
                        reservation.getNumberOfPerson(),
                        tableDtos
                );
                reservationResponseDtos.add(reservationResponseDto);
            }
            return reservationResponseDtos;
        } catch (Exception e) {
            System.out.println("Error while fetching reservations: " + e.getMessage());
            return new ArrayList<>();
        }
    }
}

