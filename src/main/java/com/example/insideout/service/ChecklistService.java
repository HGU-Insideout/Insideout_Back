package com.example.insideout.service;

import com.example.insideout.domain.Checklist;
import com.example.insideout.repository.ChecklistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChecklistService {


    @Autowired
    private ChecklistRepository checklistRepository;


    public List<Checklist> findChecklistByUserId(Long userId) {
        return checklistRepository.findByUserId(userId);
    }


    public Checklist saveChecklist(Checklist checklist) {
        return checklistRepository.save(checklist);
    }



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
