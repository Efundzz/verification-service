package com.efundzz.verificationservice.mapper;

import com.efundzz.verificationservice.model.SignzyDTO.PanResponse;
import com.efundzz.verificationservice.model.authbridge.AuthbridgeDecryptedResponseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PanMapper {
    @Mapping(target = "tsTransID", source = "id")
    @Mapping(target = "msg", source = "result")
//    @Mapping(source = "result.firstName", target = "msg.firstName")
//    @Mapping(source = "result.lastName", target = "msg.lastName")
//    @Mapping(source = "result.middleName", target = "msg.middleName")
//    @Mapping(source = "result.number", target = "msg.panNumber")
//    @Mapping(source = "result.name", target = "msg.nameOnTheCard")
//    @Mapping(source = "result.panStatus", target = "msg.status")
//    @Mapping(source = "result.typeOfHolder", target = "msg.panHolderStatusType")
//    @Mapping(source = "result.isValid", target = "msg.statusDescription")
//    @Mapping(source = "result.lastUpdatedOn", target = "msg.lastUpdate")

    AuthbridgeDecryptedResponseDTO<PanResponse> mapToAuthbridgeResponse(PanResponse panResponse);
}
