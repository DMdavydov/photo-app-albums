package com.ddavydov.photoappalbums.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
public class AlbumResponse {

    private String albumId;
    private String userId;
    private String name;
    private String description;
}
