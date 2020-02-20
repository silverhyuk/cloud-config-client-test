package com.silverhyuk.cloudconfigclienttest.domain;

import com.silverhyuk.cloudconfigclienttest.common.type.UseType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.EnumType.STRING;
import static javax.persistence.FetchType.LAZY;
import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PgCompany extends BaseEntity {

    @Id @GeneratedValue(strategy = IDENTITY)
    @Column(name="pg_company_id")
    private Long id;

    @Column(nullable = false, length = 40)
    private String engName;

    @Column(nullable = false, length = 40)
    private String korName;

    @Column(length = 128)
    private String homePageUrl;

    @Column(nullable = false, length = 10)
    @Enumerated(value = STRING)
    private UseType useType;

    @OneToMany(mappedBy = "pgCompany", fetch = LAZY)
    private final List<PgInfo> pgInfos = new ArrayList<>();

    /**
     * @param pgInfo PG Info 추가 (양방향)
     */
    public void addPgInfo(PgInfo pgInfo) {
        pgInfos.add(pgInfo);
        pgInfo.setPgCompany(this);
    }

    public void setEngName(String engName) {
        this.engName = engName;
    }

    public void setKorName(String korName) {
        this.korName = korName;
    }

    public void setHomePageUrl(String homePageUrl) {
        this.homePageUrl = homePageUrl;
    }

    public void setUseType(UseType useType) {
        this.useType = useType;
    }
}
