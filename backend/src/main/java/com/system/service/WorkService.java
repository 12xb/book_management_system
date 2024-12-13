package com.system.service;

import com.system.entity.Work;
import com.system.repository.WorkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WorkService {

    @Autowired
    private WorkRepository workRepository;

    public Work addWork(Work work) {
        return workRepository.save(work);
    }

    public List<Work> getWorksByUserPhone(String phone) {
        return workRepository.findByUserPhone(phone);
    }

    public Optional<Work> getWorkById(Long id) {
        return workRepository.findById(id);
    }

    public void deleteWork(Long id) {
        workRepository.deleteById(id);
    }
}
