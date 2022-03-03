package africa.semicolon.sendAm.services;

import africa.semicolon.sendAm.data.repositories.PackageRepository;
import africa.semicolon.sendAm.dtos.requests.RegisterPackageRequest;
import africa.semicolon.sendAm.dtos.responses.RegisterPackageResponse;



public interface PackageService {


    RegisterPackageResponse register(RegisterPackageRequest requestForm);

    PackageRepository getRepository();

}
