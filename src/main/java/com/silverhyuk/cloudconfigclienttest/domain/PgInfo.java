package com.silverhyuk.cloudconfigclienttest.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import static javax.persistence.FetchType.LAZY;
import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(uniqueConstraints={
        @UniqueConstraint(
                columnNames={"pg_company_id","mallId","partnerId"}
        )
})
public class PgInfo extends BaseEntity {

    @Id @GeneratedValue(strategy = IDENTITY)
    @Column(name="pg_info_id")
    private Long id;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name="pg_company_id")
    private PgCompany pgCompany;

    @Column(length = 40)
    private String mallId;

    @Column(length = 40)
    private String partnerId;

    @Lob
    private String hashKeys;

    private boolean isSubscription;

    public void setPgCompany(PgCompany pgCompany) {
        this.pgCompany = pgCompany;
    }
}
