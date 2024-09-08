package com.example.insideout.controller;

import com.example.insideout.domain.Checklist;
import com.example.insideout.service.ChecklistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/checklist")
public class ChecklistController {


    @Autowired
    private ChecklistService checklistService;


    @GetMapping("/{userId}")
    public List<Checklist> getChecklistByUserId(@PathVariable Long userId) {
        return checklistService.findChecklistByUserId(userId);
    }


    @PostMapping
    public Checklist createChecklist(@RequestBody Checklist checklist) {
        return checklistService.saveChecklist(checklist);
    }


    @PutMapping("/{id}")
    public Checklist updateChecklist(@PathVariable Long id, @RequestBody Checklist checklistDetails) {
        return checklistService.updateChecklist(id, checklistDetails);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteChecklist(@PathVariable Long id) {
        checklistService.deleteChecklist(id);
        return ResponseEntity.ok().build();
    }
}
