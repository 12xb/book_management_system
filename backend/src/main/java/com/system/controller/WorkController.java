package com.system.controller;

import com.system.entity.Work;
import com.system.service.WorkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/works")
public class WorkController {

    @Autowired
    private WorkService workService;

    @PostMapping
    public ResponseEntity<Work> addWork(@RequestBody Work work) {
        return ResponseEntity.ok(workService.addWork(work));
    }

    @GetMapping
    public ResponseEntity<List<Work>> getWorks(@RequestParam String phone) {
        return ResponseEntity.ok(workService.getWorksByUserPhone(phone));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Work> updateWork(@PathVariable Long id, @RequestBody Work work) {
        return workService.getWorkById(id)
                .map(existingWork -> {
                    existingWork.setWorkName(work.getWorkName());
                    existingWork.setPublisher(work.getPublisher());
                    existingWork.setWordCount(work.getWordCount());
                    return ResponseEntity.ok(workService.addWork(existingWork));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteWork(@PathVariable Long id) {
        workService.deleteWork(id);
        return ResponseEntity.noContent().build();
    }
}

