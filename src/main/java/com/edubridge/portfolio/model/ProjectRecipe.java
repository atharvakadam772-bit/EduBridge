package com.edubridge.portfolio.model;

import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "project_recipes")
public class ProjectRecipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @Column(length = 1000)
    private String description;

    private String githubTemplateUrl;

    @Column(length = 1000)
    private String resumeBulletPoint;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
        name = "recipe_skills",
        joinColumns = @JoinColumn(name = "recipe_id"),
        inverseJoinColumns = @JoinColumn(name = "skill_id")
    )
    private Set<Skill> coveredSkills = new HashSet<>();

    public ProjectRecipe() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getGithubTemplateUrl() { return githubTemplateUrl; }
    public void setGithubTemplateUrl(String githubTemplateUrl) { this.githubTemplateUrl = githubTemplateUrl; }

    public String getResumeBulletPoint() { return resumeBulletPoint; }
    public void setResumeBulletPoint(String resumeBulletPoint) { this.resumeBulletPoint = resumeBulletPoint; }

    public Set<Skill> getCoveredSkills() { return coveredSkills; }
    public void setCoveredSkills(Set<Skill> coveredSkills) { this.coveredSkills = coveredSkills; }
}