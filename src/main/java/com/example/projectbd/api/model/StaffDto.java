package com.example.projectbd.api.model;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@AllArgsConstructor
@Builder
public class StaffDto {

private Integer id;
private  String phone_number;
private String full_name;

private ProcedureDto procedureDto;
}
