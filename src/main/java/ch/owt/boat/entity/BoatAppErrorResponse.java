package ch.owt.boat.entity;

import lombok.Data;

@Data
public class BoatAppErrorResponse {

    private int status;
    private String message;
    private long timeStamp;

}
