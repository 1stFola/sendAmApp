package africa.semicolon.sendAm.services;

import africa.semicolon.sendAm.data.repositories.PackageRepository;
import africa.semicolon.sendAm.dtos.requests.AddPackageRequest;
import africa.semicolon.sendAm.dtos.requests.UpdateTrackingInfoRequest;
import africa.semicolon.sendAm.dtos.responses.*;
import africa.semicolon.sendAm.dtos.responses.AddPackageResponse;


public interface PackageService {

    AddPackageResponse addPackage(AddPackageRequest myPackage);
    UpdateTrackingInfoResponse updateTrackingInfo(UpdateTrackingInfoRequest trackingRequest);
    TrackingPackageResponse trackPackage(int trackingNumber);

    PackageRepository getRepository();


}

