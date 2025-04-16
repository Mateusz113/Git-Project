package com.mateusz113.git_hub_proj.git_hub_project.controller;

import com.mateusz113.git_hub_proj.git_hub_project.model.RepositoryDto;
import com.mateusz113.git_hub_proj.git_hub_project.service.RepositoryService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import java.time.Clock;
import java.time.Instant;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class RepositoryControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockitoBean
    private RepositoryService repositoryService;
    private final Clock clock = Clock.fixed(Instant.parse(getDefaultTimeString()), ZoneOffset.UTC);

    @Test
    public void getRepositoryData_ReturnsDataWithStatus200() throws Exception {
        String owner = "owner";
        String repositoryName = "repoName";
        RepositoryDto repositoryDto = buildRepositoryDto();
        when(repositoryService.getRepositoryData(owner, repositoryName)).thenReturn(repositoryDto);
        mockMvc.perform(get("/repositories/{owner}/{repository-name}", owner, repositoryName))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.fullName").value("fullName"))
                .andExpect(jsonPath("$.description").value("description"))
                .andExpect(jsonPath("$.cloneUrl").value("cloneUrl"))
                .andExpect(jsonPath("$.stars").value("0"))
                .andExpect(jsonPath("$.createdAt").value(getDefaultTimeString()))
                .andDo(print());

    }

    @Test
    public void saveRepositoryData_ReturnsDataWithStatus201() throws Exception {
        String owner = "owner";
        String repositoryName = "repoName";
        RepositoryDto repositoryDto = buildRepositoryDto();
        when(repositoryService.saveRepositoryData(owner, repositoryName)).thenReturn(repositoryDto);
        mockMvc.perform(post("/repositories/{owner}/{repository-name}", owner, repositoryName))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.fullName").value("fullName"))
                .andExpect(jsonPath("$.description").value("description"))
                .andExpect(jsonPath("$.cloneUrl").value("cloneUrl"))
                .andExpect(jsonPath("$.stars").value("0"))
                .andExpect(jsonPath("$.createdAt").value(getDefaultTimeString()))
                .andDo(print());

    }

    private RepositoryDto buildRepositoryDto() {
        return RepositoryDto.builder()
                .fullName("fullName")
                .description("description")
                .cloneUrl("cloneUrl")
                .stars(0L)
                .createdAt(OffsetDateTime.now(clock))
                .build();
    }

    private String getDefaultTimeString() {
        return "2012-12-12T12:00:00Z";
    }
}
