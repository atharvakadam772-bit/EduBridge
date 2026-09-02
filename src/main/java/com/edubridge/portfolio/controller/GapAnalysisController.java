package com.edubridge.portfolio.controller;

import com.edubridge.portfolio.service.GapAnalysisService;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Set;

@RestController
@RequestMapping("/api/analysis")
public class GapAnalysisController {

    private final GapAnalysisService gapAnalysisService;

    public GapAnalysisController(GapAnalysisService gapAnalysisService) {
        this.gapAnalysisService = gapAnalysisService;
    }

    @PostMapping("/gap")
    public Map<String, Object> analyze(@RequestParam Long roleId, @RequestBody Set<String> curriculumSkills) {
        return gapAnalysisService.performAnalysis(roleId, curriculumSkills);
    }
}