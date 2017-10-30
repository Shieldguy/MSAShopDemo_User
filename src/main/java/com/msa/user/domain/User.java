package com.msa.user.domain;

import com.msa.common.domain.EditableDomainData;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.Tolerate;

import javax.persistence.*;

@Entity
@Data
@Builder
public class User extends EditableDomainData<Long> {
    @Column(nullable = false, length = 30, unique = true)
    private String  username;   // email address
    @Column(nullable = false, length = 50)
    private String  password;
    private boolean enabled;

    @Column(nullable = false, length = 30)
    private String  name;

    @Tolerate
    public User() {}
}
