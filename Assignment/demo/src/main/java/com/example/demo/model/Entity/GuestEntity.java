package com.example.demo.model.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Guest")
public class GuestEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer guestId;
    private String guestName;
    private String guestContactNo;  // controller/Service changes

    @OneToMany(mappedBy = "guestEntity", fetch = FetchType.LAZY , cascade = CascadeType.ALL)
    private List<BookingEntity> bookingEntities;

}
