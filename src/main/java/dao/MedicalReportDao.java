package dao;

import entity.Dog;
import entity.MedicalReport;

import java.util.List;

public interface MedicalReportDao extends Dao<MedicalReport>{
    List<MedicalReport> findByDogId(long id);
}
