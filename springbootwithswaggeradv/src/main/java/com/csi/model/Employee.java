package com.csi.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@ApiModel(description="All details about the Employee")
public class Employee {

    @Id
    @GeneratedValue
    @ApiModelProperty(value = "Employee Id")
    private long empId;

    @ApiModelProperty(value = "Employee Name")
    private String empName;

    @ApiModelProperty(value = "Employee Address")
    private String empAddress;

    @ApiModelProperty(value = "Employee Contact Number")
    private long empContactNumber;

    @ApiModelProperty(value = "Employee Date Of Birth")
    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date empDOB;


}
