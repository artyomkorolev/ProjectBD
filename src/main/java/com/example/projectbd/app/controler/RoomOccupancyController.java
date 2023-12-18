package com.example.projectbd.app.controler;

import com.example.projectbd.api.RoomOccupancyApi;
import com.example.projectbd.api.model.RoomOccupancyDto;
import com.example.projectbd.api.model.RoomOccupancyPKDto;
import com.example.projectbd.app.mapper.ClientMapper;
import com.example.projectbd.app.mapper.LivingRoomMapper;
import com.example.projectbd.app.mapper.ProcedureRoomMapper;
import com.example.projectbd.app.mapper.RoomOccupancyMapper;
import com.example.projectbd.app.service.RoomOccupancyService;
import com.example.projectbd.item.model.ClientItem;
import com.example.projectbd.item.model.RoomOccupancyItem;
import com.example.projectbd.item.model.RoomOccupancyPK;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class RoomOccupancyController implements RoomOccupancyApi {
    private final RoomOccupancyService roomOccupancyService;

    @Override
    public ResponseEntity<List<RoomOccupancyDto>> getAllRoomOccupancys() {


        List<RoomOccupancyItem> allRoomOccupancys = roomOccupancyService.getAllRoomOccupancys();
        List<RoomOccupancyDto> result = allRoomOccupancys.stream().map(this::mapToDtoRO).toList();

        return ResponseEntity.ok(result);
    }

    @Override
    public ResponseEntity<RoomOccupancyDto> addRoomOccupancys(RoomOccupancyDto roomOccupancy) {
        RoomOccupancyItem roomOccupancyItem =mapToItemRO(roomOccupancy);
        RoomOccupancyItem createdOccupancy = roomOccupancyService.createRoomOccupancy(roomOccupancyItem);

        return ResponseEntity.status(HttpStatus.CREATED).body(mapToDtoRO(createdOccupancy));
    }
    @Override
    public ResponseEntity<Void> deleteRoomOccupancy(RoomOccupancyItem procedureroomId) {
        roomOccupancyService.deleteRoomOccupancy(procedureroomId);
        return ResponseEntity.ok().build();
    }

    private RoomOccupancyPKDto mapToDto(RoomOccupancyPK item){
        return RoomOccupancyPKDto.builder()
                .livingRoom(LivingRoomMapper.INSTANCE.toDto(item.getLivingRoomItem()))
                .client(ClientMapper.INSTANCE.toDto(item.getClientItem()))
                .build();
    }

    private RoomOccupancyDto mapToDtoRO (RoomOccupancyItem item){
        return RoomOccupancyDto.builder()
                .roomOccupancyPK(mapToDto(item.getRoomOccupancyPK()))
                .endOccupancy(item.getEndOccupancy())
                .startOccupancy(item.getStartOccupancy())
                .build();
    }

    private RoomOccupancyPK mapToItem(RoomOccupancyDto dto){
        return RoomOccupancyPK.builder()
                .clientItem(ClientMapper.INSTANCE.mapToItem(dto.getRoomOccupancyPK().getClient()))
                .livingRoomItem(LivingRoomMapper.INSTANCE.mapToItem(dto.getRoomOccupancyPK().getLivingRoom()))
                .build();
    }
    private RoomOccupancyItem mapToItemRO(RoomOccupancyDto dto){
        return RoomOccupancyItem.builder()
                .startOccupancy(dto.getStartOccupancy())
                .endOccupancy(dto.getEndOccupancy())
                .roomOccupancyPK(mapToItem(dto))


                .build();
    }
}
