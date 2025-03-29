package com.veerajk.pms.dtos;

import com.veerajk.pms.entities.TestCase;
import jakarta.annotation.Nullable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.NonNull;

import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TestCaseDTO {

    private Long id;
    private Map<String ,Object> input;
    private Map<String, Object> output;
    private Long problemId;


}
