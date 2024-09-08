package com.example.insideout.service;

import com.example.insideout.domain.Checklist;
import com.example.insideout.repository.ChecklistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChecklistService {

    // ChecklistRepository를 주입받아 사용
    @Autowired
    private ChecklistRepository checklistRepository;

    // 특정 사용자 ID를 기준으로 체크리스트 조회
    public List<Checklist> findChecklistByUserId(Long userId) {
        return checklistRepository.findByUserId(userId);
    }

    // 체크리스트 저장
    public Checklist saveChecklist(Checklist checklist) {
        return checklistRepository.save(checklist);
    }


// 체크리스트 업데이트
public Checklist updateChecklist(Long id, Checklist checklistDetails) {
    Checklist checklist = checklistRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Checklist not found"));

    checklist.setSuccessCount(checklistDetails.getSuccessCount());
    checklist.setSuccessYn(checklistDetails.getSuccessYn());
    checklist.setSuccessDate(checklistDetails.getSuccessDate());

    return checklistRepository.save(checklist);
}

    public void deleteChecklist(Long id) {
        checklistRepository.deleteById(id);
    }
}
