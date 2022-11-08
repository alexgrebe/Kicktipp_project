package com.kicktipp.server.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
public class Spiel {

    @ManyToOne(fetch = FetchType.LAZY)
    public Liga liga;
}
