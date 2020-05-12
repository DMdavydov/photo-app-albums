package com.ddavydov.photoappalbums.controller;

import com.ddavydov.photoappalbums.dto.AlbumResponse;
import com.ddavydov.photoappalbums.model.AlbumEntity;
import com.ddavydov.photoappalbums.service.AlbumsService;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/users/{id}/albums")
public class AlbumsController {

    
    AlbumsService albumsService;
    
    @GetMapping(
            produces = {
                    MediaType.APPLICATION_JSON_VALUE,
                    MediaType.APPLICATION_XML_VALUE,
            })
    public List<AlbumResponse> userAlbums(@PathVariable String id) {

        List<AlbumResponse> returnValue = new ArrayList<>();

        List<AlbumEntity> albumsEntities = albumsService.getAlbums(id);

        if(albumsEntities == null || albumsEntities.isEmpty())
        {
            return returnValue;
        }

        Type listType = new TypeToken<List<AlbumResponse>>(){}.getType();

        returnValue = new ModelMapper().map(albumsEntities, listType);
        log.info("Returning " + returnValue.size() + " albums");
        return returnValue;
    }
}
