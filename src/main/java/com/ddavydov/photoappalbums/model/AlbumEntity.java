package com.ddavydov.photoappalbums.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
public class AlbumEntity {

    private long id;
    private String albumId;
    private String userId;
    private String name;
    private String description;
}
