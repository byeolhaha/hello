package com.hellomeritz.member.domain;

import com.hellomeritz.chat.global.SourceLanguage;
import com.hellomeritz.chat.global.VisaType;
import jakarta.persistence.*;
import lombok.Getter;
import org.springframework.util.Assert;

import java.time.LocalDate;

@Getter
@Entity
public class Foreigner {

    private static final Long MIN_USER_ID = 1L;
    private static final LocalDate MAX_BIRTH_DATE = LocalDate.now();
    private static final LocalDate MIN_BIRTH_DATE = LocalDate.of(1800, 1, 1);

    @Column(name = "foreigner_id", nullable = false)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "mac_address")
    private String ipAddress;

    @Enumerated(EnumType.STRING)
    @Column(name = "language")
    private SourceLanguage language;

    @Enumerated(EnumType.STRING)
    @Column(name = "visa_type")
    private VisaType visaType;

    @Column(name = "has_resident_card")
    private boolean hasResidentCard;

    @Column(name = "birth_date")
    @Embedded
    private BirthDate birthDate;

    protected Foreigner() {
    }

    private Foreigner(
            Long userId,
            SourceLanguage sourceLanguage,
            VisaType visaType,
            boolean hasResidentCard,
            BirthDate birthDate
    ) {
        Assert.isTrue(userId >= MIN_USER_ID, "user id는 양수여야 합니다.");
        Assert.notNull(sourceLanguage, "외국인의 언어는 null일 수 없습니다.");
        Assert.notNull(visaType, "외국인의 visa type은 null일 수 없습니다.");

        this.id = userId;
        this.language = sourceLanguage;
        this.birthDate = birthDate;
        this.visaType = visaType;
        this.hasResidentCard = hasResidentCard;
    }

    public static Foreigner of(
            Long userId,
            SourceLanguage sourceLanguage,
            VisaType visaType,
            boolean hasResidentCard,
            BirthDate birthDate
    ) {
        return new Foreigner(
                userId,
                sourceLanguage,
                visaType,
                hasResidentCard,
                birthDate
        );
    }

    public static Foreigner of() {
        return new Foreigner();
    }

}