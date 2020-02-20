package com.silverhyuk.cloudconfigclienttest.domain;

import com.silverhyuk.cloudconfigclienttest.common.type.PayMethodType;
import com.silverhyuk.cloudconfigclienttest.common.type.UseType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import static javax.persistence.EnumType.STRING;
import static javax.persistence.FetchType.LAZY;
import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PgPayMethod extends BaseEntity {

    @Id @GeneratedValue(strategy = IDENTITY)
    @Column(name="pg_method_id")
    private Long id;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name="pg_company_id")
    private PgCompany pgCompany;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name="pg_info_id")
    private PgInfo pgInfo;

    @Column(length = 40)
    private String payMethodName;

    @Column(length = 20)
    private String payMethodCode;

    @Column(nullable = false, length = 10)
    @Enumerated(value = STRING)
    private PayMethodType payMethodType;


    @Column(nullable = false, length = 10)
    @Enumerated(value = STRING)
    private UseType useType;

}
