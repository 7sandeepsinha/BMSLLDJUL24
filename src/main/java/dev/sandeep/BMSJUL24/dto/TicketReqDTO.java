package dev.sandeep.BMSJUL24.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class TicketReqDTO {
    private List<Integer> showSeatIds;
    private int userId;
}
