package com.codewithcup.studentinfo.employee;

import com.codewithcup.studentinfo.employee.enums.Gender;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.util.Date;

@NoArgsConstructor
@Setter
@Getter
@Data
@ApiModel(description ="All details about the Employee ")
@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int empId;
    @NotNull
    @Size(min = 2,message="name must be between min 2 to 15 ")
    @ApiModelProperty(notes = "name must be between min 2 to 15 ")
    private String empName;
    @ApiModelProperty(notes = "email cann't be blank")
    @Size(min = 1,message = "email cann't be blank")
    private String empEmail;
    @NotNull
    @Past
    private Date dob;
    @NotNull
    private Gender gender;
    private Country country;

    public enum Gender {
        MALE,FEMALE
    }
    public enum Country{
        AA,AB,AE,AF,AK,AM,AN,AR,AS,AV,AY,AZ,BA,BE,BG,BH,BI,BM,BN,BO,BR,BS
        ,CA,CE,CH,CO,CR,CS,CU,CV,CY,DA,DE,DV,DZ,EE,EL,EN,EO,ES,ET,EU,FA,FF
        ,FI,FJ,FO,FR,FY,GA,GD,GL,GN,GU,GV,HA,HE,HI,HO,HR,HT,HU,HY,HZ,IA,ID
        ,IE,IG,II,IK,IN, IO,IS,IT,IU,IW,JA,JI,JV,KA,KG,KI,KJ,KK,KL,KM,KN,KO
        ,KR,KS,KU,KV,KW,KY,LA,LB,LG,LI,LN,LO,LT,LU,LV,MG,MH,MI,MK,ML,MN,MO
        ,MR,MS,MT,MY,NA,NB,ND,NE,NG,NL,NN,NO,NR,NV,NY,OC,OJ,OM,OR,OS,PA,PI
        ,PL,PS,PT,QU,RM,RN,RO,RU,RW,SA,SC,SD,SE,SG,SI,SK,SL,SM,SN,SO,SQ,SR
        ,SS,ST,SU,SV,SW,TA,TE,TG,TH,TI,TK,TL,TN,TO,TR,TS,TT,TW,TY,UG,UK,UR
        ,UZ,VE,VI,VO,WA,WO,XH,YI,YO,ZA,ZH,ZU,US
    }

    public Employee(int empId, String empName, String empEmail, Date dob, Gender gender,Country country) {
        this.empId = empId;
        this.empName = empName;
        this.empEmail = empEmail;
        this.dob = dob;
        this.gender = gender;
        this.country = country;
    }
}
