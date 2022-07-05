package com.lecture.reservation.kidari.domain;

import com.lecture.reservation.kidari.model.LectureDTO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import static org.assertj.core.api.Assertions.assertThat;

public class LectureTest {

    Lecture lectureEntity = Lecture.builder()
            .title("문학 강의")
            .lecturer("한국인")
            .hall("3번 강연장")
            .content("문학에 대한 전반적인 내용")
            .numberOfAdmissions(10)
            .startDate(LocalDateTime.of(2022,7,1,16,30))
            .build();

    @Test
    void createLecture(){
        assertThat(lectureEntity.getTitle()).isEqualTo("문학 강의");
        assertThat(lectureEntity.getLecturer()).isEqualTo("한국인");
        assertThat(lectureEntity.getHall()).isEqualTo("3번 강연장");
        assertThat(lectureEntity.getContent()).isEqualTo("문학에 대한 전반적인 내용");
        assertThat(lectureEntity.isView()).isFalse();
        assertThat(lectureEntity.getNumberOfAdmissions()).isEqualTo(10);
    }

    @Test
    @DisplayName("강의가 예약되었을 경우")
    void reserved(){
        lectureEntity.checkFinishReservation();
        assertThat(lectureEntity.getNumberOfAdmissions()).isEqualTo(9);
    }

    @Test
    @DisplayName("인원이 꽉차 예약 종료")
    void endReservation(){
        for(int i=0; i < 10 ; i++){
            lectureEntity.checkFinishReservation();
        }
        assertThat(lectureEntity.getNumberOfAdmissions()).isEqualTo(0);
    }

    @Test
    @DisplayName("강의 시작 7일 전 목록 보여주기")
    void isView(){
        lectureEntity.checkViewing(LocalDateTime.of(2022,7,10,16,30));
        assertThat(lectureEntity.isView()).isFalse();

        lectureEntity.checkViewing(LocalDateTime.of(2022,7,3,16,30));
        assertThat(lectureEntity.isView()).isTrue();
    }


}
