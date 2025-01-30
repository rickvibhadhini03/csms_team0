package com.cars24.csms.services.impl;


import com.cars24.csms.data.dao.Impl.ServicesDaoImpl;
import com.cars24.csms.data.req.CreateServiceReq;
import com.cars24.csms.data.resp.CreateServiceResponse;
import com.cars24.csms.services.VehicleServiceManagementService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class VehicleServiceManagementServiceImpl implements VehicleServiceManagementService {
    //@Autowired
    private final ServicesDaoImpl servicesDaoimpl;
    @Override
    public CreateServiceResponse createService(CreateServiceReq createServiceReq) {
        servicesDaoimpl.createService(createServiceReq);
        log.info("[createService]", createServiceReq);
        return null;


    }
    @Override
    public void deleteService(Integer id){
       servicesDaoimpl.deleteService(id);
        log.info("[deleteService]", id);

//
    }
    //@Override
public CreateServiceResponse getServiceByID(int id){
    return  servicesDaoimpl.getServiceByID(id);
}

//    @Override
//    public GetServiceRes getService(GetServiceReq getServiceReq) {
//        {
//            System.out.println("[getServiceByName] Fetching service with name: " + name);
//
//            // Call DAO to fetch the entity by name
//            ServicesEntity entity = servicesDaoimpl.getServiceByName(name);
//
//            // Handle if no service is found
//            if (entity == null) {
//                throw new RuntimeException("Service not found with name: " + name);
//            }
//
//            // Map the entity to the response object
//            GetServiceResp response = new GetServiceResp();
//            response.setName(entity.getName().toString()); // Convert ServiceType enum to String
//            response.setPrice(entity.getPrice());
//
//            return response;
//        }
//        return null;
//}
}
