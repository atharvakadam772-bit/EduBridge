package com.edubridge.portfolio.dto;

import java.util.Set;

public class GapAnalysisRequest {

    private String targetRole;
    private Set<String> curriculumSkillNames;

    public GapAnalysisRequest() {}

    public String getTargetRole() {
        return targetRole;
    }

    public void setTargetRole(String targetRole) {
        this.targetRole = targetRole;
    }

    public Set<String> getCurriculumSkillNames() {
        return curriculumSkillNames;
    }

    public void setCurriculumSkillNames(Set<String> curriculumSkillNames) {
        this.curriculumSkillNames = curriculumSkillNames;
    }
}