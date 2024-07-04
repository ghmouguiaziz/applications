package com.sofrecom.applications.services;






import com.sofrecom.applications.entities.DataCenter;
import com.sofrecom.applications.repositories.DataCenterRepo;
import org.springframework.stereotype.Service;

@Service
public class DataCenterService implements IDataCenterService{

    private final DataCenterRepo datacenterrepo;

    public DataCenterService(DataCenterRepo datacenterrepo) {
        this.datacenterrepo = datacenterrepo;
    }


    @Override
    public String addDataCenter(int id) {
        DataCenter dc = new DataCenter();
        dc.setIdDataCenter(id);
        datacenterrepo.save(dc);
        return "added";
    }




}
