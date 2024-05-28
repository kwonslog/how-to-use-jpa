package com.example.entity.paging;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Slice;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class PageRepositoryTest {

    @Autowired
    private PageRepository pageRepository;

    @BeforeEach
    public void setUp() {
        pageRepository.saveAndFlush(LogData.builder().action("액션1").message("메세지1").build());
        pageRepository.saveAndFlush(LogData.builder().action("액션2").message("메세지2").build());
        pageRepository.saveAndFlush(LogData.builder().action("액션3").message("메세지3").build());
        pageRepository.saveAndFlush(LogData.builder().action("액션4").message("메세지4").build());
        pageRepository.saveAndFlush(LogData.builder().action("액션5").message("메세지5").build());
        pageRepository.saveAndFlush(LogData.builder().action("액션6").message("메세지6").build());
        pageRepository.saveAndFlush(LogData.builder().action("액션7").message("메세지7").build());
        pageRepository.saveAndFlush(LogData.builder().action("액션8").message("메세지8").build());
        pageRepository.saveAndFlush(LogData.builder().action("액션9").message("메세지9").build());
    }

    @Test
    @DisplayName("페이징 처리 후 리턴타입이 Page 인 경우")
    public void test1() {
        Page<LogData> logData = pageRepository.testResultPage(PageRequest.of(1, 5));

        System.out.println("현재 페이지의 데이터 size : " + logData.getContent().size());
        System.out.println("전체 건수 : " + logData.getTotalElements());
        System.out.println("전체 페이지 수 : " + logData.getTotalPages());
        System.out.println("현재 페이지 번호 : " + logData.getNumber());

        System.out.println("페이지 당 표시 건수 : " + logData.getSize());
        System.out.println("현재 페이지의 표시 건수 : " + logData.getNumberOfElements());
        System.out.println("다음 페이지 여부 : " + logData.hasNext());
        System.out.println("이전 페이지 여부 : " + logData.hasPrevious());
        System.out.println("첫 페이지 여부: " + logData.isFirst());
        System.out.println("마지막 페이지 여부 : " + logData.isLast());
    }

    @Test
    @DisplayName("페이징 처리 후 리턴타입이 Slice 인 경우")
    public void test2() {
        Slice<LogData> logData = pageRepository.testResultSlice(PageRequest.of(1, 5));

        System.out.println("현재 페이지의 데이터 size : " + logData.getContent().size());
        //System.out.println("전체 건수 : " + logData.getTotalElements());
        //System.out.println("전체 페이지 수 : " + logData.getTotalPages());
        System.out.println("현재 페이지 번호 : " + logData.getNumber());

        System.out.println("페이지 당 표시 건수 : " + logData.getSize());
        System.out.println("현재 페이지의 표시 건수 : " + logData.getNumberOfElements());
        System.out.println("다음 페이지 여부 : " + logData.hasNext());
        System.out.println("이전 페이지 여부 : " + logData.hasPrevious());
        System.out.println("첫 페이지 여부: " + logData.isFirst());
        System.out.println("마지막 페이지 여부 : " + logData.isLast());
    }

}