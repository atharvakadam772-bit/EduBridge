package com.edubridge.portfolio.Config;

import com.edubridge.portfolio.model.JobRole;
import com.edubridge.portfolio.model.ProjectRecipe;
import com.edubridge.portfolio.model.Skill;
import com.edubridge.portfolio.repository.JobRoleRepository;
import com.edubridge.portfolio.repository.ProjectRecipeRepository;
import com.edubridge.portfolio.repository.SkillRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class DataInitializer implements CommandLineRunner {

    private final SkillRepository skillRepository;
    private final JobRoleRepository jobRoleRepository;
    private final ProjectRecipeRepository recipeRepository;

    public DataInitializer(SkillRepository skillRepository, JobRoleRepository jobRoleRepository, ProjectRecipeRepository recipeRepository) {
        this.skillRepository = skillRepository;
        this.jobRoleRepository = jobRoleRepository;
        this.recipeRepository = recipeRepository;
    }

    @Override
    public void run(String... args) {
        if (jobRoleRepository.count() == 0) {
            // === IT & SOFTWARE SKILLS ===
            Skill spring = skillRepository.save(new Skill("Spring Boot", "Tech"));
            Skill mysql = skillRepository.save(new Skill("MySQL", "Tech"));
            Skill docker = skillRepository.save(new Skill("Docker", "Tech"));
            Skill react = skillRepository.save(new Skill("React", "Tech"));
            Skill cicd = skillRepository.save(new Skill("CI/CD", "Tech"));

            // === COMMERCE & FINANCE SKILLS ===
            Skill financialModeling = skillRepository.save(new Skill("Financial Modeling", "Business"));
            Skill tally = skillRepository.save(new Skill("Tally Prime & GST", "Business"));
            Skill excelAdvanced = skillRepository.save(new Skill("Advanced Excel", "Business"));
            Skill corporateFinance = skillRepository.save(new Skill("Corporate Finance", "Business"));

            // === ARTS, MEDIA & DESIGN SKILLS ===
            Skill videoEditing = skillRepository.save(new Skill("Video Editing & Premiere Pro", "Design"));
            Skill canva = skillRepository.save(new Skill("Canva & Motion Graphics", "Design"));
            Skill uiux = skillRepository.save(new Skill("Figma & UI/UX Design", "Design"));
            Skill copyWriting = skillRepository.save(new Skill("SEO & Content Strategy", "Design"));

            // === CORE ENGINEERING (MECHANICAL & CIVIL) SKILLS ===
            Skill autocad = skillRepository.save(new Skill("AutoCAD", "Engineering"));
            Skill solidworks = skillRepository.save(new Skill("SolidWorks Design", "Engineering"));
            Skill staadPro = skillRepository.save(new Skill("STAAD Pro", "Engineering"));
            Skill thermodynamics = skillRepository.save(new Skill("Thermodynamics Analysis", "Engineering"));

            // === SCIENCE & BIOTECH SKILLS ===
            Skill pcr = skillRepository.save(new Skill("PCR Testing & Gel Electrophoresis", "Science"));
            Skill bioinformatics = skillRepository.save(new Skill("Bioinformatics & Python", "Science"));
            Skill labSafety = skillRepository.save(new Skill("GLP & Lab Safety", "Science"));


            // 1. JOB ROLE: CS / FULL-STACK ENGINEER
            JobRole fullstack = new JobRole("Full-Stack Java Engineer", "Computer Science / IT");
            fullstack.setRequiredSkills(Set.of(spring, mysql, docker, react, cicd));
            jobRoleRepository.save(fullstack);

            ProjectRecipe r1 = new ProjectRecipe();
            r1.setTitle("Distributed Microservices E-Commerce Engine");
            r1.setDescription("Architected a decoupled microservices platform utilizing Spring Boot REST APIs, MySQL relational storage, Docker containers, and CI/CD automation pipelines.");
            r1.setGithubTemplateUrl("https://github.com/edubridge-templates/fullstack-microservices");
            r1.setResumeBulletPoint("Architected a containerized Spring Boot microservice stack with Docker CI/CD pipelines and MySQL storage, increasing system throughput by 35%.");
            r1.setCoveredSkills(Set.of(spring, mysql, docker, react, cicd));
            recipeRepository.save(r1);


            // 2. JOB ROLE: COMMERCE / FINANCIAL ANALYST
            JobRole finAnalyst = new JobRole("Financial Analyst & Tax Consultant", "Commerce & Finance");
            finAnalyst.setRequiredSkills(Set.of(financialModeling, tally, excelAdvanced, corporateFinance));
            jobRoleRepository.save(finAnalyst);

            ProjectRecipe r2 = new ProjectRecipe();
            r2.setTitle("Automated Corporate Valuation & GST Compliance Model");
            r2.setDescription("Build dynamic DCF financial models in Excel integrated with Tally Prime audit logs for quarterly GST filing and risk management.");
            r2.setGithubTemplateUrl("https://github.com/edubridge-templates/financial-valuation-model");
            r2.setResumeBulletPoint("Engineered automated DCF financial models in Advanced Excel and managed GST reconciliation pipelines via Tally Prime, reducing quarterly audit cycle times by 40%.");
            r2.setCoveredSkills(Set.of(financialModeling, tally, excelAdvanced, corporateFinance));
            recipeRepository.save(r2);


            // 3. JOB ROLE: ARTS / DIGITAL CONTENT & UI DESIGNER
            JobRole mediaDesigner = new JobRole("UI/UX & Multimedia Producer", "Arts, Media & Design");
            mediaDesigner.setRequiredSkills(Set.of(videoEditing, canva, uiux, copyWriting));
            jobRoleRepository.save(mediaDesigner);

            ProjectRecipe r3 = new ProjectRecipe();
            r3.setTitle("Brand Identity & Video Production Suite");
            r3.setDescription("Produce high-engagement video assets, Figma UI component libraries, and SEO content strategies for digital campaign launches.");
            r3.setGithubTemplateUrl("https://github.com/edubridge-templates/media-design-kit");
            r3.setResumeBulletPoint("Designed complete Figma UI design systems and produced multi-platform promotional videos using Premiere Pro, driving a 25% boost in user engagement.");
            r3.setCoveredSkills(Set.of(videoEditing, canva, uiux, copyWriting));
            recipeRepository.save(r3);


            // 4. JOB ROLE: MECHANICAL CAD DESIGNER
            JobRole mechEngineer = new JobRole("Mechanical Product Design Engineer", "Mechanical Engineering");
            mechEngineer.setRequiredSkills(Set.of(autocad, solidworks, thermodynamics));
            jobRoleRepository.save(mechEngineer);

            ProjectRecipe r4 = new ProjectRecipe();
            r4.setTitle("Thermal Energy Storage CAD & FEA Analysis");
            r4.setDescription("Design 3D mechanical assemblies in SolidWorks and execute thermal strain analysis under variable operational loads.");
            r4.setGithubTemplateUrl("https://github.com/edubridge-templates/mechanical-cad-blueprint");
            r4.setResumeBulletPoint("Designed complex 3D mechanical components in SolidWorks and conducted thermal stress simulations in AutoCAD, achieving a 15% reduction in material waste.");
            r4.setCoveredSkills(Set.of(autocad, solidworks, thermodynamics));
            recipeRepository.save(r4);


            // 5. JOB ROLE: SCIENCE / BIOTECH RESEARCH ASSOCIATE
            JobRole biotechRole = new JobRole("Biotech & Computational Biologist", "Biological Sciences");
            biotechRole.setRequiredSkills(Set.of(pcr, bioinformatics, labSafety));
            jobRoleRepository.save(biotechRole);

            ProjectRecipe r5 = new ProjectRecipe();
            r5.setTitle("Genomic Sequence Alignment Pipeline");
            r5.setDescription("Develop Python biopython scripts to process PCR test outputs and analyze genetic markers while adhering to GLP safety guidelines.");
            r5.setGithubTemplateUrl("https://github.com/edubridge-templates/biotech-genomics-pipeline");
            r5.setResumeBulletPoint("Developed automated genomic sequence analysis scripts using Python Bioinformatics libraries on PCR sample data in compliance with GLP safety protocols.");
            r5.setCoveredSkills(Set.of(pcr, bioinformatics, labSafety));
            recipeRepository.save(r5);

            System.out.println(">>> EDUBRIDGE MULTI-DOMAIN DATASET INITIALIZED <<<");
        }
    }
}