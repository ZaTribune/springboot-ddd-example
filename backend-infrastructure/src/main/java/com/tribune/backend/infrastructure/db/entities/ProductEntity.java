package com.tribune.backend.infrastructure.db.entities;


import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class ProductEntity {

    @Id
    private UUID id;
}
