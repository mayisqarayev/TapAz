package com.TapazApp.service;

import com.TapazApp.repository.ParameterRepository;
import org.springframework.stereotype.Service;

@Service
public class ParameterService {

    private final ParameterRepository parameterRepository;

    public ParameterService(ParameterRepository parameterRepository) {
        this.parameterRepository = parameterRepository;
    }

    public Boolean getIsNewOfParameterByStickerId(String stickerId)
    {
        return parameterRepository.findIsNewOfParameterByStickerId(stickerId);
    }

}
