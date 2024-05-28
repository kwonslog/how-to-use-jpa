package com.example.entity.paging;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PageRepository extends JpaRepository<LogData, Long> {

    @Query("SELECT log FROM LogData log")
    Page<LogData> testResultPage(Pageable pageable);

    @Query("SELECT log FROM LogData log")
    Slice<LogData> testResultSlice(Pageable pageable);

}
